package beans;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Lukas on 16.10.2014.
 */
public class Question implements Serializable
{

    private String gerQuestion;
    private String gerRightAnswer;
    private LinkedList<String> gerWrongAnswers;
    private String gerHint;
    private String gerCat;

    private String engQuestion;
    private String engRightAnswer;
    private LinkedList<String> engWrongAnswers;
    private String engHint;
    private String engCat;

    public Question(String gerQuestion, String gerRightAnswer, LinkedList<String> gerWrongAnswers, String gerHint, String gerCat, String engQuestion, String engRightAnswer, LinkedList<String> engWrongAnswers, String engHint, String engCat) {
        this.gerQuestion = gerQuestion;
        this.gerRightAnswer = gerRightAnswer;
        this.gerWrongAnswers = gerWrongAnswers;
        this.gerHint = gerHint;
        this.gerCat = gerCat;
        this.engQuestion = engQuestion;
        this.engRightAnswer = engRightAnswer;
        this.engWrongAnswers = engWrongAnswers;
        this.engHint = engHint;
        this.engCat = engCat;
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

    public String getGerHint() {
        return gerHint;
    }

    public void setGerHint(String gerHint) {
        this.gerHint = gerHint;
    }

    public String getGerCat() {
        return gerCat;
    }

    public void setGerCat(String gerCat) {
        this.gerCat = gerCat;
    }

    public String getEngCat() {
        return engCat;
    }

    public void setEngCat(String engCat) {
        this.engCat = engCat;
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

    public String getEngHint() {
        return engHint;
    }

    public void setEngHint(String engHint) {
        this.engHint = engHint;
    }

    @Override
    public String toString() {
        return "Question{"
                + "cat: " +gerCat + " {"
                + gerQuestion + " "
                + gerRightAnswer
                + ", " + gerWrongAnswers + "} "
                + "hint: " + gerHint + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (engCat != null ? !engCat.equals(question.engCat) : question.engCat != null) return false;
        if (engHint != null ? !engHint.equals(question.engHint) : question.engHint != null) return false;
        if (engQuestion != null ? !engQuestion.equals(question.engQuestion) : question.engQuestion != null)
            return false;
        if (engRightAnswer != null ? !engRightAnswer.equals(question.engRightAnswer) : question.engRightAnswer != null)
            return false;
        if (engWrongAnswers != null ? !engWrongAnswers.equals(question.engWrongAnswers) : question.engWrongAnswers != null)
            return false;
        if (gerCat != null ? !gerCat.equals(question.gerCat) : question.gerCat != null) return false;
        if (gerHint != null ? !gerHint.equals(question.gerHint) : question.gerHint != null) return false;
        if (gerQuestion != null ? !gerQuestion.equals(question.gerQuestion) : question.gerQuestion != null)
            return false;
        if (gerRightAnswer != null ? !gerRightAnswer.equals(question.gerRightAnswer) : question.gerRightAnswer != null)
            return false;
        if (gerWrongAnswers != null ? !gerWrongAnswers.equals(question.gerWrongAnswers) : question.gerWrongAnswers != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gerQuestion != null ? gerQuestion.hashCode() : 0;
        result = 31 * result + (gerRightAnswer != null ? gerRightAnswer.hashCode() : 0);
        result = 31 * result + (gerWrongAnswers != null ? gerWrongAnswers.hashCode() : 0);
        result = 31 * result + (gerHint != null ? gerHint.hashCode() : 0);
        result = 31 * result + (gerCat != null ? gerCat.hashCode() : 0);
        result = 31 * result + (engQuestion != null ? engQuestion.hashCode() : 0);
        result = 31 * result + (engRightAnswer != null ? engRightAnswer.hashCode() : 0);
        result = 31 * result + (engWrongAnswers != null ? engWrongAnswers.hashCode() : 0);
        result = 31 * result + (engHint != null ? engHint.hashCode() : 0);
        result = 31 * result + (engCat != null ? engCat.hashCode() : 0);
        return result;
    }
}
