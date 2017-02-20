/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mco364;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yrobi
 */
class Multithreading {
    
    /**
     * 
     * @param list
     * @param min
     * @param max - exclusive
     */
    public static void initWithRandom(int[] list, int min, int max) {
        Random r = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = r.nextInt(max - min) + min;
        }
    }

    public static void initWithValue(int[] list, int val) {
        for (int i = 0; i < list.length; i++) {
            list[i] = val;
        }
    }

    public static double averageMT(int[] list, int threadCount) {
        double averageSizePerThread = (double) list.length / threadCount;
        ArrayList<SummationThread> threadList = new ArrayList<>();
        
        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int min = (int) (threadNumber * averageSizePerThread);
            int max = (int) ((threadNumber + 1) * averageSizePerThread + 0.0001);
            SummationThread t = new SummationThread(list, min, max);
            threadList.add(t);
            t.start();
        }
        long grandTotal = 0;
        for (SummationThread t : threadList) {
            try {
                t.join(); // wait for each thread to die (= complete) before continuting
            } catch (InterruptedException ex) {
            }
            grandTotal += t.sum;
        }
        return (double) grandTotal / list.length;
    }
    
}
