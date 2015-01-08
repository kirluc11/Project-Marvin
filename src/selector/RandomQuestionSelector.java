package selector;

import android.content.res.AssetManager;
import beans.Question;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Lukas on 16.10.2014.
 */
public class RandomQuestionSelector {

    private static RandomQuestionSelector randomQuestionSelectorInstance;

    private LinkedHashMap<String, LinkedList<Question>> questions;
    private LinkedList<Question> usedQuestion = new LinkedList<Question>();
    private LinkedList<String> keys;

    public static RandomQuestionSelector getInstance(AssetManager am) throws Exception {
        if(randomQuestionSelectorInstance == null)
        {
            randomQuestionSelectorInstance = new RandomQuestionSelector(am);
        }
        return randomQuestionSelectorInstance;
    }

    public static RandomQuestionSelector getInstance()
    {
        return randomQuestionSelectorInstance;
    }

    private RandomQuestionSelector(AssetManager am) throws Exception {
        questions = QuestionLoader.getInstance(am).getQuestions();

        keys=QuestionLoader.getInstance().getKeys();
    }

    public LinkedList<Question> getUsedQuestion() {
        return (LinkedList<Question>) usedQuestion.clone();
    }

    public void questionPickSystem() throws IOException
    {
        keys=QuestionLoader.getInstance().getKeys();
        usedQuestion.clear();
        keys.remove("FUN");
        LinkedList<Question> tempQ = questions.get("FUN");
        Random randy = new Random();
        int zz = randy.nextInt(tempQ.size());
        usedQuestion.add(tempQ.get(zz));
        for (int i = 0; i < 9; i++)
        {
            zz=randy.nextInt(keys.size());
            tempQ=questions.get(keys.get(zz));
            keys.remove(zz);
            zz=randy.nextInt(tempQ.size());
            usedQuestion.add(0,tempQ.get(zz));
        }
    }
}
