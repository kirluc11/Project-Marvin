package selector;

import beans.Question;
import resources.CSVReader;

import java.io.*;
import java.util.*;

/**
 * Created by Lukas on 16.10.2014.
 */
public class QuestionLoader implements Serializable{

    private static QuestionLoader questionLoaderInstance;
    private LinkedHashMap<String, LinkedList<Question>> questions = new LinkedHashMap<String, LinkedList<Question>>();
    private LinkedList<String> keys = new LinkedList<String>();

    public static QuestionLoader getInstance() throws IOException, FileNotFoundException
    {
        if(questionLoaderInstance ==  null){
            questionLoaderInstance = new QuestionLoader();
        }
        return questionLoaderInstance;
    }

    private QuestionLoader() throws IOException, FileNotFoundException {
        loadData();
    }

    private void loadData() throws IOException, FileNotFoundException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "trunk" + File.separator + "src" + File.separator + "resources" + File.separator + "Questions.txt")),"UTF-8" );
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("/data/local/tmp/com.example.Project_Marvin/trunk")),"UTF-8" );
        BufferedReader br = new BufferedReader(isr);

        String line = "";

        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(";");

            String gerQuestion = parts[0];
            String gerRightAnswer = parts[1];
            LinkedList<String> gerWrongAnswers = new LinkedList<String>();
            gerWrongAnswers.add(parts[2]);
            gerWrongAnswers.add(parts[3]);
            gerWrongAnswers.add(parts[4]);
            gerWrongAnswers.add(parts[5]);
            String gerHint = parts[6];

            String cat = parts[7];

            String engQuestion = parts[8];
            String engRightAnswer = parts[9];
            LinkedList<String> engWrongAnswers = new LinkedList<String>();
            engWrongAnswers.add(parts[10]);
            engWrongAnswers.add(parts[11]);
            engWrongAnswers.add(parts[12]);
            engWrongAnswers.add(parts[13]);
            String engHint = parts[14];

            Question q = new Question(gerQuestion,gerRightAnswer,gerWrongAnswers,gerHint,cat,engQuestion,engRightAnswer,engWrongAnswers,engHint);
            sortInCatList(q);
            if(!keys.contains(cat))
            {
                keys.add(cat);
            }
            System.out.println(q);
        }
    }

    private void sortInCatList(Question q)
    {
        LinkedList<Question> qForCat = questions.get(q.getCat());
        if(qForCat == null)
        {
            qForCat = new LinkedList<Question>();
        }
        questions.put(q.getCat(), qForCat);
    }

    public LinkedHashMap<String, LinkedList<Question>> getQuestions() {
        return questions;
    }

    public LinkedList<String> getKeys() {
        return keys;
    }

    public static void main(String[] args) {
        try {
            QuestionLoader ql = new QuestionLoader();
        } catch (FileNotFoundException ex)
        {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
