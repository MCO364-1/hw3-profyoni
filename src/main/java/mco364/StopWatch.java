package mco364;

/**
 *
 * @author yrobi
 */
class StopWatch {
    
    private long msStartTime;

    public void startTimer() {
        msStartTime = System.currentTimeMillis();
    }

    /**
     * returns the number of milliseconds since startTimer was called.
     */
    /**
     * If startTimer was never called, or stopTimer
     */
    /**
     * was already called once, throws an TimerException (a subclass of
     */
    /**
     * RuntimeException) with an appropriate message
     */
    public long stopTimer() {
        if (msStartTime == 0) {
            throw new TimerException("Must call 'startTimer' before each call to 'stopTimer'");
        }
        return System.currentTimeMillis() - msStartTime;
    }
    
}
