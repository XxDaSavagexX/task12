import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzMultithreading {
    private final int n;
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzzMultithreading(int n) {
        this.n = n;
    }

    public void fizz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                try {
                    queue.put("fizz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void buzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                try {
                    queue.put("buzz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fizzbuzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                try {
                    queue.put("fizzbuzz");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void number() {
        for (int i = 1; i <= n; i++) {
            try {
                if (i % 3 != 0 && i % 5 != 0) {
                    queue.put(Integer.toString(i));
                }
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int n = 15;

        FizzBuzzMultithreading fizzBuzz = new FizzBuzzMultithreading(n);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
