package mazeMinotaur;
import java.util.Scanner;

public class Hero {
    private int health;
    private int countSteps;
    private Scanner scanner = new Scanner(System.in);

    public Hero() {
        health = 10;
    }

    public int getHealth() {
        return health;
    }

    public String move() {
        String userInput;
        userInput = scanner.next();
        countSteps++;
        return userInput;
    }

    public void apply(int content) {
        health += content;
    }

    public boolean isDead() {
        if (health <= 0) {
            return true;
        }
        return false;
    }

    public boolean heroIsTired() {
        if (countSteps == 10) {
            return true;
        }
        return false;
    }
}
