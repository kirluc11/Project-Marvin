package beans;

/**
 * Created by Lukas on 27.11.2014.
 */
public class Language
{
    private static Language instance;

    private final String[] GERMAN={
            "Start",
            "Info",
            "Mitwirkende",
            "MARVIN UND\n\nSEINE FREUNDE",
            "SO WIRD GESPIELT",                                  //4
            "Drücke auf \"Start\" und beantworte 10 Fragen. Falls du Hilfe brauchst, frage Schüler, Lehrer oder klicke auf die Frage, um einen Tipp zu erhalten (du hast aber nur 2!).",
            "Hol dir zum Schluss ein kleines Geschenk! ;)",
            " Sekunden verbleiben.",
            "Sekunde verbleibt.",
            "HERZLICHEN\nGLÜCKWUNSCH!",                         //9
            "Du hast ",
            " von 10 Fragen richtig beantwortet.",
            "Hi, ich bin Marvin, viel Spaß beim Fragen beantworten!",
            "Tipp",
            "zurück",                                           //14
            "Leider kein Tipp mehr verfügbar!",
            "Auweeeh!",
            "Du hast leider nur "
    };
    private final String[] ENGLISH={
            "Start",
            "Info",
            "Credits",
            "MARVIN AND\n\nHIS FRIENDS",
            "HOW TO PLAY",                                      //4
            "Press \"Start\" and answer 10 questions. If you need help, ask a student, a teacher or touch the question to get a hint (but you have only 2!).",
            "Get a little present at the end! ;)",
            " seconds remaining.",
            " second remaining.",
            "CONGRATULATIONS!",                                //9
            "You got ",
            " out of 10 questions right.",
            "Hi, I'm Marvin, have fun answering my questions!",
            "Hint",
            "back",                                            //14
            "You don't have any hints anymore!",
            "Oh nooo!",
            "You only got "
    };
    private boolean english = true;

    public static Language getInstance()
    {
        if(instance == null)
        {
            instance = new Language();
        }
        return instance;
    }

    private Language(){}

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
