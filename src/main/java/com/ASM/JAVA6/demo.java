package com.ASM.JAVA6;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class demo {
   static class table {
     void print(int n) {
            for (int i = 0; i < 5; i++) {
                System.out.println(i * n);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

   static class Thread1 extends Thread {
        table t;

        Thread1(table t) {
            this.t = t;
        }

        public void run() {
            t.print(1);
        }
    }

   static class Thread2 extends Thread {
        table t;

        Thread2(table t) {
            this.t = t;
        }

        public void run() {
            t.print(100);
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> t = new TreeMap<Integer, String>();
        t.put(5, "a");
        t.put(1, "b");
        t.put(3, "d");
        t.put(4, "e");
        for(Map.Entry<Integer, String> e : t.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
}
