package com.b2fsgr2.tp_java_contant_magalie.entities;

import com.b2fsgr2.tp_java_contant_magalie.enumeration.FishEnv;

import javax.persistence.*;

@Entity(name = "FISH")
public class Fish extends Animal{
    @Column(name="LIVING_ENV")
    @Enumerated(EnumType.STRING)
    private FishEnv livingEnv;

    public FishEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
