import java.util.Scanner;
public class BusTravel{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int routeChoice;
      double speed = 0, distance = 0, arrivalTime = 0;
      
      System.out.println("South Bus Terminal");
      System.out.println("Welcome to Cebu City!");
      System.out.println("Route 1 Minglanilla");
      System.out.println("Route 2 San Fernando");
      System.out.println("Route 3 Carcar City\n");
      System.out.println("What route you want to take?(Enter a number)");
      System.out.println("1.Barili\n2.Sibonga");
      System.out.print("Enter choice: ");
      routeChoice = scan.nextInt();
         switch(routeChoice){
            case 1:
               System.out.println("You have chosen the route 4.1 barili route");
               System.out.println("You are now in route 4.1.1  Dumanjug");
               System.out.println("You are now in route 4.1.2 Alcantatra");
               System.out.println("You have reached your destination in MoalBoal\n");
               System.out.println("How fast are you going in km/hr: ");
               speed = scan.nextDouble();
               distance = 84.9;
               arrivalTime = distance/speed;
               int temp = (int)(arrivalTime* 100);
               int hour = temp/100;
               int min = temp % 100;
               if(min >=60){
                  hour++;
                  min = min-60;
               }
               System.out.println("You speed is "+ speed+ "km");
               System.out.println("Your distance travelled is "+ distance + "km");
               
               System.out.printf("ETA: %d hour and %d minutes", hour,min+1);
              
           
               break;
            
            case 2:
               int choice;
               System.out.println("You have chosen the route 4.1 Sibonga route");
               System.out.println("What route do you want to take?(Enter route number)");
               System.out.println("[1]Dumanjug\n[2]Argao");
               System.out.print("Enter choice: ");
               choice = scan.nextInt();
               if(choice == 1){
                  System.out.println("You have chosen the route 4.2.1 Dumanjug route");
                  System.out.println("You are now in route 4.2.2 Alcantara");
                  System.out.println("You have reached your destination in MoalBoal");
                  System.out.println("How fast are you going in km/hr: ");
                  speed = scan.nextDouble();
                  distance = 96.2;
                  arrivalTime = distance/speed;
                  int temp1 = (int)(arrivalTime* 100);
                  int hour1 = temp1/100;
                  int min1 = temp1 % 100;
                  if(min1 >=60){
                     hour1++;
                     min1 = min1-60;
                  }
                  System.out.println("You speed is "+ speed+ "km");
                  System.out.println("Your distance travelled is "+ distance + "km");
                  System.out.printf("ETA: %d hours and %d minutes", hour1,min1+1);
                     
               
               }
               if(choice == 2){
                  System.out.println("You have chosen the route 5 Argao route");
                  System.out.println("You are now in route 5.1 ronda");
                  System.out.println("You are now in route 5.2 Alcantara");
                  System.out.println("You have reached your destination in MoalBoal");
                  System.out.println("How fast are you going in km/hr: ");
                  speed = scan.nextDouble();
                  distance = 126.7;
                  arrivalTime = distance/speed;
                  int temp2 = (int)(arrivalTime* 100);
                  int hour2 = temp2/100;
                  int min2 = temp2 % 100;
                  if(min2 >=60){
                     hour2++;
                     min2 = min2-60;
                  }
                  System.out.println("You speed is "+ speed+ "km");
                  System.out.println("Your distance travelled is "+ distance + "km");
                  System.out.printf("ETA: %d hours and %d minutes", hour2,min2+1);
                   
               }               
               break;       
        }
   }
}