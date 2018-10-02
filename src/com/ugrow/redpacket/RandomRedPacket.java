package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * ��ȡҪ���ĺ�����ܽ���Ҫ���ĺ���ĸ���,����ַ�������
 */
public class RandomRedPacket {
	DecimalFormat df;
	double total;
	int count;
	int countFor;
	double min = 0.01;
	double max = total - min * count;
	Random rd = new Random();// ���������
	double tl;
	double totalNum = 0;

	public RandomRedPacket(DecimalFormat df, double total, int count, int countFor) {
		super();
		this.df = df;
		this.total = total;
		this.count = count;
		this.countFor = countFor;
	}

	public ArrayList<Double> RedPacket() {
		ArrayList<Double> al = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			tl = rd.nextDouble() * (total - totalNum - min * (count - i));
			tl = Double.parseDouble(df.format(tl));
			if (i == count - 1) {// ���������һ�����ʱ,��ʣ�����н����õ��������
				tl = Double.parseDouble(df.format(total - totalNum));
				al.add(tl);
				break;
			} else if (total - totalNum == min * (count - i)) {
				// ��ʣ����ֻ�ܹ���û�˷���С�Ľ��ʱ,ƽ��ÿ��min�����,Ȼ��break
				for (int j = i; j < count; j++) {
					al.add(min);
				}
				break;
			} else { // �������
				al.add(tl);
				totalNum += tl;
			}
		}
		countFor++;

		return al;
	}

}
