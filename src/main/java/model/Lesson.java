package model;

import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_lesson;

    @Column (name = "name_lesson", length = 255)
    private String NameLesson;

    public Lesson(String NameLesson, long id_lesson){
        this.NameLesson = NameLesson;
        this.id_lesson = id_lesson;
    }

    public Lesson() {

    }

    public long getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(long id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getNameLesson() {
        return NameLesson;
    }

    public void setNameLesson(String nameLesson) {
        NameLesson = nameLesson;
    }

    @Override
    public  String toString(){
        return "model.Lesson{" + "NameLesson: " + NameLesson + "}";
    }
}
