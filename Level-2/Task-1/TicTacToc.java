import java.util.Scanner;


public class TicTacToc {

    public static void main(String args[]){

        GameLogic game = new GameLogic();

        game.display();

        while(true){
        
            game.playerMove('X');

            if(game.checkWinner('X')){

                System.out.println("Player X wins ");


                break;


            }

            if(game.checkDraw()){

                System.out.println("Game Draw");

                break;

            }

            game.playerMove('O');

            if(game.checkWinner('O')){

                System.out.println("Player O Wins");

                break;
            }

            if(game.checkDraw()){

                System.out.println("Game Draw");

                break;
            }
            
        }

        Scanner sc = new Scanner(System.in);

        char choice = 'Y';
        while(choice == 'Y' || choice == 'y' ){

            game.resetBoard();
            game.display();
        while(true){

            game.playerMove('X');

            if(game.checkDraw()){

                System.out.println("Game Draw");

                break;
            }

            if(game.checkWinner('X')){

                System.out.println("Player X wins");

                break;
            }

            game.playerMove('O');

            if(game.checkDraw()){

                System.out.println("Game Draw");

                break;
            }
            if(game.checkWinner('O')){

                System.out.println("Player O wins");
            }
             
          
        }

        System.out.println("Do You Want To Play Agin ? (Y/N)");

        choice = sc.next().charAt(0);

        sc.close();

    }


    }

    
    
}
