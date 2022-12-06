import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Part1 {

  public static void main(String[] args) {
    Path file = Paths.get("src/input.txt");
    Charset cs = StandardCharsets.UTF_8;
    String line;

    try (BufferedReader reader = Files.newBufferedReader(file, cs)) {
      line = reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(getMarker(line, 4));
    System.out.println(getMarker(line, 14));
  }

  public static int getMarker(String line, int numUniqueChars) {
    int markerIndex = 0;
    // charsToCheck can only reach required number of elements if all elements are unique. When the List
    // size check hits the required number, the loop ends and the index of the marker is printed.
    for (int i = 0; i <= line.length() - numUniqueChars; i++) {
      markerIndex = i+4;
      ArrayList<Character> charsToCheck = new ArrayList<>();
      for (int j = 0; j <= numUniqueChars - 1; j++) {
        Character ch = line.charAt(i + j);
        if (charsToCheck.contains(ch)) break;
        else charsToCheck.add(ch);
      }
      if (charsToCheck.size() == numUniqueChars) break;
    }
    return markerIndex;
  }
}
