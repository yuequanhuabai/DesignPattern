package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestService {

    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            final int ii =i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(1000);
                        semaphore.release();
                        System.out.println("i="+ii+",进来了"+Thread.currentThread().getName()+","+(System.currentTimeMillis()-start)+"ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        threadPool.shutdown();

    }
}
