package com.example.springbootproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {

    @RequestMapping
    public void testCotroller(){
        return ;
    }
}
