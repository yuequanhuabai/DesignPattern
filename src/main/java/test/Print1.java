package test;

import pojo.Dog;

public class Print1 implements TestDog2{
    @Override
    public String print(Dog dog) {
        String s = dog.getAge() > 5 ? "older" : "younger";
        String msg= "D "+s+" "+dog.getName()+"岁";
        return msg;
    }
}
