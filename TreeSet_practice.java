package com.tom.set;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 练习4：
 * 1）创建一个Product产品类，包括名称、价格、数量三个字段
 * 2）创建TreeSet集合，存储Product产品，默认为按价格升序排列，向几个中添加Product对象
 * 3）对TreeSet集合中的产品根据数量降序再次排列
 *
 * HashSet则是根据equals根据判断
 * TreeSet中不能存储重复的元素，即集合中已经存在该元素，不能再重复复添加
 * 当前TreeSet集合以价格比较，如果两个Product对象的价格一样，就不能添加（视为同一个元素）
 * add（）
 * contain（）   也是依靠什么进行比较，就看是否包含它（通过价格相等）
 *
 */

class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int number;

    public Product(String name, double price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    @Override
    public int compareTo(Product product) {    //进行默认的排序
        //Double 类型的判断  方法一
        return this.number == product.number ? 0 : (this.number - product.number > 0 ? 1 : -1);
        //Double 类型的判断  方法二
        /*if(this.price == product.price){
            return 0;
        }else if(this.price - product.price>0){
            return 1;
        }else{
            return -1;
        }*/
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                number == product.number &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, number);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
public class TreeSetTest {
    public static void main(String[] args) {
        //进行特定业务的排序  升序

       /* TreeSet<Product> treeSet = new TreeSet<>(new Comparator<Product>() {
            @Override
            public int compare(Product product, Product t1) {
               if(product.getPrice() == t1.getPrice()){
                    return 0;
                }else if(product.getPrice() - t1.getPrice() > 0){
                    return 1;
                }else{
                    return -1;
                }
            }
        });*/

       //按照数量进行排序

        TreeSet<Product> treeSet = new TreeSet<>();

        treeSet.add(new Product("hp",4800.0,12));
        treeSet.add(new Product("levno",7123.0,33));
        treeSet.add(new Product("dell",7800.0,333));
        treeSet.add(new Product("macpro",8900.0,32));
        treeSet.add(new Product("software",12300.0,132));
        Iterator<Product> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------");

        //测试TreeSet的add() contain()  方法
        treeSet.add(new Product("asus",4834,12));
        Iterator<Product> iterator1 = treeSet.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}
