// Dmitrijs Ivanovs PD1

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "ints_10.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_100.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_1K.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_10K.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_100K.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_1M.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call

        fileName = "ints_10M.txt"; // File name
        System.out.println(fileName + " - biggest increase = " + BiggestIncreaseFinder.findBiggestIncrease(fileName)); // Console output and function call
    }
}

class BiggestIncreaseFinder {

    public static List<Integer> readNumbersFromFileToList(String fileName) { // function that reads numbers form file and adds to list (numbersList)
        List<Integer> numbersList = new ArrayList<>(); // List creation

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { // try block (try with resources contains initialization of BufferedReader for file reading)
            String line; // line with number
            while ((line = br.readLine()) != null) { // loop to scan the entire file line by line and add to list (numbersList) - if line==null -> end
                numbersList.add(Integer.parseInt(line)); // add to list (numbersList) + parse string value to integer value
            }
        } catch (IOException e) { // catch block
            System.out.println("Error reading file: " + fileName); // error message
        }

        return numbersList; // function returns list
    }

    public static int findBiggestIncrease(String fileName) { // function that finds biggest increase in file
        List<Integer> numbersList = readNumbersFromFileToList(fileName); // calls function to prepare add numbers to list to work easier
        int biggestIncrease = 0; // initialization of biggest increase by 0 on start
                             // because program has not analyzed any values yet and do not know about any biggest increase
        int minValue = Integer.MAX_VALUE; // initialization min value by MAX VALUE OF TYPE INTEGER on start,
                                          // because program has not analyzed any values yet
                                          // can not be set as '0', because first number in list could be greater than 0
                                          // well could be set with first number of list

        for (int number : numbersList) { // for-each loop to find biggest increase of list, look up each element
                                         // here we got algorithmic complexity = O(n) because there are no further loops, only this one
            if (number < minValue) { // checks is this number a minimal value
                                     // if true -> program saves value as minValue, because it could be a value that creates biggest increase
                                     // like this could be n1 of formula 'n2-n1 where n2 comes after n1'
                minValue = number; // update of minvalue
            } else { // if this number not a new minimal value so program calculates increase (difference)
                     // because this number could be a value that creates biggest increase
                     // like this could be n2 of formula 'n2-n1 where n2 comes after n1'
                int difference = number - minValue; // calculation of increase (difference)
                if (difference > biggestIncrease) { // check is this increase (difference) the biggest one or no
                                                    // if true -> program find new biggest increase and saves it
                    biggestIncrease = difference; // update of biggestIncrease
                }
            }
        }

        return biggestIncrease; // function returns biggest increase
    }
}