package design;

import test.TestDog2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test2Impl implements Test2 {
    @Override
    public void process(Runnable r) {
        r.run();
    }

    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\resource\\唐门.txt"))) {
            String s = null;
            while (br != null) {

                s = br.readLine();

                System.out.println(s);
            }

            return s;
        }
    }

    public static void main(String[] args) throws IOException {

//        String s = processFile((BufferedReader br) -> br.readLine() + br.readLine());
//        processFile();
        String s = processFile((BufferedReader b) ->
                b.readLine()+b.readLine()
        );
        while (true){
            if(s !=null){
                System.out.println(s);
            }
        }



//        new Test2Impl().process( ()-> System.out.println("当前线程名称："+Thread.currentThread().getName()));
    }

    private static String processFile(BufferedReaderProcessor b) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("D:\\resource\\唐门.txt"))
        ) {
            return b.process(br);
        }

    }
}
