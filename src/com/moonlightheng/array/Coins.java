/*
 * Coins.java
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
public class Coins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] b = {1,2,5};
		int a= getResult(100,b);
		System.out.println(a);
	}
	static int getResult(int n,int[] coins) {
		 
	    int[] a = new int[n+1];
	 
	    for(int i = 0; i <= n;i++)
	        a[i] = 0;
	 
	    a[0] = 1;
	 
	    for(int j = 0; j<coins.length; j++)
	        for(int i = 0; i <= n;i++)        
	             a[i+coins[j]] += a[i]; 
	 
	    return a[n];
	 
	}

}
