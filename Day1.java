import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("InputDay1.txt"))) {
    //    try (BufferedReader br = new BufferedReader(new FileReader("exampleDay1.txt"))) {
            String line;
            int currPos = 50;
            int numZeros = 0;
            while ((line = br.readLine()) != null) {
                boolean isRight = line.charAt(0) == 'R';
                int magnitude = Integer.parseInt(line.substring(1));

                if(isRight) {
                    currPos = currPos + magnitude;
                    numZeros += currPos / 100;
                    currPos = Math.abs(currPos) % 100;
                } else {
                    int buffer = ((magnitude / 100) + 1) * 100;
                    int bufferedPos = currPos + buffer;
                    // count how many times you passed 0
                    int tempPos = bufferedPos - magnitude;
                    numZeros += (bufferedPos / 100) - (tempPos / 100);
                    // starting at 0 isn't a crossing
                    if (currPos == 0) {
                        numZeros--; 
                    }

                    currPos = tempPos % 100;
                    
                    if (currPos == 0) {
                        numZeros++;
                    }
                    // currPos = currPos - magnitude;
                    // if(currPos < 0) {
                    //     if(currPos > -100) {
                    //         numZeros += 1;
                    //     } else {
                    //         numZeros += (Math.abs(currPos) / 100);
                    //     }
                    //     currPos = 100 - (Math.abs(currPos) % 100);
                    // }
                }

//                if(currPos == 0) {
//                    numZeros += 1;
//                }

                System.out.println("Rotated" + isRight + " and went " + magnitude + " landed on " + currPos);
                System.out.println(numZeros);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
