import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String input = "Game 1: 10 green, 9 blue, 1 red; 1 red, 7 green; 11 green, 6 blue; 8 blue, 12 green\n" +
                "Game 2: 11 red, 7 green, 3 blue; 1 blue, 8 green, 5 red; 2 red, 12 green, 1 blue; 10 green, 5 blue, 7 red\n" +
                "Game 3: 2 red, 7 green, 1 blue; 1 blue, 8 red; 7 green, 19 red, 5 blue; 1 blue, 10 green, 18 red; 10 red, 6 blue, 4 green\n" +
                "Game 4: 2 blue, 5 green, 2 red; 7 red, 3 green; 3 blue, 2 red; 16 green, 2 blue\n" +
                "Game 5: 1 blue, 9 red; 5 blue, 9 green, 6 red; 8 red, 10 blue, 3 green; 3 red, 13 green, 4 blue; 5 green, 9 red, 6 blue; 4 green, 8 red, 7 blue\n" +
                "Game 6: 1 red, 2 green; 2 red, 1 blue; 5 red, 10 green, 2 blue; 1 blue, 2 green, 3 red; 1 red, 6 green\n" +
                "Game 7: 9 blue, 14 green, 5 red; 10 green, 8 blue, 2 red; 20 green, 1 red; 4 blue, 17 green, 4 red\n" +
                "Game 8: 16 blue, 16 green, 8 red; 16 blue, 6 red, 10 green; 13 blue, 8 green, 16 red; 10 red, 13 green, 13 blue\n" +
                "Game 9: 8 blue, 10 green, 4 red; 18 green, 14 blue, 12 red; 4 green, 10 blue, 17 red; 16 red, 6 blue, 5 green; 11 red, 9 blue; 16 green, 13 red, 7 blue\n" +
                "Game 10: 5 green, 2 red, 13 blue; 3 red, 2 green, 17 blue; 3 green, 12 blue, 15 red; 7 blue, 14 red; 3 red, 4 green, 17 blue\n" +
                "Game 11: 8 green, 10 blue, 15 red; 11 blue, 4 green, 3 red; 10 blue, 4 green, 5 red; 7 blue, 1 green, 4 red; 2 red, 9 blue; 18 red, 8 green, 2 blue\n" +
                "Game 12: 16 red, 10 green; 12 red, 8 blue, 3 green; 8 red, 10 green, 7 blue; 10 green, 12 red\n" +
                "Game 13: 5 green, 2 red; 13 blue, 4 green, 4 red; 8 blue, 4 green\n" +
                "Game 14: 9 green, 3 red, 1 blue; 1 blue, 3 red, 1 green; 6 green; 3 green, 5 red; 1 blue, 4 red\n" +
                "Game 15: 13 red, 2 blue, 7 green; 6 green, 4 red, 7 blue; 8 blue, 11 red, 4 green; 1 green, 7 blue, 10 red; 3 blue, 9 green, 6 red; 6 green, 11 red, 1 blue\n" +
                "Game 16: 1 red, 14 green; 4 green, 1 blue, 4 red; 3 red, 1 blue, 5 green; 5 red, 1 blue, 14 green; 1 blue, 1 red, 12 green; 6 red, 14 green, 1 blue\n" +
                "Game 17: 14 green, 14 red; 19 green, 3 blue, 10 red; 4 green, 10 red, 1 blue\n" +
                "Game 18: 9 green, 1 blue, 12 red; 1 green, 10 red; 1 blue, 3 red\n" +
                "Game 19: 6 blue, 3 red, 3 green; 12 blue; 11 red, 14 blue, 3 green; 14 blue, 13 red, 1 green; 5 blue, 9 red\n" +
                "Game 20: 10 blue, 11 green, 3 red; 2 red, 16 green; 6 blue, 16 green, 4 red; 14 green, 7 red, 1 blue; 5 red, 9 blue, 11 green\n" +
                "Game 21: 1 red; 4 red; 2 red, 2 green, 1 blue\n" +
                "Game 22: 11 green, 3 blue, 3 red; 12 blue, 6 green; 1 red, 5 blue, 1 green; 9 blue, 6 green; 10 green, 1 red, 8 blue\n" +
                "Game 23: 13 blue, 3 green; 3 red, 5 green, 6 blue; 2 red, 11 green, 9 blue\n" +
                "Game 24: 1 blue, 1 green; 1 blue; 1 red\n" +
                "Game 25: 7 red, 1 green, 14 blue; 17 blue, 4 red, 6 green; 7 blue, 5 red; 2 red, 6 green, 20 blue\n" +
                "Game 26: 10 green, 8 red, 11 blue; 13 green, 2 blue, 4 red; 1 blue, 6 green, 9 red\n" +
                "Game 27: 9 green, 1 blue, 6 red; 7 red, 14 green; 13 green, 2 red; 2 red, 13 green; 2 green, 7 red\n" +
                "Game 28: 10 red, 6 green; 7 green, 11 red, 1 blue; 8 red, 5 green; 10 green, 13 red; 17 red, 3 green\n" +
                "Game 29: 4 blue, 3 red, 13 green; 9 green, 2 red, 1 blue; 11 green, 5 blue, 2 red; 1 blue, 7 green, 2 red; 4 blue, 1 red, 12 green\n" +
                "Game 30: 6 blue, 1 green, 3 red; 1 green, 3 red, 1 blue; 6 green, 2 red, 2 blue\n" +
                "Game 31: 11 red; 5 red, 2 green; 3 green, 6 red, 1 blue; 1 green, 18 red; 2 green, 14 red\n" +
                "Game 32: 11 blue, 12 green, 11 red; 5 red, 14 blue, 5 green; 5 blue, 7 green, 18 red\n" +
                "Game 33: 8 blue, 4 green, 11 red; 14 blue, 11 red, 3 green; 3 green, 1 blue; 17 red, 2 green, 9 blue; 7 green, 7 blue, 3 red; 2 green, 3 red, 7 blue\n" +
                "Game 34: 1 blue, 17 green; 2 blue, 1 red, 10 green; 10 green, 1 red; 6 green, 1 red, 1 blue; 2 green, 2 blue, 1 red\n" +
                "Game 35: 1 blue, 5 red, 5 green; 4 blue, 3 green, 8 red; 5 green, 14 blue; 5 green, 4 blue, 14 red\n" +
                "Game 36: 13 green, 7 red, 2 blue; 2 red, 2 green; 1 red, 12 green; 7 green, 8 red\n" +
                "Game 37: 11 red, 4 green, 1 blue; 12 red, 3 green, 5 blue; 1 blue, 12 red, 1 green; 9 red, 10 green; 7 red, 2 blue, 5 green; 7 green, 1 red, 4 blue\n" +
                "Game 38: 14 red, 20 blue, 6 green; 14 red, 12 green, 13 blue; 10 green, 10 red, 9 blue; 9 green, 9 blue, 15 red\n" +
                "Game 39: 4 blue; 8 green, 7 blue; 12 green, 2 blue, 5 red; 2 blue, 3 green, 3 red; 5 red, 1 green, 1 blue; 6 red, 1 blue\n" +
                "Game 40: 7 green, 10 red, 3 blue; 2 blue, 1 red, 7 green; 2 red, 5 blue, 11 green; 4 blue, 12 red, 6 green; 13 green, 7 blue, 9 red; 14 blue, 7 green, 8 red\n" +
                "Game 41: 14 red, 17 blue, 3 green; 18 blue, 4 green, 17 red; 2 green, 17 red, 8 blue; 7 green, 13 blue, 6 red\n" +
                "Game 42: 1 blue, 16 green; 14 green; 17 blue, 4 green, 7 red; 6 red, 7 blue, 8 green\n" +
                "Game 43: 8 red, 15 blue; 8 red, 1 green, 11 blue; 17 blue, 3 red\n" +
                "Game 44: 10 red, 2 green, 11 blue; 8 green, 4 blue, 6 red; 6 green, 2 blue, 10 red; 1 blue, 12 red, 7 green\n" +
                "Game 45: 1 blue, 4 red, 4 green; 2 red, 5 green; 3 green, 6 blue, 1 red; 12 blue, 1 red, 2 green\n" +
                "Game 46: 2 blue; 1 red, 4 blue; 2 blue, 15 red; 3 blue, 4 green, 5 red; 4 green, 13 red; 1 blue, 3 green, 9 red\n" +
                "Game 47: 13 blue, 2 green, 2 red; 2 green, 12 blue, 3 red; 2 green, 1 blue\n" +
                "Game 48: 1 blue, 4 green, 11 red; 2 blue, 5 red, 8 green; 6 red\n" +
                "Game 49: 1 red, 10 green; 3 green, 8 blue, 5 red; 7 red, 5 green, 7 blue\n" +
                "Game 50: 12 blue, 5 green, 1 red; 7 blue, 2 red; 12 blue, 3 green; 16 blue; 1 blue, 3 green; 2 red, 14 blue, 11 green\n" +
                "Game 51: 6 blue, 15 red, 1 green; 15 red, 2 blue, 1 green; 12 red, 2 green\n" +
                "Game 52: 5 green, 11 blue, 5 red; 18 green, 4 red, 10 blue; 14 green, 8 blue, 8 red; 2 red, 9 green, 11 blue; 9 blue, 5 red, 10 green\n" +
                "Game 53: 1 red, 1 green; 2 green, 1 red, 2 blue; 2 green, 1 blue\n" +
                "Game 54: 4 blue, 3 red, 7 green; 4 blue, 13 green; 1 red, 2 green, 7 blue; 5 blue, 5 red, 17 green\n" +
                "Game 55: 8 red, 11 green, 11 blue; 1 green, 15 blue, 6 red; 7 red, 8 blue, 11 green; 2 green, 1 red, 11 blue; 11 blue, 3 red; 3 red, 7 blue, 10 green\n" +
                "Game 56: 13 blue, 3 green; 1 red, 1 green, 7 blue; 17 blue, 2 red; 3 blue, 4 green, 4 red\n" +
                "Game 57: 9 green, 11 blue, 12 red; 13 red, 6 green, 1 blue; 4 blue, 1 green, 14 red; 11 red, 6 blue, 3 green\n" +
                "Game 58: 7 green, 2 blue, 6 red; 1 red, 4 green; 1 blue, 8 green, 10 red\n" +
                "Game 59: 3 green, 11 red, 3 blue; 1 blue, 5 red, 8 green; 10 green, 9 red; 5 green, 5 red, 1 blue; 4 green, 8 blue; 13 green\n" +
                "Game 60: 2 blue, 11 green, 7 red; 5 red, 9 green, 2 blue; 3 blue, 2 red, 8 green; 6 red, 2 blue, 9 green; 5 red, 4 green, 2 blue; 6 red, 5 blue, 11 green\n" +
                "Game 61: 7 blue, 5 green, 8 red; 12 blue, 1 red, 11 green; 15 blue, 14 red, 15 green; 14 red, 7 blue, 6 green; 9 blue; 3 green, 10 blue, 11 red\n" +
                "Game 62: 8 red, 1 blue, 1 green; 2 red, 1 blue, 8 green; 11 blue, 15 red, 4 green; 1 red, 5 green, 2 blue; 15 green, 11 blue, 12 red\n" +
                "Game 63: 6 red, 3 green, 7 blue; 8 red, 2 green; 4 green, 3 red, 4 blue; 6 blue, 3 red, 10 green; 4 blue, 6 red, 9 green; 8 blue, 10 green, 5 red\n" +
                "Game 64: 1 blue, 9 red, 1 green; 17 red, 3 blue; 8 red, 2 green; 12 red, 8 blue\n" +
                "Game 65: 15 blue, 2 red; 1 green, 14 blue; 10 green, 1 red, 10 blue; 10 green, 1 red, 12 blue; 13 blue, 1 green\n" +
                "Game 66: 18 green, 3 red, 7 blue; 19 blue, 2 red; 5 red, 8 blue, 11 green; 1 red, 15 blue, 12 green; 13 blue, 6 green; 12 blue, 6 green\n" +
                "Game 67: 1 blue, 2 green, 6 red; 7 red, 5 blue; 9 red, 13 blue, 5 green; 4 green, 4 blue, 5 red; 11 blue, 7 red; 3 blue, 9 red\n" +
                "Game 68: 2 blue, 8 green, 16 red; 11 green, 13 blue; 6 red, 7 green, 1 blue; 4 green, 7 red, 8 blue\n" +
                "Game 69: 7 green, 3 blue, 5 red; 11 green, 4 blue; 1 red, 15 green, 10 blue; 8 green, 12 blue, 4 red\n" +
                "Game 70: 8 blue, 8 green; 4 blue, 1 red, 6 green; 1 green, 1 blue; 7 green, 4 blue\n" +
                "Game 71: 7 red, 13 blue, 4 green; 2 blue, 11 red, 9 green; 14 blue, 6 green, 2 red; 10 red, 6 blue, 10 green\n" +
                "Game 72: 1 blue, 9 green, 1 red; 4 blue, 6 green, 1 red; 1 red, 3 green, 3 blue; 10 green, 3 blue, 2 red; 3 blue, 1 red, 1 green; 3 green, 1 red, 3 blue\n" +
                "Game 73: 4 green, 15 red, 6 blue; 1 green, 12 red; 2 green, 16 red; 1 green, 12 red, 2 blue; 6 red, 4 green, 2 blue; 19 red, 3 blue, 2 green\n" +
                "Game 74: 14 green, 2 blue, 3 red; 13 green, 4 red; 3 green, 4 blue; 3 blue, 3 red; 2 red, 12 green; 3 blue, 3 green\n" +
                "Game 75: 13 red, 10 blue, 1 green; 14 blue, 9 red, 2 green; 8 blue; 1 green, 13 red, 11 blue\n" +
                "Game 76: 2 red, 8 blue, 12 green; 11 green, 2 red; 2 red, 2 blue, 10 green; 5 blue, 2 green; 3 red, 11 green, 8 blue\n" +
                "Game 77: 4 blue, 8 red, 14 green; 15 green, 12 red, 5 blue; 8 red, 5 green, 1 blue\n" +
                "Game 78: 8 red, 19 blue, 4 green; 18 blue, 2 red; 12 blue, 4 green, 8 red; 17 blue, 2 green, 9 red; 9 red, 10 blue, 1 green; 6 green, 9 blue, 1 red\n" +
                "Game 79: 1 blue, 11 red, 2 green; 2 red, 2 green, 6 blue; 11 red, 2 blue, 2 green; 11 red, 2 green, 4 blue\n" +
                "Game 80: 1 red, 9 blue; 1 red, 5 blue, 8 green; 5 green, 1 red, 4 blue; 2 green, 9 blue, 1 red; 7 blue, 1 green, 1 red\n" +
                "Game 81: 1 green, 1 blue, 7 red; 3 blue, 7 green, 6 red; 5 green; 3 blue; 3 red, 4 blue, 1 green; 5 red, 9 green\n" +
                "Game 82: 12 blue, 4 red, 4 green; 7 red, 4 blue; 3 green, 10 red, 3 blue; 6 blue, 13 red; 4 blue, 5 red, 1 green\n" +
                "Game 83: 1 red, 1 green, 18 blue; 20 blue, 16 red, 1 green; 17 blue, 12 red; 1 green, 9 blue, 7 red\n" +
                "Game 84: 6 blue, 7 green, 6 red; 6 red, 10 green, 1 blue; 5 red, 8 green; 13 green, 2 red, 7 blue\n" +
                "Game 85: 1 blue, 7 red, 11 green; 1 red; 8 red, 10 green, 4 blue; 4 red, 11 green, 1 blue; 1 blue, 6 green\n" +
                "Game 86: 9 green, 2 blue; 3 red, 1 green, 2 blue; 1 green, 5 blue, 9 red; 1 blue, 2 green; 9 red, 1 green, 4 blue\n" +
                "Game 87: 15 red, 1 green, 16 blue; 1 green, 6 red, 17 blue; 7 red, 1 green, 3 blue; 8 red, 3 blue, 1 green; 15 red, 1 green\n" +
                "Game 88: 7 green, 3 red, 10 blue; 8 blue, 8 red, 3 green; 18 green, 1 blue, 7 red; 8 red, 7 green, 10 blue\n" +
                "Game 89: 5 red, 16 blue; 7 blue; 5 blue, 4 red; 3 blue, 4 green, 6 red; 1 red, 2 green, 16 blue\n" +
                "Game 90: 19 blue, 5 green, 4 red; 2 green, 20 blue, 1 red; 18 blue\n" +
                "Game 91: 10 red, 11 blue, 1 green; 18 red, 12 blue; 11 blue, 10 red\n" +
                "Game 92: 3 green, 1 blue; 8 red, 5 green; 10 red, 3 green\n" +
                "Game 93: 5 green, 1 blue, 5 red; 1 blue, 2 red, 7 green; 2 green, 6 red, 1 blue; 7 green, 1 blue, 2 red; 6 red, 1 green\n" +
                "Game 94: 3 red, 6 blue, 2 green; 5 blue, 9 red; 11 blue, 5 red, 2 green; 2 green, 3 red, 14 blue; 5 red, 13 blue; 6 blue, 2 green, 8 red\n" +
                "Game 95: 4 red, 3 green, 17 blue; 1 red, 5 green, 4 blue; 15 blue, 11 green; 5 green, 1 red, 4 blue; 11 blue, 2 green, 17 red\n" +
                "Game 96: 3 red, 20 blue, 18 green; 1 red, 1 blue, 20 green; 18 blue, 4 green, 8 red\n" +
                "Game 97: 11 green; 7 red, 8 green, 2 blue; 4 green, 17 red; 4 green, 7 red; 14 green, 18 red, 2 blue\n" +
                "Game 98: 2 blue, 7 green, 1 red; 9 green, 10 red, 5 blue; 13 blue, 10 red, 8 green; 8 green, 11 red, 12 blue; 5 blue, 4 green, 2 red\n" +
                "Game 99: 2 blue, 13 green; 1 blue; 1 red, 2 blue, 2 green; 1 red, 1 blue\n" +
                "Game 100: 1 red, 14 green; 17 green, 12 red; 3 green, 7 red, 3 blue; 4 green, 13 red, 3 blue; 5 green, 11 red, 5 blue";

        ArrayList<String> test = new ArrayList<String>(arrayMaker(input));
        System.out.println("day 2.2: " + day22(test));
        //  System.out.println("\t" + valueFinder(test));
        // System.out.println(input);

        /** for(int i = 0; i < test.size(); i++){
         System.out.println("\t"+ test.get(i));
         }
         */
        //int result2 = calc(test);
        // System.out.println(letterValueFinder(test));
        // int result = iDCalculator(test);
        //  System.out.println(result);
        /**
         String array2D = "467..114..\n" +
         "...*......\n" +
         "..35..633.";
         arrayMaker2D(array2D);
         char[][] twoDArray = arrayMaker2(array2D);
         printTable1(twoDArray);

         String engineSchematicString = "467..114..\n" +
         "...*......\n" +
         "..35..633.\n" +
         "......#...\n" +
         "617*......\n" +
         ".....+.58.\n" +
         "..592.....\n" +
         "......755.\n" +
         "...$.*....\n" +
         ".664.598..";
         //  char[][] engineSchematic = arrayMaker31(engineSchematicString);

         int sum = engine(engineSchematicString);
         System.out.println("Sum of part numbers: " + sum);
         */

    }

    public static ArrayList<String> arrayMaker(String starter) {
        ArrayList<String> inputArray = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < starter.length(); i++) {
            if (starter.charAt(i) != '\n') {
                temp += starter.charAt(i);
                if (i == starter.length() - 1) {
                    inputArray.add(temp);
                }

            } else {
                inputArray.add(temp);
                temp = "";
            }
        }
        return inputArray;
    }
    public static void arrayMaker2D(String s) {
        ArrayList<ArrayList<Character>> array = new ArrayList<>();
        String[] split = s.split("\n");
        for (int i = 0; i < split.length; i++) {
            ArrayList<Character> rows = new ArrayList<>();
            for (int j = 0; j < split[i].length(); j++) {
                rows.add(split[i].charAt(j));  // Add each character directly to the ArrayList
            }
            array.add(rows);  // Add the row to the 2D ArrayList
        }
        printTable(array);
    }
    public static char[][] arrayMaker2(String s) {
        String[] split = s.split("\n");
        char[][] array = new char[split.length][];

        for (int i = 0; i < split.length; i++) {
            array[i] = split[i].toCharArray();
        }

        return array;
    }

    public static void printTable1(char[][] table) {
        for (char[] row : table) {
            for (char value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


    public static void printTable(ArrayList<ArrayList<Character>> table) {
        for (ArrayList<Character> row : table) {
            for (Character value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


    //1A
    public static int valueFinder(ArrayList<String> array) {
        int counter = 0;
        for (int i = 0; i < array.size(); i++) {
            String temp = "";
            for (int n = 0; n < array.get(i).length(); n++) {
                if (array.get(i).charAt(n) == '0' || array.get(i).charAt(n) == '1' || array.get(i).charAt(n) == '2' || array.get(i).charAt(n) == '3' || array.get(i).charAt(n) == '4' || array.get(i).charAt(n) == '5' || array.get(i).charAt(n) == '6' || array.get(i).charAt(n) == '7' || array.get(i).charAt(n) == '8' || array.get(i).charAt(n) == '9') {
                    temp += array.get(i).charAt(n);
                    break;
                }
            }
            for (int z = array.get(i).length() - 1; z >= 0; z--) {
                if (array.get(i).charAt(z) == '0' || array.get(i).charAt(z) == '1' || array.get(i).charAt(z) == '2' || array.get(i).charAt(z) == '3' || array.get(i).charAt(z) == '4' || array.get(i).charAt(z) == '5' || array.get(i).charAt(z) == '6' || array.get(i).charAt(z) == '7' || array.get(i).charAt(z) == '8' || array.get(i).charAt(z) == '9') {
                    temp += array.get(i).charAt(z);
                    break;
                }
            }
            int tempNumber = Integer.parseInt(temp);
            System.out.println(tempNumber);
            counter += tempNumber;
        }
        return counter;
    }

    //1B
    public static int letterValueFinder(ArrayList<String> array) {
        int total = 0;
        for (int i = 0; i < array.size(); i++) {
            String firstNumber = "";
            int firstNumberInteger = 0;

            for (int n = 0; n < array.get(i).length(); n++) {
                if (array.get(i).charAt(n) == '0' || array.get(i).charAt(n) == '1' || array.get(i).charAt(n) == '2' || array.get(i).charAt(n) == '3' || array.get(i).charAt(n) == '4' || array.get(i).charAt(n) == '5' || array.get(i).charAt(n) == '6' || array.get(i).charAt(n) == '7' || array.get(i).charAt(n) == '8' || array.get(i).charAt(n) == '9') {
                    firstNumber += array.get(i).charAt(n);
                    break;
                } else if (n < array.get(i).length() - 3 && array.get(i).charAt(n) == 'o' || array.get(i).charAt(n) == 't' || array.get(i).charAt(n) == 'f' || array.get(i).charAt(n) == 's' || array.get(i).charAt(n) == 'e' || array.get(i).charAt(n) == 'n') {
                    if (n < array.get(i).length() - 3 && array.get(i).charAt(n) == 'o' && array.get(i).substring(n, n + 3).equals("one")) {
                        firstNumber += "1";
                        break;
                    }
                    if (n < array.get(i).length() - 3 && array.get(i).charAt(n) == 't' && array.get(i).substring(n, n + 3).equals("two")) {
                        firstNumber += "2";
                        break;
                    }
                    if (n < array.get(i).length() - 5 && array.get(i).charAt(n) == 't' && array.get(i).substring(n, n + 5).equals("three")) {
                        firstNumber += "3";
                        break;
                    }
                    if (n < array.get(i).length() - 4 && array.get(i).charAt(n) == 'f' && array.get(i).substring(n, n + 4).equals("four")) {
                        firstNumber += "4";
                        break;
                    }
                    if (n < array.get(i).length() - 4 && array.get(i).charAt(n) == 'f' && array.get(i).substring(n, n + 4).equals("five")) {
                        firstNumber += "5";
                        break;
                    }
                    if (n < array.get(i).length() - 3 && array.get(i).charAt(n) == 's' && array.get(i).substring(n, n + 3).equals("six")) {
                        firstNumber += "6";
                        break;
                    }
                    if (n < array.get(i).length() - 5 && array.get(i).charAt(n) == 's' && array.get(i).substring(n, n + 5).equals("seven")) {
                        firstNumber += "7";
                        break;
                    }
                    if (n < array.get(i).length() - 5 && array.get(i).charAt(n) == 'e' && array.get(i).substring(n, n + 5).equals("eight")) {
                        firstNumber += "8";
                        break;
                    }
                    if (n < array.get(i).length() - 4 && array.get(i).charAt(n) == 'n' && array.get(i).substring(n, n + 4).equals("nine")) {
                        firstNumber += "9";
                        break;
                    }
                }
            }
            for (int z = array.get(i).length() - 1; z >= 0; z--) {
                if (array.get(i).charAt(z) == '0' || array.get(i).charAt(z) == '1' || array.get(i).charAt(z) == '2' || array.get(i).charAt(z) == '3' || array.get(i).charAt(z) == '4' || array.get(i).charAt(z) == '5' || array.get(i).charAt(z) == '6' || array.get(i).charAt(z) == '7' || array.get(i).charAt(z) == '8' || array.get(i).charAt(z) == '9') {
                    firstNumber += array.get(i).charAt(z);
                    break;
                }
                if (z > 1 && array.get(i).charAt(z - 2) == 'o' && array.get(i).substring(z - 2, z + 1).equals("one")) {
                    firstNumber += "1";
                    break;
                }
                if (z > 1 && array.get(i).charAt(z - 2) == 't' && array.get(i).substring(z - 2, z + 1).equals("two")) {
                    firstNumber += "2";
                    break;
                }
                if (z > 3 && array.get(i).charAt(z - 4) == 't' && array.get(i).substring(z - 4, z + 1).equals("three")) {
                    firstNumber += "3";
                    break;
                }
                if (z > 2 && array.get(i).charAt(z - 3) == 'f' && array.get(i).substring(z - 3, z + 1).equals("four")) {
                    firstNumber += "4";
                    break;
                }
                if (z > 2 && array.get(i).charAt(z - 3) == 'f' && array.get(i).substring(z - 3, z + 1).equals("five")) {
                    firstNumber += "5";
                    break;
                }
                if (z > 1 && array.get(i).charAt(z - 2) == 's' && array.get(i).substring(z - 2, z + 1).equals("six")) {
                    firstNumber += "6";
                    break;
                }
                if (z > 3 && array.get(i).charAt(z - 4) == 's' && array.get(i).substring(z - 4, z + 1).equals("seven")) {
                    firstNumber += "7";
                    break;
                }
                if (z > 3 && array.get(i).charAt(z - 4) == 'e' && array.get(i).substring(z - 4, z + 1).equals("eight")) {
                    firstNumber += "8";
                    break;
                }
                if (z > 2 && array.get(i).charAt(z - 3) == 'n' && array.get(i).substring(z - 3, z + 1).equals("nine")) {
                    firstNumber += "9";
                    break;
                }
            }
            int tempNumber = Integer.parseInt(firstNumber);
            total += tempNumber;
        }
        return total;
    }

    //2A
    public static int iDCalculator(ArrayList<String> array) {
        int total = 0;
        for (int i = 0; i < array.size(); i++) {
            // System.out.println(array.get(i));
            String temp = "";
            String idString = "";
            boolean checker = true;
            for (int n = array.get(i).indexOf(':'); n < array.get(i).length(); n++) {
                if (array.get(i).charAt(n) == '0' || array.get(i).charAt(n) == '1' || array.get(i).charAt(n) == '2' || array.get(i).charAt(n) == '3' || array.get(i).charAt(n) == '4' || array.get(i).charAt(n) == '5' || array.get(i).charAt(n) == '6' || array.get(i).charAt(n) == '7' || array.get(i).charAt(n) == '8' || array.get(i).charAt(n) == '9') {
                    temp += array.get(i).charAt(n);
                    // System.out.println(array.get(i).charAt(n));
                }
                if (array.get(i).charAt(n) == ' ' && Character.isDigit(array.get(i).charAt(n - 1)) && Character.isLetter(array.get(i).charAt(n + 1))) {
                    int tempNumber = Integer.parseInt(temp);
                    // System.out.println("test" + tempNumber);
                    // Adjust the conditions based on your intended logic
                    if ((array.get(i).charAt(n + 1) == 'r' && tempNumber <= 12) || (array.get(i).charAt(n + 1) == 'g' && tempNumber <= 13) || (array.get(i).charAt(n + 1) == 'b' && tempNumber <= 14)) {
                        // System.out.println("test 2" + temp);
                        temp = "";
                        System.out.println("test 3" + "." + temp);
                    } else {
                        // System.out.println("test 8" + temp + " " + tempNumber);
                        temp = "";
                        checker = false;
                        break;
                    }
                }

            }

            if (checker) {
                for (int z = 0; z < array.get(i).indexOf(':'); z++) {
                    System.out.println(array.get(i).charAt(z));
                    if (Character.isDigit(array.get(i).charAt(z))) {
                        idString += array.get(i).charAt(z);
                    }
                }
                total += Integer.parseInt(idString);
            }
        }
        return total;
    }
    public static int calc(ArrayList<String> array) {
        int total = 0;
        for(int i = 0; i < array.size(); i++){
            String temp = "";
            String idString = "";
            int n = 0;
            boolean checker = true;
            while(n < array.get(i).length()){

                while(Character.isDigit(array.get(i).charAt(n))){
                    temp += array.get(i).charAt(n);
                    n++;
                }
                if(array.get(i).charAt(n+1) == 'r'){
                    int tempNumber = Integer.parseInt(temp);
                    if(tempNumber <= 12){
                        temp = "";
                        checker = false;
                        break;
                    }
                }
                if(array.get(i).charAt(n+1) == 'g'){
                    int tempNumber = Integer.parseInt(temp);
                    if(tempNumber <= 12){
                        temp = "";
                        checker = false;
                        break;
                    }
                }
                if(array.get(i).charAt(n+1) == 'b'){
                    int tempNumber = Integer.parseInt(temp);
                    if(tempNumber <= 12){
                        temp = "";
                        checker = false;
                        break;
                    }
                }
                n++;
            }
            if (checker) {
                for (int q = 0; q < array.get(i).indexOf(':'); q++) {
                    System.out.println(array.get(i).charAt(q));
                    if (Character.isDigit(array.get(i).charAt(q))) {
                        idString += array.get(i).charAt(q);
                    }
                }
                total += Integer.parseInt(idString);
            }

        }
        return total;
    }

    public static int day22(ArrayList<String> array){
        int total = 0;
     for(int i = 0; i < array.size(); i++) {
         int greatestBlue = 0;
         int greatestRed = 0;
         int greatestGreen = 0;

         int toBeAdded = 1;


         Pattern blue = Pattern.compile("(\\d+)\\s+blue");
         Pattern red = Pattern.compile("(\\d+)\\s+red");
         Pattern green = Pattern.compile("(\\d+)\\s+green");

         Matcher blueMatcher = blue.matcher(array.get(i));
         Matcher redMatcher = red.matcher(array.get(i));
         Matcher greenMatcher = green.matcher(array.get(i));

         while(blueMatcher.find()){
             int curr = Integer.parseInt(blueMatcher.group(1));
             if(curr > greatestBlue) {
                 greatestBlue = curr;
             }
         }
         while(redMatcher.find()){
             int curr = Integer.parseInt(redMatcher.group(1));
             if(curr > greatestRed) {
                 greatestRed = curr;
             }
         }
         while(greenMatcher.find()){
             int curr = Integer.parseInt(greenMatcher.group(1));
             if(curr > greatestGreen) {
                 greatestGreen = curr;
             }
         }

         toBeAdded *= greatestBlue * greatestRed * greatestGreen;

        total += toBeAdded;
     }
        return total;
    }

    public static int day3(char[][] array) {
        int total = 0;
        for (int row = 0; row < array.length; row++) {
            String temp = "";
            for (int col = 0; col < array[row].length; col++) {
                boolean isNum = Character.isDigit(array[row][col]);
                if (isNum) {
                    temp += array[row][col];
                }
                if (isNum == false && !temp.isEmpty()) {


                    if (row > 0 && col > 0 && col < array[row].length - 1 && row < array.length) {
                        for(int q = -1; q < temp.length() +1; q++){
                            if (array[row - 1][col + q] != '.' && !Character.isDigit(array[row - 1][col + q]) || array[row + 1][col + q] != '.' && !Character.isDigit(array[row + 1][col + q])) {
                                int tempNumber = Integer.parseInt(temp);
                                total+= tempNumber;
                                break;
                            }
                        }
                        // Case 1
                    } else if (row <= 0 && col > 0 && col < array[row].length - 1 && row < array.length) {
                        // Case 2
                    } else if (row <= 0 && col >= array[row].length - 1 && row < array.length && col > 0) {
                        // Case 3
                    } else if (row <= 0 && col >= array[row].length - 1 && row >= array.length && col > 0) {
                        // Case 4
                    } else if (row <= 0 && col >= array[row].length - 1 && row >= array.length && col <= 0) {
                        // Case 5
                    } else if (row > 0 && col >= array[row].length - 1 && row >= array.length && col <= 0) {
                        // Case 6
                    } else if (row > 0 && col < array[row].length - 1 && row >= array.length && col <= 0) {
                        // Case 7
                    } else if (row > 0 && col < array[row].length - 1 && row < array.length && col <= 0) {
                        // Case 8
                    } else if (row <= 0 && col < array[row].length - 1 && row >= array.length && col <= 0) {
                        // Case 9
                    } else if (row > 0 && col > 0 && col >= array[row].length - 1 && row < array.length) {
                        // Case 10
                    } else if (row <= 0 && col > 0 && col >= array[row].length - 1 && row < array.length) {
                        // Case 11
                    } else if (row > 0 && col > 0 && col < array[row].length - 1 && row >= array.length) {
                        // Case 12
                    } else if (row > 0 && col <= 0 && row < array.length) {
                        // Case 13
                    } else if (row <= 0 && col <= 0) {
                        // Case 14
                    } else if (row <= 0 && col > 0 && col < array[row].length - 1 && row >= array.length) {
                        // Case 15
                    } else if (row > 0 && col <= 0 && row >= array.length) {
                        // Case 16
                    }




                    /**if(array[row][col] != '.' && Character.isDigit(array[row][col])){
                     try {
                     if(Character.isDigit(array[row-1][col-1])){
                     numberFinderday3(array[row-1],col-1);
                     //replace commas
                     //repeat for all values
                     }
                     } catch (ArrayIndexOutOfBoundsException e) {
                     System.out.println("Caught an exception: " + e.getMessage());
                     }
                     }
                     */

                }
                return 1;
            }
        }
        return 1;
    }
    public static String numberFinderday3(char [] array, int index){


        return "";
    }


    public static int engine(String input) {
        char[][] engine = arrayMaker31(input);
        boolean keepNumber = false;
        String number = "";
        int sum = 0;

        for (int i = 1; i < engine.length - 1; i++) {
            for (int j = 1; j < engine[i].length - 1; j++) {
                if (engine[i][j] >= '0' && engine[i][j] <= '9') {
                    number += engine[i][j];
                    if (checkAdjustments(engine, i, j)) {
                        keepNumber = true;
                    }
                } else {
                    if (keepNumber && !number.isEmpty()) {
                        sum += Integer.parseInt(number);
                    }

                    keepNumber = false;
                    number = "";
                }
            }

            if (keepNumber && !number.isEmpty()) {
                sum += Integer.parseInt(number);
            }

            keepNumber = false;
        }

        return sum;
    }

    private static boolean checkAdjustments(char[][] engine, int i, int j) {
        return engine[i + 1][j] != '.' || engine[i - 1][j] != '.' || engine[i + 1][j + 1] != '.' || engine[i + 1][j - 1] != '.' || engine[i - 1][j + 1] != '.' || engine[i - 1][j - 1] != '.' || !isDigitOrDot(engine[i][j + 1]) || !isDigitOrDot(engine[i][j - 1]);
    }

    private static boolean isDigitOrDot(char c) {
        return c >= '0' && c <= '9' || c == '.';
    }

    private static char[][] arrayMaker31(String s) {
        String[] split = s.split("\n");
        char[][] array = new char[split.length][];

        for (int i = 0; i < split.length; i++) {
            array[i] = split[i].toCharArray();
        }

        return array;
    }
    public static HashMap<String, String> hashMapMaker(ArrayList<String> array){
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < array.size(); i++){
            map.put(array.get(i).substring(0, array.get(i).indexOf(":")), array.get(i).substring(array.get(i).indexOf(":"), array.get(i).length()));
        }
        return map;
    }

    //HashMap<String, String> map
    public static int day42(ArrayList<String> array){
        //   for(Map.Entry<String, String> entry : map.entrySet()){
        // }

        ArrayList<ArrayList<String>> index = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            ArrayList<String> inner = new ArrayList<>();
            index.add(inner);
        }
        for(int i = 0; i < array.size(); i++){
            index.get(i).add(array.get(i));
        }
        int counter = 0;
        for(int i = 0; i < index.size(); i++){
            System.out.println(i);
            for(int n = 0; n < index.get(i).size(); n++){
                String compact = index.get(i).get(n).substring(index.get(i).get(n).indexOf(':') + 1);
                String [] split = compact.split("\\|");
                Pattern pattern = Pattern.compile("\\d+");

                Matcher matcher = pattern.matcher(split[0]);
                Matcher matcher1 = pattern.matcher(split[1]);

                ArrayList<Integer> myNumbers = new ArrayList<>();
                ArrayList<Integer> winningNumbers = new ArrayList<>();

                while (matcher.find()) {
                    int number = Integer.parseInt(matcher.group());
                    myNumbers.add(number);
                }

                while (matcher1.find()) {
                    int number = Integer.parseInt(matcher1.group());
                    winningNumbers.add(number);
                }

                HashSet<Integer> overlapping = new HashSet<>(myNumbers);
                overlapping.retainAll(winningNumbers);

                int count = overlapping.size();

                if(count > 0){
                    for(int z = 1; z <= count; z++){
                        String duplicate = index.get(i+z).get(n);
                        index.get(i+z).add(duplicate);
                    }
                }
            }


        }
        for(int w = 0; w < index.size(); w++){
            counter += index.get(w).size();
        }

        return counter;
    }
    public static int day4(ArrayList<String> array){

        int total = 0;
        for (int i = 0; i < array.size(); i++) {
            String compact = array.get(i).substring(array.get(i).indexOf(':') + 1);
            String[] split = compact.split("\\|");
            Pattern pattern = Pattern.compile("\\d+");

            Matcher matcher = pattern.matcher(split[0]);
            Matcher matcher1 = pattern.matcher(split[1]);

            ArrayList<Integer> myNumbers = new ArrayList<>();
            ArrayList<Integer> winningNumbers = new ArrayList<>();

            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                myNumbers.add(number);
            }

            while (matcher1.find()) {
                int number = Integer.parseInt(matcher1.group());
                winningNumbers.add(number);
            }

            HashSet<Integer> overlapping = new HashSet<>(myNumbers);
            overlapping.retainAll(winningNumbers);

            int doubler = overlapping.size();

            total += Math.pow(2, overlapping.size()-1);
        }

        return total;
    }
    public static int day6(ArrayList<String> array){
        ArrayList<Integer>  time = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();
        int total = 1;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(array.get(0));
        Matcher matcher1 = pattern.matcher(array.get(1));
        while(matcher.find()){
            int number = Integer.parseInt(matcher.group());
            time.add(number);
        }
        while(matcher1.find()){
            int number = Integer.parseInt(matcher1.group());
            distance.add(number);
        }
        for(int n = 0; n < time.size(); n ++){
            int time1 = time.get(n);
            int distance1 = distance.get(n);
            int roundScore = 0;
            for(int z = 0; z < time1; z++){
                int charge = z;
                int toTravel = time1-z;
                if((charge * toTravel) > distance1){
                    roundScore += 1;
                }
            }
            total *= roundScore;

        }
        return total;
    }
    public static int day62(ArrayList<String> array){
        ArrayList<Integer>  time = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();

        int total = 0;
        String times = "";
        String distances = "";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(array.get(0));

        while(matcher.find()){
            String temp = matcher.group();
            System.out.println(temp);
            times += temp;
        }
        System.out.println(times);

        Matcher matcher1 = pattern.matcher(array.get(1));

        while(matcher1.find()){
            distances += matcher1.group();
        }
        System.out.println(distances);

        Long time1 = Long.parseLong(times);
        Long distance1 = Long.parseLong(distances);

        System.out.println(time1);
        System.out.println(distance1);

        for(long i = 0; i < time1; i++){
            Long charge = i;
            Long timeToTravel = time1-i;

            if((charge * timeToTravel) > distance1){

                total +=1;
            }
        }
        return total;
    }
}
