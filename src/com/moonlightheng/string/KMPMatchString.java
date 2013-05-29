/*
 * KMPMatchString.java
 *
 * Copyright 2013 Baidu Inc.
 * All rights reserved.
 * 
 * Created on 2013-5-6
 */
package com.moonlightheng.string;

/**
 * 功能概述：<br>
 *
 * @author 张珩
 */
public class KMPMatchString {

	
	char[] next;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "abcd";
		//a.contains(s)
	}
	void myget_nextval(char[] T, int next[]) 
	{ 
	     // 求模式串T的next函数值（第二种表示方法）并存入数组 next。                 
	     int j = 1, k = 0; 
	     next[0] = 0; 
	       while ( T[j] != '\0' ) 
	     {     
	                   if(T[j] == T[k]) 
	                   { 
	                         next[j] = k; 
	                         ++j; ++k;                  
	                   } 
	                   else if(T[j] != T[0]) 
	                   { 
	                  next[j] = k; 
	                  ++j; 
	                           k=0; 
	                   } 
	                   else 
	                   { 
	                          next[j] = k; 
	                  ++j; 
	                             k=1; 
	                   } 
	     }//while 
	    for(int i=0;i<j;i++) 
	     { 
	           System.out.println(next[i]);
	     } 
	  //   cout<<endl; 
	}// myget_nextval 
	int my_KMP(char[] S, char[] T, int pos) 
	{ 
	int i = pos, j = 0;//pos(S 的下标0≤pos<StrLength(S)) 
	while ( S[i] != '\0' && T[j] != '\0' ) 
	{ 
	    if (S[i] == T[j] ) 
	     { 
	         ++i; 
	             ++j; // 继续比较后继字符
	     } 
	   else             // a b a b c a a b c 
	                    // 0 0 0 1 2 0 1 1 2 
	   {              //-1 0 -1 0 2 -1 1 0 2 
	      i++; 
	     j = next[j];     /*当出现S[i] !=T[j]时，
	              下一次的比较应该在S[i]和T[next[j]] 之间进行。要求next[0]=0。
	在这两个简单示范函数间使用全局数组next[]传值。*/ 
	   } 
	}//while 
	if ( T[j] == '\0' ) 
	    return (i-j); // 匹配成功
	else 
	     return -1; 
	} // my_KMP 
}
