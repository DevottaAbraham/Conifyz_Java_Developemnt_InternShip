import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String []args){

       
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter THe length of the Password:");

        int  length =sc.nextInt();

        System.out.print("Include Uppercase Letters? (Y/N): ");

        char choice = sc.next().charAt(0);

          boolean upperCase = (choice == 'Y' || choice == 'y');

         System.out.print("Include LowerCase Letters? (Y/N): ");

         choice = sc.next().charAt(0);

        boolean lowerCase = (choice == 'Y' || choice == 'y');

        System.out.print("Include Numbers Letters? (Y/N): ");

         choice = sc.next().charAt(0);

        boolean numbers = (choice == 'Y' || choice == 'y');


        System.out.print("Include SpecialCharacters Letters? (Y/N): ");

         choice = sc.next().charAt(0);

        boolean specialCharacters = (choice == 'Y' || choice == 'y');


        PasswordLogic Logic = new PasswordLogic();
        String password = Logic.generatePassword(length, upperCase, lowerCase, numbers, specialCharacters);

        System.out.println("Generated Password: " + password);






        

        

        





    }
    
}
