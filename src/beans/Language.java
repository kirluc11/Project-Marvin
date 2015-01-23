package beans;

/**
 * Created by Lukas on 27.11.2014.
 */
public class Language {

    private static Language instance;

    private final String[] GERMAN={"Start", "Info","Credits","MARVIN UND SEINE FREUNDE","SO WIRD GESPIELT","Es geht eigentlich nur darum, dass du dich ein bisschen mit der Schule beschäftigst." +
            " Das heißt: nachdem du auf \"Start\" gedrückt hast, erwarten dich nur 10 kurze Fragen, die du beantworten sollst. Solltest du eine Frage nicht beantworten können, gibt es diese Möglichkeiten: " +
            "gehe zu den Räumen, frage Schüler, verwende einen Tipp (du hast aber nur 2!) oder - am besten: frage einen Lehrer. Sie werden dir GERNE helfen!",
            "Und nicht vergessen, nachher dein kleines Geschenk abzuholen! ;)"," Sekunden verbleiben.","Sekunde verbleibt.","HERZLICHEN GLÜCKWUNSCH!","Du hast "," von 10 Fragen richtig beantwortet."};
    private final String[] ENGLISH={"Start", "Info","Credits","MARVIN AND HIS FRIENDS","HOW TO PLAY","It's basically just about you getting in touch with the school. It means: After you clicked on \"Start\", you " +
            "should only answer 10 little questions. In case you can't answer a question on your own, you can do these things: go to the rooms, ask students, use a hint (but you have only 2!) or" +
            " - the best thing: ask a teacher. They'll LOVE to help you.",
            "And don't forget to come and take your little present at the end! ;)"," seconds remain."," second remains.","CONGRATULATIONS!","You got "," out of 10 questions right."};
    private boolean english = true;

    public static Language getInstance()
    {
        if(instance == null)
        {
            instance = new Language();
        }
        return instance;
    }

    private Language()
    {

    }

    public String[] getActualLanguage()
    {
        if(english)
        {
            return ENGLISH;
        }
        return GERMAN;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }
}
