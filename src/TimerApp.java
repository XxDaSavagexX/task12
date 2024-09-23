public class TimerApp {
    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println("Час з моменту запуску: " + elapsedTime + " секунд");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread notifyThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeThread.start();
        notifyThread.start();
    }
}
