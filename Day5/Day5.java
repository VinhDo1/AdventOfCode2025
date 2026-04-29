package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
  public static void main(String[] args) {
//    try (BufferedReader br = new BufferedReader(new FileReader("Day5/InputDay5.txt"))) {
    try (BufferedReader br = new BufferedReader(new FileReader("Day5/exampleDay5.txt"))) {
      String line;
      List<int[]> ranges = new ArrayList<>();
      List<Integer> ingredients = new ArrayList<>();

      // Parse ranges until blank line
      while ((line = br.readLine()) != null && !line.isEmpty()) {
        String[] parts = line.split("-");
        ranges.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
      }

      // Parse ingredient IDs
      while ((line = br.readLine()) != null) {
        ingredients.add(Integer.parseInt(line.trim()));
      }

      int freshCount = 0;
      for (int id : ingredients) {
        // check if id falls within any range
        // if so, increment freshCount
      }

      System.out.println("Fresh ingredients: " + freshCount);

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }
}
