package EducationThread;

import java.io.FileWriter;
import java.io.IOException;

public class StreamingExecution {
    public static void main(String[] args) {
        int[] arrayFirst = new int[250_000];
        int[] arrayTwo = new int[250_000];
        int[] arrayThree = new int[250_000];
        int[] arrayFour = new int[250_000];

        new Thread(() -> {

        }).start();

        new Thread(() -> {

        }).start();

        new Thread(() -> {

        }).start();

        new Thread(() -> {

        }).start();

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt", true)) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
