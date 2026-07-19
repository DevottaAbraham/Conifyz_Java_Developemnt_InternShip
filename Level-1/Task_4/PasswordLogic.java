
import java.util.Random;


public class PasswordLogic {


    
        final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        final String LOWER_CASE ="abcdefghijklmnopqrstuvwxyz";

        final String NUMBERS ="0123456789";

        final String SPECIAL_CHARACTERS="!@#$%^&*()-_=+?";

    public String generatePassword(int length, boolean upperCase,
                                   boolean lowerCase,
                                   boolean numbers,
                                   boolean specialCharacters){


            String  availableCharacters="";

              if(upperCase){

                availableCharacters+=UPPER_CASE;
              }if(lowerCase){

               availableCharacters+=LOWER_CASE;
              }if(numbers){
                  availableCharacters+=NUMBERS;
              }if(specialCharacters){
                  availableCharacters+=SPECIAL_CHARACTERS;
              }
              if(availableCharacters.isEmpty()){

                  return "Error:Please Select at least one characters...";

              }

            Random random = new Random();

           StringBuilder str = new StringBuilder();

        
           for(int i=0;i<length;i++){  

              

                 int randomIndex=random.nextInt(availableCharacters.length());
                 str.append(availableCharacters.charAt(randomIndex));
                 

           }

             return str.toString();
    }
 
}
