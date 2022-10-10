import java.util.Scanner; 
import java.util.Random; 
class BeerBottlesGame extends Thread{ 
 public static void main(String args[]) { 
 while (true) { 
 RunGame game = new RunGame(); 
 Scanner agr = new Scanner(System.in); 
 if (game.caseType()) { 
 ScreenClearner.clrScreen(); 
 StartGame game2 = new StartGame("user"); 
 game2.user_startGame(); 
 } else { 
 ScreenClearner.clrScreen(); 
 StartGame game2 = new StartGame("com"); 
 game2.user_startGame(); 
 } 
 System.out.print("\n\n\n\tDo you play, again?\n\n\n\tEnter:\t"); 
 String d = agr.nextLine(); 
 if (!(d).equals("yes") || d.equals("YES")) { 
 ScreenClearner.clrScreen(); 
 break; 
 } 
 ScreenClearner.clrScreen(); 
 } 
 } 
} 
///   MAin END|
class StartMessage { 
 public StartMessage() { 
 ScreenClearner.clrScreen(); 
 System.out.println("\t\t----------- Beer Bottles Game -----------\n\n"); 
 System.out.println("\tThere are 21 beer bottles..."); 
 System.out.println("\tComputer and yourself, there are 2 players"); 
 System.out.println("\tAt a time , each one can pick up any number of bottles between 1 and 4 (inclusive)"); 
 System.out.println("\n\n\tWill you like to play First ?"); 
 System.out.println("\n\tTYPE:\t \"YES\""); 
 System.out.print("\tINPUT:\t"); 
 } 
} 
//=============================================================================
class RunGame extends StartMessage { 
 StartMessage message = new StartMessage(); 
 Scanner intiDes = new Scanner(System.in); 
 String sr = intiDes.nextLine(); 
 boolean firstPlayer; 
 public boolean caseType() { 
 System.out.println(sr); 
 firstPlayer = (sr.equals("yes") || sr.equals("YES")) ? true : false; 
 return firstPlayer; 
 } 
} 
//========================================================
class ScreenClearner { 
 public static void clrScreen() { 
 try { 
 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
 } catch (Exception e) { 
 System.out.println(e); 
 } 
 } 
} 
//===================================================================
class StartGame { 
 String playerType, lastUser = "none"; 
 int totalBottle = 21; 
 int round = 1; 
 Scanner pickUp = new Scanner(System.in); 
 Boolean endGame = false; 
 public StartGame(String playerType) { 
 this.playerType = playerType; 
 } 
 public void user_startGame() { 
 if (playerType.equals("user")) { 
 while (!endGame) { 
 if (lastUser.equals("none")) { 
 int getBottle = 0; 
 StartGame.roundableMessage(round); 
 round++; 
 System.out.print("\n\tEnter:\t"); 
 getBottle = pickUp.nextInt(); 
 if (getBottle <= 4 && getBottle >= 0) { 
 if (getBottle <= totalBottle) { 
 totalBottle -= getBottle; 
 if (totalBottle > 0) { 
 if (totalBottle <= 1) { 
 lastUser = "com"; 
 } else { 
    //======================================
    try {
        System.out.println(" wait for 3 second...  for computer input .");
        for(int i=0;i<3;i++){
            Thread.sleep(1000);
            Thread.yield();
            
        }
        traceComputer(getBottle); 
    } catch (Exception e) {
        
    }
 } 
 } else { 
 endGame = true; 
 } 
 } else { 
 System.out.println("\n\tREMAINING MESS:\tRemaining totals bottles " + totalBottle + "\n"); 
 } 
 } else { 
 System.out.println( 
 "\n\tWRONG-INPUT MESS:\tOops!, You enter wrong number. Please enter the number between 1 to 4...\n"); 
 } 
 } else { 
 if (totalBottle <= 1) { 
 if (lastUser.equals("user")) { 
 System.out.println("\n\tYou will have to pick up last...\n\tYou are loser!"); 
 } else { 
 System.out.println( 
 "\n\tComputer will have to pick up last...\n\tCongratulation!, You are Winner!"); 
 } 
 endGame = true; 
 break; 
 } 
 } 
 } 
 } else { 
 while (!endGame) { 
 if (lastUser.equals("none")) { 
 traceComputer(0); 
 if (!(totalBottle <= 1)) { 
 int getBottle = 0; 
 StartGame.roundableMessage(round); 
 round++; 
 System.out.print("\n\tEnter:\t"); 
 getBottle = pickUp.nextInt(); 
 if (getBottle <= 4 && getBottle >= 0) { 
 if (getBottle <= totalBottle) { 
 totalBottle -= getBottle; 
 if (totalBottle > 0) { 
 if (totalBottle <= 1) { 
 lastUser = "com"; 
 } 
 } else { 
 endGame = true; 
 } 
 } else { 
 System.out 
 .println("\n\tREMAINING MESS:\tRemaining totals bottles " + totalBottle + "\n"); 
 } 
 } else { 
 System.out.println( 
 "\n\tWRONG-INPUT MESS:\tOops!, You enter wrong number. Please enter the number between 1 to 4...\n"); 
 } 
 } 
 } else { 
 if (totalBottle <= 1) { 
 if (lastUser.equals("user")) { 
 System.out.println("\n\tYou will have to pick up last...\n\tYou are loser!"); 
 } else { 
 System.out.println( 
 "\n\tComputer will have to pick up last...\n\tCongratulation!, You are Winner!"); 
 } 
 endGame = true; 
 break; 
 } 
 } 
 } 
 } 
 } 
 //++++++++++++++++++++++++++++++++++++++++++++++++++
 public static void roundableMessage(int s) { 
 switch (s) { 
 case 1: 
 System.out.println("\tHow many you would like to pick up?"); 
 break; 
 case 2: 
 System.out.println("\tNow, again how many you would like to pick up?"); 
 break; 
 default: 
 System.out.println("\tgreat, How many you would like to pick up?"); 
 break; 
 } 
 } 

 public void traceComputer(int inputData) { 

 Random random = new Random(); 
 int getNumber = 0; 
 if (playerType.equals("user")) { 
 switch (totalBottle) { 
 case 17, 12, 7, 2: 
 getNumber = 1; 
 break; 
 case 18, 13, 8, 3: 
 getNumber = 2; 
 break; 
 case 19, 14, 9, 4: 
 getNumber = 3; 
 break; 
 case 20, 15, 10, 5: 
 getNumber = 4; 
 break; 
 default: 
 getNumber = 1 + random.nextInt(3); 
 break; 
 } 
 } else { 
 switch (totalBottle) { 
 case 12, 7, 2: 
 getNumber = 1; 
 break; 
 case 13, 8, 3: 
 getNumber = 2; 
 break; 
 case 14, 9, 4: 
 getNumber = 3; 
 break; 
 case 10, 5: 
 getNumber = 4; 
 break; 
 default: 
 getNumber = 1 + random.nextInt(3); 
 break; 
 } 
 } 
 if (getNumber <= totalBottle) { 
 totalBottle -= getNumber; 
 System.out.println("\tComputer has picked " + getNumber); 
 System.out.println("\tThe bottles remaining are: " + totalBottle); 
 System.out.println("---------------------------------------------------------------\n\n"); 
 if (totalBottle <= 1) { 
 lastUser = "user"; 
 } 
 } else { 
 traceComputer(0); 
 } 
 } 
} 