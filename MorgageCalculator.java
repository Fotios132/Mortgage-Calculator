/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.morgagecalculator;

import java.util.Scanner;
import java.text.NumberFormat;

public class MorgageCalculator {

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        double principal = 0;
        double monthlyRate = 0;
        int numberOfPayments = 0;

        // Principal
        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextDouble();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        // Interest rate
        while (true) {
            System.out.print("Annual Interest Rate: ");
            double annualInterest = scanner.nextDouble();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyRate = annualInterest / 100 / 12;
                break;
            }
            System.out.println("Enter a number between 1 and 30.");
        }

        // Period
        while (true) {
            System.out.print("Period (Years): ");
            int period = scanner.nextInt();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * 12;
                break;
            }
            System.out.println("Enter a number between 1 and 30.");
        }

        scanner.close();

        // Calculate monthly payment
        double mathPower = Math.pow(1 + monthlyRate, numberOfPayments);
        double monthlyPayment = principal * (monthlyRate * mathPower) / (mathPower - 1);

        // Format into $
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        // Print result
        System.out.println("Monthly Mortgage Payment: " + monthlyPaymentFormatted);
    
      
    }
}
      