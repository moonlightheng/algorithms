/*
 * dd.java
 *
 * Copyright 2013 Baidu Inc.
 * All rights reserved.
 * 
 * Created on 2013-3-27
 */
package com.moonlightheng.sort;

/**
 * 功能概述：<br>
 *
 * @author 张珩
 */

import java.util.Comparator;

public class Minimum {

	public static <T> T minimum(T[] t, Comparator<? super T> comparator) {
		T min = t[0];
		for (int i = 1; i < t.length; i++)
			if (comparator.compare(min, t[i]) > 0)
				min = t[i];
		return min;
	}

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 31, 41, 59, 26, 41, 58 };
		Integer min = minimum(ints, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});
		System.out.println(min);
	}
}
