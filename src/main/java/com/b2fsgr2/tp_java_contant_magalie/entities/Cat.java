package com.b2fsgr2.tp_java_contant_magalie.entities;

import javax.persistence.*;

@Entity(name = "CAT")
@DiscriminatorValue("C")
public class Cat extends Animal{
    @Column(name="CHIPID")
    private String chipId;

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

}
