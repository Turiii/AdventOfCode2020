package Day2;

public class Policy {
    private int positionA;
    private int positionB;
    private char letter;

    public Policy(int min, int max, char letter) {
        this.positionA = min;
        this.positionB = max;
        this.letter = letter;
    }

    public int getPositionA() {
        return positionA;
    }

    public int getPositionB() {
        return positionB;
    }

    public char getLetter() {
        return letter;
    }
}
