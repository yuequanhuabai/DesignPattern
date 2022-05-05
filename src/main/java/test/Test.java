package test;




import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Test
{

    @org.junit.Test
    public void test1(){
//         Map<String,List<String>> map = new HashMap<>();
//        map.put("1",new ArrayList<>());
//        map.get("1").add("3");
//        String orgCode= "";
//        String s = orgCode.substring(0, 5) + "99999";
//        System.out.println(s);

//        String s2="asdf";
//
//        boolean noneBlank = StringUtils.isNoneBlank(s2);
//        System.out.println(noneBlank);

//        String s= "12345678";
//        String substring = s.substring(0, 5);
//        System.out.println(substring);

        for (int i = 0; i < 10; i++) {
            int a=10;
            System.out.println(i);
            if(a>5){
                break;
            }
        }

//        Assert.isTrue("asdf");



    }

    public static  final String[] list1 = new String[]{"123","asdf","asdf234"};


    public static void main(String[] args) {
        String arr[] = {"date"};
        List<String> list = Arrays.asList(list1);

//        arr[0]="date";

//        List<StudentInfo> studentList = new ArrayList<>();
//        studentList.add(new StudentInfo("李小明",true,18,1.76, randomDate("2019-01-01","2019-01-31")));
//        studentList.add(new StudentInfo("张小丽",false,18,1.61, randomDate("2019-01-01","2019-01-31")));
//        studentList.add(new StudentInfo("王大朋",true,19,1.82, randomDate("2019-01-01","2019-01-31")));
//        studentList.add(new StudentInfo("陈小跑",false,17,1.67, randomDate("2019-01-01","2019-01-31")));
//        System.out.println("=============");

        String s =null;
        if(StringUtils.isBlank(s)){
            System.out.println("s is null");
        }else {
            System.out.println("s not null");
        }


//        Map<String, StudentInfo> collect = studentList.stream().collect(Collectors.toMap(StudentInfo::getName, studentInfo -> studentInfo));
//        System.out.println(collect);


    }


    private static Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }


    @org.junit.Test
    public void test(){



    }

}
