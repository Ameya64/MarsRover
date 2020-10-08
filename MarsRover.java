
import java.util.*;
public class MarsRover{

     public static void main(String []args){
         Scanner s = new Scanner(System.in);
         float x, y;
         
        System.out.println("Welcome to NASA Mars Rover Command Center \n Please enter NE corner co-ordinates of Plateau:\n");
         
         while(true) {
         x = s.nextFloat();
         y = s.nextFloat();
         
        /* Assuming a minimum size of the plateau as > (0.0001x0.0001) */
        if (x <= 0.0001 || y <= 0.0001) {
        System.out.println("SW corner co-ordinates are (0,0) \n Please enter NE corner co-ordinates of Plateau (each must be > 0.0001):");
        }
        else {
            System.out.println("Thank you");
            break;
        }
        }
        
        float rx1, ry1;
        String dir = "";
        System.out.println("Please enter co-ordinates and heading of Rover 1 respectively followed by moving instructions(L/M/R) as one string:");
        while(true) {
         rx1 = s.nextFloat();
         ry1 = s.nextFloat();
         dir = s.next();
       
		/* Assuming a minimum size of the plateau as > (0.0001x0.0001) */

        if (rx1 <= 0.0001 || ry1 <= 0.0001 || dir.length() > 1 || rx1 > x || ry1 > y) {
            System.out.println("SW corner co-ordinates are (0,0) \n Please enter co-ordinates and heading of Rover 1 respectively (each must be > 0, < NE co-ordinates and the heading is one letter (N,E,S,W)):");
        }
    
        else { 
            break;
        }
        }
        dir = dir.toUpperCase();
        String move = "";
        move = s.next();

        for (int i = 0; i < move.length(); i++) {

           switch(move.charAt(i)){
            case 'L': 
            switch(dir) {
              case "N":
                {
                  dir = "W";
                  break;
                }
              case "E":
                {
                 dir = "N";
                 break;
                }
              case "S":
              {
              dir = "E";
              break;                
              }
              case "W":
              {
                dir = "S";
              break;
              }
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              dir = s.next();
              if(dir.length() > 1) {
                System.out.println("Dude it's 1 letter -_-");
              }
              else {
                i--;
                break;
              }
              }
            }
            break;
            case 'R': 
            switch(dir) {
              case "N":
              dir = "E";
              break;
              case "E":
              dir = "S";
              break;
              case "S":
              dir = "W";
              break;
              case "W":
              dir = "N";
              break;
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              dir = s.next();
              if(dir.length() > 1) {
                System.out.println("Dude it's 1 letter -_-");
              }
              else {
                i--;
                break;
              }
              }
            }
            break;
            case 'M':
            switch(dir){
              case "N":
              ry1++; break;
              case "E":
              rx1++; break;
              case "S":
              ry1--; break;
              case "W":
              rx1--; break;
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              dir = s.next();
              if(dir.length() > 1) {
                System.out.println("Dude it's 1 letter -_-");
              }
              else {
                i--;
                break;
              }
              } 
            }
            break;
           	default:
           	System.out.println("Invalid instruction at move" + (i + 1));
           	System.out.println("Please re-enter the move");
            String temp = move.substring(0,i+1)+s.next()+move.substring(i+2);
            i--;
            }
      	
        }

     }
}