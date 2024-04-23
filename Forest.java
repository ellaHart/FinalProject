package week15FinalProject;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class Forest implements Serializable{
    private String name;
    private ArrayList<Tree> trees = new ArrayList<>();
    final static String DB = ".db";
    final static String COMMA = ",";

    public Forest() {
        this.name = "Unnamed Forest";
    }

    public static Forest readForestFromCSV(String fileName) {

        Forest forest = null;
        try {
            // Open file

            BufferedReader inFile = new BufferedReader(new FileReader(fileName + ".csv"));
            forest = new Forest();
            forest.setName(fileName);

            String line;
            while ((line = inFile.readLine()) != null) {
                String[] treeParts = line.split(",");

                Tree.TreeSpecies treeSpecies =  Tree.TreeSpecies.valueOf(treeParts[0].toUpperCase().trim());
                int yearPlanted = Integer.parseInt(treeParts[1]);
                double height = Double.parseDouble(treeParts[2]);
                double growthRate = Double.parseDouble(treeParts[3]);

                forest.trees.add(new Tree(treeSpecies, yearPlanted, height, growthRate));

            }
            inFile.close();

        } catch (IOException e) {
            System.out.println("no file");
        }
        return forest;
    }

    public void setName(String forestName) {
        name = forestName;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void print() {

        int index;
        double totalHeight = 0.0;

        //print out the header
        System.out.println("\nForest name: " + name);
        //loop for each tree in the forest
        for (index = 0; index < trees.size(); index++) {
            //output the data for the tree
            System.out.printf("   %2d %s\n", index, trees.get(index));
            //track forest total height
            totalHeight += trees.get(index).getHeight();
        }
        //print the tree total and average height
        System.out.printf("There are %d trees, with an average height of %.2f\n", trees.size(), totalHeight / trees.size());

    }

    public void add() {
        trees.add(Tree.makeRandomTree());
    }

    public void cut(int treeNumber) {

        if (treeNumber >= 0 && treeNumber < trees.size()) {
            trees.remove(treeNumber);
        } else {
            System.out.println("Tree number " + treeNumber + " does not exist");
        }
    }

    //grow the forest
    public void grow() {
        for (Tree tree : trees) {
            double growthRate = tree.getGrowthRate();
            double currentHeight = tree.getHeight();
            double newHeight = currentHeight * (1 + growthRate/100);
            tree.setHeight(newHeight);
        }
    }

    public void reap() {
        Scanner scanner = new Scanner(System.in);
        double heightThreshold;
        do {
            try {
                System.out.print("Height to reap from: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("That is not an integer.");
                    scanner.next(); // Consume the invalid input
                    System.out.print("Height to reap from: ");
                }
                heightThreshold = scanner.nextDouble();
                for (int index = 0; index < trees.size(); index++) {
                    if (trees.get(index).getHeight() > heightThreshold) {
                        System.out.println("Reaping the tall tree " + trees.get(index));
                        Tree newTree = Tree.makeRandomTree();
                        trees.set(index, newTree);
                        System.out.println("Replacing with new tree " + newTree.toString());
                    }
                }
                break; // Exit the loop if input is a valid double
            } catch (InputMismatchException e) {
                System.out.println("That is not an integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (true);

    }


    public static boolean save(Forest forest, String fileName) {
        ObjectOutputStream toStream = null;

        try {
            toStream = new ObjectOutputStream(new FileOutputStream(fileName));
            toStream.writeObject(forest);
            return(true);
        } catch (IOException e) {
            System.out.println("Error saving forest: " + e.getMessage());
            return(false);
        } finally {
            if (toStream != null) {
                try {
                    toStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

//    public static Forest loadTreeFile(String loadFileName) {
//        ObjectInputStream fromStream = null;
//
//        try {
//            fromStream = new ObjectInputStream(new FileInputStream(loadFileName));
//            Forest forest = (Forest) fromStream.readObject();
//            return forest;
//        } catch (EOFException e) {
//            // Ignore it - we came to end of file. That's cool.
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error loading forest.");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fromStream != null) {
//                    fromStream.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Error closing file.");
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }


//    public static Forest loadForest (String fileName) {
//        ObjectInputStream fromStream = null;
//
//        try {
//            fromStream = new ObjectInputStream(new FileInputStream(fileName));
//            Forest forest = (Forest) fromStream.readObject();
//            return forest;
//
//        } catch (EOFException e) {
//            // Ignore it - we came to end of file. That's fine.
//            return null;
//        } catch (FileNotFoundException e) {
//            System.out.println("Error opening/reading " + fileName);
//            return null;
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error: Loading forest: " + e.getMessage());
//            return null;
//        } finally {
//            if (fromStream != null) {
//                try {
//                    fromStream.close();
//                } catch (IOException e) {
//                    System.out.println("Error: Closing file: " + e.getMessage());
//                }
//            }
//        }
//  }

    public static Forest loadTreeFile(String loadFileName) {
        try (ObjectInputStream fromStream = new ObjectInputStream(new FileInputStream(loadFileName))) {
            Forest forest = (Forest) fromStream.readObject();
            return forest;
        } catch (EOFException e) {
            // Ignore it - we came to end of file. That's cool.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading forest.");
            e.printStackTrace();
        }
        return null;
    }


}// end of Forest class
