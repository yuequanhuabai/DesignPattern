package test;

public class Outer {

    private  String name="tony";

    class Inner{
        public void print(){
            System.out.println(name);
        }

    }

    public void fn(){
        new Inner().print();
    }

    public static void main(String[] args) {
        new Outer().fn();
    }
}
