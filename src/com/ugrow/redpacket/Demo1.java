package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * ģ��΢������������
 */
public class Demo1 {
	public static void main(String[] args) {
		/*
		 * count ������� total ����ܽ�� totalNum �ѷ����ĺ����� max ������������ min ���������С���
		 * 
		 */
		System.out.println("������Ҫ���͵ĺ���ܽ��:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		double d1 = sc.nextDouble();// ���������޶���С�������λ��
		double total = Double.parseDouble(df.format(d1));
		System.out.println("������Ҫ���͵ĺ������");
		int count = sc.nextInt();
		int countFor = 0;// ������,ͳ�Ƴ���һ��ִ���˼���
		ArrayList<Double> al = new ArrayList<>();
		RandomRedPacket rrp = new RandomRedPacket(df, total, count, countFor);
//		al = randomRedPacket(df, total, count);
		while (true) {
			al = rrp.RedPacket();
			if (al.size() > 2) {// ���������ǵ�������������ִ���������
				double maxtotal = total * 0.6;// ���Ƶ������

				if (al.get(0) >= maxtotal || al.get(1) >= maxtotal) {
					al = rrp.RedPacket();
				} else {
					break;
				}
			} else {
				break;
			}
		}
		// ����������
		PrintMoney pm = new PrintMoney(df, al);
		pm.print();
	}
}
