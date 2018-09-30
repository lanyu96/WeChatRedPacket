package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * ����������,��������ķ�����print
 */
public class PrintMoney {
	int num1 = 1;// ����ڼ������
	double countZ = 0;// ��ʱ��¼����ܽ����,�����Գ���ʹ��
	private ArrayList<Double> al;
	private DecimalFormat df;

	public PrintMoney(DecimalFormat df, ArrayList<Double> al) {
		this.al = al;
		this.df = df;
	}

	public void print() {
		for (Double d : al) {
			d = Double.parseDouble(df.format(d));
			System.out.println("��" + num1 + "��������Ϊ:" + d);
			num1++;
			countZ += d;
			countZ = Double.parseDouble(df.format(countZ));
		}
		System.out.println("����ܽ��Ϊ:" + countZ);
	}

}
