import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader("InputDay3.txt"))) {
//          try (BufferedReader br = new BufferedReader(new FileReader("exampleDay3.txt"))) {
      String line;
      long total = 0;
      int numBatteries = 12;

      while ((line = br.readLine()) != null) {
        int flexSpots = line.length() - numBatteries;
        long maxJolt = Long.parseLong(getMaxJoltString(line, flexSpots, numBatteries));
        // and add it to total
        System.out.println(maxJolt);
        total += maxJolt;
      }

      System.out.println("Total: " + total);

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  private static String getMaxJoltString(String line, int flexSpots, int openSpots) {
//    System.out.println("START---------  FLEX " + flexSpots + " OPEN " + openSpots);
    if (openSpots == 0) {
      return "";
    } else if (line.length() <= openSpots || flexSpots < 1) {
//      System.out.println("DONE---------");
      return line;
    }

    String maxDigit = line.substring(0, 1);
    String searchArea = line.substring(0, flexSpots+1);
    int remainingFlexSpots = flexSpots;
    int startLoc = 0;
    for (int i = 1; i < searchArea.length(); i++) {
      String currDigit = searchArea.substring(i, i + 1);
      if (Integer.parseInt(currDigit) > Integer.parseInt(maxDigit)) {
        maxDigit = currDigit;
        remainingFlexSpots = flexSpots - i;
        startLoc = i;
//        System.out.println("Searched: " + searchArea + " Max is " + maxDigit);
      }
    }
//    System.out.println("TAKING: " + maxDigit);
//    System.out.println("FROM: " + searchArea);
    return maxDigit + getMaxJoltString(line.substring(startLoc+1), remainingFlexSpots, openSpots - 1);

//    int maxJolt = 0;
//    int tens;
//    int ones;

    // find the max 2-digit joltage from picking exactly 2 batteries
    //    for (int i = 0; i < line.length() - 1; i++) {
    //      tens = line.charAt(i) - '0';
    //      if (tens > maxJolt / 10) {
    //        for (int j = i + 1; j < line.length(); j++) {
    //          ones = line.charAt(j) - '0';
    //          int currJolt = (tens * 10) + ones;
    //          if (currJolt > maxJolt) {
    //            maxJolt = currJolt;
    //          }
    //        }
    //      }
    //    }
    //    return maxJolt;
  }
}
