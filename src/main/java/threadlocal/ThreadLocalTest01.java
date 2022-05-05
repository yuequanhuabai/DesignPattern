package threadlocal;

import java.util.stream.IntStream;

public class ThreadLocalTest01 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        IntStream.range(0, 10).forEach(i -> new Thread(
                () -> {
                    int a =i;
                    System.out.println("原来threadName：" + Thread.currentThread().getName() +":"+ a);
                    threadLocal.set(Thread.currentThread().getName() + ":" + a);
                    System.out.println("=============后来的threadName："  + threadLocal.get());
                }
        ).start());
    }

}
