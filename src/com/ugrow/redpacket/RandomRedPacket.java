package com.ugrow.redpacket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * 获取要发的红包的总金额和要发的红包的个数,随机分发红包金额
 */
public class RandomRedPacket {
	DecimalFormat df;
	double total;
	int count;
	int countFor;
	double min = 0.01;
	double max = total - min * count;
	Random rd = new Random();// 创建随机数
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
			if (i == count - 1) {// 当发到最后一个红包时,将剩余所有金额放置到最后红包里
				tl = Double.parseDouble(df.format(total - totalNum));
				al.add(tl);
				break;
			} else if (total - totalNum == min * (count - i)) {
				// 当剩余金额只能够给没人发最小的金额时,平均每人min个金额,然后break
				for (int j = i; j < count; j++) {
					al.add(min);
				}
				break;
			} else { // 正常情况
				al.add(tl);
				totalNum += tl;
			}
		}
		countFor++;

		return al;
	}

}
