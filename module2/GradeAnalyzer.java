import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    private static int linesSkipped = 0;

    public static void main(String[] args) {
        
        String inputFile;
        if(args.length == 0) 
            inputFile = "scores.txt";
        else inputFile = args[0];
        
        String outputFile = "report.txt";
        
        //Step 1:  read scores from file

        ArrayList<Integer> scores = readScores(inputFile);


        //Step 2:  calculate statistics

        double avg = calculateAverage(scores);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int s : scores) {
            if(s > max) max = s;
            if(s < min) min = s;
        }

        // if scores is empty, set these to zero
        if(scores.size() == 0) {
            min = 0;
            max = 0;
        }

        
        writeReport(scores, avg, max, min, outputFile);
        

        //Step 3:  write and print report
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        
        var scores = new ArrayList<Integer>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String s;
            while( (s = reader.readLine()) != null) {
                
                try {
                    scores.add(Integer.parseInt(s.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score read: " + e.getMessage());
                    linesSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        
        if(scores.isEmpty()) return 0.0;

        double sum = 0.0;

        for(int s : scores) sum += s;
        
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg,
                                   int high, int low, String outputFile) {

        
        ArrayList<String> output = new ArrayList<String>();



        output.add("");
        output.add("=== Grade Analysis Report ===");
        output.add("Total scores processed: " + scores.size());
        output.add("Invalid lines skipped: " + linesSkipped);
        output.add("");
        output.add(String.format("Average score:  %.2f ", avg));
        output.add(String.format("Highest score:  %d", high));
        output.add(String.format("Lowest score:   %d", low));

        int countA, countB, countC, countD, countF;
        countA = countB = countC = countD = countF = 0;

        for(int s : scores) {
            if(s >= 90)
                countA++;
            else if(s < 90 && s >= 80 )
                countB++;
            else if(s < 80 && s >= 70)
                countC++;
            else if(s < 70 && s >= 60)
                countD++;
            else countF++;
        }
        
        output.add("");
        output.add("Grade distribution:");
        output.add(String.format("  A (90-100):     %d", countA));
        output.add(String.format("  B (80-89):      %d", countB));
        output.add(String.format("  C (70-79):      %d", countC));
        output.add(String.format("  D (60-69):      %d", countD));
        output.add(String.format("  F (below 60):   %d", countF));

        // print output to screen
        for(String line : output) System.out.println(line);

        // print output to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false))) {

            for(String line : output) writer.write(line + System.lineSeparator());
            
        } catch (IOException e) {
            System.out.println("Cannot write to file:  " + e.getMessage());
        }

    }
    


}