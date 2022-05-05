package test;

import pojo.Dog;

public class Print2 implements TestDog2{
    @Override
    public String print(Dog dog) {
        String name = dog.getName();
        String msg = "a dog name :"+name;
        return msg;
    }
}
