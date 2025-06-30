package br.edu.ifb.java_web_dev.controller;

import br.edu.ifb.java_web_dev.model.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
@CrossOrigin
public class CalculatorRestController {

    private final CalculatorService calculatorService = new CalculatorService();

    // Métodos GET
    @GetMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b) {
        return calculatorService.sum(a, b);
    }

    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        return calculatorService.sub(a, b);
    }

    @GetMapping("/mul")
    public int mul(@RequestParam int a, @RequestParam int b) {
        return calculatorService.mul(a, b);
    }

    @GetMapping("/div")
    public double div(@RequestParam int a, @RequestParam int b) {
        return calculatorService.div(a, b);
    }

    // Métodos POST
    @PostMapping("/sum")
    public int sumPost(@RequestBody Operands operands) {
        return calculatorService.sum(operands.a, operands.b);
    }

    @PostMapping("/sub")
    public int subPost(@RequestBody Operands operands) {
        return calculatorService.sub(operands.a, operands.b);
    }

    @PostMapping("/mul")
    public int mulPost(@RequestBody Operands operands) {
        return calculatorService.mul(operands.a, operands.b);
    }

    @PostMapping("/div")
    public double divPost(@RequestBody Operands operands) {
        return calculatorService.div(operands.a, operands.b);
    }

    // Classe auxiliar para POST
    public static class Operands {
        public int a;
        public int b;
    }
}