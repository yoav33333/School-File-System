package src;

public class globals {
    private globals instance;

    public globals getInstance(){
        if (instance == null){
            instance = new globals();
        }
        return instance;
    }

    public boolean windowOn = false;
}
