/*
 * BackPackege.java
 *
 * Copyright 2013 Baidu Inc.
 * All rights reserved.
 * 
 * Created on 2013-5-17
 */
package com.moonlightheng.backpackege;

/**
 * 功能概述：<br>
 *
 * @author 张珩
 */
public class Knapsack {
    private int[] weight;
    private int maxWeight;
    private int currentWeight;
    private int bestWeight;
    private int height;
    private int[] state;
    private int[] currentState;
    public Knapsack(int mw,int[] weightSet){
        this.maxWeight = mw;
        this.weight = weightSet;
        this.currentWeight = 0;
        this.bestWeight = 0;
        this.height = weightSet.length - 1;//要减一，是因为第一个节点的height是0
        state = new int[weightSet.length];
        currentState = new int[weightSet.length];
        backtrace(0);
        printResult();
    }
    
    public void backtrace(int i){
        if (i > height){//到达了叶节点
            if (currentWeight > bestWeight){
                bestWeight = currentWeight;
                for (int j=0;j<state.length;j++){
                    state[j] = currentState[j];
                }
            }
            return;
        }
        
        if (currentWeight + weight[i] <= maxWeight){//检查右子树
            currentWeight += weight[i];
            currentState[i] = 1;
            backtrace(i+1);
            currentWeight -= weight[i];
            currentState[i] = 0;
        }
        backtrace(i+1);//检查左子树
    }
    
    public void printResult(){
        System.out.println("result is "+bestWeight);
        for (int i=0;i<state.length;i++){
            System.out.print(state[i] + " ");
        }
        System.out.println();
        
        
    }
    
    public static void main(String args[]){
        int[] weight = {2,5,4,7,16,11,13};
        new Knapsack(10,weight);
    }
}