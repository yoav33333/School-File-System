package src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static src.SchoolTime.*;

public class FindLesson extends Thread{
    private final String history = "היסטוריה";
    private final String math = "מתמטיקה";
    private final String physics = "פיזיקה";
    private final String CS = "מדמח";
    private final String lang = "לשון";
    private final String english = "אנגלית";
    private final String bible = "תנך";
    private final String RandShit = "רנדומאלי";
    private LocalTime TimeL;
    static ArrayList<HashMap<SchoolTime.Lesson, String>> Schedule = new ArrayList<>();
    widgets widgets = new widgets();

    public FindLesson() {
    }

    public void run()  {
        Schedule = createSchedule();
        while (true){
            try {
                int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-1;
                setSubject(Schedule.get(day).get(timeToLesson()));

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }
            System.out.println(new create_file.builder().getInstance().getSubject());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private ArrayList<HashMap<SchoolTime.Lesson, String>> createSchedule(){
        ArrayList<HashMap<SchoolTime.Lesson, String>> list = new ArrayList<>();
        list.add(Sunday());
        list.add(Monday());
        list.add(Tuesday());
        list.add(Wendsday());
        list.add(Thursday());
        list.add(Weekend());
        list.add(Weekend());
        return list;
    }

    private HashMap<SchoolTime.Lesson, String> Sunday(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, history);
        day.put(SchoolTime.lesson2, math);
        day.put(lesson3, RandShit);
        day.put(SchoolTime.lesson4, null);
        day.put(SchoolTime.lesson5, physics);
        day.put(SchoolTime.lesson6, physics);
        day.put(SchoolTime.lesson7, physics);
        return day;
    }

    private HashMap<SchoolTime.Lesson, String> Weekend(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, null);
        day.put(SchoolTime.lesson2, null);
        day.put(lesson3, null);
        day.put(SchoolTime.lesson4, null);
        day.put(SchoolTime.lesson5, null);
        day.put(SchoolTime.lesson6, null);
        day.put(SchoolTime.lesson7, null);
        return day;
    }

    private HashMap<SchoolTime.Lesson, String> Monday(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, null);
        day.put(SchoolTime.lesson2, CS);
        day.put(lesson3, CS);
        day.put(SchoolTime.lesson4, lang);
        day.put(SchoolTime.lesson5, english);
        day.put(SchoolTime.lesson6, CS);
        day.put(SchoolTime.lesson7, CS);
        day.put(SchoolTime.lesson8, CS);
        return day;
    }

    private HashMap<SchoolTime.Lesson, String> Tuesday(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, null);
        day.put(SchoolTime.lesson2, lang);
        day.put(lesson3, math);
        day.put(SchoolTime.lesson4, english);
        day.put(SchoolTime.lesson5, english);
        day.put(SchoolTime.lesson6, history);
        day.put(SchoolTime.lesson7, bible);
        return day;
    }


    private HashMap<SchoolTime.Lesson, String> Wendsday(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, physics);
        day.put(SchoolTime.lesson2, physics);
        day.put(lesson3, RandShit);
        day.put(SchoolTime.lesson4, CS);
        day.put(SchoolTime.lesson5, CS);
        day.put(SchoolTime.lesson6, CS);
        day.put(SchoolTime.lesson7, bible);
        day.put(SchoolTime.lesson8, math);
        day.put(SchoolTime.lesson9, math);
        return day;
    }

    private HashMap<SchoolTime.Lesson, String> Thursday(){
        HashMap<SchoolTime.Lesson, String> day = new HashMap<SchoolTime.Lesson, String>();
        day.put(lesson1, bible);
        day.put(SchoolTime.lesson2, RandShit);
        day.put(lesson3, math);
        day.put(SchoolTime.lesson4, math);
        day.put(SchoolTime.lesson5, english);
        day.put(SchoolTime.lesson6, lang);
        day.put(SchoolTime.lesson7, history);
        return day;
    }

    private SchoolTime.Lesson timeToLesson(){
        SchoolTime.Lesson lesson =  new SchoolTime.Lesson(new SchoolTime.S_time(LocalTime.now().getHour(), LocalTime.now().getMinute()));
        if (lesson1.inRange(lesson.getStart())){
            return lesson1;
        }
        else if (lesson2.inRange(lesson.getStart())) {
            return lesson2;
        }
        else if (lesson3.inRange(lesson.getStart())) {
            return lesson3;
        }
        else if (lesson4.inRange(lesson.getStart())) {
            return lesson4;
        }
        else if (lesson5.inRange(lesson.getStart())) {
            return lesson5;
        }
        else if (lesson6.inRange(lesson.getStart())) {
            return lesson6;
        }
        else if (lesson7.inRange(lesson.getStart())) {
            return lesson7;
        }
        else if (lesson8.inRange(lesson.getStart())) {
            return lesson8;
        }
        else if (lesson9.inRange(lesson.getStart())) {
            return lesson9;
        }

        return null;
    }

    private void setSubject(String subject) throws InterruptedException {
        if (subject != null && !widgets.CSubject.getState()) {
            widgets.subject.setEnabled(false);

            new create_file.builder().getInstance().setSubject(subject);
            widgets.currentSubject.setText(new create_file.builder().getInstance().getSubject());

        }
        else {
            widgets.CSubject.setState(true);
            widgets.subject.setEnabled(true);
            new create_file.builder().getInstance().setSubject(widgets.subject.getItem());
        }

        widgets.currentSubject.setText(new create_file.builder().getInstance().getSubject());
    }


}
