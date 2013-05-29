/*
 * Matrixchain.java
 *
 * Copyright 2013 Baidu Inc.
 * All rights reserved.
 * 
 * Created on 2013-5-8
 */
package com.moonlightheng.matrix;

/**
 * 功能概述：<br>
 * 
 * @author 张珩
 */
public class MatrixChain {

	public void matrixChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;
		System.out.println(n);

		for (int i = 1; i <= n; i++) {
			m[i][i] = 0;
		}

		for (int r = 2; r <= n; r++) {
			for (int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				for (int k = i + 1; k < j; k++) {
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}

	public void traceback(int[][] s, int i, int j) {
		if (i == j) {
			return;
		}
		traceback(s, i, s[i][j]);
		traceback(s, s[i][j] + 1, j);
		System.out.println("Multiply A" + i + "," + s[i][j] + "and A" + (s[i][j] + 1) + "," + j);
	}

	public static void main(String[] args) {
		MatrixChain mc = new MatrixChain();
		int n = 7;
		int p[] = { 30, 35, 15, 5, 10, 20, 25 };
		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		mc.matrixChain(p, m, s);

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.print(m[i][j] + "     ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}

		mc.traceback(s, 1, 6);
	}
}
