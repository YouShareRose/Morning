package com.test;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Varible {
    public static void main(String [] args){
        System.out.println(add(2,3));
        System.out.println(add(2,3,5));
    }
    public static int add(int x,Object ...args){
        int sum=1;
        for(int i=0;i<args.length;i++){
            sum+= Integer.valueOf(args[i].toString());
        }
        return sum;
    }
}
