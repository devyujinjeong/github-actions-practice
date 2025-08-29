package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    /**
     *  계산기 입력 페이지로 이동
     *  */
    @GetMapping("/calculator")
    public String calculatorPage() {
        return "calculator";
    }

    /**
     *  계산 결과 페이지로 이동
     *  */
    @GetMapping("/calculator/result")
    public String calculate(
            @RequestParam int num1,
            @RequestParam int num2,
            @RequestParam String operation,
            Model model
    ) {
        double result = switch (operation) {
            case "add" -> num1 + num2;
            case "subtract" -> num1 - num2;
            case "multiply" -> num1 * num2;
            case "divide" -> (double) num1 / num2;
            default -> 0;
        };

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        return "result";
    }
}