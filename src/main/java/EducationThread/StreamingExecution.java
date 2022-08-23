package EducationThread;

import java.io.FileWriter;
import java.io.IOException;

public class StreamingExecution {
    public static void main(String[] args) {
        int fixValue = 250_000;
        for (int thread = 0; thread < 4; thread++) {
            int start = fixValue * thread;
            int end = start + fixValue;
            new Thread(() -> {
                for (int i = start; i <= end; i++) {
                    double result = Math.sqrt(i);
                    try (FileWriter fileWriter = new FileWriter("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt", true)) {
                        fileWriter.write("√" + i + " = " + result + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
