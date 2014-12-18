package selector;

import android.content.res.AssetManager;
import beans.Language;
import beans.Question;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Lukas on 21.11.2014.
 */
public class QuestionHandler {

    private static QuestionHandler questionHandlerInstance;

    private LinkedList<Question> usedQuestion = new LinkedList<Question>();
    private Question currentQuestion;
    private boolean currentQuestionAnswered = true;
    private LinkedList<String> currentQuestionAnswers = null;
    private int right = 0;


    public QuestionHandler(AssetManager am) throws Exception {
        usedQuestion = RandomQuestionSelector.getInstance(am).getUsedQuestion();
    }

    public String getNextAnswer()
    {
        if(currentQuestion != null)
        {
            if(currentQuestionAnswers == null)
            {
                if(Language.getInstance().isEnglish())
                {
                    currentQuestionAnswers = (LinkedList<String>) currentQuestion.getEngWrongAnswers().clone();
                    currentQuestionAnswers.add(currentQuestion.getEngRightAnswer());
                }
                else
                {
                    currentQuestionAnswers = (LinkedList<String>) currentQuestion.getGerWrongAnswers().clone();
                    currentQuestionAnswers.add(currentQuestion.getGerRightAnswer());
                }
            }
            Random rand = new Random();
            int i = rand.nextInt(currentQuestionAnswers.size());
            String answer = currentQuestionAnswers.get(i);

            currentQuestionAnswers.remove(i);
            if(currentQuestionAnswers.size() == 0)
            {
                currentQuestionAnswers = null;
            }
            System.out.println();
            return answer;
        }
        return null;
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

    public int getRight() {
        return right;
    }

    /**
     * @param answer
     * @return 0: right,
     *         1: wrong,
     *         2: no current question
     */
    public int checkAnswer(String answer)
    {
        if(currentQuestion == null)
        {
            return 2;
        }
        else
        {
            currentQuestionAnswered = true;
            if(Language.getInstance().isEnglish())
            {
                if(answer != null && answer.equals(currentQuestion.getEngRightAnswer()))
                {
                    right++;
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                if(answer != null && answer.equals(currentQuestion.getGerRightAnswer()))
                {
                    right++;
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
        }
    }
}
