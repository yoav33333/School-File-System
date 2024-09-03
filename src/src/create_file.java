package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class create_file {
    private String Subject;
    private String FileName;
    private String MainPath;
    private String Date;
    private String path;
    private String ending;

    private create_file(builder builder){
        this.Subject = builder.Subject;
        this.FileName = builder.FileName;
        this.MainPath = builder.MainPath;
        this.Date = builder.Date;
        this.ending = builder.ending;
    }

    public void create()  {
        path = MainPath + "\\" + Subject + "\\" + Date + "\\" + FileName + ending;
        try {
            Files.createDirectories(Paths.get(MainPath, Subject, Date));
            Files.createFile(Paths.get(path));



        } catch (IOException e) {
            System.err.println(path);
        }
        try {
            if (ending.equals(".xlsx")){
                Path pathXL = Paths.get("\\src\\src\\baseXL.txt");
                Files.write(Paths.get(path), Files.readAllBytes(pathXL));
                System.out.println(Arrays.toString(Files.readAllBytes(pathXL)));
            }
            System.out.println("File created successfully: " + path);
            new openFile(Paths.get(path));
        }
        catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }

    public String getPath(){
        return path;
    }
    public static class builder {
        private String FileName;
        private String Subject;
        private String Date;
        private String MainPath;
        private String ending;
        private static builder Instance;

        public builder getInstance() {
            if (Instance == null){
                Instance = new builder();
            }
            return Instance;
        }

        public builder setSubject(String subject){
            Instance.Subject = subject;
            return this;
        }

        public String getSubject() {
            return Subject;
        }

        public builder setFileName(String fileName){
            Instance.FileName = fileName;
            return this;
        }
        public builder setEnding(String ending){
            Instance.ending = ending;
            return this;
        }
        public builder setMainPath(String mainPath){
            Instance.MainPath = mainPath;
            return this;
        }
        public builder setDate(String date){
            Instance.Date = date;
            return this;
        }
        public create_file build(){
            return new create_file(Instance);
        }
    }
}

