package EducationThread;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StreamingExecution {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        double[] arrayFirst = new double[250_000];
        double[] arrayTwo = new double[500_000];
        double[] arrayThree = new double[750_000];
        double[] arrayFour = new double[1_000_000];

        System.out.println("Start!");

        CalculatingRoot(arrayFirst, arrayTwo);

        CalculatingRoot(arrayThree, arrayFour);

        try (FileWriter fileWriter =
                     new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt", false)) {
            System.out.println("Print...");
            for (int i = 0; i < 1_000_000; i++) {
                if (i < 250_000) fileWriter.write("√" + (i + 1) + " = " + arrayFirst[i] + "\n");
                else if (i >= 250_000 && i < 500_000) fileWriter.write("√" + (i + 1) + " = " + arrayTwo[i] + "\n");
                else if (i < 750_000) fileWriter.write("√" + (i + 1) + " = " + arrayThree[i] + "\n");
                else fileWriter.write("√" + (i + 1) + " = " + arrayFour[i] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End!");

        long end = System.currentTimeMillis();

        System.out.println("Время выполнения работы длилось - " + (end - start) + " мс.");
    }

    private static void CalculatingRoot(double[] arrayListA, double[] arrayListB) {
        new Thread(() -> {
            for (int i = 0; i <= arrayListA.length - 1; i++) {
                arrayListA[i] = i;
                double result = Math.sqrt(arrayListA[i]);
                arrayListA[i] = result;
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= arrayListB.length - 1; i++) {
                arrayListB[i] = i;
                double result = Math.sqrt(arrayListB[i]);
                arrayListB[i] = result;
            }
        }).start();
    }
}
