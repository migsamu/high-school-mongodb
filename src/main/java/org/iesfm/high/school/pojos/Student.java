package org.iesfm.high.school.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "students")
public class Student {
    @Id
    private String nif;
    private String name;
    private String surname;
    private int courseId;
    private List<Absence> absences;

    @JsonCreator
    public Student(@JsonProperty("nif") String nif,
                   @JsonProperty("name") String name,
                   @JsonProperty("surname") String surname,
                   @JsonProperty("courseId") int courseId,
                   @JsonProperty("absences") List<Absence> absences) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.courseId = courseId;
        this.absences = absences;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return courseId == student.courseId && Objects.equals(nif, student.nif) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(absences, student.absences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, courseId, absences);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", courseId=" + courseId +
                ", absences=" + absences +
                '}';
    }
}
