package EquationMatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ValidEquation {
    public static void main(String[] args) {

        try {
            File equationsFile = new File("equations.txt");
            Scanner myReader = new Scanner(equationsFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                ArrayList<String> equations = new ArrayList<String>();

                String stringBuilder = "";
                for (int i = 0; i < data.length(); i++) {
                    System.out.println("data substring" + data.substring(i,i+1));
                    if (data.substring(i,i+1).contains("[")) {
                        System.out.println("open bracket, continue");
                        continue;
                    } else if (data.substring(i,i+1).contains(",")) {
                        System.out.println("comma, add stringBuilder to equations, reset stringBuilder");
                        equations.add(stringBuilder);
                        stringBuilder = "";
                    } else if (data.substring(i,i+1).contains("]")) {
                        System.out.println("close bracket, add stringBuilder to equations");
                        equations.add(stringBuilder);
                    } else {
                        System.out.println("is int or \" \"");
                        stringBuilder = stringBuilder + data.substring(i,i+1);
                        System.out.println(stringBuilder);
                    }


                }

                System.out.println("equations: " + equations);

                ArrayList<Boolean> checkValidity = new ArrayList<>();
                for (int k = 1; k <= 10; k++) {
                    ArrayList<String> copyEquations = new ArrayList<String>();
                    for (String e : equations) {
                        copyEquations.add(e);
                    }
                    double value = 0;
                    System.out.println("this is k" +k);
                    for (int i = 0; i < copyEquations.size(); i++) {
                        if (i == 0) {
                            System.out.println("value1 b4:" +value);

                            if (copyEquations.get(i).contains("a")) {
                                copyEquations.set(i, String.valueOf(Double.valueOf(k)));
                                System.out.println("printing about k" + copyEquations.get(i));
                            }
                            value = Double.valueOf(copyEquations.get(i));
                            System.out.println("value1 af:" +value);
                        }

                        if (copyEquations.get(i).contains("+")) {
                            System.out.println("value2 b4:" +value);

                            if (copyEquations.get(i+1).contains( "a")) {
                                copyEquations.set(i+1, String.valueOf(Double.valueOf(k)));
                            }
                            value = value + Double.valueOf(copyEquations.get(i + 1));
                            i++;
                            System.out.println("value2 af:" +value);

                        }

                        if (copyEquations.get(i).contains("-")) {
                            System.out.println("value3 b4:" +value);

                            if (copyEquations.get(i+1).contains( "a")) {
                                copyEquations.set(i+1, String.valueOf(Double.valueOf(k)));
                            }
                            System.out.println("value3 af:" +value);

                            value = value - Double.valueOf(copyEquations.get(i + 1));
                            i++;
                        }   if (copyEquations.get(i).contains("/")) {
                            System.out.println("value3 b4:" +value);

                            if (copyEquations.get(i+1).contains( "a")) {
                                copyEquations.set(i+1, String.valueOf(Double.valueOf(k)));
                            }
                            System.out.println("value4 af:" +value);

                            value = value / Double.valueOf(copyEquations.get(i + 1));
                            i++;
                        }   if (copyEquations.get(i).contains("*")) {
                            System.out.println("value5 b4:" +value);

                            if (copyEquations.get(i+1).contains("a")) {
                                copyEquations.set(i+1, String.valueOf(Double.valueOf(k)));
                            }
                            System.out.println("printing newTerm" +Double.valueOf(copyEquations.get(i + 1)));
                            value = value * Double.valueOf(copyEquations.get(i + 1));
                            System.out.println("value5 af:" +value);

                            i++;
                        }   if (copyEquations.get(i).contains("^")) {
                            System.out.println("value6 b4:" +value);

                            if (copyEquations.get(i+1).contains( "a")) {
                                copyEquations.set(i+1, String.valueOf(Double.valueOf(k)));
                            }
                            System.out.println("value6 af:" +value);

                            value = Math.pow(value, Double.valueOf(copyEquations.get(i + 1)));
                            i++;
                        }
                    }
                    System.out.println(value);
                    if (value == (double) calculateSummandial(k)) {
                        checkValidity.add(true);
                        System.out.println("value matches!");
                    } else {
                        checkValidity.add(false);
                    }
                }
                if (checkValidity.contains(false) == false) {
                    System.out.println("a nonrecursive equation was found");
                    System.out.println(equations);


                    File nonrecursivesolutions = new File("nonrecursivesolutons.txt");
                    FileWriter fr = new FileWriter(nonrecursivesolutions, true);

                    fr.append("" + equations + "\n");

                    fr.close();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double operatorSystem(double calculateExpression, String operator, double newTerm) {
        switch (operator) {
            case "-":
                calculateExpression = calculateExpression - newTerm;
                break;
            case "+":
                calculateExpression = calculateExpression + newTerm;
                break;
            case "*":
                calculateExpression = calculateExpression * newTerm;
                break;
            case "/":
                calculateExpression = calculateExpression / newTerm;
                break;
            case "^":
                calculateExpression = Math.pow(calculateExpression, newTerm);

                break;
            default:
                break;
        }
        return calculateExpression;
    }

    public static int calculateSummandial(int input) {
        int c = 0;
        for (int i = 1; i <= input; i++) {
            c += i;
        }
        return c;
    }
}

