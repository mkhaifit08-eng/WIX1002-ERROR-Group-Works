/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package viva1;
import java.util.*;
/**
 *
 * @author User
 */
public class Q5 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        int x,y,b; 

            // input x, y, z 
        while(true){ 
            System.out.print("Enter width X: "); 
            x = scanner.nextInt(); 
            System.out.print("Enter height Y: "); 
            y = scanner.nextInt(); 
            System.out.print("Enter block size B: "); 
            b = scanner.nextInt(); 
        

            // check even or out of limit input   
            if(((x%2==0)||(y%2==0)||(x<7||x>29))||(y<7||y>29)||(b<1||b>3)){ 
                System.out.println("X and Y must be odd numbers between 7 and 29, and B must be between 1 and 3."); 
            }else{ 
                break; 
            } 
        } 
        for(int r=0;r<y;r++){ 
            //ratio x per y per row, as col 
            int diag1=(int)Math.round((double)r*(x-1)/(y-1));  
            int diag2=(x-1)-diag1; 
            
            
            for(int c=0;c<x;c++){ 
                if((c==0||c==x-1)&&(r==0||r==y-1)){ 
                    System.out.print('+'); // ‘+’ corners 
                }else if(r==0||r==y-1){ 
                    System.out.print('='); // ‘=’ top and bottom edge 
                }else if(c==0||c==x-1){ 
                    System.out.print('I'); // ‘I’ side edge 
                }else if(r==y/2&&c==x/2){ 
                    System.out.print('@'); // ‘@’ centre point 
                }else if(c==diag1||c==diag2){ 
                    System.out.print('X'); // ‘X’ diagonal 
                }else if(c==x/2){ 
                    System.out.print('|'); // ‘|’ centre column           

                }else if(r==y/2){ 
                    System.out.print('-'); // ‘-’ centre row 
                }else if((r/b+c/b)%2==0){ 
                    System.out.print('.'); // ‘.’ for background 
                }else{ 
                    System.out.print('o'); // ‘o’ for other 
                } 
            
            } 
            System.out.println(); 
            scanner.close(); 
        } 
        
    } 
  
}