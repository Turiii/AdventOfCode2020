package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static boolean checkPassword(Policy policy, String password) {
        char[] chars = password.toCharArray();
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (chars[i] == policy.getLetter()) {
                counter++;
            }
        }
        return counter >= policy.getPositionA() && counter <= policy.getPositionB();
    }

    public static boolean checkPassword_v2(Policy policy, String password){
        char[] chars = password.toCharArray();
        int a = policy.getPositionA() - 1;
        int b = policy.getPositionB() - 1;
        if(password.length() > b){
            if(chars[a] == chars[b]) return false;
            else return chars[a] == policy.getLetter() || chars[b] == policy.getLetter();
        }
        return false;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day2.txt");
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            String[] minAndMax = s[0].split("-");
            int positionA = Integer.parseInt(minAndMax[0]);
            int positionB = Integer.parseInt(minAndMax[1]);
            char[] chars = s[1].toCharArray();
            char letterToCheck = chars[0];
            String password = s[2];
            char[] passwordAsChars = password.toCharArray();
            Policy passwordPolicy = new Policy(positionA, positionB, letterToCheck);
            if (checkPassword_v2(passwordPolicy, password)) {
                counter++;
                System.out.println("Correct.");
            } else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println("Amount of correct passwords: " + counter);
    }
}
