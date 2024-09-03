package src;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

public class runFrame extends Frame{
    boolean b = true;
    public runFrame(){
        Frame();
    }

    public void Frame(){
        setTitle("File system");
        setBounds(0,0,1920,1080);
        setSize(900, 200);
        setVisible(b);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


    }

}
