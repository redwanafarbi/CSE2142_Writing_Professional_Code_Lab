//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {
//		Check arguments
        if (args.length > 1) {
            System.out.println("Invalid number of arguments");
        }
        else {
            if (args[0].equals("a")) {
                System.out.println("Loading data ...");
                try {
                    String studentName = readFrom("student.txt");
                    String students[] = studentName.split(",");
                    for (String student : students) {
                        System.out.println(student.trim());
                    }
                } catch (Exception e) {

                }
                System.out.println("Data Loaded.");
            }
            else if (args[0].equals("r")) {
                System.out.println("Loading data ...");
                try {
                    String studentName = readFrom("student.txt");
                    String student[] = studentName.split(",");
                    Random randomStudent = new Random();
                    int randomIndexForStudentSelection = randomStudent.nextInt(student.length);
                    System.out.println(student[randomIndexForStudentSelection].trim());
                } catch (Exception e) {
                }
                System.out.println("Data Loaded.");
            }
            else if (args[0].contains("+")) {
                System.out.println("Loading data ...");
                try {
                    String newStudent = args[0].substring(1);
                    Date date = new Date();
                    String datePrintStyle = "dd/mm/yyyy-hh:mm:ss a";
                    DateFormat dateFormat = new SimpleDateFormat(datePrintStyle);
                    String formattedDate = dateFormat.format(date);
                    writeInFile(", " + newStudent + "\nList last updated on " + formattedDate,"student.txt");
                } catch (Exception e) {

                }
                System.out.println("Data Loaded.");
            }
            else if (args[0].contains("?")) {
                System.out.println("Loading data ...");
                try {
                    String studentName = readFrom("student.txt");
                    String students[] = studentName.split(",");
                    boolean done = false;
                    String searchedStudentName = args[0].substring(1);
                    for (int index = 0; index < students.length && !done; index++) {
                        if (students[index].equals(searchedStudentName)) {
                            System.out.println("We found it!");
                            done = true;
                        }
                    }
                } catch (Exception e) {

                }
                System.out.println("Data Loaded.");
            } else if (args[0].contains("c")) {
                System.out.println("Loading data ...");
                try {
                    String studentName = readFrom("student.txt");
                    char students[] = studentName.toCharArray();
                    boolean in_word = false;
                    int count = 0;
                    for (char student : students) {
                        if (student == ' ') {
                            if (!in_word) {
                                count++;
                                in_word = true;
                            } else {
                                in_word = false;
                            }
                        }
                    }
                    System.out.println(count + " word(bufferedReader) found ");
                } catch (Exception e) {

                }
                System.out.println("Data Loaded.");
            }
        }
    }

    public static String readFrom(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
        return "";
    }

    public static String writeInFile(String writingText ,String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(fileName, true));
            bufferedWriter.write(writingText);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing file");
        }
        return "";
    }
}



