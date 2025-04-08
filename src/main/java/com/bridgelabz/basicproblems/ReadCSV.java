package com.bridgelabz.basicproblems;
import java.io.BufferedReader;
import java.io.FileReader;
public class ReadCSV {
    public static void main(String[] args) {
        String line;
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/basicproblems/students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                System.out.println("ID    : " + data[0]);
                System.out.println("Name  : " + data[1]);
                System.out.println("Age   : " + data[2]);
                System.out.println("Marks : " + data[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

