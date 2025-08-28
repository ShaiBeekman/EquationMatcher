package EquationMatcher;

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

                    stringExpressionList.get(t - 1).add(stringExpression);
                    allList.get(t - 1).get(v - 1).add(stringExpression);

                    arithmeticExpressionList.get(t - 1).add(arithmeticExpression);
                    allList.get(t - 1).get(v - 1).add(arithmeticExpression);

                    continue;

                } else {

                    if (t > 1) {

                        newTerm = v;

                        for (ArrayList<Object> expressionForms : allList.get(t - 2)) {
                            for (int o = 0; o < operations.length - 1; o++) {
                                ArrayList<Object> addToAllList = new ArrayList<Object>();

                                newTerm = v;

                                calculateExpression = operatorSystem((double) expressionForms.get(0), operations[o], newTerm);

                                expressionList.get(t - 1).add(calculateExpression);

                                addToAllList.add(calculateExpression);

                                String updateStringExpression = "" + expressionForms.get(1) + " " + operations[o] + " " + newTerm;

                                stringExpressionList.get(t - 1).add(updateStringExpression);

                                addToAllList.add(updateStringExpression);

                                arithmeticExpression = ""+operations[5].charAt(0) + "" + expressionForms.get(2) + " " + operations[o] + " " + newTerm + operations[5].charAt(1);

                                arithmeticExpressionList.get(t - 1).add(arithmeticExpression);

                                addToAllList.add(arithmeticExpression);

                                allList.get(t-1).add(addToAllList);
                            }
                        }
                    }
                }
            }
        }

        ArrayList<List<ArrayList<Object>>> slnsFound = new ArrayList<List<ArrayList<Object>>>();
        for (int c = 1; c <= input; c++) {
            List<ArrayList<Object>> partoFactorialAnswers = iterateAllList(c, allList, operations);
            slnsFound.add(partoFactorialAnswers);
        }
        int count = 0 ;
        int partoFactoriandIndex = 0;
        for (ArrayList<Object> slnGroup : slnsFound.get(partoFactoriandIndex)){
            String stringSolution = slnGroup.get(1).toString();
            ArrayList<String> stringSolutionAsArray = new ArrayList<String>();

            String stringTerm = "";
            for (int s = 0; s < stringSolution.length(); s++) {
                if (stringSolution.substring(s, s+1).contains(" ") == false) {
                    stringTerm += stringSolution.substring(s,s+1);
                } else {
                    stringSolutionAsArray.add(stringTerm);
                    stringTerm = "";
                }
            }
            count ++;

            stringSolutionAsArray.add(stringTerm);//*

            List<ArrayList<ArrayList<ArrayList<String>>>> stringSolutionsList = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
            stringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());
            stringSolutionsList.get(0).add(new ArrayList<ArrayList<String>>());

            int stringSolutionsListSubGroup = 0;
            int stringSolutionsListSubGroupElementIndex = 0;
            stringSolutionsList.get(partoFactoriandIndex).get(0).add(stringSolutionAsArray);

            List<ArrayList<String>> trackSlnCongruences = new ArrayList<ArrayList<String>>(); //!@@
            trackSlnCongruences.add(stringSolutionAsArray); //!@@@

            List<ArrayList<ArrayList<ArrayList<String>>>> answers = recurToGenerateACompleteListOfStringArrays(slnsFound, partoFactoriandIndex+1, stringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex, trackSlnCongruences);

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
        }
    }

    public static ArrayList<String> lastRecursion (List<ArrayList<ArrayList<ArrayList<String>>>> answers, ArrayList<List<ArrayList<Object>>> slnsFound, ArrayList<String> completeSolution, int partoFactoriandIndex, File myObj) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt", true);
            for (int i = partoFactoriandIndex; i < partoFactoriandIndex + 1; i++) {
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

                        boolean found = false;

                        for (ArrayList<Object> compute : slnsFound.get(partoFactoriandIndex)) {
                            if (compute.contains(solutionString)) {

                                myWriter.append("" + solutionString + "\n");

                                found = true;
                                completeSolution.add(solutionString);

                                myWriter.append(""+completeSolution + "\n");
                                myWriter.close();
                                lastRecursion(answers, slnsFound, completeSolution, partoFactoriandIndex + 1, myObj);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("out of bounds");
        }
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
                        if (prevFactoriandProperties.get(0).contains("1.0 + 1.0 * 1.0 / 2.0")) {
//                            System.out.println("found this too");
                        }
                    }
                    for (int l = 0; l < factorialVariables.size(); l++) {
                        if (factorialVariables.get(l).equals(factorialVariables2.get(l))) {
                            congruences++;
                        }
                    }

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
        return congruenceGroup;
    }

    public static List<ArrayList<Object>> iterateAllList(int c, List<ArrayList<ArrayList<Object>>> allList, String[] operations) {

        List<ArrayList<Object>> solutionsFound = new ArrayList<ArrayList<Object>>();

        for (ArrayList<ArrayList<Object>> expressionFormsGroup : allList) {
            for (ArrayList<Object> expressionForm : expressionFormsGroup) {
                if ((double) expressionForm.get(0) == (double) calculateSummandial(c)) {
                    solutionsFound.add(expressionForm);
                }
            }
        }
        return solutionsFound;
    }

    public static List<ArrayList<ArrayList<ArrayList<String>>>> recurToGenerateACompleteListOfStringArrays (ArrayList<List<ArrayList<Object>>> slnsFound, int partoFactoriandIndex, List<ArrayList<ArrayList<ArrayList<String>>>> stringSolutionsList, int stringSolutionsListSubGroup, int stringSolutionsListSubGroupElementIndex, List<ArrayList<String>> trackSlnCongruences) {

        int stringSolutionCongruences = 0;

        int countPosition = 0;
        ArrayList<Integer> positions = new ArrayList<Integer>(5);

        for (String stringSolutionAsArray : stringSolutionsList.get(partoFactoriandIndex - 1).get(stringSolutionsListSubGroup).get(stringSolutionsListSubGroupElementIndex)) {

            try {

                if (Double.valueOf(stringSolutionAsArray) == (double) partoFactoriandIndex) {

                    stringSolutionCongruences++;

                    countPosition++;

                    positions.add(countPosition);
                } else {
                    countPosition++;
                }
            } catch (NumberFormatException N) {

                System.out.println("Error caught:");

                continue;
            }
        }

        List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();


        int Supergroupnum;
        int Expressionnum;
        int NewestNum;
        int Unitnum;


        for (int z = 0; z < stringSolutionsList.size(); z++) {

            Supergroupnum = z;

            newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());

            for (int y = 0; y < stringSolutionsList.get(z).size(); y++) { //; ArrayList<String> expression : superGroup) {

                Expressionnum = y;

                newStringSolutionsList.get(Supergroupnum).add(new ArrayList<ArrayList<String>>());

                for (int w = 0; w < stringSolutionsList.get(z).get(y).size(); w++) {

                    NewestNum = w;

                    newStringSolutionsList.get(Supergroupnum).get(Expressionnum).add(new ArrayList<String>());

                    for (int x = 0; x < stringSolutionsList.get(z).get(y).get(w).size(); x++) {

                        Unitnum = x;

                        newStringSolutionsList.get(Supergroupnum).get(Expressionnum).get(NewestNum).add(stringSolutionsList.get(Supergroupnum).get(Expressionnum).get(NewestNum).get(Unitnum));
                    }
                }
            }
        }

        newStringSolutionsList.add(new ArrayList<ArrayList<ArrayList<String>>>());

        System.out.println("Printing new solutions list " + newStringSolutionsList);

        int congruences = 1; //since stringSolutionCongruences is stated to be > 0 we know 1 congruences does at least exist. So, we are going to send a congruence unit 1 as our basis for the span of newStringSolutionsList matrix 3 in recurrenceMethod.

        return recursionMethod( stringSolutionCongruences,  newStringSolutionsList.get(partoFactoriandIndex-1).getLast().getLast(),  congruences ,   newStringSolutionsList,  partoFactoriandIndex,  slnsFound,  stringSolutionsListSubGroup,  stringSolutionsListSubGroupElementIndex,  trackSlnCongruences);
    }

    public static List<ArrayList<ArrayList<ArrayList<String>>>> recursionMethod (int stringSolutionCongruences, ArrayList<String> stringSolutionArray, int congruences ,  List<ArrayList<ArrayList<ArrayList<String>>>> newStringSolutionsList, int partoFactoriandIndex, ArrayList<List<ArrayList<Object>>> slnsFound, int stringSolutionsListSubGroup, int stringSolutionsListSubGroupElementIndex, List<ArrayList<String>> trackSlnCongruences) {
        if (congruences ==1){
            for (int h = congruences; h <= stringSolutionCongruences; h++) {
                newStringSolutionsList.get(partoFactoriandIndex).add(new ArrayList<ArrayList<String>>());
            }
        }

        if (congruences <= stringSolutionCongruences) { //*
            for (int i = 0; i < stringSolutionArray.toArray().length; i++) {
                try {
                    if (Double.valueOf(stringSolutionArray.get(i)) == (double) partoFactoriandIndex) {

                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).add(new ArrayList<String>());

                        for (String element : stringSolutionArray) {
                            newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1).add(element);
                        }

                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1).set(i, Double.toString((double) partoFactoriandIndex + 1));

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

                                int count = 0;
                                for (int p = 0; p < newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).size(); p++) {
                                    if (newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).get(p).equals(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(t).get(p))) {
                                        count++;
                                    }
                                    if (count == newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(g).size()) {
                                        newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).remove(t);
                                        removed = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    recursionMethod( stringSolutionCongruences,  newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).get(newStringSolutionsList.get(partoFactoriandIndex).get(congruences-1).size()-1),  congruences+1 ,   newStringSolutionsList,  partoFactoriandIndex,  slnsFound,  stringSolutionsListSubGroup,  stringSolutionsListSubGroupElementIndex,  trackSlnCongruences);
                } catch (NumberFormatException N) {
                    System.out.println("Operation over here!");
                } catch (IndexOutOfBoundsException E) {
                    System.out.println("out of bounds!");
                }
            }
        }

        if (partoFactoriandIndex + 1 < slnsFound.size()) {
            stringSolutionsListSubGroup = newStringSolutionsList.get(partoFactoriandIndex).size() - 1;
            stringSolutionsListSubGroupElementIndex = newStringSolutionsList.get(partoFactoriandIndex).get(stringSolutionsListSubGroup).size()-1;
            return recurToGenerateACompleteListOfStringArrays( slnsFound, partoFactoriandIndex + 1, newStringSolutionsList, stringSolutionsListSubGroup, stringSolutionsListSubGroupElementIndex, trackSlnCongruences);
        }
        return newStringSolutionsList;}
}