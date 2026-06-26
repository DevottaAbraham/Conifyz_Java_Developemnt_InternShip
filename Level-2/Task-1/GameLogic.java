import java.util.Scanner;


public class GameLogic {

    char [][] board =new char[3][3];

    public GameLogic(){

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                board[i][j]=' ';
            }
        }

    }

    public void display(){
    
        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                System.out.print(" " + board[i][j]+ " ");

                if(j<2){

                    System.out.print("|");

                }

                
            }

            System.out.println();

           if (i < 2) {
              System.out.println("---------");
            }
        }

     

    }
    

    public void playerMove(char player){

        int row;
        int column;

        Scanner sc = new Scanner(System.in);

        System.out.println("Player" +player+ "Turn");

        System.out.println("Enter the Row (1-3)");

        row = sc.nextInt();

        System.out.println("Enter The Column (1-3");
        column = sc.nextInt();

        while(board[row-1][column-1]=='X'||board[row-1][column-1]=='O'){

            System.out.println("Cell Already Occupied  Try Agin ");

            System.out.println("Enter Row (1-3)");
            row = sc.nextInt();

            System.out.println("Enter Column (1-3)");
            column = sc.nextInt();       
        }
        
        board[row-1][column-1]=player;

        display();


    }

    public boolean checkWinner(char player){

        for(int i=0;i<3;i++){

            if(board[i][0]==player
                 && board[i][1]==player
                  && board[i][2]==player){

                return true;

            }

        }

        for(int j=0;j<3;j++){

            if(board[0][j]==player 
                && board[1][j]==player
                 && board[2][j]==player){

                return true;
            }
        }

        for(int i=0;i<3;i++){

            if(board[0][0]==player 
                && board[1][1]==player 
                && board[2][2]==player){

                return true;
            }
        }

        for(int j=0;j<3;j++){

            if(board[0][2]==player 
                && board[1][1]== player
                 && board[2][0]==player){
                return true;
            }
        }
        return false;



    }

    public boolean checkDraw(){

        for(int i=0;i<3;i++){

           for(int j=0;j<3;j++){

              if(board[i][j]==' '){

                return false;
              }
           }

        }
        return true;



    }

   public void resetBoard() {

    for (int i = 0; i < 3; i++) {

        for (int j = 0; j < 3; j++) {

            board[i][j] = ' ';
        }
    }

    }
}
