import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
  public static void main(String[] args) {
//    try (BufferedReader br = new BufferedReader(new FileReader("InputDay4.txt"))) {
    try (BufferedReader br = new BufferedReader(new FileReader("exampleDay4.txt"))) {
      String line;
      List<String> grid = new ArrayList<>();

      while ((line = br.readLine()) != null) {
        grid.add(line);
      }

      int rows = grid.size();
      int cols = grid.getFirst().length();
      int count = 0;

      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {

          // TODO: count adjacent rolls in 8 directions
          // if fewer than 4, this roll is accessible — increment count
        }
      }

      System.out.println("Accessible rolls: " + count);

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }
}
