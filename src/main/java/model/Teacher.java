package model;

import javax.persistence.*;

@Entity
@Table(name = "model.Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_teacher", nullable = false)
    private long id_teacher;

    @Column (name = "first_name", length = 255)
    private String FirstName;

    @Column (name = "last_name", length = 255)
    private String LastName;

    public Teacher(String FirstName, String LastName,  long id_teacher){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.id_teacher = id_teacher;
    }

    public Teacher() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public long getId_teacher() {
        return id_teacher;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setId_teacher(long id_teacher) {
        this.id_teacher = id_teacher;
    }

    @Override
    public  String toString(){
        return "model.Teacher{" + "FirstName" + FirstName + "LastName" + LastName + "}";
    }

}
