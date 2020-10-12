
import java.util.*;

public class Main extends Rover{
          
     public static void main(String []args){
         Scanner s = new Scanner(System.in);
         
          Rover plateau = new Rover();
          float[] p = plateau.getPlateau();
         
          Rover command1 = new Rover(p[0],p[1]);
          Object[] c1 = command1.getData(command1.x,command1.y);
          // for(int i = 0;i < o.length; i++) {
          //         System.out.println(o[i] + " "); 
          // }
          Rover curiosity = new Rover(c1[0],c1[1],c1[2],c1[3]);
           

          Rover command2 = new Rover(p[0],p[1]);
          Object[] c2 = command2.getData(command2.x,command2.y);
          Rover opportunity = new Rover(c2[0],c2[1],c2[2],c2[3]);
           
           curiosity.compute();
           opportunity.compute();

     }
}