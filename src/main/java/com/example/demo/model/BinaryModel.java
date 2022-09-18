package com.example.demo.model;

import java.math.BigDecimal;
import java.math.MathContext;

import static com.example.demo.model.MathOperation.*;
import static com.example.demo.model.MathOperation.MULTIPLY;

public class BinaryModel {
   private String firstNumber;

   private String secondNumber;

   private MathOperation mathOperation;

   public BinaryModel(String firstNumber, String secondNumber, MathOperation mathOperation) {
      this.firstNumber = firstNumber;
      this.secondNumber = secondNumber;
      this.mathOperation = mathOperation;
   }

   public String calculate() throws DivisionByZeroException {
      BigDecimal result;
      if (mathOperation == PLUS) {
         result = plus(new BigDecimal(firstNumber), new BigDecimal(secondNumber));
      } else if (mathOperation == MINUS) {
         result = minus(new BigDecimal(firstNumber), new BigDecimal(secondNumber));
      } else if (mathOperation == DIVIDE) {
         if(!secondNumber.equals("0")){
            result = divide(new BigDecimal(firstNumber), new BigDecimal(secondNumber));
         } else {
            return "Cannot divide by zero";
         }
      } else if (mathOperation == MULTIPLY) {
         result = multiply(new BigDecimal(firstNumber), new BigDecimal(secondNumber));
      } else {
         throw new IllegalArgumentException("Unknown binary operation: " + mathOperation);
      }
      return String.valueOf(result);
   }

   private BigDecimal plus(BigDecimal firstValue, BigDecimal secondValue) {
      return firstValue.add(secondValue, MathContext.DECIMAL32);
   }

   private BigDecimal minus(BigDecimal firstValue, BigDecimal secondValue) {
      return firstValue.subtract(secondValue, MathContext.DECIMAL32);
   }

   private BigDecimal multiply(BigDecimal firstValue, BigDecimal secondValue) {
      return firstValue.multiply(secondValue, MathContext.DECIMAL32);
   }

   private BigDecimal divide(BigDecimal firstValue, BigDecimal secondValue) throws DivisionByZeroException {
      if (!secondValue.equals(BigDecimal.ZERO)) {
         return firstValue.divide(secondValue, MathContext.DECIMAL32);
      } else {
         throw new DivisionByZeroException();
      }
   }
}
