package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
  static List<String> grid = new ArrayList<>();

  public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Day4/InputDay4.txt"))) {
//    try (BufferedReader br = new BufferedReader(new FileReader("Day4/exampleDay4.txt"))) {
      String line;

      while ((line = br.readLine()) != null) {
        grid.add(line);
      }

      int count = 0;
      int removed = 1;

      while(removed != 0) {
        removed = removePaper();
        count += removed;
        System.out.println(removed);
      }

      System.out.println("Accessible rolls: " + count);

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  static int removePaper()
  {
    int rows = grid.size();
    int cols = grid.getFirst().length();
    int count = 0;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid.get(r).charAt(c) == '@' && getSurrounding(r, c) < 4) {
          count++;
          String newRow = grid.get(r);
          newRow = newRow.substring(0, c) + "x" + newRow.substring(c+1);
          grid.set(r, newRow);
        }
      }
    }
    return count;
  }

  static int getSurrounding(int r, int c) {
    int rows = grid.size();
    int cols = grid.getFirst().length();
    int counter = 0;

    for (int i = r - 1; i < r + 2; i++) {
      for (int j = c - 1; j < c + 2; j++) {
        boolean withinBounds = i > -1 && i < rows && j > -1 && j < cols;
        boolean samePosition = i == r && j == c;
        if (withinBounds && !samePosition && grid.get(i).charAt(j) == '@') {
          counter++;
        }
      }
    }
    return counter;
  }
}
