package com.bridgelabz.basicproblems;
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/basicproblems/employees.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,Prakul,HR,50000\n");
            writer.append("2,Shreya,Engineering,70000\n");
            writer.append("3,Parth,Marketing,55000\n");
            writer.append("4,Parag,Finance,60000\n");
            writer.append("5,Prakirti,IT,65000\n");
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

