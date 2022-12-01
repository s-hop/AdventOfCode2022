import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {
  public static void main(String[] args) {
    String line;
    int tempCalories = 0;
    ArrayList<Integer> calorieSumList = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"))) {
      while ((line = reader.readLine()) != null) {
        if (!line.isEmpty()) tempCalories += Integer.parseInt(line);
        else {
          calorieSumList.add(tempCalories);
          tempCalories = 0;
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    calorieSumList.sort(Collections.reverseOrder());
    System.out.println(calorieSumList.get(0) + calorieSumList.get(1) + calorieSumList.get(2));
  }
}
