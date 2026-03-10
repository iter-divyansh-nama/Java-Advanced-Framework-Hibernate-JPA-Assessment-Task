package com.capgemini.author.management.entity;



import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Biography implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String summary;
    private String birthPlace;
    private String birthDate;

    @OneToOne(mappedBy = "biography")
    private Author author;

    public Biography() {}

    public Biography(String summary, String birthPlace, String birthDate) {
        this.summary = summary;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, summary, birthPlace, birthDate);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Biography other = (Biography) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Biography [summary=" + summary +
                ", birthPlace=" + birthPlace +
                ", birthDate=" + birthDate + "]";
    }
}
