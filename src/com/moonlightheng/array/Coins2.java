/*
 * Coins2.java
 *
 * Copyright 2013 Baidu Inc.
 * All rights reserved.
 * 
 * Created on 2013-5-17
 */
package com.moonlightheng.array;

/**
 * 功能概述：<br>
 *
 * @author 张珩
 */
public class Coins2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] b = {1,2,5};
		int a= getResult(100,b,0);
		System.out.println(a);
	}
	static int getResult(int n,int[] coins, int i) {
	    if (n == 0) return 1;
	    if (n < 0 || i >= coins.length) return 0;
	    System.out.println("coins[i] "+coins[i]+"i "+i);
	    int used = getResult(n - coins[i], coins, i);
	    int notUsed = getResult(n, coins, i + 1);
	    return used + notUsed;
	}


}
