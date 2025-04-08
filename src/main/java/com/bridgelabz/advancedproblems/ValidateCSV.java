package com.bridgelabz.advancedproblems;
import java.io.*;
import java.util.regex.*;
public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/advancedproblems/users.csv";
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                String email = data[2].trim();
                String phone = data[3].trim();
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid email in row: " + line);
                }
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid phone number in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
