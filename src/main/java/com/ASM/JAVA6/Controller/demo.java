package com.ASM.JAVA6.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Company {

    public static void main(String[] args) {
        int ranks[] = { 4, 4, 3, 3, 1, 0 };
        int ans = 0;
        int a = 0;

        // for(int i = 0; i < ranks.length; i++){
        // for(int j = i+1; j < ranks.length; j++){
        // if(ranks[i] == ranks[i]+1){
        // ans ++;
        // }
        // }
        // }
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < ranks.length; i++) {
            l.add(ranks[i]);
        }
        for (int i : ranks) {
            System.out.println(i);
            System.out.println(l);
            if(l.contains(i+1)){
                ans++;
            }
        }
        // List<Integer> l = new LinkedList<Integer>();
        // for(int i = 0; i < ranks.length; i++){
        // l.add(ranks[i]);
        // }
        // for(int i = 0; i < ranks.length; i++){
        // if(l.contains(i+1)){
        // ans++;
        // }
        // }
        System.out.println(ans);
        // Set<Integer> set = new HashSet<Integer>();
        // for(int i = 0;i<ranks.length;i++) {
        // set.add(ranks[i]);
        // }
        // for(int i : ranks){

        // if(set.contains(i+1)){
        // ans ++;
        // }
        // }
        // System.out.println(ans);
    }

}
