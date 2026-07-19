import java.util.Scanner;

public class CurrencyConveter {
    
        public static void main(String args[]) throws Exception{

            

            Scanner sc = new Scanner(System.in);

                       double  amount;
 
            
                   System.out.println("Enter The Amount");

                   amount = sc.nextDouble();

                 System.out.println("Select Base Currency:");
                   System.out.println("1. INR");
                   System.out.println("2. USD");
                   System.out.println("3. EUR");
                   System.out.println("4. GBP");
                   System.out.println("5. JPY");

                   int baseChoice = sc.nextInt();

                   String baseCurrency = "";


                   switch(baseChoice){

                    case 1:
                        baseCurrency = "INR";
                        break;
                    
                    case 2:
                        baseCurrency = "USD";
                        break;

                    case 3:
                        baseCurrency = "EUR";
                        break;

                    case 4:
                        baseCurrency = "GBP";
                        break;

                    case 5:
                        baseCurrency = "JPY";
                        break;

                    default :

                       System.out.println("Invaild Choice");

                       return;

                    

                   }

                   System.out.println("Select The Traget Currency ");

                   System.out.println("1. INR");
                   System.out.println("2. USD");
                   System.out.println("3. EUR");
                   System.out.println("4. GBP");
                   System.out.println("5. JPY");


                   int TragetChoice = sc.nextInt();

                   String tragetCurrency ="";

                   switch(TragetChoice){

                    case 1:

                      tragetCurrency = "INR";

                      break;

                    case 2:

                       tragetCurrency = "USD";

                       break;
                    case 3:
                         
                        tragetCurrency = "EUR";

                        break;

                    case 4:

                        tragetCurrency = "GBP";

                        break;
                    case 5:

                        tragetCurrency = "JPY";

                        break;

                    default :

                        System.out.println("INVALID CHOICE");

                       return;


                   }







     ApiClient apiClient = new ApiClient();

        CurrencyService currencyService =
                new CurrencyService(apiClient);

        String response =
                currencyService.convertCurrency(
                        baseCurrency,
                        tragetCurrency,
                        amount
                );

        System.out.println(response);




                   

        }
                    


           
}
