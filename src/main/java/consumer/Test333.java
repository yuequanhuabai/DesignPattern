package consumer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test333 {

@Test
    public  void test1(){
List<? super Father> list = new ArrayList<>();
list.add(new Father());
//list.add(new Human());
//    list.add(new Son());
//    list.add(new LeiFeng());

//    Father father = list.get(0);
//    Son son = list.get(0);
    Object father = list.get(0);


}
    public static void main(String[] args) {



        // 3
        List<? extends Father> list = new LinkedList<Son>();
        list.add(null);


        List<? extends Father> fathers = new ArrayList<Father>();

        List<? extends Father> sons = new ArrayList<Son>();

        List<? extends Father> leiFengs = new ArrayList<LeiFeng>();

        List<? extends  Father> fathers1= getFatherList();
        System.out.println(fathers1);
//        System.out.println(list);
    }

    private static List<? extends Father> getFatherList() {
        List<Father> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Father());
        }
        return list;
    }



}



class Human {
}

class Father extends Human {
}

class Son extends Father {
}

class LeiFeng extends Father {
}
