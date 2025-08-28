package EquationMatcher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FindEquation {

    public static void main(String[] args) {


        try {
            File listFours = new File("listfours.txt");
            Scanner myReader = new Scanner(listFours);

            ArrayList<ArrayList<ArrayList<String>>> sortedByAs = new ArrayList<ArrayList<ArrayList<String>>>();

            int maxOfAs = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println("data: " +data);
                ArrayList<String> equations = new ArrayList<String>();

                if (data.contains("does contain")) {
                    continue;
                }
                String stringBuilder = "";
                for (int i = 0; i < data.length(); i++) {
//                    System.out.println("data substring" + data.substring(i,i+1));
                    if (data.substring(i,i+1).contains("[")) {
//                        System.out.println("open bracket, continue");
                        continue;
                    } else if (data.substring(i,i+1).contains(",")) {
//                        System.out.println("comma, add stringBuilder to equations, reset stringBuilder");
                        equations.add(stringBuilder);
                        stringBuilder = "";
                    } else if (data.substring(i,i+1).contains("]")) {
//                        System.out.println("close bracket, add stringBuilder to equations");
                        equations.add(stringBuilder);
                    } else {
//                        System.out.println("is int or \" \"");
                        stringBuilder = stringBuilder + data.substring(i,i+1);
                        System.out.println(stringBuilder);
                    }

                }
//                System.out.println("equations: " + equations);

                ArrayList<ArrayList<String>> equationsDiscrete = new ArrayList<ArrayList<String>>();
                String expressionElements = "";
                for (String equation : equations) {
                    equationsDiscrete.add(new ArrayList<String>());
                    for (int i = 0; i < equation.length(); i++) {
                        if (i + 1 == equation.length()) {
                            expressionElements += equation.substring(i, i + 1);
//                            System.out.println("in here");
//                            System.out.println("expressionelement" +expressionElements);
                            equationsDiscrete.get(equations.indexOf(equation)).add(expressionElements);
//                            System.out.println("Equationsdiscrete: " + equationsDiscrete);
                            continue;
                        }
                        if (equation.substring(i, i+1).contains(" ") == false) {
                            expressionElements += equation.substring(i, i + 1);
//                            System.out.println("expressionelement" +expressionElements);
                        } else {
//                            System.out.println("in else");
//                            System.out.println("Equationsdiscrete: " + equationsDiscrete);
                            equationsDiscrete.get(equations.indexOf(equation)).add(expressionElements);
//                            System.out.println(equations.indexOf(equation));
//                            System.out.println("Equationsdiscrete: " + equationsDiscrete);
//                            System.out.println(equationsDiscrete.get(equations.indexOf(equation)).get(0));
                            expressionElements = "";
                        }
//                        System.out.println("Equationsdiscrete: " + equationsDiscrete);
                    }
                }
                for (int i = 1; i < equationsDiscrete.size(); i ++) {
                    equationsDiscrete.get(i).removeFirst();
                }
//                System.out.println("complete: " +equationsDiscrete);


                ArrayList<String> defaultEquation = new ArrayList<String>();

                for (String element: equationsDiscrete.get(0)) {
                    defaultEquation.add(element);
                }

//                System.out.println("defaultEquation: " +defaultEquation);

                /*positions == size of defaultEquation
                        set position equal to a if all true in isSolution */
//                ArrayList<Boolean> isSolution = new ArrayList<Boolean>(equationsDiscrete.size());
                if (equationsDiscrete.size() == 1) {
                    System.out.println("not provable");
                } else {
//                    isSolution.add(true);
//                    for (int i = 1; i < equationsDiscrete.size(); i++) {
//                        ArrayList<Boolean> isSolution = new ArrayList<Boolean>(equationsDiscrete.size());
//                        isSolution.add(true); // l, then i
//                        for (int l = 0; l < equationsDiscrete.get(i).size(); l++) {
//                            if (Double.valueOf(equationsDiscrete.get(i).get(l)) == Double.valueOf(defaultEquation.get(l)) + (double) i) {
//                            isSolution.add(true);
//                        } else {
//                            continue;
//                        }
////                            if all true, position =  a;
//                    }
//                }


                    boolean substitutable = false;

                    int countAs = 0;
                    for (int p = 0; p < defaultEquation.size(); p++) {
                        ArrayList<Boolean> isSolution = new ArrayList<Boolean>(equationsDiscrete.size());
                        isSolution.add(true);

                        for (int i = 1; i < equationsDiscrete.size(); i++) {
                            try {
                                if (Double.valueOf(equationsDiscrete.get(i).get(p)) == Double.valueOf(defaultEquation.get(p)) + (double) i) {
                                    isSolution.add(true);
//                                    System.out.println("added to issolution");
                                } else {
                                    isSolution.add(false);
                                }
                            } catch (NumberFormatException n) {
//                                System.out.println("not a number");
                                isSolution.add(false);
                            }
                        }
//                        System.out.println("defaultequation2: " + defaultEquation);
//                        System.out.println(isSolution);
                        if (isSolution.contains(false) == false) {
//                            System.out.println("printing p, and a," +p +defaultEquation.get(p));
                            defaultEquation.set(p, "a");
                            countAs++;
//                            System.out.println("countAs" +countAs);
//                            System.out.println("defaultequation2: " + defaultEquation);
                            substitutable = true;
                        }
                        if (countAs > maxOfAs) {
                            maxOfAs = countAs;
                        }
                    }

//                    System.out.println("max of As:" + maxOfAs);
                    for (int i = sortedByAs.size(); i < maxOfAs; i++) {
                        sortedByAs.add(new ArrayList<>());
                    }

                    sortedByAs.get(countAs-1).add(defaultEquation);

                    if (substitutable = true) {
                        System.out.println("defaultEquation: " + defaultEquation);
                    }
                }

                try {
                    File myObj = new File("equations.txt");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                    FileWriter fileWriter = new FileWriter("equations.txt",true);
                    fileWriter.append(""+defaultEquation + "\n");
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }


//
//                for (ArrayList<String> equation : equationsDiscrete) {
//                    for (String element)
//                }
            }

//            System.out.println("printing sortedbyAs" + sortedByAs);

            try {
                File myObj = new File("sortedSubbedEquations.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
                FileWriter fileWriter = new FileWriter("sortedSubbedEquations.txt",true);
                for (ArrayList<ArrayList<String>> aGroup : sortedByAs) {
                    for (ArrayList<String> aEquation : aGroup) {
                        fileWriter.append(""+aEquation + "\n");
                    }
                }
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


        } catch (IOException e) {
        } catch (NumberFormatException n) {
            System.out.println("is not a number");
        }
    }
}
