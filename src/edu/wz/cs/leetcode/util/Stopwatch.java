package edu.wz.cs.leetcode.util;

public class Stopwatch {
    
    private final long start;
    
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    
    public double elapsed() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    
    public static void main(String[] args) {
        Stopwatch watch = new Stopwatch();
        double sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            sum += Math.sqrt(i);
        }
        System.out.println(sum);
        System.out.println(watch.elapsed() + " second");
    }

}
