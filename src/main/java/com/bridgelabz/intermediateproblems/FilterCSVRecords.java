package com.bridgelabz.intermediateproblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/basicproblems/students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3].trim());
                if (marks > 80) {
                    System.out.println("ID    : " + data[0]);
                    System.out.println("Name  : " + data[1]);
                    System.out.println("Age   : " + data[2]);
                    System.out.println("Marks : " + data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

