package selector;

import beans.Question;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Lukas on 16.10.2014.
 */
public class RandomQuestionSelector {

    private LinkedHashMap<String, LinkedList<Question>> questions;

    public RandomQuestionSelector() throws Exception {
        questions = QuestionLoader.getInstance().getQuestions();
    }

}
