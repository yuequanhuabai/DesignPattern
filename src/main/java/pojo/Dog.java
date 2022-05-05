package pojo;

public class Dog {
    public int age;
    public String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Dog() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isFiveAge(Dog dog){
        return 5==dog.getAge();
    }

    public  static  boolean isName(Dog dog){
        return "DogB"==dog.getName();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}
