package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    private String[] arr;
    private int limit;
    public SampleController() {
        this.arr = new String[20];
        this.arr[0] = "bharathi";
        this.arr[1] = "kamini";
        this.arr[2] = "shalini";
        this.arr[3] = "avinash";
        this.arr[4] = "kabinthra";

        this.limit = 5;
    }

    @GetMapping("/all")
    public String getAll() {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + " | ";
        }
        return result;
    }
}