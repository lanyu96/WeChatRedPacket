package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * 模拟微信随机红包功能
 */
public class Demo1 {
	public static void main(String[] args) {
		/*
		 * count 红包总数 total 红包总金额 totalNum 已发出的红包金额 max 单个红包最大金额 min 单个红包最小金额
		 * 
		 */
		System.out.println("请输入要发送的红包总金额:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		double d1 = sc.nextDouble();// 将红包金额限定在小数点后两位数
		double total = Double.parseDouble(df.format(d1));
		System.out.println("请输入要发送的红包个数");
		int count = sc.nextInt();
		int countFor = 0;// 计数器,统计程序一共执行了几次
		ArrayList<Double> al = new ArrayList<>();
		RandomRedPacket rrp = new RandomRedPacket(df, total, count, countFor);
//		al = randomRedPacket(df, total, count);
		while (true) {
			al = rrp.RedPacket();
			if (al.size() > 2) {// 如果红包不是单个或者两个则执行下面操作
				double maxtotal = total * 0.6;// 限制单个红包

				if (al.get(0) >= maxtotal || al.get(1) >= maxtotal) {
					al = rrp.RedPacket();
				} else {
					break;
				}
			} else {
				break;
			}
		}
		// 遍历输出红包
		PrintMoney pm = new PrintMoney(df, al);
		pm.print();
	}
}
