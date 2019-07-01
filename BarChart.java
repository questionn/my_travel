package com.tom.test;


import javafx.scene.chart.PieChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChart {
    ChartPanel frame1;

    public BarChart() {
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                "水果",    //图标的标题
                "水果种类", //横轴的显示标签
                "数量",   //数轴的显示标签
                dataset,   //数据集
                PlotOrientation.VERTICAL,  //图标方向   水平垂直
                true,  //是否显示图例   简单的柱状图 为  false
                false,   //是否生成工具
                true  //是否生成连接
        );

        //设置字体  ，解决中文乱码
        CategoryPlot categoryPlot = chart.getCategoryPlot();//获取图表区域的对象
        CategoryAxis domainAxis = categoryPlot.getDomainAxis(); //获取底部的列表
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));  //水平底部标题  格式
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis = categoryPlot.getRangeAxis();//获取  柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15)); //
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,15)); //
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));  //设置标题字体


        frame1 = new ChartPanel(chart,true);
    }

    private static CategoryDataset getDataSet(){
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(100,"北京","荔枝");
        defaultCategoryDataset.addValue(320,"北京","苹果");
        defaultCategoryDataset.addValue(340,"上海","苹果");
        defaultCategoryDataset.addValue(220,"北京","香蕉");
        defaultCategoryDataset.addValue(340,"西安","荔枝");
        defaultCategoryDataset.addValue(300,"西安","荔枝");
        defaultCategoryDataset.addValue(140,"北京","苹果");
        defaultCategoryDataset.addValue(133,"北京","香蕉");
        defaultCategoryDataset.addValue(130,"上海","香蕉");
        defaultCategoryDataset.addValue(440,"西安","苹果");
        defaultCategoryDataset.addValue(540,"上海","荔枝");
        return defaultCategoryDataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("统计");
        frame.setLayout(new GridLayout(2,3,10,10));
        frame.add(new BarChart().getChartPanel());
        frame.setBounds(50,50,800,600);
        frame.setVisible(true);
    }
}
