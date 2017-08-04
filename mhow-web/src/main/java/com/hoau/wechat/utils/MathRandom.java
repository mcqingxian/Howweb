package com.hoau.wechat.utils;

public class MathRandom {
	/**
	 * 5出现的概率为%74
	 */
	public static double rate0 = 0.74;
	/**
	 * 10出现的概率为%21
	 */
	public static double rate1 = 0.21;
	/**
	 * 20出现的概率为%15
	 */
	public static double rate2 = 0.03;
	/**
	 * 50出现的概率为%10
	 */
	public static double rate3 = 0.015;
	/**
	 * 100出现的概率为%4
	 */
	public static double rate4 = 0.005;
	
	/**
	 * Math.random()产生一个double型的随机数，判断一下 例如0出现的概率为%50，则介于0到0.50中间的返回0
	 * 
	 * @return int
	 * 
	 */
	public static int PercentageRandom() {
		double randomNumber;
		randomNumber = Math.random();
		if (randomNumber >= 0 && randomNumber <= rate0) {
			return 0;
		} else if (randomNumber >= rate0  && randomNumber <= rate0 + rate1) {
			return 1;
		} else if (randomNumber >= rate0 + rate1
				&& randomNumber <= rate0 + rate1 + rate2) {
			return 2;
		} else if (randomNumber >= rate0 + rate1 + rate2
				&& randomNumber <= rate0 + rate1 + rate2 + rate3) {
			return 3;
		} else if (randomNumber >= rate0 + rate1 + rate2 + rate3
				&& randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4) {
			return 4;
		}
		return -1;
	}

	/**
	 * 测试主程序
	 * 
	 * @param agrs
	 */
	public static void main(String[] agrs) {
		int[] number = {5,10,20,50,100};
		int no = 0;
		int count1=0,count2=0,count3=0,count4=0,count5=0;
		for (int i = 0; i <= 1000; i++)// 打印100个测试概率的准确性
		{
			no = number[PercentageRandom()];
			if(no==5){
				count1++;
			}else if(no==10){
				count2++;
			}else if(no==20){
				count3++;
			}else if(no==50){
				count4++;
			}else if(no==100){
				count5++;
			}
			System.out.println(no);
		}
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
		System.out.println(count5);
	}
}