package AnotherVersionThread;

public class FirstThread extends Thread {
    MainThread mainThread = new MainThread();

    @Override
    public void run() {
        System.out.println("Первый поток запущен...");
        double[] getCount = mainThread.getCount();
        for (int i = 0; i < 500_000; i++) {

            getCount[i] = i + 1;
            double result = Math.sqrt(getCount[i]);
            getCount[i] = result;

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Первый поток завершился.");
    }
}
