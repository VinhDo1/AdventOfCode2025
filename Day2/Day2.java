import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day2 {
  public static Map<Integer,Set> factorsMap = new HashMap<>();

  static void getAllFactors(int n) {
    Set<Integer> factors = new HashSet<>();
    int step = n % 2 == 0 ? 1 : 2;
    for (int i = 1; i <= Math.sqrt(n); i += step) {
      if (n % i == 0) {
        factors.add(i);
        if (i != 1) {
          factors.add(n / i);
        }
      }
    }
    factorsMap.put(n, factors);
  }

  public static void main(String[] args) {

    try (BufferedReader br = new BufferedReader(new FileReader("InputDay2.txt"))) {
      //    try (BufferedReader br = new BufferedReader(new FileReader("exampleDay2.txt"))) {
      String line = br.readLine();
      if (line == null)
        return;

      String[] ranges = line.split(",");
      long total = 0;

      for (String range : ranges) {
        range = range.trim();
        if (range.isEmpty())
          continue;
        String[] parts = range.split("-");
        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);

        for (long i = start; i < end + 1; i++) {
          String id = Long.toString(i);
          int idLength = id.length();
          if (idLength < 2) {
            continue;
          }

          if (!factorsMap.containsKey(idLength)) {
            getAllFactors(idLength);
          }
          Set factors = factorsMap.get(idLength);

          // For each factor, take a chunk
          for (Object factorObject : factors) {
            int factor = (int)factorObject;
            String chunk = id.substring(0, factor);
            // is that chunk repeated the entire time?
            if (isStringMadeOfChunks(chunk, id)) {
              total += i;
              System.out.println("Adding " + i);
              break;
            }
          }
        }
      }

      System.out.println("Total: " + total);

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  static boolean isStringMadeOfChunks(String chunk, String id) {
    //    System.out.println(chunk + " and id: " + id);
    int chunkLength = chunk.length();
    if (chunkLength == id.length()) {
      return chunk.equals(id);
    } else if (id.substring(0, chunkLength).equals(chunk)) {
      return isStringMadeOfChunks(chunk, id.substring(chunkLength));
    } else {
      return false;
    }
  }
}
