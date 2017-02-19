package mco364;





public class Main {

    public static void main(String[] args) {
        int [] list = new int[100_000_000];
        //Multithreading.initWithRandom(list, 1, 100);
        Multithreading.initWithValue(list, 1);
        StopWatch stopWatch = new StopWatch();
        long lastSpeed = Long.MAX_VALUE;
        for (int degreeOfMultiThreading = 1; degreeOfMultiThreading < 100000; degreeOfMultiThreading *= 2)
        {
            stopWatch.startTimer();
            double average = Multithreading.averageMT(list, degreeOfMultiThreading );
            long speed = stopWatch.stopTimer();
            System.out.println(degreeOfMultiThreading + ":" + average + ", " + speed);
            if (speed > lastSpeed)
                break;
            lastSpeed = speed;
        }

    }
}
