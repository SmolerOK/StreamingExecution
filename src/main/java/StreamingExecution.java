import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StreamingExecution {

    public static void main(String[] args) throws InterruptedException {
        RootNumber rootNumber = new RootNumber();
        rootNumber.start();
        rootNumber.join();

        System.out.println("Вычисление закончено!");
    }
}

class RootNumber extends Thread {
    private static final Object lock = new Object();
    File file = new File("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt");

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            synchronized (lock) {
                for (double i = 1; i <= 1_000_000; i++) {
                    String result = "√" + i + " = " + Math.sqrt(i) + "\n";
                    fileWriter.write(result);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}