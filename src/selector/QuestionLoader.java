package selector;

import android.content.res.AssetManager;
import beans.Question;

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
        return questionLoaderInstance;
    }

    public static QuestionLoader getInstance(AssetManager am) throws IOException, FileNotFoundException
    {
        if(questionLoaderInstance ==  null){
            questionLoaderInstance = new QuestionLoader(am);
        }
        return questionLoaderInstance;
    }

    private QuestionLoader(AssetManager am) throws IOException, FileNotFoundException {
        loadData(am);
    }

    private void loadData(AssetManager am) throws IOException, FileNotFoundException {


        InputStream is = am.open("Questions.csv");
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line = "";

        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(";");

            final int MAX = 10;

            String gerQuestion = parts[0];
            String gerRightAnswer = parts[1].length() > MAX ? parts[1].replaceFirst("\\s+", "\n") : parts[1];
            LinkedList<String> gerWrongAnswers = new LinkedList<String>();
            gerWrongAnswers.add(parts[2].length() > MAX ? parts[2].replaceFirst("\\s+", "\n") : parts[2]);
            gerWrongAnswers.add(parts[3].length() > MAX ? parts[3].replaceFirst("\\s+", "\n") : parts[3]);
            gerWrongAnswers.add(parts[4].length() > MAX ? parts[4].replaceFirst("\\s+", "\n") : parts[4]);
            gerWrongAnswers.add(parts[5].length() > MAX ? parts[5].replaceFirst("\\s+", "\n") : parts[5]);
            String gerHint = parts[6];
            String gerCat = parts[7];

            String engQuestion = parts[8];
            String engRightAnswer = parts[9].length() > MAX ? parts[9].replaceFirst("\\s+", "\n") : parts[9];
            LinkedList<String> engWrongAnswers = new LinkedList<String>();
            engWrongAnswers.add(parts[10].length() > MAX ? parts[10].replaceFirst("\\s+", "\n") : parts[10]);
            engWrongAnswers.add(parts[11].length() > MAX ? parts[11].replaceFirst("\\s+", "\n") : parts[11]);
            engWrongAnswers.add(parts[12].length() > MAX ? parts[12].replaceFirst("\\s+", "\n") : parts[12]);
            engWrongAnswers.add(parts[13].length() > MAX ? parts[13].replaceFirst("\\s+", "\n") : parts[13]);
            String engHint = parts[14];
            String engCat = parts[15];

            /*String gerQuestion = fixUml(parts[0]);
            String gerRightAnswer = fixUml(parts[1]);
            LinkedList<String> gerWrongAnswers = new LinkedList<String>();
            gerWrongAnswers.add(fixUml(parts[2]));
            gerWrongAnswers.add(fixUml(parts[3]));
            gerWrongAnswers.add(fixUml(parts[4]));
            gerWrongAnswers.add(fixUml(parts[5]));
            String gerHint = fixUml(parts[6]);

            String cat = fixUml(parts[7]);

            String engQuestion = fixUml(parts[8]);
            String engRightAnswer = fixUml(parts[9]);
            LinkedList<String> engWrongAnswers = new LinkedList<String>();
            engWrongAnswers.add(fixUml(parts[10]));
            engWrongAnswers.add(fixUml(parts[11]));
            engWrongAnswers.add(fixUml(parts[12]));
            engWrongAnswers.add(fixUml(parts[13]));
            String engHint = fixUml(parts[14]);*/

            Question q = new Question(gerQuestion,gerRightAnswer,gerWrongAnswers,gerHint,gerCat,engQuestion,engRightAnswer,engWrongAnswers,engHint, engCat);
            sortInCatList(q);
            if(!keys.contains(gerCat))
            {
                keys.add(gerCat);
            }
        }
    }

    private String fixUml(String str)
    {
        str=str.replace("&uuml","ü");
        str=str.replace("&auml","ä");
        str=str.replace("&ouml","ö");
        str=str.replace("&Uuml","Ü");
        str=str.replace("&Auml","Ä");
        str=str.replace("&Ouml","Ö");
        str=str.replace("&eur","€");
        str=str.replace("&dol","$");
        str=str.replace("&ssharp","ß");

        return str;
    }

    private void sortInCatList(Question q)
    {
        LinkedList<Question> qForCat = questions.get(q.getGerCat());
        if(qForCat == null)
        {
            qForCat = new LinkedList<Question>();
        }
        qForCat.add(q);
        questions.put(q.getGerCat(), qForCat);
    }

    public LinkedHashMap<String, LinkedList<Question>> getQuestions() {
        return (LinkedHashMap<String, LinkedList<Question>>) questions.clone();
    }

    public LinkedList<String> getKeys() {
        return (LinkedList<String>) keys.clone();
    }
}
