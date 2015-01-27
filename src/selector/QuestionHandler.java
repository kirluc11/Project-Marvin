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

    private LinkedList<Question> usedQuestion = new LinkedList<Question>();
    private Question currentQuestion;
    private boolean currentQuestionAnswered = true;
    private LinkedList<String> currentQuestionAnswers = null;
    private int right = 0;
    private int takenHints = 0;
    private Question lastHintQuestion;


    public QuestionHandler(AssetManager am) throws Exception {
        RandomQuestionSelector.getInstance(am).questionPickSystem();
        usedQuestion = RandomQuestionSelector.getInstance().getUsedQuestion();

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
            answer.replaceAll(" ", "\n");
            return answer;
        }
        return null;
    }

    public Question getNextQuestion()
    {
        if(usedQuestion != null && usedQuestion.size() >= 0)
        {
            if(currentQuestionAnswered)
            {
                currentQuestionAnswered = false;
                currentQuestion = usedQuestion.getFirst();
                usedQuestion.removeFirst();
            }
            return currentQuestion;
        }
        return null;
    }

    public String getCat()
    {
        return Language.getInstance().isEnglish() ? currentQuestion.getEngCat() : currentQuestion.getGerCat();
    }

    public int getRight() {
        return right;
    }

    public String getHint()
    {
        if(currentQuestion.equals(lastHintQuestion))
        {
            return Language.getInstance().isEnglish() ? currentQuestion.getEngHint() : currentQuestion.getGerHint();
        }
        else
        {
            if(takenHints < 2)
            {
                takenHints++;
                lastHintQuestion = currentQuestion;
                return Language.getInstance().isEnglish() ? currentQuestion.getEngHint() : currentQuestion.getGerHint();
            }
            else
            {
                return Language.getInstance().getActualLanguage()[15];
            }
        }
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
