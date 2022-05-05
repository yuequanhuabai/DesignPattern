package com.design.pattern;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Command
 * @Description 描述
 * @Author YuequanHuabai
 * @Date 2021/7/22 20:42
 * @Version 1.0
 **/
public class Command {
    static class Student{
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        private String id;

        private int age;

        private String name;

    }


    public static void main(String[] args) {


        Student student;
        String name ="name";
        List<Student> list = new ArrayList();
        for(int i=0;i<10;i++){
            student=new Student();
            student.setName(name+i);
            student.setAge(i);
            student.setId(UUID.randomUUID().toString());
            list.add(student);
        }
        Student student1 = new Student();
        student1.setName("是快递费");
        Student student2 = new Student();
        student2.setName("递费");
        list.add(student1);
        list.add(student2);

        List<String> collect = list.parallelStream().map(Student::getName).collect(Collectors.toList());

        Map<String ,String > map = new HashMap();
        collect.stream().forEach(e->{
            String first = PinYinUtil.first(e);
            map.put(e,first);
        });



        // 根据value分组；
        Map<String, List<Map.Entry<String, String>>> collect1 = map.entrySet().stream().collect(Collectors.groupingBy(e -> e.getValue()));
        System.out.println("collect1.size(): "+collect1.size());


        Set<String> strings2 = collect1.keySet();
        Map<String,List<String>> map1 = new HashMap();

        for (String key: strings2){
            List<Map.Entry<String, String>> entries2 = collect1.get(key);
//            Set set1 = new HashSet();
            List list1 = new ArrayList();
            System.out.println("haha");
            entries2.stream().forEach(a->{
                System.out.println("baba");
                String key1 = a.getKey();
                list1.add(key1);
            });
            map1.put(key,list1);
        }

        Map map2 = new HashMap();
        for (int i = 0; i < 26; i++) {
            char a = (char) (65+i);
            System.out.println(a);
            String s = Character.toString(a);
            if(map1.keySet().contains(s)){
                map2.put(s,map1.get(s));
            }else {
                map2.put(s,new ArrayList<String>());
            }
        }

        System.out.println("排序后的数据：");








    }
}
