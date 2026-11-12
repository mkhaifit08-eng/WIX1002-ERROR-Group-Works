/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abah
 */

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        // Input
        Scanner in = new Scanner(System.in);
        double B= 0;
        
        do {
            System.out.print("Enter Outstanding Balance (RM500-RM50,000): ");
            B = in.nextDouble();
            
            // Check input validity
            if (B>=500 && B<=50000) break;
            else System.out.println("Invalid value");
        } while (true);
        
        System.out.print("Enter annual interest rate in %: ");
        double R = in.nextDouble();
        double r = R/(100*12);
        
        System.out.print("Enter monthly payment: ");
        double P = in.nextDouble();
        
        System.out.print("Would you like a payment holiday? (Y/N): ");
        char H = Character.toUpperCase(in.next().charAt(0));
        int M = 0;
        
        switch (H) {
            case 'Y': 
                // Loop for valid month
                do {
                    System.out.print("Enter your holiday month (1-36): ");
                    M = in.nextInt();
                    
                    // Check input validity
                    if (M>=1 && M<=36) {
                        break;
                    } else System.out.println("Invalid month");
                } while (true);
                break;
            default: 
                break;
        }
        in.close();

        // Processing
        double totalInterestCharged = 0, 
            totalLateFees = 0,
            totalAmountPaid = 0;
        int monthsRaised = 0;
        
        double[] yearBalances = new double[3];
        
        for (int m=1; m <= 36; m++) {
            double interest = B * r;
            
            totalInterestCharged += interest;
            B += interest;
            
            if (m == M) {
                totalLateFees += 25;
                B += 25;
                System.out.println("Month " + m + ": Payment holiday - payment fee RM25.00 charged");
            } else {
                double minimumPayment = Math.max( B * 0.05, 50);
                double actualPayment = P;
               
                if (P < minimumPayment) {
                    monthsRaised++;
                    actualPayment = minimumPayment;
                } 
                
                if (actualPayment > B) actualPayment = B;
                
                B -= actualPayment;
                totalAmountPaid += actualPayment;
            }
            
            if (m%12 == 0) yearBalances[m/12 - 1] = B;
            
            if (B < 0.005) {
                B = 0;
                System.out.println("Debt fully cleared in Month " + m + "!");
                break;
            }
        }
        
        // Output
        
        for (int i = 0; i < 3; i++) System.out.printf("End of Year %d Balance: RM %.2f\n", i+1, yearBalances[i]);
        
        System.out.printf("Total Interest Charged: RM %.2f\n", totalInterestCharged);
        System.out.printf("Total Late Fees: RM %.2f\n", totalLateFees);
        System.out.printf("Total Amount Paid: RM %.2f\n", totalAmountPaid);
        System.out.println("Months Raised to Minimum Payment: " + monthsRaised);
    }
}
