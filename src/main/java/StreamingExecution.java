import java.util.ArrayList;
import java.util.List;

public class StreamingExecution {

    public static void main(String[] args) throws InterruptedException {
        List<String> rootList = new ArrayList<>(1_000_000);


        System.out.println("Вычисление закончено!");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 333_333; i++) {

        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 333_334; i <= 666_666; i++) {

        }
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        for (int i = 666_667; i <= 1_000_000; i++) {

        }
    }
}


//class RootNumber extends Thread {
//    private static final Object lock = new Object();
//    File file = new File("C:\\Users\\Sergey\\IdeaProjects\\EducationThread\\WriteText.txt");
//
//    @Override
//    public void run() {
//        try (FileWriter fileWriter = new FileWriter(file, false)) {
//            synchronized (lock) {
//                for (double i = 1; i <= 1_000_000; i++) {
//                    String result = "√" + i + " = " + Math.sqrt(i) + "\n";
//                    fileWriter.write(result);
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//}