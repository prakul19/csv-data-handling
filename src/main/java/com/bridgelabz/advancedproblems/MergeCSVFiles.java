package com.bridgelabz.advancedproblems;
import java.io.*;
import java.util.*;
public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/advancedproblems/students1.csv";
        String file2 = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/advancedproblems/students2.csv";
        String mergedFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/advancedproblems/merged_students.csv";
        Map<String, String[]> studentInfo = new HashMap<>();
        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFile))
        ) {
            // Read students1.csv
            String line1 = br1.readLine(); // skip header
            while ((line1 = br1.readLine()) != null) {
                String[] parts = line1.split(",");
                if (parts.length >= 3)
                    studentInfo.put(parts[0], new String[]{parts[1], parts[2]}); // ID -> [Name, Age]
            }
            // Read students2.csv and merge
            String line2 = br2.readLine(); // skip header
            bw.write("ID,Name,Age,Marks,Grade\n");
            while ((line2 = br2.readLine()) != null) {
                String[] parts = line2.split(",");
                String id = parts[0];
                String marks = parts[1];
                String grade = parts[2];
                if (studentInfo.containsKey(id)) {
                    String[] info = studentInfo.get(id);
                    bw.write(String.join(",", id, info[0], info[1], marks, grade));
                    bw.newLine();
                }
            }
            System.out.println("Merged file created: " + mergedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
