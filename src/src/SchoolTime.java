package src;

import java.util.Objects;

public class SchoolTime {
    public static final Lesson lesson1 = new Lesson(new S_time(8, 40));
    public static final Lesson lesson2 = new Lesson(new S_time(9, 25));
    public static final Lesson lesson3 = new Lesson(new S_time(10, 20));
    public static final Lesson lesson4 = new Lesson(new S_time(11, 5));
    public static final Lesson lesson5 = new Lesson(new S_time(12, 0));
    public static final Lesson lesson6 = new Lesson(new S_time(13, 5));
    public static final Lesson lesson7 = new Lesson(new S_time(13, 50));
    public static final Lesson lesson8 = new Lesson(new S_time(14, 40));
    public static final Lesson lesson9 = new Lesson(new S_time(15, 20));



    public static class Lesson {
        private S_time start, end;

        public Lesson(S_time start) {
            this.start = start;
            if (start.getMinutes()<20){
                setEnd(new S_time(start.getHours(), start.getMinutes()+40));
            }
            else {
                setEnd(new S_time(start.getHours()+1, start.getMinutes()-20));
            }
        }

        public S_time getStart() {
            return start;
        }

        public void setStart(S_time start) {
            this.start = start;
        }

        public S_time getEnd() {
            return end;
        }

        public void setEnd(S_time end) {
            this.end = end;
        }

        public boolean equals(Lesson o) {
            if (o == null){
                return false;
            }
            return o.start.equals(start) && o.end.equals(end);
        }
        public boolean inRange(S_time time){
            return time.getHours()*60 + time.getMinutes() >= start.getHours()*60 + start.getMinutes() &&
                    time.getHours()*60 + time.getMinutes() <= end.getHours()*60 + end.getMinutes();
        }

    }

    public static class S_time{
        private int Hours;
        private int Minutes;

        public S_time(int hours, int minutes) {
            Hours = hours;
            Minutes = minutes;
        }

        public int getHours() {
            return Hours;
        }

        public void setHours(int hours) {
            Hours = hours;
        }

        public int getMinutes() {
            return Minutes;
        }

        public void setMinutes(int minutes) {
            Minutes = minutes;
        }
        public boolean equals(S_time time){
            return this.getMinutes() == time.getMinutes() && this.getHours() == time.getHours();
        }
    }
}
