package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@RequestMapping("/saludar")
public class HolaMnundoController {
    @GetMapping("/hola")
    public String saludar(){

        return "nunca pares de aprener";
    }
}
