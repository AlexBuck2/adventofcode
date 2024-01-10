import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String input = "Time:        35     69     68     87\n" +
                "Distance:   213   1168   1086   1248";

        ArrayList<String> test = new ArrayList<String>(arrayMaker(input));
      //  System.out.println("day 6: " + day6(test));
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

        int total = 1;
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

            int time1 = Integer.parseInt(times.toString());
            int distance1 = Integer.parseInt(distances.toString());
            System.out.println(time1);
            System.out.println(distance1);

            for(int i = 0; i < time1; i++){
                //i = charge
                int timeToTravel = time1-1;
                if((i * timeToTravel) > distance1){
                    total +=1;
                }
            }
            return total;
    }
}
