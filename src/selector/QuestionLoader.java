package selector;

import beans.Question;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Lukas on 16.10.2014.
 */
public class QuestionLoader implements Serializable{

    private LinkedList<Question> questions = new LinkedList<Question>();

    public QuestionLoader() throws IOException {
        loadData();
    }

    private void loadData() throws IOException {
        FileReader fr = new FileReader(new File("/../Questions"));
        BufferedReader br = new BufferedReader(fr);

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
            String engHit = parts[14];


        }
    }
}
