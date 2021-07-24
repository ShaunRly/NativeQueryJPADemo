package com.example.jpaadvanceddemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@AllArgsConstructor
@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class ScienceSection extends Section{
    private final int scienceCredit;
    private int labRoomNumber;
}
