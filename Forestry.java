package week15FinalProject;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Forestry {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Forest myForest;
        int argIndex;
        boolean doNext;

        //give the user a welcome message
        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");

        doNext = true;
        for (argIndex = 0; doNext && argIndex<args.length; argIndex++) {
            System.out.println("Initializing from " + args[argIndex]);
            myForest = new Forest();
            myForest = Forest.readForestFromCSV(args[argIndex]);
            if (myForest != null) {
                doNext = menu(args, myForest, argIndex);

            } else {
                System.out.println("Error opening/reading" + args[argIndex] + ".csv");
            }
            //argIndex++;
        }

        //goodbye message
        System.out.println();
        System.out.println("Exiting the Forestry Simulation");
    }



    //user menu
    private static boolean menu(String[] args, Forest forest, int forestIndex) {

        String userInput;
        do {
            System.out.print("\n(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : ");
            userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "p":
                    forest.print();
                    break;
                case "a":
                    forest.add();
                    break;
                case "c":
                    int treeToCut;
                    do {
                        try {
                            System.out.print("Tree number to cut down: ");
                            treeToCut = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character left by nextInt()
                            break; // Exit the loop if input is a valid integer
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a valid integer.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                    } while (true);
                    forest.cut(treeToCut);
                    break;

                case "g":
                    forest.grow();
                    break;
                case "r":
                    forest.reap();
                    break;
                case "s":
                    String absolutePath = "C:\\CSC120\\" + args[forestIndex] + ".db";
                    boolean savedForest = Forest.save(forest, absolutePath);
                    break;
                case "l":
                    boolean loaded = true;

                    System.out.print("Enter Forest name: ");
                    String forestName = scanner.nextLine();
                    String absoluteForest = /*"C:\\CSC120\\"+ */forestName + ".db";
                    File file = new File(absoluteForest);
                    if (!file.exists()) {
                        System.out.println("Error: opening/reading " + absoluteForest);
                        System.out.println("Old forest retained");
                        loaded = false;
                    }
                    if (loaded) {
                        forest = Forest.loadTreeFile(absoluteForest);
                    }
                    break;
                case "n":
                    System.out.println("Moving to next forest");
                    return true;
                case "x":
                    return false;
                default:
                    System.out.println("Invalid menu option, try again");
            }
        } while (true);
    }

}