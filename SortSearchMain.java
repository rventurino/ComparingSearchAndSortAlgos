package LabAssignment4;


/*
Ryan Venturino
CIT 244 AC01
Assignment 4
 */

import java.io.*;
import java.util.*;

public class SortSearchAssign_Venturino {

    public static void main(String[] args) {
        AllSorts sorts = new AllSorts();
        AllSearch searches = new AllSearch();
        int[] millionNumbers = new int[1000000];
        // START HERE
        createFile();
        millionNumbers = getArray();

        long startTime = System.currentTimeMillis();    //to measure time

        millionNumbers = sorts.mergeSort(millionNumbers);
        System.out.println("ARRAY SORTED");
        System.out.println("INDEX OF 11: " + searches.binSearch(millionNumbers, 11));

        long endTime = System.currentTimeMillis();      //to measure time

        System.out.println("That took " + (endTime - startTime) + " milliseconds"); //display result

        /*

        Cursed algorithms use at your PERIL

        millionNumbers = sorts.selectionSort(millionNumbers);
        System.out.println("INDEX OF 11: " + searches.linearSearch(millionNumbers, 11));

         */
    }

    // Method which generates text file containing 1 million random numbers
    public static void createFile()
    {
        // File to be created in default directory
        File file = new File("somanynumbers.txt");
        Random rng = new Random();
        int r;

        try {
            // Create the file
            PrintWriter output = new PrintWriter(file);

            // Write random numbers into a file
            for (int i = 0; i < 1000000; i++)
            {
                // Genereates a random number in range of (0 - 100)
                r = rng.nextInt(101);
                output.write(r + ", ");
            }
            System.out.println("File created.");
            // Close file
            output.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Cannot do that.");
        }
    }

    // STUDENT TODO
    public static int[] getArray(){
        File somanynumbers = new File("somanynumbers.txt");
        int[] numbersArray = new int[1000000];
        String numberAsString = "";
        int index = 0;
        Scanner scan;

        try{
            scan = new Scanner(somanynumbers);
            while(scan.hasNext()) {
                numberAsString = scan.next();   //Get a string
                numberAsString = numberAsString.replaceAll(",$", "");   //Remove the comma
                numbersArray[index] = Integer.parseInt(numberAsString); //Convert String to int
                numberAsString = "";    //reset the string var
                index++;                //Increase index, then repeat
            }
        } catch (Exception e){
            System.out.println("ERROR");
        }

        return numbersArray;
    }

}