package test;

import org.junit.Test;

public class ThreadLocalTest {

    private  static final ThreadLocal<String> threadLocalName= ThreadLocal.withInitial(()->Thread.currentThread().getName());
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println("ThreadName: "+threadLocalName+  "    ===   " +threadLocalName.get());

            }
            ,"        yuequanhuabai-"+i
            ).start();
        }
    }

    @Test
    public  void test(){
        String name = Thread.currentThread().getName();
        System.out.println("name: "+name);
        Runnable aNew = ThreadLocalTest::new;
    }

}
