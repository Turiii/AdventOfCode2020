package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int checkFirstSeven(String line) {
        char[] chars = line.toCharArray();
        int start = 0;
        int end = 127;
        int row = 0;
        for (int i = 0; i < 7; i++) {
            if (chars[i] == 'F') {
                end = (start + end) / 2;
//                System.out.println("F -> start: " + start + ", end: " + end);
            }
            if (chars[i] == 'B') {
                start = (start + end) / 2 + 1;
//                System.out.println("B -> start: " + start + ", end: " + end);
            }
            if (start == end) {
                row = start;
            }
        }
        return row;
    }

    public static int checkLastThree(String line) {
        char[] chars = line.toCharArray();
        int start = 0;
        int end = 7;
        int column = 0;
        for (int i = 7; i < 10; i++) {
            if (chars[i] == 'R') {
                start = (start + end) / 2 + 1;
//                System.out.println("R -> start: " + start + ", end: " + end);
            }
            if (chars[i] == 'L') {
                end = (start + end) / 2;
//                System.out.println("L -> start: " + start + ", end: " + end);
            }
            if (i == 9) {
                if (chars[i] == 'R') {
                    column = end;
                } else column = start;
            }
        }
        return column;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day5.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        int max = 0;
        for (String line :
                lines) {
            int row = checkFirstSeven(line);
            int column = checkLastThree(line);
            int seatID = row * 8 + column;
            if (seatID > max) {
                max = seatID;
            }
            System.out.println("row: " + row +
                    ", column: " + column +
                    ", seat ID: " + seatID);
        }
        System.out.println("Highest seat ID: " + max);
    }
}
