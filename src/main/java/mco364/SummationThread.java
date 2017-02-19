package mco364;
/**
 *
 * @author yrobi
 */
class SummationThread extends Thread {
    
    // the entry point of a thread is run
    private int[] list;
    int min;
    int max;

    SummationThread(int[] list, int min, int max) {
        this.list = list;
        this.min = min;
        this.max = max;
        
        if (AppSettings.DEBUG)
        {
            System.out.println(min + "," + max);
        }
    }
    long sum;

    @Override
    public void run() {
        for (int i = min; i < max; i++) {
            sum += list[i];
        }
    }
    
}
