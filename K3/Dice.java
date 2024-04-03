import java.util.Random;

public class Dice {
	public static void main(String[] args) {
		System.out.println("Rolling the dice...");
		Random randomGenerator = new Random();

		int randomValue = randomGenerator.nextInt(6) + 1;	// first throw
		System.out.println("Result: " + randomValue);

		randomValue = randomGenerator.nextInt(6) + 1;		// second throw
		System.out.println("Result: " + randomValue);

		randomValue = randomGenerator.nextInt(6) + 1;		// third throw
		System.out.println("Result: " + randomValue);

		randomValue = randomGenerator.nextInt(6) + 1;		// fourth throw
		System.out.println("Result: " + randomValue);

		randomValue = randomGenerator.nextInt(6) + 1;		// fifth throw
		System.out.println("Result: " + randomValue);
	}
}
