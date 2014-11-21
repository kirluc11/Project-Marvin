package selector;

import android.content.res.AssetManager;
import beans.Question;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Lukas on 21.11.2014.
 */
public class QuestionHandler {

    private static QuestionHandler questionHandlerInstance;

    private LinkedList<Question> usedQuestion = new LinkedList<Question>();
    private Question currentQuestion;
    private boolean currentQuestionAnswered = true;
    private int right = 0;


    public static QuestionHandler getInstance(AssetManager am) throws Exception {
        if(questionHandlerInstance == null)
        {
            questionHandlerInstance = new QuestionHandler(am);
        }
        return questionHandlerInstance;
    }

    public static QuestionHandler getInstance()
    {
        return questionHandlerInstance;
    }

    private QuestionHandler(AssetManager am) throws Exception {
        usedQuestion = RandomQuestionSelector.getInstance(am).getUsedQuestion();
    }

    public Question getNextQuestion()
    {
        if(usedQuestion != null && usedQuestion.size() > 0)
        {
            if(currentQuestionAnswered)
            {
                System.out.println("returned new question");
                currentQuestionAnswered = false;
                currentQuestion = usedQuestion.getFirst();
                usedQuestion.removeFirst();
            }
            return currentQuestion;
        }
        return null;
    }

    /**
     *
     * @param answer
     * @return 0: right,
     *         1: wrong,
     *         2: no current question
     */
    public int checkAnswer(String answer)
    {
        if(currentQuestion == null)
        {
            System.out.println("null");
            return 2;
        }
        else
        {
            currentQuestionAnswered = true;
            if(answer != null && answer.equals(currentQuestion.getGerRightAnswer()))
            {
                right++;
                System.out.println("true");
                return 0;
            }
            else
            {
                System.out.println("false");
                return 1;
            }
        }
    }
}
