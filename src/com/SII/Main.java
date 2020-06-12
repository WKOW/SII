package com.SII;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> controlers = new ArrayList<String>();
        int numberOfEmployees = 1100;
        int numberOfControlers = 1100;
        putAllControlersToDefaultMode(numberOfControlers,"Program", controlers);
        runInauguralProcess(numberOfControlers, numberOfEmployees, controlers);
        printCountOfMode(controlers, "Run");
        }

    private static void putAllControlersToDefaultMode(int numberOfControlers, String defaultMode, ArrayList controlers){
        for (int controler = 0; controler < numberOfControlers; controler++) {
            controlers.add(defaultMode);
        }
    }

    private static void runInauguralProcess(int numberOfControlers, int numberOfEmployees, ArrayList controlers) {
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
    }

    private static void printCountOfMode(ArrayList controlers, String modeType){
        int numberOfOccurences = Collections.frequency(controlers,modeType);
        System.out.println("Number of controlers on " +  modeType +  " mode is " + numberOfOccurences );
    }
}