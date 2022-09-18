package com.example.demo.controller;

import com.example.demo.model.BinaryModel;
import com.example.demo.model.DivisionByZeroException;
import com.example.demo.model.MathOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/binary")
@AllArgsConstructor
public class BinaryOperationController {

    @GetMapping
    public String m(@RequestParam("number1") String number1, @RequestParam("number2") String number2, @RequestParam("operation") String operation) throws DivisionByZeroException {
        return new BinaryModel(number1, number2, MathOperation.valueOf(operation)).calculate();
    }
}
