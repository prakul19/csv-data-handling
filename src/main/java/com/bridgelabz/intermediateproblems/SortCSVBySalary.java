package com.bridgelabz.intermediateproblems;
import java.io.*;
import java.util.*;
public class SortCSVBySalary {
    public static void main(String[] args) {
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/intermediateproblems/employees.csv";
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));
            System.out.println(header);
            // Print top 5
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] rec = records.get(i);
                System.out.println(String.join(",", rec));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

