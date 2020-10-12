
import java.util.*;

public class Rover{
          protected float x;
          protected float y;
          protected float rx;
          protected float ry;
          protected String z = "";
          protected String move = "";

          Rover() {
          }
          Rover(Object x,Object y) {
            this.x = (float)x;
            this.y = (float)y;
            //System.out.print(this.x+" "+this.y);
          }
          Rover(Object rx, Object ry, Object z, Object move) {
            this.rx = (float)rx;
            this.ry = (float)ry;
            this.z = (String)z;
            this.move = (String)move;//System.out.print(this.x+" "+this.y);
          }
          
          static float[] getPlateau() {
          Scanner s = new Scanner(System.in);

          float x,y;
          float get[] = new float[2];
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
            get[0] = x;
            get[1] = y;
            //System.out.println(get[0]+" "+get[1]);
            return get;
        }




         Object[] getData(float x, float y) {
         Scanner s = new Scanner(System.in);
         float rx, ry;
         String z = "",move = "";
        System.out.println("Please enter co-ordinates and heading of the Rover respectively followed by moving instructions(L/M/R) as one string:");
        while(true) {
         rx = s.nextFloat();
         ry = s.nextFloat();
         z = s.next();
        move = s.next();
        move = move.toUpperCase();
        //System.out.println(rx + " " + ry + " " + z + " " + move);
    /* Assuming a minimum size of the plateau as > (0.0001x0.0001) */

        if (rx < 0.0001 || ry < 0.0001 || z.length() > 1 || rx > x || ry > y) {
            System.out.println("SW corner co-ordinates are (0,0) \n Please enter co-ordinates and heading of Rover 1 respectively (each must be > 0, < NE co-ordinates and the heading is one letter (N,E,S,W)):");
        }
    
        else { 
            break;
        }
        }
        z = z.toUpperCase();
        //System.out.println(rx + " " + ry + " " + z + " " + move); 
        Object[] o = new Object[4];
        o[0] = rx;
        o[1] = ry;
        o[2] = z;
        o[3] = move;
        // for(int i = 0;i < o.length; i++) {
        //           System.out.println(o[i] + " "); 

        // }
        return o;

}

        void compute() {
          float x = this.x;
          float y = this.y;
          float rx = this.rx;
          float ry = this.ry;
          String z = this.z;
          String move = this.move;
          Scanner s = new Scanner(System.in);

           for (int i = 0; i < move.length(); i++) {

           switch(move.charAt(i)){
            case 'L': 
            switch(z) {
              case "N":
                {
                  z = "W";
                  break;
                }
              case "E":
                {
                 z = "N";
                 break;
                }
              case "S":
              {
              z = "E";
              break;                
              }
              case "W":
              {
                z = "S";
              break;
              }
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              z = s.nextLine();
              if(z.length() > 1) {
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
            switch(z) {
              case "N":
              z = "E";
              break;
              case "E":
              z = "S";
              break;
              case "S":
              z = "W";
              break;
              case "W":
              z = "N";
              break;
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              z = s.next();
              if(z.length() > 1) {
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
            switch(z){
              case "N":
              ry++; break;
              case "E":
              rx++; break;
              case "S":
              ry--; break;
              case "W":
              rx--; break;
              default:
              while(true) { 
              System.out.println("Heading has to be N/E/W/S(directions) - \n Please enter the right heading:");
              z = s.next();
              if(z.length() > 1) {
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
        System.out.println(rx + " " + ry + " " + z);
        }

}