
//部分代码
package com.tom.myspring;

public class XmlShapeCompute {
    private Circular circular;
    private Rectangle rectangle;
    private Triangle triangle;
    public Object compute(String shapeName) {
        if (shapeName == null || shapeName.length() == 0) {
            throw new IllegalArgumentException("Not found " + shapeName);
        }
        if (shapeName.equals("circular")) {
            return circular;
        }
        if (shapeName.equals("rectangle")) {
            return rectangle;
        }
        if (shapeName.equals("triangle")) {
            return triangle;
        }
        throw new IllegalArgumentException("Not found " + shapeName);
    }
    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
    public void setCircular(Circular circular) {
        this.circular = circular;
    }

    public Circular getCircular() {
        return circular;
    }
}

//spring容器
<?xml version="1.0" encoding="ISO-8859-1"?>

<beans xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:cache="http://www.springframework.org/schema/cache"
       xsi:schemaLocation="
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd

    http://www.springframework.org/schema/cache
    http://www.springframework.org/schema/cache/spring-cache-3.1.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd
    http://www.springframework.org/schema/util
    http://www.springframework.org/schema/util/spring-util.xsd">

    <bean id="circular" class="com.tom.myspring.Circular">
        <constructor-arg name="radius" value="29">
        </constructor-arg>
    </bean>

    <bean id="rectangle" class="com.tom.myspring.Rectangle">
        <constructor-arg name="width" value="12"></constructor-arg>
        <constructor-arg name="height" value="19"></constructor-arg>
    </bean>

    <bean id="Triangle" class="com.tom.myspring.Triangle">
        <constructor-arg name="a" value="12"></constructor-arg>
        <constructor-arg name="b" value="12"></constructor-arg>
        <constructor-arg name="c" value="11"></constructor-arg>
    </bean>

    <bean id="xmlShapeCompute" class="com.tom.myspring.XmlShapeCompute">
        <property name="circular" ref="circular"/>
        <property name="rectangle" ref="rectangle"/>
        <property name="triangle" ref="Triangle"/>
    </bean>
    
</beans>


//spring测试
package tom;

import com.tom.myspring.Circular;
import com.tom.myspring.XmlShapeCompute;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testMethod(){
        XmlShapeCompute c = (XmlShapeCompute)applicationContext.getBean("xmlShapeCompute");
        System.out.println("面积 = "+ c.getCircular().getRadius());
    }
}

