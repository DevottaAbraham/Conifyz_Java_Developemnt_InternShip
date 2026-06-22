import java.util.Scanner;

class PalindromeLogic{

   public boolean isPalindrome(String text){

       String original=text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();


       int left=0;

       int right=original.length()-1;

       while(left<right){

          if(original.charAt(left)!=original.charAt(right)){

            return false;
   

          }

          left++;
          right--;
       }

       return true;

   }

}

public class PalindromeChecker {
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        PalindromeLogic logic = new PalindromeLogic();

        System.out.println("Enter Word or phrase:");

        String text = sc.nextLine();

          sc.close();

        if(logic.isPalindrome(text)){
            System.out.println("It is a Palindrome");
        }else{

            System.out.println("It is  Not a Palindrome");

        }








    }
}
