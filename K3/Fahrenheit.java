import java.util.Scanner;
import java.util.Locale;

public class Fahrenheit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Temperature in °C: ");
		double temperature = sc.nextDouble();
		double tempFahrenheit = 9.0/5.0*temperature + 32.0;
		System.out.println("Entered temperature: " + temperature);
		System.out.println("Temperature in Fahrenheit: " + tempFahrenheit);
	}
}
