package beans;

/**
 * Created by Lukas on 27.11.2014.
 */
public class Language {

    private static Language instance;

    private final String[] GERMAN={"Start", "Steuerung","Mitwirkende"};
    private final String[] ENGLISH={"Start", "Control","Credits"};
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
