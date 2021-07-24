package com.example.jpaadvanceddemo.dao;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ComputerSection extends Section{
    private final int computerCredit;

    //Non-Lombok constructor and getter
    public ComputerSection(String id, String courseCode, String roomNumber, String professor, int computerCredit){
        super(id, courseCode, roomNumber, professor);
        this.computerCredit = computerCredit;
    }

    public int getComputerCredit() {
        return computerCredit;
    }
}
