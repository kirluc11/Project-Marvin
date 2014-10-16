package selector;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Lukas on 16.10.2014.
 */
public class QuestionSelector implements Serializable{



    public QuestionSelector() throws IOException {
        laodData();
    }

    private void laodData() throws IOException {
        FileReader fr = new FileReader(new File("/../Questions"));
        BufferedReader br = new BufferedReader(fr);

        String line = "";

        while((line = br.readLine()) != null)
        {
            String[] parts = line.split(";");

        }
    }
}
