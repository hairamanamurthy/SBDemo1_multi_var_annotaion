package com.example.SBDemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public  String helloWorld(){
        return "Hello world";
    }
@GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name){
        return "Hello" + name;
    }
@GetMapping("/show/{showId}/seat/{seatId}")
    public String bMSExample(@PathVariable("showId") String showId,@PathVariable("seatId") int seatId){
        return "Hello " + showId +" your Seat_id: "+ seatId;
    }
}
