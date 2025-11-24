import java.util.Locale;

class FallingObject {
    
    private static final double gravity = 9.81; // in m/(s^2)
    
    static double fallingTime(double fallingHeight) {
        return Math.sqrt(2.0 * fallingHeight / gravity);
    }
    
    static double endSpeed(double fallingHeight) {
        return gravity * fallingTime(fallingHeight);
    }
    
    static double convertToKmH(double speedInMS) {
        return speedInMS * 3.6;
    } 
      
    public static void main(String[] args) {
        double height = Double.parseDouble(args[0]);
        double time = fallingTime(height);
        System.out.print("The time for an object to fall from height "
            + height + " meter is ");
        System.out.printf(Locale.US, "%.2f seconds.\n", time);
        double speed = endSpeed(height);
        double speedInKmH = convertToKmH(speed);
        System.out.printf(Locale.US, "The end speed is %.2f m/s, ", speed);
        System.out.printf(Locale.US, "which is %.2f km/h.\n", speedInKmH);
    }
    
}