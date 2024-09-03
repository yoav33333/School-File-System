package src;

import java.awt.*;

public class choice_subject extends Choice {
    private String history = "היסטוריה";
    private String math = "מתמטיקה";
    private String physics = "פיזיקה";
    private String CS = "מדמח";
    private String lang = "לשון";
    private String english = "אנגלית";
    private String bible = "תנך";
    private String RandShit = "רנדומאלי";
    public choice_subject() {
        this.addItem(history);
        this.addItem(math);
        this.addItem(physics);
        this.addItem(CS);
        this.addItem(lang);
        this.addItem(english);
        this.addItem(bible);
        this.addItem(RandShit);


    }
    public String getItem(){
        return this.getSelectedItem();
    }

    public void isVisible(boolean b) {
        setVisible(b);
    }
}
