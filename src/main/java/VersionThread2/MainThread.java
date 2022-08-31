package VersionThread2;

import java.io.FileWriter;
import java.io.IOException;

public class MainThread {
    static long start = System.currentTimeMillis();
    private static final double[] count = new double[1_000_000];

    public double[] getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Начало работы!");
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();

        firstThread.start();
        secondThread.start();

        Thread.sleep(3000);

        try (FileWriter writers = new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\src\\main\\java\\AnotherVersionThread\\Text.txt", false)) {
            System.out.println("Запись результата в файл...");
            int i = 1;
            for (double counts : count) {
                writers.write("√" + (i) + " = " + counts + "\n");
                i++;
            }
            System.out.println("Готово!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения работы - " + (end - start) + " ms");
    }
}
