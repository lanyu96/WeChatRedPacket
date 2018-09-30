package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 遍历输出红包,调用输出的方法是print
 */
public class PrintMoney {
	int num1 = 1;// 定义第几个红包
	double countZ = 0;// 临时记录红包总金额数,供测试程序使用
	private ArrayList<Double> al;
	private DecimalFormat df;

	public PrintMoney(DecimalFormat df, ArrayList<Double> al) {
		this.al = al;
		this.df = df;
	}

	public void print() {
		for (Double d : al) {
			d = Double.parseDouble(df.format(d));
			System.out.println("第" + num1 + "个红包金额为:" + d);
			num1++;
			countZ += d;
			countZ = Double.parseDouble(df.format(countZ));
		}
		System.out.println("红包总金额为:" + countZ);
	}

}
