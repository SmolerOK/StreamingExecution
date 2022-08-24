package EducationThread;

import java.io.FileWriter;
import java.io.IOException;

public class StreamingExecution {
    public static void main(String[] args) {
        double[] arrayFirst = new double[250_000];
        double[] arrayTwo = new double[250_000];
        double[] arrayThree = new double[250_000];
        double[] arrayFour = new double[250_000];

        CalculatingRoot(arrayFirst, arrayTwo);

        CalculatingRoot(arrayThree, arrayFour);

        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt", true)) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void CalculatingRoot(double[] arrayListA, double[] arrayListB) {
        new Thread(() -> {
            for (int i = 0; i < arrayListA.length; i++) {
                double result = Math.sqrt(arrayListA[i]);
                arrayListA[i] = result;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < arrayListB.length; i++) {
                double result = Math.sqrt(arrayListB[i]);
                arrayListB[i] = result;
            }
        }).start();
    }
}
