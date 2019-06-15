package com.tom.set;

import java.util.*;

/**
 * HashSet底层是HashMap
 * 向HashSet中添加元素，实际上是把该元素作为键添加到HashMap中
 * HashSet就是HashMap的键的集合
 *
 *
 * TreeSet
 *     TreeSet实现了SortedSet接口，可以对元素进行自然排序，要求集合中的元素必须是可比较的
 *         在创建TreeSet接口时，可以指定Comparator比较器
 *         在没有指定比较器的情况下，要求元素的类必须实现Comparable接口
 *     TreeSet底层是TreeMap
 *          向TreeSet中添加元素就相当于将元素作为键，添加到TreeMap中
 *          TreeSet就是TreeMap键的集合
 */
class Student{
    String stuNu;//学号
    String name;//姓名
    int score;//成绩

    public Student(String stuNu, String name, int score) {
        this.stuNu = stuNu;
        this.name = name;
        this.score = score;
    }

    public String getStuNu() {
        return stuNu;
    }

    public void setStuNu(String stuNu) {
        this.stuNu = stuNu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                Objects.equals(stuNu, student.stuNu) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNu, name, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNu='" + stuNu + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
public class SetTest {
    //HashSet
    public void MyHashSet() {
        Set<String> set = new HashSet<>();

        set.add("haha");
        set.add("hahb");
        set.add("hahc");
        set.add("hahd");
        set.add("haha");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("这就是1");
        hashSet.add("这就是2");
        hashSet.add("这就是3");
        hashSet.add("这就是4");

        Iterator<String> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    /*Iterator<String> iterator = set.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }*/
    }
    public static void main(String[] args) {
        String s = "01,勇哥,100;02,杜哥,95;03,明哥,90;04,菲菲,50;05,杨哥,60";
        String[] flag = s.split("[,;]"); //按照,;分

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < flag.length; i += 3) {
            list.add(new Student(flag[i], flag[i + 1], Integer.parseInt(flag[i + 2])));
        }

        //创建迭代器
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //判断是否有明哥
        boolean adjust = false;
        for (Student student : list
        ) {
            if (student.name.equals("明哥")) {
                adjust = true;
                break;
            }
        }
        if (adjust == true) {
            System.out.println("存在明哥");
        } else {
            System.out.println("不存在明哥");
        }

        //按照降序排序
        //第一种方法。使用Collections工具类   2  list.sort
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return t1.score - student.score;
            }
        });
        Iterator<Student> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        /*for (int i = 0; i < list.size() ; i++) {
            System.out.println(list.get(i));
        }*/

        //删除明哥
        Iterator<Student> iterator3 = list.iterator();
        while (iterator3.hasNext()) {
            Student s1 = iterator3.next();
            if (s1.name.equals("明哥")) {
                iterator3.remove();
            }
        }

        System.out.println("--------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------------");
        for (Student student2 : list
        ) {
            System.out.println(student2);
        }
    }
}
