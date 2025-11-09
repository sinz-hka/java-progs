package K01_Objekte_Klassen.Vector2D;

class Vector2D {
  float x;
  float y;
}

class Main {
  public static void main(String args[]) {
    System.out.println("Hier erstellen wir ein Vector2D-Objekt.");
    Vector2D position = new Vector2D();
    position.x = 1.0f;
    position.y = -2.5f;
    
    System.out.println("Das ist die x-Koordinate:");
    System.out.println(position.x);
    System.out.println("Und das die y-Koordinate:");
    System.out.println(position.y);
  }
}
