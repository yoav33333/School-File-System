package src;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new FindLesson().start();
        //new widgets();

        new create_file.builder().getInstance()
                .setMainPath("C:\\Users\\ADMIN\\Desktop\\עבודות\\י");

        System.out.println(System.getProperty("user.home") + "\\Desktop\\עבודות\\י");
        System.out.println("C:\\Users\\ADMIN\\Desktop\\עבודות\\י");
    }
}