package EducationThread;

public class StreamingExecution {
    public static void main(String[] args) {
        int fixValue = 250_000;
        for (int thread = 0; thread < 4; thread++) {
            int start = fixValue * thread;
            int end = start + fixValue;
            new Thread(() -> {
                for (int i = start; start < end; i++) {
                    double result = Math.sqrt(i);


                }
            });
        }
    }
}
