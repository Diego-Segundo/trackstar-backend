package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Apartment {

    private String name;

    public Apartment(){

    }
    public Apartment(String name)  {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "name='" + name + '\'' +
                '}';
    }
}
