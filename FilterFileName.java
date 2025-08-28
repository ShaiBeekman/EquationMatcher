package EquationMatcher;

import java.io.*;
import java.util.Scanner;

public class FilterFileName {

    public static void main(String[] args) {

        try {
            File filename = new File("filename.txt");
            try {
                File listFours = new File("listFours.txt");
                if (listFours.createNewFile()) {
                    System.out.println("File created: " + listFours.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            Scanner myReader = new Scanner(filename);
            while (myReader.hasNextLine()) {
                int commaCount = 0;
                String data = myReader.nextLine();
                System.out.println(data);
                for (int i = 0; i < data.length(); i++) {
                    if (",".contains(data.substring(i,i+1))) {
//                        System.out.println(",");
                        commaCount++;
//                        System.out.println("commaCount:" + commaCount);
                    }
                }
                if (commaCount==1) {
                    try {
                        FileWriter myWriter = new FileWriter("listFours.txt", true);
                        myWriter.append(data + "\n");
                        myWriter.close();
//                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("an error");
                    }
                }
            }
            myReader.close();
//        }
//        try {
//            FileWriter fileWriter = new FileWriter("filename.txt");
//catch {}
        } catch (FileNotFoundException e ) {
            System.out.println("File not found");
        }
    }
}
