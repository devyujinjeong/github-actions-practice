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
        double result = 0;

        switch (operation) {
            case "add" -> result = num1 + num2;
            case "subtract" -> result = num1 - num2;
            case "multiply" -> result = num1 * num2;
            case "divide" -> {
                if (num2 == 0) {
                    model.addAttribute("error", "0으로 나눌 수 없습니다!");
                    return "calculator";
                }
                result = (double) num1 / num2;
            }
            default -> result = 0;
        }
        
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        return "result";
    }
}