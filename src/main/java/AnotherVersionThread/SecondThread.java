package AnotherVersionThread;

public class SecondThread extends Thread {
    MainThread mainThread = new MainThread();

    @Override
    public void run() {
        System.out.println("Второй поток запущен...");
        double[] getCount = mainThread.getCount();
        for (int i = 500_000; i <= 1_000_000; i++) {
            getCount[i - 1] = i;
            double result = Math.sqrt(getCount[i - 1]);
            getCount[i - 1] = result;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Второй поток завершился.");
    }
}
