package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class widgets extends runFrame{
    Button createFileButton = new Button("Create File");
    Label currentSubject = new Label("Current Subject");
    TextField fileName = new TextField("File Name");
    choice_file_type fileTypeChoice = new choice_file_type();
    Checkbox CSubject = new Checkbox("בחירת נושא ידנית");
    choice_subject subject = new choice_subject();
    boolean b = true;

    Choice Sub = new Choice();
    public widgets(){

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));
        add(CSubject);
        add(subject);
        add(fileTypeChoice);
        add(createFileButton);
        add(fileName);
        add(currentSubject);
        CSubject.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                subject.setEnabled(true);
                new create_file.builder().getInstance().setSubject(subject.getItem());
                currentSubject.setText(subject.getItem());
            }
        });


        subject.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                currentSubject.setText(subject.getItem());
            }
        });
        createFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new create_file.builder().getInstance()
                        .setEnding(fileTypeChoice.getItem())
                        .setFileName(fileName.getText())
                        .setDate(LocalDate.now().toString())
                        .build().create();
            }
        });



    }
}
