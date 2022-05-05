package test;

import org.junit.Test;
import pojo.Dog;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestComparator {

    public final int value =4;

    public void doIt(){
        int value =6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();

    }

    public static void main(String[] args) {
        TestComparator t = new TestComparator();
        t.doIt();

    }

    @Test
    public void testComparator() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(5, "DogA"));
        list.add(new Dog(6, "DogB"));
        list.add(new Dog(7, "DogC"));



//        Collections.sort();
    }

    @Test
    public void test2() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(5, "DogA"));
        list.add(new Dog(6, "DogB"));
        list.add(new Dog(7, "DogC"));

//        List<Dog> dogs = filterDogs(list, new DogAgePredicate());
//        System.out.println("-=====-");

//        List<Dog> dogs = printDogs(list, new Print2());
        List<Dog> dogs = filterDogs(list, new DogPredicate() {
            @Override
            public boolean test(Dog dog) {
                return dog.getAge() > 5;
            }
        });
        System.out.println("==================");

        // 1.
//        List<Dog> dogs = filterDog(list, Dog::isFiveAge);
//        System.out.println(dogs);

        // 2.
//        List<Dog> dogs = filterDog(list, (Dog dog) -> 5 == dog.getAge());
//        System.out.println(dogs);

        // 3.

    }

    @Test
    public  void test3(){
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(5, "DogB"));
        list.add(new Dog(6, "DogA"));
        list.add(new Dog(7, "DogC"));

//        List<Dog> dogs = filterDogs(list, (Dog dog)->dog.getAge()>5);
//        System.out.println("==="+dogs+"====");
//        list.sort(new Comparator<Dog>() {
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                return o1.getAge().compareteTo(o2.getAge());
//            }
//        });

//        list.sort(new Comparator<Dog>() {
//
//            public int compare(Dog o1, Dog o2) {
//
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };

        Thread t = new Thread(() -> {
            System.out.println("hello World!");
            System.out.println("hello World!");
        });




        thread.start();

    }


    public static List<Dog> printDogs(List<Dog> dogList,TestDog2 predicate) {
        List<Dog> list = new ArrayList<>();
        for (Dog dog :
                dogList) {

            String print = predicate.print(dog);
            System.out.println(print);

//            }
        }
        return list;
    }

    public static List<Dog> filterDogs(List<Dog> dogList,DogPredicate predicate) {
        List<Dog> list = new ArrayList<>();
        for (Dog dog :
                dogList) {
          if(predicate.test(dog)){
              list.add(dog);
          }
        }
        return list;
    }



    public static List<Dog> filterAge(List<Dog> dogList) {
        List<Dog> list = new ArrayList<>();
        for (Dog dog :
                dogList) {
            if (5 == dog.getAge()) {
                list.add(dog);
            }
        }
        return list;
    }

    public static List<Dog> filterDog(List<Dog> dogList, Predicate<Dog> p) {
        List<Dog> list = new ArrayList<>();
        for (Dog dog : dogList) {
            if (p.test(dog)) {
                list.add(dog);
            }

        }
        return list;
    }

}
