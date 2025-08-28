//https://www.w3schools.com/java/java_switch.asp
//https://www.w3schools.com/java/java_foreach_loop.asp
//https://www.w3schools.com/java/tryjava.asp?filename=demo_.*
//https://stackoverflow.com/questions/5884353/how-to-insert-a-character-in-a-string-at-a-certain-position


import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.Math;


public class EquationMatcher {


    public static int read() {
        Scanner myReader = new Scanner(System.in);
        System.out.println("Enter number of terms");
        String number = myReader.nextLine();
        return Integer.parseInt(number);
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


    public static int calculateFactorial(int input) {
        int c = 1;
        for (int i = 1; i <= input; i++) {
            c = c * i;
        }
        return c;
    }


    public static int calculateSummandial(int input) {
        int c = 0;
        for (int i = 1; i <= input; i++) {
            c += i;
        }
        return c;
    }


    public static void main(String[] args) throws IOException {
        String[] operations = {"-", "+", "*", "/", "^", "()"};
        ArrayList<ArrayList<Double>> expressionList = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<String>> stringExpressionList = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> discreteExpressionList = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> arithmeticExpressionList = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> expressionArray = new ArrayList<ArrayList<String>>();


        List<ArrayList<ArrayList<Object>>> allList = new ArrayList<ArrayList<ArrayList<Object>>>();


        int input = read();
        double calculateExpression = 0;
        String stringExpression = "";
        String arithmeticExpression = "";
        String discreteExpression = "";


        int counter = 0;


        int termsAmount = 6;


        for (int t = 1; t <= termsAmount; t++) {
            expressionList.add(new ArrayList<Double>());
            stringExpressionList.add(new ArrayList<String>());
            discreteExpressionList.add(new ArrayList<String>());
            arithmeticExpressionList.add(new ArrayList<String>());
            allList.add(new ArrayList<ArrayList<Object>>());
//            System.out.println("t="+t);


            int expressionCount = 0;


            double newTerm;


            int vtGroupCount=0;


            int allListCount=0;


            for (int v = 1; (v <= 6); v++) {


                if (t == 1) {
                    newTerm = v;
                    calculateExpression = newTerm;
                    stringExpression = "" + newTerm;
                    arithmeticExpression = "" + operations[5].charAt(0) + stringExpression + operations[5].charAt(1);
                    discreteExpression = "";


                    expressionList.get(t - 1).add(calculateExpression);
                    allList.get(t - 1).add(new ArrayList<Object>());
                    allList.get(t - 1).get(v - 1).add(calculateExpression);




//                    stringExpressionList.get(t - 1).add(new ArrayList<String>());
                    stringExpressionList.get(t - 1).add(stringExpression);
                    allList.get(t - 1).get(v - 1).add(stringExpression);


                    arithmeticExpressionList.get(t - 1).add(arithmeticExpression);
                    allList.get(t - 1).get(v - 1).add(arithmeticExpression);






//                    allList.get(t - 1).get(v - 1).add(new ArrayList<Object>());
//                    for (int r = 0; r < stringExpression.length(); r++) {
//                        discreteExpression = Character.toString(stringExpression.charAt(r));
//                        discreteExpressionList.get(t - 1).add(discreteExpression);
//                        allList.get(t - 1).get(v - 1).add(discreteExpression);
//                    }


                    continue;


                } else {


                    if (t > 1) {
//                        System.out.println("" + t + " : t does equal 3!");


                        newTerm = v;


                        for (ArrayList<Object> expressionForms : allList.get(t - 2)) {
//                            System.out.println("expforms" +expressionForms);
                            for (int o = 0; o < operations.length - 1; o++) {
                                ArrayList<Object> addToAllList = new ArrayList<Object>();


                                newTerm = v;


//                                System.out.println("expressionForms " +expressionForms);


//                                System.out.println("expf0"+expressionForms.get(0));
                                calculateExpression = operatorSystem((double) expressionForms.get(0), operations[o], newTerm);
//                                System.out.println("ccexp"+calculateExpression);
                                expressionList.get(t - 1).add(calculateExpression);
//                                System.out.println("Expression List: " +expressionList);
                                addToAllList.add(calculateExpression);
//                                System.out.println("addtoalllist1"+addToAllList);


//                                System.out.println("stringExpressionList1: "+expressionForms.get(1));
                                String updateStringExpression = "" + expressionForms.get(1) + " " + operations[o] + " " + newTerm;
//                                System.out.println("ccexp"+updateStringExpression);
                                stringExpressionList.get(t - 1).add(updateStringExpression);
//                                System.out.println("stringExpressionList List: " +stringExpressionList);
                                addToAllList.add(updateStringExpression);
//                                System.out.println("addtoalllist1"+addToAllList);




//                                System.out.println("arithmeticExpressionList1: "+expressionForms.get(2));
                                arithmeticExpression = ""+operations[5].charAt(0) + "" + expressionForms.get(2) + " " + operations[o] + " " + newTerm + operations[5].charAt(1);
//                                System.out.println("ccexp"+arithmeticExpression);
                                arithmeticExpressionList.get(t - 1).add(arithmeticExpression);
//                                System.out.println("arithmeticExpressionList List: " +arithmeticExpressionList);
                                addToAllList.add(arithmeticExpression);
//                                System.out.println("addtoalllist1"+addToAllList);




//                                System.out.println("allList" +allList);
                                allList.get(t-1).add(addToAllList);
//                                System.out.println("allList" +allList);


//                                System.out.println("addtoall" +addToAllList);




//                                    expressionList.get(t - 1).get(vtGroupCount).add(calculateExpression);


//
//                                add to t-1;
//
//                                allList.get(t - 1).add(new ArrayList<Object>());
//                                expressionList
//                                expressionForms.get() ;
                            }




//                            System.out.println(expressionList);
//                            System.out.println("allList: " +allList);
                        }
//                        System.out.println(expressionList);
//                        System.out.println("allList: " +allList);


//                        expressionList.get(t - 1).add(new ArrayList<Double>());
//                        stringExpressionList.get(t - 1).add(new ArrayList<String>());
//                        arithmeticExpressionList.get(t - 1).add(new ArrayList<String>());
//                        discreteExpressionList.get(t - 1).add(new ArrayList<String>());


//                        for (int i = 0; i < expressionList.get(t - 2).toArray().length; i++) {
//                            expressionList.get(t - 1).add(new ArrayList<Double>());
//                            stringExpressionList.get(t - 1).add(new ArrayList<String>());
//                            arithmeticExpressionList.get(t - 1).add(new ArrayList<String>());
//                            discreteExpressionList.get(t - 1).add(new ArrayList<String>());
////                            System.out.println("alllistb4:" +allList);
////                            System.out.println("alllistaf:" +allList);
//
//
//                            for (int g = 0; g < stringExpressionList.get(t - 2).get(i).toArray().length; g++) {//number of expressions in i'th array'
//                                ArrayList<ArrayList<ArrayList<Object>>> containExpressionGroup = new ArrayList<ArrayList<ArrayList<Object>>>();
//                                for (int o = 0; o < operations.length - 1; o++) {
////                                    System.out.println("allList1:"+allList);
////                                    ArrayList<ArrayList<Object>> addToAllList2 = new ArrayList<ArrayList<Object>>();
////                                    allList.get(t - 1).add(new ArrayList<ArrayList<Object>>());
////                                    System.out.println("allList2:"+allList);
//
//                                    calculateExpression = operatorSystem(expressionList.get(t - 2).get(i).get(g), operations[o], newTerm);
//                                    expressionList.get(t - 1).get(vtGroupCount).add(calculateExpression);
//
////                                    ArrayList<Object> addToAllList2A = new ArrayList<Object>();
////                                    addToAllList2A.add(calculateExpression);
//
//                                    String updateStringExpression = "" + stringExpressionList.get(t - 2).get(i).get(g) + " " + operations[o] + " " + newTerm;
//                                    stringExpressionList.get(t - 1).get(vtGroupCount).add(updateStringExpression);
////                                    System.out.println("allList5:"+allList);
////                                    allList.get(t - 1).get(vtGroupCount).add(new ArrayList<Object>());
////                                    System.out.println("allList6:"+allList);
////                                    allList.get(t - 1).get(vtGroupCount).get(1).add(updateStringExpression);
//
////                                    ArrayList<Object> addToAllList2B = new ArrayList<Object>();
////                                    addToAllList2B.add(updateStringExpression);
//
//
//
//                                    arithmeticExpression = ""+operations[5].charAt(0) + "" + arithmeticExpressionList.get(t - 2).get(i).get(g) + " " + operations[o] + " " + newTerm + operations[5].charAt(1);
//                                    arithmeticExpressionList.get(t - 1).get(vtGroupCount).add(arithmeticExpression);
//
////                                    ArrayList<Object> addToAllList2C = new ArrayList<Object>();
////                                    addToAllList2C.add(arithmeticExpression);
//
//4
//
////                                    System.out.println("allList8:"+allList);
////                                    allList.get(t - 1).get(vtGroupCount).add(new ArrayList<Object>());
////                                    System.out.println("allList9:"+allList);
////                                    allList.get(t - 1).get(vtGroupCount).get(2).add(arithmeticExpression);
//
////                                    System.out.println("allList10:"+allList);
////                                    allList.get(t - 1).get(vtGroupCount).add(new ArrayList<Object>());
////                                    System.out.println("allList11:"+allList);
//
////                                  System.out.println(allList);
//
////                                    ArrayList<Object> addToAllList2D = new ArrayList<Object>();
//                                   for (int r = 0; r < updateStringExpression.length(); r++) {
////                                        discreteExpression = Character.toString(updateStringExpression.charAt(r));
////                                        discreteExpressionList.get(t - 1).get(vtGroupCount).add(discreteExpression);
//////                                        addToAllList2C.add(discreteExpression);
////                                    }
//
////                                    ArrayList<ArrayList<Object>> addtoAllList3 = new ArrayList<ArrayList<Object>>();
////                                    addtoAllList3.add(addToAllList2A);
////                                    addtoAllList3.add(addToAllList2B);
////                                    addtoAllList3.add(addToAllList2C);
////                                    addtoAllList3.add(addToAllList2D);
////
////                                    allList.get(t-1).get(allListCount).add(addtoAllList3);
//
////                                    System.out.println("discrete:" +discreteExpressionList.get(t - 1).get(vtGroupCount));
////                                    allList.get(t - 1).get(vtGroupCount).get(3).add(discreteExpressionList.get(t - 1).get(vtGroupCount));
////                                    System.out.println("vt3"+);
//
////                                    discreteExpressionList.get(t - 1).get(i).add("" + expressionList.get(t - 2).get(i).get(g));
////                                    discreteExpressionList.get(t - 1).get(i).add("" + operations[o]);
////                                    discreteExpressionList.get(t - 1).get(i).add("" + newTerm);
////
//                                }
//                            }
//                            vtGroupCount++;
//                        }
                    }
                }
            }
        }
//        System.out.println(
//                "Expression List"+"\n" +expressionList + "\n" +
//                        "String Expression List:"+"\n" +stringExpressionList + "\n" +
//                        "Arithmetic Expression List:"+"\n" +arithmeticExpressionList
//        );




        ArrayList<List<ArrayList<Object>>> slnsFound = new ArrayList<List<ArrayList<Object>>>();
        for (int c = 1; c <= input; c++) {
            List<ArrayList<Object>> partoFactorialAnswers = iterateAllList(c, allList, operations);
            slnsFound.add(partoFactorialAnswers);
        }
//        System.out.println(slnsFound);
//        System.out.println("number of solutions:" +slnsFound.get(0).size() +slnsFound.get(1).size() +slnsFound.get(2).size() +slnsFound.get(3).size());


        int count = 0 ;
        int partoFactoriandIndex = 0;
        for (ArrayList<Object> slnGroup : slnsFound.get(partoFactoriandIndex)){
            String stringSolution = slnGroup.get(1).toString();
            ArrayList<String> stringSolutionAsArray = new ArrayList<String>();


            String stringTerm = "";
            for (int s = 0; s < stringSolution.length(); s++) {
                if (stringSolution.substring(s, s+1).contains(" ") == false) {
//                    System.out.println("string sln substring is " + stringSolution.substring(s, s+1));
                    stringTerm += stringSolution.substring(s,s+1);
//                    variables.get(strSlnIndex.indexOf(sln)).add(constructVariable);
//                    constructVariable = "";
                } else {
//                    System.out.println("string sln substring2 is " + stringSolution.substring(s, s+1));


//                    System.out.println("stringTerm is: " +stringTerm);
                    stringSolutionAsArray.add(stringTerm);
                    stringTerm = "";
                }
//                    stringSolutionArray.add(constructNewString);
            }
//            System.out.println("stringTermFinal is: " +stringTerm);
            count ++;
//            System.out.println("stringSolution is:" +stringSolution);
            stringSolutionAsArray.add(stringTerm);//*
//            System.out.println("string solution as arrayList: " +stringSolutionAsArray);


//            if (slnsFound.size() == 1) {
//                System.out.println("all solutions for input "  +input +": " +slnsFound);
//            System.out.println("pruin" +count + " other " +slnsFound.get(partoFactorialIndex).size())
//            } else {; ig parto < size; return;


//            if


//            List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();


            List<ArrayList<ArrayList<ArrayList<String>>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
            stringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());
            stringSolutionsList.get(0).add(new ArrayList<ArrayList<String>>());


            int stringSolutionsListSubGroup = 0;
            int stringSolutionsListSubGroupElementIndex = 0;
            stringSolutionsList.get(partoFactoriandIndex).get(0).add(stringSolutionAsArray);


            List<ArrayList<String>> trackSlnCongruences = new ArrayList<ArrayList<String>>(); //!@@
            trackSlnCongruences.add(stringSolutionAsArray); //!@@@


//            System.out.println("String Solutions List : " +stringSolutionsList);


            if (stringSolutionAsArray.get(0).equals(Double.toString(1.0))==false) {
//                System.out.println("is this");
                continue;
            }


//            System.out.println("recurrence result: " +recurToGenerateACompleteListOfStringArrays(slnsFound, partoFactoriandIndex+1, stringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex, trackSlnCongruences));
            List<ArrayList<ArrayList<ArrayList<String>>>> answers = recurToGenerateACompleteListOfStringArrays(slnsFound, partoFactoriandIndex+1, stringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex, trackSlnCongruences);
//            System.out.println(slnsFound);




            ArrayList<String> completeSolution = new ArrayList<String>();


            try {
                File myObj = new File("C:\\Users\\jenni\\IdeaProjects\\Linear Expressions\\filename.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
                System.out.println(lastRecursion(answers,slnsFound, completeSolution, 0, myObj));


            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
//            for (int i = 0; i < answers.size(); i++) {
//                for (int p = 0; p < answers.get(i).size(); p++) {
//
//                    for (int f = 0; f < answers.get(i).get(p).size(); f++) {
//                        String solutionString = "";
//                        for (int g = 0; g < answers.get(i).get(p).get(f).size(); g++) {
//                            if (g == 0) {
//                                solutionString += answers.get(i).get(p).get(f).get(g);
//                            } else {
//                                solutionString += " " + answers.get(i).get(p).get(f).get(g);
//                            }
//                        }
//                        System.out.println("printing solutionString: " + solutionString);
//                        if (slnsFound.get(i).get(p).contains(solutionString)) {
//                            completeSolution.add(solutionString);
//                            break;
//                        }
//                    }
//                }
//            }




//
//
//            generalSolutionSearch(stringSolutionAsArray, partoFactorialIndex+1, trackSlnCongruences, slnsFound);
//            }//just need to
        } //for loop






//         searchGeneralSolution(slnsFound, 0);




//        ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>> congruenceGroups = new ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>>();
//        for (int t = 0; t <= termsAmount; t++) {
//            ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>> congruenceGroup = new ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>();
//            congruenceGroups.add(congruenceGroup);
//        }
//        System.out.println("entering conggroups:" +congruenceGroups);
//        congruenceGroups = congruenceSearch(congruenceGroups, slnsFound, -1);




//        File file = new File("print.txt");
//        FileWriter fr = new FileWriter(file);
//        for (ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>> groups : congruenceGroups) {
//            for (ArrayList<ArrayList<ArrayList<ArrayList<String>>>> group : groups) {
//                fr.write("" + group + "\n\n");
//            }
//        }
//        fr.close();


    }


    public static ArrayList<String> lastRecursion (List<ArrayList<ArrayList<ArrayList<String>>>> answers, ArrayList<List<ArrayList<Object>>> slnsFound, ArrayList<String> completeSolution, int partoFactoriandIndex, File myObj) {
//        System.out.println("in lastRecursion");
//        System.out.println("printing answers"  +answers);
//try {
//    FileWriter myWriter = new FileWriter(myObj);
//} catch (java. io. IOException e) {
//
//}
        try {
            FileWriter myWriter = new FileWriter("filename.txt", true);
//                System.out.println("File created: " + myObj.getName());


//            myWriter.write("Files in Java might be tricky, but it is fun enough!");
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
            for (int i = partoFactoriandIndex; i < partoFactoriandIndex + 1; i++) {
//                System.out.println(answers.get(i));
                for (int p = 0; p < answers.get(i).size(); p++) {


                    for (int f = 0; f < answers.get(i).get(p).size(); f++) {
                        String solutionString = "";
                        for (int g = 0; g < answers.get(i).get(p).get(f).size(); g++) {
                            if (g == 0) {
                                solutionString += answers.get(i).get(p).get(f).get(g);
                            } else {
                                solutionString += " " + answers.get(i).get(p).get(f).get(g);
                            }
                        }
//                        System.out.println("printing solutionString: " + solutionString);
//                        System.out.println("slnsfound scnd index size:  " +slnsFound.get(partoFactoriandIndex).size());
//                        System.out.println("slnsfound scnd index :  " +partoFactoriandIndex +slnsFound.get(partoFactoriandIndex));


                        boolean found = false;


                        for (ArrayList<Object> compute : slnsFound.get(partoFactoriandIndex)) {
//                            if (solutionString.contains("1.0 ^ 2.0 + 1.0 / 2.0")) {
//                                System.out.println("found 1.0 ^ 2.0 + 1.0 / 2.0");
//                            }
                            if (compute.contains(solutionString)) {
//                                System.out.println("found is true");
//                                myWriter.append("does contain");
                                myWriter.append("" + solutionString + "\n");


//                                System.out.println(partoFactoriandIndex);
                                found = true;
                                completeSolution.add(solutionString);


                                myWriter.append(""+completeSolution + "\n");
                                myWriter.close();
//                                System.out.println("Successfully wrote to the file.");


//                                System.out.println("complete solution:" +completeSolution);
                                lastRecursion(answers, slnsFound, completeSolution, partoFactoriandIndex + 1, myObj);
                            }
                        }
//                        if (slnsFound.get(partoFactoriandIndex).contains(solutionString)) {
//                        System.out.println("completesolution: " +completeSolution);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        }


//        System.out.println(completeSolution);
        return completeSolution;
    }


    public static ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>> congruenceSearch(ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<ArrayList<String>>>>>> congruenceGroups, ArrayList<ArrayList<ArrayList<ArrayList<String>>>> slnsFound, int groupCongruenceCounter) {
        ArrayList<ArrayList<ArrayList<String>>> factoriand = slnsFound.get(groupCongruenceCounter + 1);
        for (ArrayList<ArrayList<String>> factoriandSlnProperties : factoriand) {
            int groupCongruenceCount = groupCongruenceCounter;


            ArrayList<ArrayList<ArrayList<ArrayList<String>>>> congruenceGroup = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();


            groupCongruenceCount++;


            ArrayList<ArrayList<ArrayList<String>>> congruenceGroupSlot1 = new ArrayList<ArrayList<ArrayList<String>>>();
            congruenceGroupSlot1.add(factoriandSlnProperties);
            congruenceGroup.add(congruenceGroupSlot1);


            ArrayList<ArrayList<ArrayList<String>>> congruenceGroupSlot2 = new ArrayList<ArrayList<ArrayList<String>>>();
            int congruences = 0;
            ArrayList<ArrayList<String>> congruenceArray = new ArrayList<ArrayList<String>>();
            ArrayList<String> congruenceArrayList = new ArrayList<String>();
            congruenceArrayList.add("" + congruences);
            congruenceArray.add(congruenceArrayList);
            congruenceGroupSlot2.add(congruenceArray);
            congruenceGroup.add(congruenceGroupSlot2);


            ArrayList<ArrayList<ArrayList<String>>> congruenceGroupSlot3 = new ArrayList<ArrayList<ArrayList<String>>>();
            ArrayList<ArrayList<String>> groupCongruenceCountArray= new ArrayList<ArrayList<String>>();
            ArrayList<String> groupCongruenceCountArrayList = new ArrayList<String>();
            groupCongruenceCountArrayList.add(""+groupCongruenceCount);
            groupCongruenceCountArray.add(groupCongruenceCountArrayList);
            congruenceGroupSlot3.add(groupCongruenceCountArray);
            congruenceGroup.add(congruenceGroupSlot3);


//            System.out.println("congruence gp: " + congruenceGroup);


            congruenceGroup = congruenceSearch2(congruenceGroup, slnsFound, groupCongruenceCount);
            congruenceGroups.get(Integer.parseInt(congruenceGroup.get(2).get(0).get(0).get(0))).add(congruenceGroup);
        }/*213*/
        return congruenceGroups;
    }


    public static ArrayList<ArrayList<ArrayList<ArrayList<String>>>> congruenceSearch2(ArrayList<ArrayList<ArrayList<ArrayList<String>>>> congruenceGroup, ArrayList<ArrayList<ArrayList<ArrayList<String>>>> slnsFound, int groupCongruenceCount) {
        try {
            ArrayList<ArrayList<String>> prevFactoriandProperties = congruenceGroup.get(0).get(groupCongruenceCount);
            ArrayList<String> factorialVariables = congruenceGroup.get(0).get(groupCongruenceCount).get(2);
            ArrayList<String> factorialOperations = congruenceGroup.get(0).get(groupCongruenceCount).get(3);


            groupCongruenceCount++;


            ArrayList<ArrayList<ArrayList<String>>> factoriand2 = slnsFound.get(groupCongruenceCount);
            for (ArrayList<ArrayList<String>> factoriandSlnProperties2 : factoriand2) {
                int congruences = 0;


                ArrayList<String> factorialVariables2 = factoriandSlnProperties2.get(2);
                ArrayList<String> factorialOperations2 = factoriandSlnProperties2.get(3);


                if (factorialOperations.equals(factorialOperations2)) {
                    if (factoriandSlnProperties2.get(0).contains("1.0 + 2.0 * 2.0 / 2.0")) {
//                        System.out.println("found!");
                        if(prevFactoriandProperties.get(0).contains("1.0 + 1.0 * 1.0 / 2.0")) {
//                            System.out.println("found this too");
                        }
//                        System.out.println(factoriandSlnProperties2.get(0));
                    }
                    for (int l = 0; l < factorialVariables.size(); l++) {
                        if (factorialVariables.get(l).equals(factorialVariables2.get(l))) {
//                            System.out.println("factorialvariables: " + factorialVariables);
//                            System.out.println("factorialvariables2: " + factorialVariables2);
                            congruences++;
//                            System.out.println("congrss" +congruences);
                        }
                    }
//                    System.out.println("outside of for.. congruences: " + congruences);
//                    System.out.println("failed if");


                    congruenceGroup.get(1).remove(0);
                    ArrayList<String> congruencesArray = new ArrayList<String>();
                    congruencesArray.add("" + congruences);
                    ArrayList<ArrayList<String>> congruencesArrayList = new ArrayList<ArrayList<String>>();
                    congruencesArrayList.add(congruencesArray);
                    congruenceGroup.get(1).add(congruencesArrayList);


                    congruenceGroup.get(2).remove(0);


                    ArrayList<String> congruenceGroupCountArray = new ArrayList<String>();
                    congruenceGroupCountArray.add("" + groupCongruenceCount);
                    ArrayList<ArrayList<String>> congruenceGroupCountArrayList = new ArrayList<ArrayList<String>>();
                    congruenceGroupCountArrayList.add(congruenceGroupCountArray);
                    congruenceGroup.get(2).add(congruenceGroupCountArrayList);


                    congruenceGroup.get(0).add(factoriandSlnProperties2);


                    congruenceSearch2(congruenceGroup, slnsFound, groupCongruenceCount);


                } else {
                    continue;
                }


            }




        } catch (IndexOutOfBoundsException i) {
            System.out.println("threw an error or at end !");
            return congruenceGroup;
        }
//        System.out.println("end of " +groupCongruenceCount + " iteration");
        return congruenceGroup;
    }


    public static List<ArrayList<Object>> iterateAllList(int c, List<ArrayList<ArrayList<Object>>> allList, String[] operations) {
//        int countiter1 = 0;
//        ArrayList<String> strSlnIndex = new ArrayList<String>();
//        ArrayList<Double> calcSlnIndex = new ArrayList<Double>();


        List<ArrayList<Object>> solutionsFound = new ArrayList<ArrayList<Object>>();


        for (ArrayList<ArrayList<Object>> expressionFormsGroup : allList) {
            for (ArrayList<Object> expressionForm : expressionFormsGroup) {
                if ((double) expressionForm.get(0) == (double) calculateSummandial(c)) {
                    solutionsFound.add(expressionForm);
                }
            }
        }


        return solutionsFound;
//
//
//                int slnCount = 0;
//        for (ArrayList<ArrayList<Double>> i : expressionList) {
//            int countiter2 = 0;
//            for (ArrayList<Double> p : i) {
//                int countiter3 = 0;
//                for (double l : p) {
//                    if (l == calculateSummandial(input)) {
//                        strSlnIndex.add(stringExpressionList.get(countiter1).get(countiter2).get(countiter3));
//                        calcSlnIndex.add(expressionList.get(countiter1).get(countiter2).get(countiter3));
//                        slnCount++;
//                    }
//                    countiter3++;
//                }
//                countiter2++;
//            }
//            countiter1++;
//        }
//        return checkCongruence(strSlnIndex, calcSlnIndex, operations);
//    }


//    public static ArrayList<ArrayList<ArrayList<String>>> checkCongruence(ArrayList<String> strSlnIndex, ArrayList<Double> calcSlnIndex, String[] operations) {
//
//        ArrayList<ArrayList<String>> variables = new ArrayList<ArrayList<String>>();
//
//        for (String sln : strSlnIndex) {
//            String constructVariable = "";
//            for (int s = 0; s < sln.length(); s++) {
//                if (sln.substring(s) == " " || Arrays.asList(operations).contains(sln.substring(s,s+1)) == true) {
//                    variables.add(new ArrayList<String>());
//                    variables.get(strSlnIndex.indexOf(sln)).add(constructVariable);
//                    constructVariable = "";
//                } else {
//                    constructVariable += sln.substring(s,s+1);
//                }
//            }
//            variables.add(new ArrayList<String>());
//            variables.get(strSlnIndex.indexOf(sln)).add(constructVariable);
//
//            System.out.println("here");
//        }
//
//        System.out.println("here2");
//
//        ArrayList<ArrayList<String>> operationcheckForm = new ArrayList<ArrayList<String>>();
//        ArrayList<String> operationSequenceList = new ArrayList<String>();
//
//        for (String i : strSlnIndex) {
//            operationcheckForm.add(new ArrayList<String>());
//            String operationSequence = "";
//            for (int j = 0; j < i.length(); j++) {
//                operationcheckForm.get(strSlnIndex.indexOf(i)).add(""+i.charAt(j));
//                if (Arrays.asList(operations).contains(""+i.charAt(j))) {
//                    operationSequence=operationSequence+i.charAt(j);
//                }
//                System.out.println("here7");
//            }
//            operationSequenceList.add(operationSequence);
//            System.out.println("here6");
//        }
//        System.out.println("here3");
//
//        ArrayList<ArrayList<ArrayList<String>>> storeAnswers = new ArrayList<ArrayList<ArrayList<String>>>();
//        for (int h = 0; h < strSlnIndex.toArray().length; h ++) {
//            ArrayList<ArrayList<String>> holdArrays = new ArrayList<ArrayList<String>>();
//            storeAnswers.add(holdArrays);
//
//            int holdStringIndex = 0;
//
//            ArrayList<String> holdString1 = new ArrayList<String>();
//            storeAnswers.get(h).add(holdString1);
//            storeAnswers.get(h).get(holdStringIndex).add(strSlnIndex.get(h));
//            holdStringIndex++;
//
//            storeAnswers.get(h).add(operationcheckForm.get(h));
//            holdStringIndex++;
//
//            storeAnswers.get(h).add(variables.get(h));
//            holdStringIndex++;
//
//            ArrayList<String> holdString3 = new ArrayList<String>();
//            holdArrays.add(holdString3);
//            storeAnswers.get(h).get(holdStringIndex).add(operationSequenceList.get(h));
//
//            System.out.println("here4");
//
//        }
//
//        System.out.println("here5");
//        return storeAnswers;


    }


//    public static void generalSolutionSearch(ArrayList<String> stringSolutionAsArray, int partoFactorialIndex, ArrayList<List<ArrayList<Object>>> slnsFound, List<ArrayList<String>> trackSlnsCongruences) {
////        recurTerm(stringArray,), return ArrayList[0,congruences]size;
////        foreach chk sln of ArrayList stuff in [0, congruences];
////        if string is in slnsFound,;  recurrr with partoFactorialIndex
////
//////        List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();
//////        int stringSolutionCongruences = 0;
////        generateCompleteListOfStringArrays(stringSolutionAsArray,stringSolutionsList, stringSolutionCongruences);
////        dothing andif~congruences!false  then return stringSolutionsList
////
///////*1*/   List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();
///////*2*/   int stringSolutionCongruences = 0;
///////*3*/  stringSolutionsList.get(stringSolutionCongruences).add(stringSolutionAsArray);
//
/////*4*/   generalSolutionSearch(stringSolutionCongruences, stringSolutionsList);
////
////
////        int congruences = stringSolutionsListIndex;
//
////        generalSolutionSearch();
//
////        int stringSolutionCongruences = 0;
//
//
//        /*1*/  List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();
//        /*2*/  int stringSolutionCongruences = 0;
//        stringSolutionsList.add(new ArrayList<ArrayList<String>>());
//        /*3*/  stringSolutionsList.get(stringSolutionCongruences).add(stringSolutionAsArray);
//
//            for (String arrayTerm : stringSolutionAsArray) {
//                try {
//                    if (Double.valueOf(arrayTerm) == (double) partoFactorialIndex) {
//                        stringSolutionCongruences++;
//                    }
//                } catch (NumberFormatException m) {
//                    System.out.println("current term is an operation!");
//                }
//            }
//
//            if ()
//        while (0 < stringSolutionCongruences) {
//            stringSolutionsList.add(new ArrayList<ArrayList<String>>());
//            for (ArrayList<String> stringSolutionArray : stringSolutionsList.get(k)) {
//                for (String arrayTerm : stringSolutionArray) {
//                    if (Double.valueOf(arrayTerm) == (double) partoFactorialIndex) {
//                        ArrayList<String> newStringSolutionArray = stringSolutionArray;
//                        newStringSolutionArray.set(stringSolutionArray.indexOf(arrayTerm), String.valueOf(partoFactorialIndex+1));
//
//                        stringSolutionsList.get(k).add(newStringSolutionArray);
//                    }
//                }
//            }
//            k++;
//            recurToGenerateACompleteListOfStringArrays(k++, stringSolutionsList)
//        }
//            else {
//                return stringSolutionsList;
//            }
//        System.out.println(stringSolutionsList);
//    }
//}
//
////        List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();
////
////        generateCompleteListOfStringArrays(stringSolutionAsArray, stringSolutionCongruences, stringSolutionsList);
//
////
//
//        List<ArrayList<ArrayList<String>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<String>>>();
//
//        int countToCongruences = 0;
//        stringSolutionsList.get(countToCongruences).add(stringSolutionAsArray);
//
//            countToCongruences++;
//            for (ArrayList<String> stringSolutionArray : stringSolutionsList.get(countToCongruences)) {
//                for (String arrayTerm : stringSolutionArray) {
//                    if (Double.valueOf(arrayTerm) == (double) partoFactorialIndex) {
//                        ArrayList<String> newStringSolutionArray = stringSolutionArray;
//                        newStringSolutionArray.set(stringSolutionArray.indexOf(arrayTerm), String.valueOf(partoFactorialIndex+1));
//                        stringSolutionsList.get(countToCongruences).add(newStringSolutionArray);
//                    }
//                }
//            }
//
////
//                ArrayList<String> stringSolutionAsArray2 = stringSolutionAsArray;
//                stringSolutionAsArray2.set(stringSolutionAsArray.indexOf(arrayTerm), Double.toString((double) partoFactorialIndex + 1));
//                stringSolutionList.add(stringSolutionAsArray2)
//
//               if ()
//
//        for(stringSolutionAsArray.size()) i+2;
//        stringSolutionAsArray
//
//        int count = strstringSolutionAsArray~counting
//
//                if 2;
//                    reeplace 1 at a time;
//                    for each replacement, replace other.
//                add to array;
//                    full collection....!
//                now, check if
//
//            answer is, in .. slnList?
//                if in, recur, else, return;


//
//                String buildSlnString = "";
//                for (ArrayList<ArrayList<String>> stringSolutionGroup : stringSolutionsList) {
//                    for (ArrayList<String> stringArray : stringSolutionGroup){
//                        for (String stringChar : stringArray) {
//                            buildSlnString+=stringChar;
//                        }
//                        if (slnsFound.get())
//        }
//        }
//                //check if contains sln from ;


//        for (ArrayList<Object> slnGroup : slnsFound.get(recursion)){
//            String stringSolution = slnGroup.get(1).toString();
//                    ArrayList<String> stringSolutionArray = new ArrayList<String>();
//            for (int s = 0; s < stringSolution.length(); s++) {
//
//                String constructNewString = "";
//                if (stringSolution.substring(s) != " ") {
//                    constructNewString += stringSolution.substring(s,s+1);
//                    variables.get(strSlnIndex.indexOf(sln)).add(constructVariable);
//                    constructVariable = "";
//                } else {
//                    stringSolutionArray.add(constructNewString);
//                }
//            }
//
//            newstring = "";
//
//            for (ArrayList<Object> group :slnsFound.get(0)) {
//                String stringSolution = String.valueOf(group.get(1));
//                if (Double.valueOf(stringSolution) == (double) recursion + 1) {
//                    stringSolutionArray.remove(stringSolution.indexOf(f));
//                    stringSolutionArray.add(stringSolution.indexOf(f), "" + recursion + 1);
//
//                }
//                newstring += f;
//            }
//        }
//        searchGeneralSolution(slnsFound, recursion++);
//    }
//                for (String f : stringSolutionArray) {
//                    if (Double.parseDouble(f) == (double) recursion + 1) {
//                        stringSolutionArray.remove(stringSolution.indexOf(f));
//                        stringSolutionArray.add(stringSolution.indexOf(f), "" + recursion + 1);
//
//                    }
//                    newstring += f;
//                }
//            }
//        searchGeneralSolution(slnsFound, recursion++);
    ////        }
    ////replace reform calculate!
//    }
//
    public static List<ArrayList<ArrayList<ArrayList<String>>>> recurToGenerateACompleteListOfStringArrays (ArrayList<List<ArrayList<Object>>> slnsFound, int partoFactoriandIndex, List<ArrayList<ArrayList<ArrayList<String>>>> stringSolutionsList, int stringSolutionsListSubGroup, int stringSolutionsListSubGroupElementIndex, List<ArrayList<String>> trackSlnCongruences) {


//        System.out.println();


//        System.out.println("Printing slnsFound so that you can see the list of solutions already generated:");


//        System.out.println(slnsFound);


//        System.out.println();


//        System.out.println("Setting stringSolutonCongruences, which records the number of congruences that can be found between the factoriand index and each term in the expression");


        int stringSolutionCongruences = 0;


//        System.out.println("int stringSolutionCongruences = 0;");


//        System.out.println();


//        System.out.println("For loop, to check the number of congruences in the expression.");


//        System.out.println("for (String stringSolutionAsArray : stringSolutionsList.get(partoFactoriandIndex-1).get(stringSolutionsListSubGroup).get(stringSolutionsListSubGroupElementIndex))");


//        System.out.println();


//        System.out.println("StringSolutionsList:" +stringSolutionsList);


//        System.out.println(partoFactoriandIndex);


        int countPosition = 0;
        ArrayList<Integer> positions = new ArrayList<Integer>(5);
//        System.out.println("stringSolutionsListSubGroup " +stringSolutionsListSubGroup + " ; stringSolutionsListSubGroupElementIndex " +stringSolutionsListSubGroupElementIndex);
        for (String stringSolutionAsArray : stringSolutionsList.get(partoFactoriandIndex - 1).get(stringSolutionsListSubGroup).get(stringSolutionsListSubGroupElementIndex)) {


//            System.out.println("Printing the expression:" + "\n" + stringSolutionsList.get(partoFactoriandIndex - 1).get(stringSolutionsListSubGroup).get(stringSolutionsListSubGroupElementIndex));


//            System.out.println();


//            System.out.println("Try is for checking the property of the element in expression; either a value, or an operation...");
            try {


//                System.out.println("try {\"" + stringSolutionAsArray + "\"};" + "\n");


//                System.out.println("Seeing if an element in the expression has the same number value has the index of slnsFound");


//                System.out.println("if (Double.valueOf(stringSolutionAsArray) == (double) partoFactoriandIndex) {");


//                System.out.println();


//                System.out.println();


                if (Double.valueOf(stringSolutionAsArray) == (double) partoFactoriandIndex) {


//                    System.out.println("A congruence was found between the element in the expression and the parto-factoriand");


//                    System.out.println("\t" + stringSolutionAsArray + " is congruent to " + partoFactoriandIndex);


//                    System.out.println("Incrementing the count for number of congruences found...");


                    stringSolutionCongruences++;


//                    System.out.println("\t" + "stringSolutionCongruences++;");


//                    System.out.println();


//                    System.out.println("Keeping track of positions of congruence");


                    countPosition++;


//                    System.out.println("countPosition++;");


//                    System.out.println();


//                    System.out.println("Adding position of current congruence to positions");


//                    System.out.println("positions.add(countPosition);");


                    positions.add(countPosition);


//                    System.out.println(positions);


//                    System.out.println();


                } else {


                    countPosition++;


//                    System.out.println();


                }


            } catch (NumberFormatException N) {


//                System.out.println("Error caught:");


//                System.out.println("Continuing from null result due to non-numeric " + stringSolutionAsArray + " as input...");


//                System.out.println();


                continue;
            }


        }
        //!1


//        System.out.println("String Solution Congruences: " + stringSolutionCongruences);
//        System.out.println("String Solutions List: " + stringSolutionsList);


//        System.out.println("Creating the successor for stringSolutionsList");


//        System.out.println("printing stringSolution congruences " +stringSolutionCongruences);


        List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();


//        System.out.println("List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>()");


//        System.out.println();


//        System.out.println("Creating indices for the successor array:");


        int Supergroupnum;
        int Expressionnum;
        int NewestNum;
        int Unitnum;


//        System.out.println("\t int Supergroupnum; \n" + "\t int Expressionnum; \n" + "\t int NewestNum; \n" + "\t int UnitNum;");


//        System.out.println();


//        System.out.println("Copying the elements of stringSolutionsList to newStringSolutionsList...");


//        System.out.println();


//        System.out.println("\t Constructing Matrix 2...");


//        System.out.println();


//        System.out.println("\t\t for (int z = 0; z < stringSolutionsList.size(); z++) {");


//        System.out.println();


        for (int z = 0; z < stringSolutionsList.size(); z++) {


//            System.out.println(" \t\t\t Assigning value of Supergroupernum to z");
//            System.out.println(" \t\t\t Supergroupnum = z;");
            Supergroupnum = z;


//            System.out.println();


//            System.out.println("\t\t\t Constructing array newStringSolutionsList at Matrix 2");
//            System.out.println("\t\t\t newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());");
            newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());


//            System.out.println();


//            System.out.println("\t\t\t Printing newStringSolutionsList on Matrix 2...");
//            System.out.println("\t\t\t " + newStringSolutionsList);


//            System.out.println();


//            System.out.println("\t\t\t for (int y = 0; y < stringSolutionsList.size(); y++) {");


//            System.out.println();


            for (int y = 0; y < stringSolutionsList.get(z).size(); y++) { //; ArrayList<String> expression : superGroup) {


//                System.out.println("\t\t\t\t Assigning value of Expressionnum to y");
//                System.out.println("\t\t\t\t Expressionnum = y;");
                Expressionnum = y;


//                System.out.println();


//                System.out.println("\t\t\t\t Constructing array newStringSolutionsList at Matrix 3");
//                System.out.println("\t\t\t\t newStringSolutionsList.get(Supergroupnum).add(new ArrayList<ArrayList<String>>());");
                newStringSolutionsList.get(Supergroupnum).add(new ArrayList<ArrayList<String>>());


//                System.out.println();


//                System.out.println("\t\t\t\t Printing newStringSolutionsList on Matrix 3...");
//                System.out.println("\t\t\t\t " + newStringSolutionsList);


//                System.out.println();


//                System.out.println("\t\t\t\t for (int w = 0; w < stringSolutionsList.size(); w++) {");


//                System.out.println();


                for (int w = 0; w < stringSolutionsList.get(z).get(y).size(); w++) {


//                    System.out.println("\t\t\t\t\t Assigning value of NewestNum to w");
//                    System.out.println("\t\t\t\t\t NewestNum = w;");
                    NewestNum = w;


//                    System.out.println();


//                    System.out.println("\t\t\t\t\t Constructing array newStringSolutionsList at Matrix 4");
//                    System.out.println("\t\t\t\t\t newStringSolutionsList.get(Supergroupnum).get(Expressionnum).add(new ArrayList<String>());");
                    newStringSolutionsList.get(Supergroupnum).get(Expressionnum).add(new ArrayList<String>());


//                    System.out.println();


//                    System.out.println("\t\t\t\t\t Printing newStringSolutionsList on Matrix 4...");
//                    System.out.println("\t\t\t\t\t " + newStringSolutionsList);


//                    System.out.println();


//                    System.out.println("\t\t\t\t\t for (int x = 0; x < stringSolutionsList.get(z).get(y).get(w).size(); x++) {");


//                    System.out.println();


                    for (int x = 0; x < stringSolutionsList.get(z).get(y).get(w).size(); x++) {


//                        System.out.println("\t\t\t\t\t Assigning value of Unitnum to x");
//                        System.out.println("\t\t\t\t\t Unitnum = x;");
                        Unitnum = x;


//                        System.out.println();


//                        System.out.println("\t\t\t\t\t Printing newStringSolutionsList with element added to Matrix 4...");
                        newStringSolutionsList.get(Supergroupnum).get(Expressionnum).get(NewestNum).add(stringSolutionsList.get(Supergroupnum).get(Expressionnum).get(NewestNum).get(Unitnum));
//                        System.out.println("\t\t\t\t\t " + newStringSolutionsList);
//                        System.out.println();
//                        System.out.println("\t\t\t}");


//                        System.out.println();


                    }
                }
            }
//            System.out.println("} % 4");
        }


//        System.out.println();


//        System.out.println("Fully copied newStringSolutionList: " + newStringSolutionsList);


//        System.out.println();


//        System.out.println("Now updating newStringSolutionsList:");


//        System.out.println();


//        System.out.println("\t Checking if a number of congruences, stringSolutionCongruences, can be found in stringSolutionAsArray;");
//        System.out.println("\t Also checking whether the partofactoriand-indices have been fully checked" + "\n");


//        System.out.println("\t\t if (stringSolutionCongruences > 0 && partoFactoriandIndex < slnsFound.toArray().length) {");


//        if (stringSolutionCongruences > 0 && partoFactoriandIndex < slnsFound.toArray().length) {
//            System.out.println("newStringSolutionsList#1: " +newStringSolutionsList);
//            newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());
//            System.out.println("newStringSolutionsList#2: " +newStringSolutionsList);


//        System.out.println();


//        System.out.println("Initiating Second Array");


//        System.out.println("for (int z = 0; z < stringSolutionsList.get(stringSolutionsListSubGroup).size(); z++) {");
//        for (int w = 0; w < stringSolutionsList.size(); w++) {//2 : for each arrayList that contains the expression components
//        System.out.println(newStringSolutionsList);
//);
//                System.out.println("Print here");
        newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());
//        System.out.println(newStringSolutionsList);




//                System.out.println("Keeping track of congruences");


//                System.out.println("for (int congruence = 1; congruence <= stringSolutionCongruences; congruence++) {ray");


//                for (int congruence = 1; congruence <= stringSolutionCongruences; congruence++) {
//                    ArrayList<String> newStringSolutionArray = new ArrayList<String>();
//                    ArrayList<String> completeStringSolutionArray = new ArrayList<String>();
//            for (int x = 0; x < stringSolutionsList.get(w).size(); x++) {//3 considers each Term
//                        System.out.println("newStringSolutionsArray#3: " +newStringSolutionArray);
//                        newStringSolutionArray.add(stringSolutionsList.get(stringSolutionsListSubGroup).get(z).get(y).get(0));
//                        System.out.println("newStringSolutionsArray#4: " +newStringSolutionArray);
//                newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());
//                newStringSolutionsList.get(w+1).add(new ArrayList<ArrayList<String>>());
//                System.out.println(newStringSolutionsList);




//                        int count = 1;
//                for (int y = 0; y < stringSolutionsList.get(w).get(x).size(); y++) {
//                            System.out.println(newStringSolutionsList);
//                            System.out.println("newStringSolutionsList.get(z).get(y):" +newStringSolutionsList.get(w).get(x));
//                            System.out.println("newStringSolutionsList.get(z).get(y).get(w):" +newStringSolutionsList.get(w).get(x).get(y));
//                            System.out.println("stringSoltuionslist: " + stringSolutionsList);


//                            ArrayList<String> newStringSolutionArray = new ArrayList<String>();


//                    newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());


//                    newStringSolutionsList.get(w).add(new ArrayList<ArrayList<String>>());


        System.out.println("Printing new solutions list " + newStringSolutionsList);


//                    return newStringSolutionsList.get(w).get(x);


        int congruences = 1; //since stringSolutionCongruences is stated to be > 0 we know 1 congruences does at least exist. So, we are going to send a congruence unit 1 as our basis for the span of newStringSolutionsList matrix 3 in recurrenceMethod.


//                    System.out.println(( stringSolutionCongruences +" "+  newStringSolutionsList.get(w+1).get(congruences-1).get(newStringSolutionsList.get(w+1).get(congruences-1).size()-1) +" "+  congruences+1 +" "+   newStringSolutionsList +" "+  w  partoFactoriandIndex,  slnsFound, stringSolutionsList,  stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex,  trackSlnCongruences);


//                    newStringSolutionsList.get(x).get(y).ge
        return recursionMethod( stringSolutionCongruences,  newStringSolutionsList.get(partoFactoriandIndex-1).getLast().getLast(),  congruences ,   newStringSolutionsList,  partoFactoriandIndex,  slnsFound,  stringSolutionsListSubGroup,  stringSolutionsListSubGroupElementIndex,  trackSlnCongruences);
//        ;
//        System.out.println("Printing the new stringSolutionsList: " +newStringSolutionsList);


//                            recurrenceMethod


//                            newStringSolutionsList.get(w).get(x).get(y);
//                            newStringSolutionArray.set(positions.get((int) (Math.random() * congruence) + 1), "" + ((double) partoFactoriandIndex + 1));//has the right index for partofactorial number//


//                    recursionMethod(stringSolutionCongruences, newStringSolutionsList.get(w).get(x).get(y), positions, newStringSolutionsList);


//                            for (int congruence = 1; congruence <= stringSolutionCongruences; congruence++) {


//                                    if (Double.valueOf(stringSolutionsList.get(w).get(x).get(y).get(z)) == (double) partoFactoriandIndex) { //4 if term has the most previous factoriand,... ! need to replace in a temp array, and add it to tempStringList


//                                        System.out.println((int) (Math.random() * congruence) + 1.0);


//                                recursionMethod ( stringSolutionCongruences, newStringSolutionsList.get(w).get(x).get(y),  positions,  newStringSolutionsList) {


//                                    int congruence = 1;
//                                    while (congruence < stringSolutionCongruences) {
//                                        newStringSolutionArray
//                                        congruence++;
//                                    }
//                                    recurrenceMethod(congruence, newStringSolutionArray);
//                                    arrayToChange
//                                }
//                                        while (congruence <= positions.size()) {
//
////                                            int makePosition = (int) (Math.random() * congruence) + 1;
//
////                                            newStringSolutionArray.set(positions.get((int) (Math.random() * congruence) + 1), "" + ((double) partoFactoriandIndex + 1));//has the right index for partofactorial number//
//
//                                            while (newStringSolutionsList.get(w).get(x).size() < (congruence*(congruence+1)/2)) {
//                                                newStringSolutionArray.set(positions.get((int) (Math.random() * congruence) + 1), "" + ((double) partoFactoriandIndex + 1));//has the right index for partofactorial number//
//                                                if (newStringSolutionsList.get(w).get(x).contains(newStringSolutionArray) == false) {
//                                                    newStringSolutionsList.get(w).get(x).add(newStringSolutionArray);
//                                                }
//                                            }
//                                    }
//                                }
//
//                            }
//                            try {
//                                if (Double.valueOf(stringSolutionsList.get(w).get(x).get(y).get(z)) == (double) partoFactoriandIndex) { //4 if term has the most previous factoriand,... ! need to replace in a temp array, and add it to tempStringList
//                                    if (count == congruence) {
//                                        System.out.println("newStringSolutionsArray#5: " +newStringSolutionArray);
//                                        newStringSolutionArray.set(w, "" + ((double) partoFactoriandIndex + 1));//has the right index for partofactorial number//
//                                        System.out.println("newStringSolutionsArray#6: " +newStringSolutionArray);
//                                    }


//                                    System.out.println("Incrementing Counter for ");
//                                    count++;
//                                    if (newStringSolutionsList.get(partoFactoriandIndex).get(stringSolutionsListSubGroup + 1).contains(newStringSolutionArray) == false) {
//                                        System.out.println("newStringSolutionsArray#7: " +newStringSolutionsList);
//                                        System.out.println("thising: "+newStringSolutionsList.get(z+1).get(y).set(w,newStringSolutionArray));
//                                        System.out.println("newStringSolutionsArray#8: " +newStringSolutionsList);
//                                    }
//                                    System.out.println("New String solution List: " + newStringSolutionsList);
//                                }
//                            } catch (NumberFormatException N) {
//                                System.out.println("Operation over here!");
//                            } catch (IndexOutOfBoundsException E) {
//                                System.out.println("out of bounds!");
//                            }
//                }
//            }
//            return string
//        }
//        return newStringSolutionsList;
    }


//                    if (newStringSolutionsList.get(stringSolutionsListSubGroup + 1) . contains ( newStringSolutionArray) == false) {
//                    newStringSolutionsList.get(stringSolutionsListSubGroup + 1).get(0).add(newStringSolutionArray);
//                }
//                }
//            }
//            System.out.println("about to recur!");
//            return recurToGenerateACompleteListOfStringArrays(slnsFound, partoFactoriandIndex, newStringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex + 1, trackSlnCongruences);
//        } else if (partoFactoriandIndex < slnsFound.toArray().length) {
//recurToGenerateACompleteListOfStringArrays(); //!!!
//            System.out.println("here uh");


//        }
//        else {
//            return trackSlnCongruences;
//        }
//            return trackSlnCongruences;


    public static List<ArrayList<ArrayList<ArrayList<String>>>> recursionMethod (int stringSolutionCongruences, ArrayList<String> stringSolutionArray, int congruences ,  List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList, int partoFactoriandIndex, ArrayList<List<ArrayList<Object>>> slnsFound, int stringSolutionsListSubGroup, int stringSolutionsListSubGroupElementIndex, List<ArrayList<String>> trackSlnCongruences) {
//        ArrayList<List<ArrayList<Object>>> slnsFound, int partoFactoriandIndex, List<ArrayList<ArrayList<ArrayList<String>>>> stringSolutionsList, List<ArrayList<String>> trackSlnCongruences
//        System.out.println();
//        newStringSolutionsList.get(w+1).add(new ArrayList<ArrayList<String>>());
//        System.out.println("new string solution list" +newStringSolutionsList);
//        System.out.println(slnsFound.size());
//        System.out.println("partofactoriandindex : " +partoFactoriandIndex);
        if (congruences ==1){
            for (int h = congruences; h <= stringSolutionCongruences; h++)
            {             newStringSolutionsList.get(partoFactoriandIndex).add(new ArrayList<ArrayList<String>>());
            }}
        //*
//        System.out.println("Congruences: " +congruences);
//        System.out.println("newStringSolutionArray length: " +stringSolutionArray.toArray().length);
        if (congruences <= stringSolutionCongruences) { //*
//            newStringSolutionsList.get(w+1).add(new ArrayList<ArrayList<String>>());
//            System.out.println("pt1:  " +newStringSolutionsList);
            for (int i = 0; i < stringSolutionArray.toArray().length; i++) {
//                ArrayList<String> newStringSolutionArray = new ArrayList<String>();
//                newStringSolutionsList.get(w+1).get(congruences-1).add(new ArrayList<String>());
//                System.out.println(newStringSolutionsList);
//                System.out.println(i);
//                System.out.println("pt2:  " +newStringSolutionsList);


                try {
//                    System.out.println("prinnt here 1");
//                    System.out.println("pt3:  " +newStringSolutionsList);


//                    System.out.println("Double.valueOf(stringSolutionArray.get(i) : "+Double.valueOf(stringSolutionArray.get(i)));
                    if (Double.valueOf(stringSolutionArray.get(i)) == (double) partoFactoriandIndex) {
//                        System.out.println("prinnt here 2");


                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).add(new ArrayList<String>());


//                        System.out.println("pt4:  " +newStringSolutionsList);


                        for (String element : stringSolutionArray) {
//                            System.out.println("prinnt here 3");
//                            System.out.println("pt5:  " +newStringSolutionsList);


//                            System.out.println("printing congruences again" +congruences);
                            newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1).add(element);


                        }


//                        System.out.println("printing :" +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1));
//                        for (


//                        System.out.println("prinnt here 4");
//                    }
//                        System.out.println(newStringSolutionsList);
                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1).set(i, Double.toString((double) partoFactoriandIndex + 1));


//                        System.out.println(newStringSolutionsList);
                        boolean removed = false;
                        for (int g = 0; g < newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size(); g++) {


                            if (removed == true) {
                                break;
                            }


                            for (int t = 0; t < newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size(); t++) {


                                if (g == t) {
                                    continue;
                                }


                                if (removed == true) {
                                    break;
                                }
                                /*next*/
//                                System.out.println("is here");
//                                System.out.println(g + " " + t);


                                int count = 0;
                                for (int p = 0; p < newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).size(); p++) {
//                                    int count = 0;
//                                    System.out.println("inside 4:");
//                                    System.out.println("printing if: " +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).get(p) + "and " +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(t).get(p));
                                    if (newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).get(p).equals(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(t).get(p))) {
//                                        System.out.println("? " +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).get(p) +"=="+ newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(t).get(p) );
                                        count++;
//                                        System.out.println("print count: " +count);
                                    }
                                    if (count == newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).size()) {
//                                        System.out.println("got here");
                                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).remove(t);
                                        removed = true;
                                        break;
                                    }
                                }


//                                if (newStringSolutionsList.get(w+1).get(congruences-1).get(g) == (newStringSolutionsList.get(w+1).get(congruences-1).get(t))) {
//                                    System.out.println("is here2");
//                                    newStringSolutionsList.get(w+1).get(congruences-1).remove(g);
//                                    removed = true;
//                                    break;
//                                }


                            }
                        }
                    }
//                        System.out.println(newStringSolutionArray);
//                    System.out.println(newStringSolutionsList);
//                    System.out.println("prinnt here 5");
//                    System.out.println("Trying print" +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1));
//                    System.out.println("Trying print" +newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1));


//                        newStringSolutionsList.get(w+1).get(congruences-1).add(newStringSolutionArray);
//                        System.out.println("Trying print" +newStringSolutionsList.get(w+1).get(congruences-1));
//                    System.out.println(congruences);
//                    System.out.println("Trying print" +newStringSolutionsList);


//                    System.out.println(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1));


                    recursionMethod( stringSolutionCongruences,  newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1),  congruences+1 ,   newStringSolutionsList,  partoFactoriandIndex,  slnsFound,  stringSolutionsListSubGroup,  stringSolutionsListSubGroupElementIndex,  trackSlnCongruences);






//                ((double) partoFactoriandIndex + 1));/


//            } else {
//                newStringSolutionArray.set(i, stringSolutionArray.get(i));


//                    System.out.println("printing here");
//                    System.out.println(newStringSolutionsList);


//                    if (newStringSolutionsList.get(w).get(congruences - 1).contains(newStringSolutionArray) == false) {
////                                         newStringSolutionsList.get(w).get(congruences-1).add(newStringSolutionArray);
//            }
//           newStringSolutionsList.get(w+1).get(congruences-1).add(newStringSolutionArray);
//                    System.out.println(newStringSolutionsList);




                } catch (NumberFormatException N) {
//                    System.out.println("Operation over here!");
                } catch (IndexOutOfBoundsException E) {
//                    System.out.println("out of bounds!");
                }
