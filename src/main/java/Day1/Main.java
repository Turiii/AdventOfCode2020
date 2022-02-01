package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static int searchForTwoNumbers(ArrayList<Integer> numbers) {
        int value = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int x = 2020 - numbers.get(i);
            if (numbers.contains(x)) {
                value = numbers.get(i) * x;
            }
        }
        return value;
    }

    public static int searchForThreeNumbers(ArrayList<Integer> numbers){
        int value = 0;
        int remain = 0;
        for (int i = 0; i < numbers.size(); i++) {

        }
        return value;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day1.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            numbers.add(scanner.nextInt());
        }

        System.out.println(searchForTwoNumbers(numbers));
    }
}
