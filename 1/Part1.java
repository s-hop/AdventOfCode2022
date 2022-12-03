import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
  public static void main(String[] args) {
    String line;
    int tempCalories = 0;
    Integer mostCalories = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader("1/input.txt"))) {
      while ((line = reader.readLine()) != null) {
        if (!line.isEmpty()) {
          tempCalories += Integer.parseInt(line);
        } else {
          if (tempCalories > mostCalories)
            mostCalories = tempCalories;
          tempCalories = 0;
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(mostCalories);
  }
}
