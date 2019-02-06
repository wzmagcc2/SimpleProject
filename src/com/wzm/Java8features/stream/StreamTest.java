package com.wzm.Java8features.stream;

import com.wzm.entity.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    //Stream 的 of 方法使用一组初始值生成新的 Stream

    //collect通过stream的值生成一个列表
    //及早求值
    @Test
    public void collectTest(){
        List<String> list1 = Stream.of("a","b","c").collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

    //map将一种类型的流转换为另一种类型的流
    //惰性求值
    @Test
    public void mapTest(){
        List<String> list1 = Stream.of("a","wzm","HelloWorld")
                .map(String::toUpperCase).collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

    //filter过滤出符合条件的元素的一个流
    @Test
    public void filterTest(){
        List<String> list1 = Stream.of("a","wzm","HelloWorld")
                .filter( value -> 'w'==value.charAt(0))
                .collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

    //flatMap将一种类型流转换为另一种类型流并做合并流处理


    //max和min
    @Test
    public void maxAndMinTest(){
        List<String> list1 = Stream.of("a","wzm","HelloWorld").collect(Collectors.toList());
        String max = list1.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("长度最长字符是："+max);
        String min = list1.stream().min(Comparator.comparing(String::length)).get();
        System.out.println("长度最短字符是：" + min);
    }

    //reduce可以实现累计处理结果
    @Test
    public void reduceTest(){
        int count = Stream.of(1,4,7).reduce(0,(result,value)-> result+value);
        System.out.println("求值结果为：" + count);
    }

    //整合操作
    @Test
    public void streamFilterTest(){

        User user1 = new User();
        user1.setName("wzm");
        user1.setAge(20);
        user1.setSex("男");
        user1.setIntro("上海");

        User user2 = new User();
        user2.setName("zwj");
        user2.setAge(20);
        user2.setSex("女");
        user2.setIntro("北京");

        User user3 = new User();
        user3.setName("bj");
        user3.setAge(22);
        user3.setSex("女");
        user3.setIntro("上海");

        //找出所有在上海生活，年龄不超过22岁的姓名有哪些？
        Stream.of(user1,user2,user3)
                .filter(user -> "上海".equals(user.getIntro()))
                .filter(user -> user.getAge()<=22)
                .map(User::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /*long result1 = Stream.of(user1,user2,user3).filter((user) -> {
         if(20==user.getAge()){
             return true;
         }else{
             return false;
         }
        }).count();

        System.out.println(result1);

        List<User> result2 = Stream.of(user1,user2,user3).filter((user) -> {
            if("上海".equals(user.getIntro())){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());

        result2.forEach((user) -> System.out.println(user.getName()));*/
    }
}
