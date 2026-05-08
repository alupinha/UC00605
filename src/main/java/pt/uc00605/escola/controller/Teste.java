package pt.uc00605.escola.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class Teste {

    @GetMapping("/hello")

    public String hello () {
        return "Olá Paula";
    }
         
}
