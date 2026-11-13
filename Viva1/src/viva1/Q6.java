package viva1;

import java.util.Scanner;
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xP=0, xQ=0;
        int yP=0, yQ=0;

        // Heading: 0 = North, 1 = East, 2 = South, 3 = West
        int dirP = 0;
        int dirQ = 0;

        int meetings = 0;
        int originReturns = 0;
        int maxGap = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        System.out.print("Enter robot commands: ");
        String commands = sc.next();
        String simplifiedCommands = new String();

        for(int i=0; i<commands.length();i++){
            char command = commands.charAt(i);
            boolean isMove = false;

            if(command == 'F' || command == 'B' || command == 'L' || command == 'R' || command == 'f' || command == 'b' || command == 'l' || command == 'r' ){
                if (command == 'F') {
                    xP += dx[dirP];
                    yP += dy[dirP];
                    isMove = true;
                } else if (command == 'B') {
                    xP -= dx[dirP];
                    yP -= dy[dirP];
                    isMove = true;
                } else if (command == 'R'){
                    dirP = (dirP+1) % 4;
                } else if (command == 'L'){
                    dirP = (dirP +3) % 4;
                } else if (command == 'f') {
                    xQ += dx[dirQ];
                    yQ += dy[dirQ];
                    isMove = true;
                } else if (command == 'b') {
                    xQ -= dx[dirQ];
                    yQ -= dy[dirQ];
                    isMove = true;
                } else if (command == 'r'){
                    dirQ = (dirQ+1) % 4;
                } else {
                    dirQ = (dirQ +3) % 4;
                }
            
                if(isMove){
                    if((xP == xQ && yP == yQ)) meetings++;
                    
                    if (command == 'F' || command == 'B') {
                        if (xP == 0 && yP == 0) {
                            originReturns++;
                        }
                    } else if (command == 'f' || command == 'b') {
                        if (xQ == 0 && yQ == 0) {
                            originReturns++;
                        }
                    }

                    int gap = Math.abs(xP - xQ) + Math.abs(yP - yQ);

                    if (gap > maxGap) {
                        maxGap = gap;
                    }
                }

            } else {
                System.out.println("Invalid Command String");
                return;
            }
        }

        System.out.println("Meetings: " + meetings);
        System.out.println("Origin Returns: " + originReturns);
        System.out.println("Maximum Gap: " + maxGap);
        char[] D = {'N', 'E', 'S', 'W'};
        System.out.printf("Robot P Final: (%d,%d) facing %s\n", xP, yP, D[dirP]);
        System.out.printf("Robot Q Final: (%d,%d) facing %s\n", xQ, yQ, D[dirQ]);
        System.out.println("Simplified Commands: " + simplifiedCommands);
        
        sc.close();
    }
}
