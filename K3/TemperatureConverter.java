import java.util.Scanner;

class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the temperature to convert: ");
        double temperatureInCelsius = scanner.nextDouble();
        double temperatureInFarenheit = 9.0/5.0 * temperatureInCelsius + 32;
        System.out.println("The temperature in Farenheit is " + temperatureInFarenheit);
    }
}