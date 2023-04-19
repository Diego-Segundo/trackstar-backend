package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class Controller {

    private Service service;
   @Autowired
    public Controller(Service service){
        this.service  = service;
    }



    @GetMapping("/")
    public ResponseEntity<String> getUser(){
        Apartment apt1 = new Apartment("Via");

        return new ResponseEntity<>(apt1.getName(), HttpStatus.OK);
    }

    @PostMapping("/apartments")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {

       try {
           File fileObj = new File("Apartment_info");
           if(fileObj.createNewFile()){
               System.out.println("file was created:" + fileObj.getName());
           }else {
               System.out.println("file already exist bruhd");
           }
       }catch (IOException e){
           e.printStackTrace();

       }

        try {
            FileWriter fileWriter = new FileWriter("Apartment_info");
            fileWriter.write(apartment.getName());
            fileWriter.close();
            System.out.println("Successfully written");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(apartment);
        return new ResponseEntity<>(apartment, HttpStatus.OK);

    }
}
