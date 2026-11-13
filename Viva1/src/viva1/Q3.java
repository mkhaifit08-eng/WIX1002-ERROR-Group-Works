/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package viva1;
import java.util.*;
/**
 *
 * @author fawwa
 */
public class Q3 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        boolean exit = false ;
        int parcount = 0 ;
        double totalfee = 0 ;
        int hw = 0;
        
        while(exit == false){
            System.out.println("ENTER DESTINATION POSTCODE (OR \"EXIT\" TO STOP ) : ");
            String pc = in.nextLine();
            String ex = "exit" ;
            pc = pc.toUpperCase().replace(" ","").replace("-","").trim();
            String malay = "MY" ;
            boolean inter = false   ;
            boolean letter = false ;
            boolean numcheck = false ;
            int area , count ;
            area = 0 ;
            count = 0 ;
            String pcm , pcn ;
            pcm = "";
            float sum = 0 ;
            int zone = 0 ;
            String namezone = "" ;
            
            
            
            if( pc.length() > 2 ){
                
            
            if ( pc.equalsIgnoreCase(ex.replace("-","").replace(" " , "").trim())){
                break ;
            }
            
            if(!Character.isLetter(pc.charAt(0)) && !Character.isLetter(pc.charAt(1))){
                if (pc.matches("[0-9]+") && !pc.matches("[A-Z]+")){
                letter = true ;
                numcheck= true ;
                
                } else {
                   numcheck = false ;
                }
            } else {
                
                if (pc.substring(0,2).matches("[A-Z]+") && pc.substring(2).matches("[0-9]+") ) {
                    numcheck = true ; 
                    letter = false ;
                } else {
                letter = false ;
                numcheck = false ;
            }}
            
            if (pc.substring(0,2).equals(malay) && pc.substring(2).matches("[0-9]+"))  {
                pcm = pc.replace(malay, "").trim();
                letter = true ;
                numcheck=true ;
            } else {
                pcm = pc.trim();
            }
            
            
            count = pcm.length();
            
            if (numcheck){
            if(!letter){
                inter = true ;
            } else {
            if(count != 5){
                    System.out.println("ERROR : INVALID POSTCODE.PARCEL SKIPPED");
                    continue;
                } else {
                pcn = pcm.substring(0,2);
                area = Integer.parseInt(pcn);
                  
                }
            }
            } else {
                System.out.println("ERROR : INVALID POSTCODE.PARCEL SKIPPED");
                continue;
            }     
            } else {
                System.out.println("ENTER THE VALID POSTCODE");
                continue;
            }
        
            
           if(inter) {
               zone = 4 ;
        } else {
            if(area >=50 && area <=60){
                zone = 1 ;
            } else if (area >= 1 && area <= 49 || area >=61 && area <= 86){
                zone = 2 ;
            } else if (area >=87 && area<= 98){
                zone = 3 ;
            }else{
                System.out.println("ERROR : INVALID POSTCODE.PARCEL SKIPPED");
                continue;
            }
    }
            
            
           
            float kgw = 0 ;
            
        do {
            System.out.print("ENTER PARCEL WEIGHT(G) : ");
             String weig = in.nextLine();
             
             
             if (weig.matches("[A-Z]+")){
                 System.out.println("ERROR : WEIGHT MUST BE INTEGER");
             } else {
                 int weig2 = Integer.parseInt(weig);
            if ( weig2 <= 0 ) {
                System.out.println("ERROR : WEIGHT MUST BE > 0 ");
            } else {
               kgw = (float) weig2 / 1000.0f ;
                break ;
            }
             }
        } while(true);
        
        
        
        do {
        
            int  tempsum = 1;
        System.out.println("ENTER PARCEL DIMENSIONS LxWxH : ");
            String dia = in.nextLine().toLowerCase();
            
            
            
            if (dia.contains("x")){
                String[] diamen = dia.split("x");
                
                if (diamen.length == 3 ){
                    boolean valid = true ;
                    
                    for ( String x : diamen){
                    
                    if (x.matches("[0-9]+") && !x.equals("0")){
                        int diaint = Integer.parseInt(x);
                        tempsum *= diaint ;
                    } else {
                        valid = false ;
                        break; 
                    }
                    }
                
                if (valid){
                    sum = (float) tempsum / 5000.0f ;
                    break;
                } else {
                    System.out.println("\n THE VALUE IS INVALID");
                }
                }else {
                    System.out.println("ERROR THE DIAMENSIONS MUST HAVE 3 VALUE ");
                }
                } else {
                System.out.println("\nENTER THE DIMENSIONS IN RIGHT FORMAT LxWxH ");
            }

        } while(true);
        
       float temptotal;
       
        if ( kgw >= sum ){
            temptotal = kgw ;
        } else {
            temptotal = sum ;
        }
        
        int temptotal2 = (int) Math.ceil(temptotal);
        double total = 0 ;
        
        switch(zone){
                case 1 :
                    total = 6 + (temptotal2-1)*1.5f ;
                    namezone = "KLANG VALLEY";
                    break;
                case 2 :
                    total = 8 + (temptotal2-1)*2.0f ;
                    namezone = "PENINSULAR";
                    break;
                case 3 :
                    total = 14 + (temptotal2-1)*4.5f;
                    namezone = "EAST MALAYSIA" ;
                    break;
                case 4 :
                    total = 35 * temptotal2 ;
                    namezone = "INTERNATIONAL" ;
                    break;
            }
        
        double aftotal = 0;
        String disname = "Standard rate";
        
        if (temptotal2 >= 5 && temptotal2 <= 10 ){
            aftotal = total * 0.95f ;
            disname = "5% bulk discount "; 
        } else if ( temptotal2 > 10) {
            aftotal = total * 1.15f ;
            disname = " 15% heavy parcel surcharge" ;
        } else {
            aftotal = total ;
        }
        
        
        
        
       
        System.out.println("------------------------------------------");
        System.out.println("SHIPPING SUMMARY");
        System.out.println("POSTCODE : " + pcm);
        System.out.println("ZONE : " + namezone );
        System.out.printf("ACTUAL WEIGHT : %.2f kg | VOLUMETRIC WEIGHT : %.2f kg\n", kgw, sum);
        System.out.println("CHARGEABLE WEIGHT : " + temptotal2 + " kg");
        System.out.println("ADJUSMENT " + disname );
        System.out.printf("SHIPPING FEE : RM %.2f \n" , aftotal );
        
        
        if (temptotal2 > hw) {
            hw = temptotal2 ;
        }
        
        totalfee += aftotal ;
        parcount ++ ;
        }  
        
        
        System.out.println("PARCELS PROCESSED : " + parcount);
        System.out.printf("TOTAL SHIPPING FEE : RM %.2f" , totalfee);
        System.out.println("\nHEAVIEST CHARGEABLE WEIGHT : " + hw + " kg ");
        
        in.close();
    }
}
