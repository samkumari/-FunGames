import java.util.Random;
import java.util.Scanner;

class Rock_Paper_Scissor {

//method for defining rules of the game
    public static int[] Game_rules(int rounds) {
        Random r = new Random();
        int comp_Choice;
        String Comp_Move = "";
        Scanner s = new Scanner(System.in);
        String user_Move;
        int Wins = 0; 
        int Loss = 0;

        for (int i = 0; i < rounds; i++) {
            comp_Choice = r.nextInt(3);
            if (comp_Choice == 0) {
                Comp_Move = "rock";
            } else if (comp_Choice == 1) {
                Comp_Move = "paper";
            } else if (comp_Choice == 2) {
                Comp_Move = "scissor";
            }
            System.out.println("Make a move rock/paper/scissor");
            user_Move = s.nextLine();

            if (user_Move.equals(Comp_Move)) {
                System.out.println("It's a draw");
            } else if ((user_Move.equalsIgnoreCase("rock") && Comp_Move.equals("scissor")) ||
                       (user_Move.equalsIgnoreCase("paper") && Comp_Move.equals("rock")) ||
                       (user_Move.equalsIgnoreCase("scissor") && Comp_Move.equals("paper"))) {
                Wins += 1;
                System.out.println("Computer chose " + Comp_Move);
            } else {
                Loss += 1;
                System.out.println("Computer chose " + Comp_Move);
            }
        }
        int results[] = new int[2]; //an integer array which stores wins and loss by the user
        results[0] = Wins;
        results[1] = Loss;
        return results;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wanna Play Best Of?"); 
        int m = sc.nextInt(); //Number of rounds user wants to play
        int[] gameResults = Rock_Paper_Scissor.Game_rules(m); //a variable defined to store the array returned by the method

        if (gameResults[0] == gameResults[1]) {
            System.out.println("It's a Draw!");
        } else if (gameResults[0] > gameResults[1]) {
            System.out.println("Congratulations, You Won! and the score is "+gameResults[0]);
        } else {
            System.out.println("Oops, you Lost!");
        }
    }
}
      
