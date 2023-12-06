import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String input = "Game 2: 11 red, 7 green, 3 blue; 1 blue, 8 green, 5 red; 2 red, 12 green, 1 blue; 10 green, 5 blue, 7 red";
        ArrayList<String> test = new ArrayList<String>(arrayMaker(input));

        //  System.out.println("\t" + valueFinder(test));
        // System.out.println(input);

        /** for(int i = 0; i < test.size(); i++){
         System.out.println("\t"+ test.get(i));
         }
         */
        //int result2 = calc(test);
        // System.out.println(letterValueFinder(test));
      //  int result = iDCalculator(test);
        //System.out.println(result2);
        String array2D = "467..114..\n" +
                "...*......\n" +
                "..35..633.";
        arrayMaker2D(array2D);
        char[][] twoDArray = arrayMaker2(array2D);
        printTable1(twoDArray);
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
                rows.add(split[i].charAt(j));  
            }
            array.add(rows); 
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
            System.out.println(array.get(i));
            String temp = "";
            String idString = "";
            boolean checker = true;
            for (int n = array.get(i).indexOf(':'); n < array.get(i).length(); n++) {
                if (array.get(i).charAt(n) == '0' || array.get(i).charAt(n) == '1' || array.get(i).charAt(n) == '2' || array.get(i).charAt(n) == '3' || array.get(i).charAt(n) == '4' || array.get(i).charAt(n) == '5' || array.get(i).charAt(n) == '6' || array.get(i).charAt(n) == '7' || array.get(i).charAt(n) == '8' || array.get(i).charAt(n) == '9') {
                    temp += array.get(i).charAt(n);
                    System.out.println(array.get(i).charAt(n));
                }
                if (array.get(i).charAt(n) == ' ' && Character.isDigit(array.get(i).charAt(n - 2)) && Character.isLetter(array.get(i).charAt(n + 1))) {
                    int tempNumber = Integer.parseInt(temp);
                    System.out.println("test" + tempNumber);
                    // Adjust the conditions based on your intended logic
                    if ((array.get(i).charAt(n + 1) == 'r' && tempNumber <= 12) || (array.get(i).charAt(n + 1) == 'g' && tempNumber <= 13) || (array.get(i).charAt(n + 1) == 'b' && tempNumber <= 14)) {
                        System.out.println("test 2" + temp);
                        temp = "";
                        System.out.println("test 3" + "." + temp);
                    } else {
                        System.out.println("test 8" + temp + " " + tempNumber);
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

    public static int day3(char[][] array){
        int total = 0;
        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[row].length; col ++){
                if(array[row][col] != '.' && Character.isDigit(array[row][col])){
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
            }
        }
        return 1;
    }
    public static String numberFinderday3(char [] array, int index){
        return "";
    }
}
