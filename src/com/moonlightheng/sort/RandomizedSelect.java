/*
 * RandomizedSelect.java
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
import java.util.Random;

public class RandomizedSelect {

	public static <T> int partition(T[] a, Comparator<? super T> c, int p, int r) {
		T t = a[r - 1];
		int i = p - 1;
		for (int j = p; j < r - 1; j++) {
			if (c.compare(a[j], t) <= 0) {
				i++;
				T tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		T tmp = a[i + 1];
		a[i + 1] = a[r - 1];
		a[r - 1] = tmp;
		return i + 1;
	}

	public static <T> int randomizedPartition(T[] a, Comparator<? super T> c, int p, int r) {
		int i = new Random().nextInt(r - p) + p;
		T tmp = a[i];
		a[i] = a[r - 1];
		a[r - 1] = tmp;
		return partition(a, c, p, r);
	}

	public static <T> T randomizedSelect(T[] t, Comparator<? super T> comparator, int p, int r, int i) {
		if (p == r)
			return t[p];
		int q = randomizedPartition(t, comparator, p, r);
		int k = q - p + 1;
		if (i <= k)
			return randomizedSelect(t, comparator, p, q, i);
		else
			return randomizedSelect(t, comparator, q + 1, r, i - k);
	}

	public static <T> T randomizedSelect(T[] t, Comparator<? super T> comparator, int i) {
		return randomizedSelect(t, comparator, 0, t.length, i);
	}

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 31, 41, 59, 26, 41, 58 };
		Integer positiong = randomizedSelect(ints, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		}, 3);
		System.out.println(positiong);

	}
}
