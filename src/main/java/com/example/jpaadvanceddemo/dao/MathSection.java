package com.example.jpaadvanceddemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MathSection extends Section{
    private final int mathCredit;

    public MathSection(String id, String courseCode, String roomNumber, String professor, int mathCredit) {
        super(id, courseCode, roomNumber, professor);
        this.mathCredit = mathCredit;
    }

    public int getMathCredit() {
        return mathCredit;
    }
}
