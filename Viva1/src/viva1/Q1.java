package viva1;

import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Original Phrase: ");
        String phrase= sc.nextLine(); 
        String characters ="!@#$%", vowel="AEIOU";
        String password = new String();
        int key, sum=0;

        for(int i=0;i<phrase.length();i++){

            if(phrase.charAt(i) >= '0' && phrase.charAt(i) <= '9'){
                sum += phrase.charAt(i)-'0';
            }
        }
        key = sum % 26;
        if(key == 0) key=13;

        for(int i=0;i<phrase.length();i++){
            String temp = new String();

            if(phrase.charAt(i) >= 'a'&& phrase.charAt(i)<= 'z'){
                char tempChar = (char)('a'+ (phrase.charAt(i) + key - 'a') % 26);
                temp = Character.toString(tempChar);
            } else if(phrase.charAt(i) >= 'A'&& phrase.charAt(i)<= 'Z'){
                for(int j=0;j<vowel.length();j++){
                    if(phrase.charAt(i)==vowel.charAt(j)){
                        temp = "*"+ Character.toLowerCase(phrase.charAt(i));
                        break;
                    } else{
                        char tempChar = phrase.charAt(i);
                        tempChar = (char)('a'+(Character.toLowerCase(tempChar) +1-'a')%26);temp = Character.toString(tempChar);
                    }
                }

            } else if(phrase.charAt(i) >= '0'&& phrase.charAt(i)<= '9'){
                int d = phrase.charAt(i) - '0';
                d = (d * d) % 10;
                temp = Integer.toString(d);
            } else if(phrase.charAt(i)==' '){
                temp=".";
            } else {
                for(int j=0;j<characters.length();j++){
                    if(phrase.charAt(i) == characters.charAt(j)){
                        temp = Character.toString(characters.charAt((j+2) % 5));
                        break;
                    } else{
                        temp = Character.toString(phrase.charAt(i));
                    }
                }
                
            }

            password += temp;
        }

        char[] passChar = password.toCharArray();
        for(int i=0; i<passChar.length/2;i++){
            char temp = passChar[i];
            passChar[i] = passChar[passChar.length-i-1];
            passChar[passChar.length-i-1] = temp;
        }
        String reversedPassword = String.valueOf(passChar);

        System.out.println("Shift Key: " + key);
        System.out.println("Before Reversal: " + password);
        System.out.println("Encoded Password: " + reversedPassword);
        sc.close();
    }
}
