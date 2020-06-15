package com.SII;

import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
        ArrayList<String> controlersFirstSolution = new ArrayList<String>();
        ArrayList<String> controlersSecondSolution = new ArrayList<String>();
        int numberOfControlers = 1100;
        int numberOfEmployees = 1100;
        runInauguralProcessFirstSolution(numberOfControlers, numberOfEmployees, controlersFirstSolution);
        runInauguralProcessSecondSolution(numberOfControlers, controlersSecondSolution);
    }

    // first solution
    private static void runInauguralProcessFirstSolution(int numberOfControlers, int numberOfEmployees, ArrayList controlers) {
        putAllControlersToDefaultMode(numberOfControlers, "Program", controlers);
        for (int employee = 0; employee < numberOfEmployees; employee++) {
            for (int controler = 0; controler < numberOfControlers; controler++) {
                if ((controler + 1) % (employee + 1) == 0) {
                    if ((controlers.get(controler).equals("Run"))) {
                        controlers.set(controler, "Program");
                    } else {
                        controlers.set(controler, "Run");
                    }
                }
            }
        }
        printCountOfMode(controlers, "Run");
    }

    private static void putAllControlersToDefaultMode(int numberOfControlers, String defaultMode, ArrayList controlers) {
        for (int controler = 0; controler < numberOfControlers; controler++) {
            controlers.add(defaultMode);
        }
    }

    // second solution
    private static void runInauguralProcessSecondSolution(int numberOfControlers, ArrayList controlers) {
        for (int controler = 0; controler < numberOfControlers; controler++) {
            int root_controler = (int) (Math.sqrt(controler + 1));
            if (root_controler * root_controler == (controler + 1))
                controlers.add("Run");
            else
                controlers.add("Program");
        }
        printCountOfMode(controlers, "Run");
    }

    private static void printCountOfMode(ArrayList controlers, String modeType) {
        int numberOfOccurences = Collections.frequency(controlers, modeType);
        System.out.println("Number of controlers on " + modeType + " mode is " + numberOfOccurences);
    }

}