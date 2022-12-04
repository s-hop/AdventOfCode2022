import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Part2 {
  static String line;
  static int overlaps;

  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new FileReader("4/input.txt"))) {
      while ((line = reader.readLine()) != null) {
        int[] assignments = Stream.of(line.split("[,-]")).mapToInt(Integer::parseInt).toArray();
        if ((assignments[0] >= assignments[2] && assignments[0] <= assignments[3])
            || assignments[1] >= assignments[2] && assignments[1] <= assignments[3]
            || (assignments[2] >= assignments[0] && assignments[2] <= assignments[1])
            || (assignments[3] >= assignments[0] && assignments[3] <= assignments[1])) {
          overlaps++;
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.format("Number of overlaps = %d!", overlaps);
  }
}
