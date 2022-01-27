package org.iesfm.high.school.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Absence {
    private Date date;
    private String module;

    @JsonCreator
    public Absence(
            @JsonProperty("date") Date date,
            @JsonProperty("module") String module) {
        this.date = date;
        this.module = module;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(date, absence.date) && Objects.equals(module, absence.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, module);
    }

    @Override
    public String toString() {
        return "Absence{" +
                "date=" + date +
                ", module='" + module + '\'' +
                '}';
    }
}
