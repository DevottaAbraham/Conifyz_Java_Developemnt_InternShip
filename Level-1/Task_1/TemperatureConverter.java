import java.util.Scanner;

class TemperatureLogic {

    public double convertToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32.0;
    }
}

public class TemperatureConverter {

    public static void main(String[] args) {

        TemperatureLogic logic = new TemperatureLogic();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the temperature in Celsius: ");
        double celsius = sc.nextDouble();
        
        sc.close();

        double fahrenheit = logic.convertToFahrenheit(celsius);

        System.out.printf("Temperature in Fahrenheit: %.2f°F%n", fahrenheit);

    }
}