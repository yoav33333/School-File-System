package src;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class choice_file_type extends Choice {
    public choice_file_type() {
        this.setBounds(300, 810, 100, 60);
        this.setSize(100, 20);
        this.addItem("Word Document");
        this.addItem("Excel Sheet");
        this.addItem("PowerPoint Presentation");
        this.setVisible(true);


    }
    public String getItem(){
        switch(this.getSelectedItem()) {
            case "Word Document":
                return ".docx";
            case "Excel Sheet":
                return ".xlsx";
            case "PowerPoint Presentation":
                return ".pptx";
            default:
                return "";
        }
    }

}
