//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {
//		Check arguments
        if (args.length > 1) {
            System.out.println(Constants.INVALID_ARGUMENT);
        }
        else {
            if (args[0].equals(Constants.CHAR_A)) {
                System.out.println(Constants.LOADING_DATA);
                try {
                    String studentName = readFrom(Constants.FILE_NAME);
                    String students[] = studentName.split(Constants.COMMA);
                    for (String student : students) {
                        System.out.println(student.trim());
                    }
                } catch (Exception e) {

                }
                System.out.println(Constants.DATA_LOADED);
            }
            else if (args[0].equals(Constants.CHAR_R)) {
                System.out.println(Constants.LOADING_DATA);
                try {
                    String studentName = readFrom(Constants.FILE_NAME);
                    String student[] = studentName.split(Constants.COMMA);
                    Random randomStudent = new Random();
                    int randomIndexForStudentSelection = randomStudent.nextInt(student.length);
                    System.out.println(student[randomIndexForStudentSelection].trim());
                } catch (Exception e) {
                }
                System.out.println(Constants.DATA_LOADED);
            }
            else if (args[0].contains(Constants.PLUS)) {
                System.out.println(Constants.LOADING_DATA);
                try {
                    String newStudent = args[0].substring(1);
                    Date date = new Date();
                    String datePrintStyle = Constants.DATE_FORMAT;
                    DateFormat dateFormat = new SimpleDateFormat(datePrintStyle);
                    String formattedDate = dateFormat.format(date);
                    writeInFile(Constants.COMMA_WITH_A_SPACE + newStudent + Constants.LAST_UPDATE + formattedDate,Constants.FILE_NAME);
                } catch (Exception e) {

                }
                System.out.println(Constants.DATA_LOADED);
            }
            else if (args[0].contains(Constants.QUESTION_MARK)) {
                System.out.println(Constants.LOADING_DATA);
                try {
                    String studentName = readFrom(Constants.FILE_NAME);
                    String students[] = studentName.split(Constants.COMMA);
                    boolean done = false;
                    String searchedStudentName = args[0].substring(1);
                    for (int index = 0; index < students.length && !done; index++) {
                        if (students[index].equals(searchedStudentName)) {
                            System.out.println(Constants.WE_FOUND);
                            done = true;
                        }
                    }
                } catch (Exception e) {

                }
                System.out.println(Constants.DATA_LOADED);
            } else if (args[0].contains("c")) {
                System.out.println(Constants.LOADING_DATA);
                try {
                    String studentName = readFrom(Constants.FILE_NAME);
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
                    System.out.println(count + Constants.WORD_FOUND);
                } catch (Exception e) {

                }
                System.out.println(Constants.DATA_LOADED);
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
            System.out.println(Constants.ERROR_READING);
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
            System.out.println(Constants.ERROR_WRITING);
        }
        return "";
    }
}