//                newStringSolutionsList.get(w+1).get(congruences-1).add(newStringSolutionArray);
//                System.out.println(newStringSolutionsList);


//            if (newStringSolutionsList.get(w).get(congruences - 1).contains(newStringSolutionArray) == false) {
//                                         newStringSolutionsList.get(w).get(congruences-1).add(newStringSolutionArray);
//            }
//            recursionMethod( stringSolutionCongruences,  stringSolutionArray,  congruences ,   newStringSolutionsList,  w,  partoFactoriandIndex);
//        } else {
//                return newStringSolutionsList;
//            }


            }


        }
//        System.out.println("returning");
        if (partoFactoriandIndex + 1 < slnsFound.size()) {
            stringSolutionsListSubGroup = newStringSolutionsList.get(partoFactoriandIndex).size() - 1;
            stringSolutionsListSubGroupElementIndex = newStringSolutionsList.get(partoFactoriandIndex).get(stringSolutionsListSubGroup).size()-1;


            return recurToGenerateACompleteListOfStringArrays( slnsFound, partoFactoriandIndex + 1, newStringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex, trackSlnCongruences);
        }


        return newStringSolutionsList;}
}
//
//            for (int position = 1; position < positions.size(); positiocn++) {
//for (int i = 0; i < newStringSolutionArray.size(); i++) {
//    newStringSolutionArray.get(i);
//}
//            }
//        }positions.size();
//
//
//        return newStringSolutionsList;
//    }
//
//    public List<ArrayList<ArrayList<ArrayList<String>>>> recursionMethod2(int stringSolutionCongruences, ArrayList<String> newStringSolutionArray, ArrayList<Integer> positions,  List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList, int congruences) {
//
//        return; a
//    }


//
//        if parto> size, return
//                otherwise,
//        listupdate = stringSolutionsList
//                for stringAsArray : stringSolutionsList { fill list}
//                recurToGenerateACompleteListOfStringArrays(stringSolutionsList{listupdate}, partofactoriandslns)
//                return ;
//        int k = 0;
//        if (k < congruenceCount) {
//
//            ..
//
////            recurToGenerateACompleteListOfStringArrays();
////        } else {
//            return
//        }
//
//
//        int stringSolutionCongruences = 0;
//        for (String arrayTerm : stringSolutionAsArray) {
//            if (Double.valueOf(arrayTerm) == (double) partoFactorialIndex) {
//                stringSolutionCongruences++;
//            }
//        }
////        int fillArray = 0;
////        while (fillArray < congruences) {
//            fillarraycode
//        }
//        return array;
//    }
//}




//https://www.w3schools.com/java/ref_arraylist_foreach.asp ~1
//Gemini recommendation notices
//https://www.w3schools.com/java/ref_arraylist_remove.asp
//https://www.w3schools.com/java/ref_string_substring.asp
//https://www.geeksforgeeks.org/java-math-random-method-examples/
//        https://stackoverflow.com/questions/5071040/java-convert-integer-to-string


