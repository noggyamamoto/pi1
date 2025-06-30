package br.edu.ifb.java_web_dev.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
@CrossOrigin
public class CalculatorRestController {

    // Métodos GET
    @GetMapping("/sum")
    public double sum(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/sub")
    public double sub(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/mul")
    public double mul(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/div")
    public double div(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new IllegalArgumentException("Divisão por zero não permitida");
        return a / b;
    }

    // Métodos POST
    @PostMapping("/sum")
    public double sumPost(@RequestBody Operands operands) {
        return operands.a + operands.b;
    }

    @PostMapping("/sub")
    public double subPost(@RequestBody Operands operands) {
        return operands.a - operands.b;
    }

    @PostMapping("/mul")
    public double mulPost(@RequestBody Operands operands) {
        return operands.a * operands.b;
    }

    @PostMapping("/div")
    public double divPost(@RequestBody Operands operands) {
        if (operands.b == 0) throw new IllegalArgumentException("Divisão por zero não permitida");
        return operands.a / operands.b;
    }

    // Classe auxiliar para POST
    public static class Operands {
        public double a;
        public double b;
    }
}