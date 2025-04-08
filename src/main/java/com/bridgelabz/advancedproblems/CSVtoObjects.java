package com.bridgelabz.advancedproblems;
import java.io.*;
import java.util.*;
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}
public class CSVtoObjects {
    public static void main(String[] args) {
        String filePath = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/csv-data-handling/src/main/java/com/bridgelabz/advancedproblems/students.csv";
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());
                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }
            // Print all student objects
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

