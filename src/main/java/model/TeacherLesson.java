package model;

import javax.persistence.*;

@Entity
@Table(name = "teacher_lesson")
public class TeacherLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher_lesson")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_lesson")
    private Lesson lesson;

    public long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}