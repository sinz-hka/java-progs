package K04_Kontrollstrukturen.QuadraticEquation;

// Stores the solutions of a quadratic equation.
// If the equation has no solution, then the values of x1, x2 are 
// undefined and nrSolutions = 0. If the equation has 1 solution, then
// nrSolutions = 1 and the single solution is stored in x1; x2 is undefined.
// If the equation has 2 solutions, then nrSolutions = 2 and the two values
// are stored in x1 and x2.

class Solution {
    double x1;
    double x2;
    int nrSolutions;
}

class QuadraticEquation {

    // The solve method computes the solutions of a quadratic equation
    // of the form a*x^2 + b*x + c = 0.
    static Solution solve(double a, double b, double c) {
        double discriminant = b * b - 4.0 * a * c;
        Solution solution = new Solution();
        if (discriminant > 0.0) {
            // 2 solutions
            solution.nrSolutions = 2;
            solution.x1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
            solution.x2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);
        } else if (discriminant == 0.0) {
            // 1 solution
            solution.nrSolutions = 1;
            solution.x1 = -b / (2.0 * a);
            // solution.x2 is set to 0.0 by default rules
        } else {
            // now discriminant < 0.0, and we have no solution
            // (We do not have to initialize the attributes, as they are
            // set to 0 by the default rules.)
        }
        return solution;
     }
     
     public static void main(String[] args) {
         if (args.length != 3) {
             System.out.println("Please give three numbers on the command line.");
             return;
         }
         double a = Double.parseDouble(args[0]);
         double b = Double.parseDouble(args[1]);
         double c = Double.parseDouble(args[2]);
         
         Solution result = QuadraticEquation.solve(a, b, c);
         
         System.out.println("The equation has " + result.nrSolutions + " solution(s).");
         switch (result.nrSolutions) {
             case 0: break;
             case 1: System.out.println("The solution is " + result.x1); break;
             case 2: System.out.println("The first solution is " + result.x1);
                     System.out.println("The second solution is " + result.x2); break;
             default: System.out.println("Error: nrSolutions not valid!"); break;
         }
     }  
}
