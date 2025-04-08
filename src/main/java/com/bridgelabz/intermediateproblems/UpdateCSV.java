package com.bridgelabz.intermediateproblems;
import java.io.*;
import java.util.*;
public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/intermediateproblems/employees.csv";
        String outputFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/intermediateproblems/updated_employees.csv";
        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter fw = new FileWriter(outputFile)
        ) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) {
                    fw.write(line + "\n");
                    isHeader = false;
                    continue;
                }
                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }
                fw.write(data[0] + "," + data[1] + "," + data[2] + "," + String.format("%.2f", salary) + "\n");
            }
            System.out.println("Salaries updated and saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

