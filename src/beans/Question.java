package beans;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Lukas on 16.10.2014.
 */
public class Question implements Serializable{

    private String gerQuestion;
    private String gerRightAnswer;
    private LinkedList<String> gerWrongAnswers;
    private String gerTip;

    private String cat;

    private String engQuestion;
    private String engRightAnswer;
    private LinkedList<String> engWrongAnswers;
    private String engTip;

    public Question(String gerQuestion, String gerRightAnswer, LinkedList<String> gerWrongAnswers, String gerTip, String cat, String engQuestion, String engRightAnswer, LinkedList<String> engWrongAnswers, String engTip) {
        this.gerQuestion = gerQuestion;
        this.gerRightAnswer = gerRightAnswer;
        this.gerWrongAnswers = gerWrongAnswers;
        this.gerTip = gerTip;
        this.cat = cat;
        this.engQuestion = engQuestion;
        this.engRightAnswer = engRightAnswer;
        this.engWrongAnswers = engWrongAnswers;
        this.engTip = engTip;
    }

    public String getGerQuestion() {
        return gerQuestion;
    }

    public void setGerQuestion(String gerQuestion) {
        this.gerQuestion = gerQuestion;
    }

    public String getGerRightAnswer() {
        return gerRightAnswer;
    }

    public void setGerRightAnswer(String gerRightAnswer) {
        this.gerRightAnswer = gerRightAnswer;
    }

    public LinkedList<String> getGerWrongAnswers() {
        return gerWrongAnswers;
    }

    public void setGerWrongAnswers(LinkedList<String> gerWrongAnswers) {
        this.gerWrongAnswers = gerWrongAnswers;
    }

    public String getGerTip() {
        return gerTip;
    }

    public void setGerTip(String gerTip) {
        this.gerTip = gerTip;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getEngQuestion() {
        return engQuestion;
    }

    public void setEngQuestion(String engQuestion) {
        this.engQuestion = engQuestion;
    }

    public String getEngRightAnswer() {
        return engRightAnswer;
    }

    public void setEngRightAnswer(String engRightAnswer) {
        this.engRightAnswer = engRightAnswer;
    }

    public LinkedList<String> getEngWrongAnswers() {
        return engWrongAnswers;
    }

    public void setEngWrongAnswers(LinkedList<String> engWrongAnswers) {
        this.engWrongAnswers = engWrongAnswers;
    }

    public String getEngTip() {
        return engTip;
    }

    public void setEngTip(String engTip) {
        this.engTip = engTip;
    }
}
