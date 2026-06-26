import java.util.Scanner;


class PasswordStengthCheckerLogic{


    public String  checkStrength(String Password){
     
        boolean hasupperCase=false;

        boolean haslowerCase=false;

        boolean hasnumbers=false;

        boolean hasSpecialCharacter = false;

        if(Password.length()<12){
                   
            return "Password contation must 12 Character";

        } 

        for(int i=0;i<Password.length();i++){
        
          char  ch = Password.charAt(i);

        if(Character.isUpperCase(ch)){

            hasupperCase = true;
  

        }else if(Character.isLowerCase(ch)){

             haslowerCase = true;
        }else if(Character.isDigit(ch)){

            hasnumbers=true;


        }else{

            hasSpecialCharacter = true;
        }
    }

        if(!hasupperCase){
              
            return "Password Must Contations UpperCase Letter (Capital Letter)";

        }if(!haslowerCase){

            return "Password Must Contations LowerCase Leter (Small Letter)";

        }if(!hasnumbers){

            return "Password Must Contations Numbers";
        }if(!hasSpecialCharacter){

            return "Password Must Contations Special Character";
        }


         return "Password is Strong";

        }


        

    }

public class PasswordStengthchecker {

    public static void main(String args[]){


        Scanner sc = new Scanner(System.in);

        PasswordStengthCheckerLogic check = new PasswordStengthCheckerLogic();

           while(true){

              System.out.println("Enter The Password");

              String Password = sc.nextLine();

              String result = check.checkStrength(Password);

              System.out.println(result);

              if(result.equals("Password is Strong")){

                   break;
              }else{

                  System.out.println("Enter The Password Agin \n");
              }

              sc.close();


           }
        



    }
    
}
