package Day3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int treeCounter(ArrayList<String> map, int option) {
        Point point = new Point(0, 0);
        int counter = 0;
        for (int i = 0; i < map.size() - 1; i++) {
            Point pointAfterChange = command(point, option);
            point.setLocation(pointAfterChange.x, pointAfterChange.y);
            if (point.y < map.size()) {
                char[] chars = map.get(point.y).toCharArray();
                if (chars[pointAfterChange.x] == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static Point command(Point point, int option) {
        Point newPoint = point;
        switch (option) {
            case 1:
                newPoint.setLocation(point.x + 1, point.y + 1);
                break;
            case 2:
                newPoint.setLocation(point.x + 3, point.y + 1);
                break;
            case 3:

                newPoint.setLocation(point.x + 5, point.y + 1);
                break;
            case 4:
                newPoint.setLocation(point.x + 7, point.y + 1);
                break;
            case 5:
                newPoint.setLocation(point.x + 1, point.y + 2);
                break;
        }
        return newPoint;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day3.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> map = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().repeat(100);
            map.add(line);
        }

        for (String line :
                map) {
            System.out.println(line);
        }

        long multiply = 1;

        for (int i = 1; i <= 5; i++) {
            int value = treeCounter(map, i);
            multiply *= value;
            System.out.println("Trees encounter: " + value);
        }

        System.out.println("Answer: " + multiply);

    }
}
