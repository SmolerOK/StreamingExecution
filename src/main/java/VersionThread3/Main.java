package VersionThread3;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private final static double[] mainArr = new double[1_000_000];

    public static void main(String[] args) throws InterruptedException {
        createThread(1);
        createThread(2);
        createThread(3);

        Thread.sleep(1000);

        try (FileWriter writer = new FileWriter("C:\\Users\\Sergei\\IdeaProjects\\StreamingExecution\\src\\main\\java\\VersionThread3\\Text.txt", false)) {
            for (int i = 0; i < mainArr.length; i++) {
                writer.write(i + " = " + mainArr[i] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createThread(int threadNum) {
        new Thread(() -> {
            int count = mainArr.length / 3;
            for (int i = 0; i < count; i++) {
                int arrIndex = mainArr.length - count * threadNum + i;
                mainArr[arrIndex] = Math.sqrt(arrIndex);
            }
        }).start();
    }
}