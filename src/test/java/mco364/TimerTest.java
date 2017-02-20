/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mco364;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yrobi
 */
public class TimerTest {

    @Test
    public void stop() {
        StopWatch sw = new StopWatch();
        sw.startTimer();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {   }

        long actual = sw.stopTimer();

        assertTrue(actual >= 100);
    }

    @Test(expected = TimerException.class)
    public void stopWithoutStart() {
        StopWatch sw = new StopWatch();
        sw.stopTimer();
    }

    @Test(expected = TimerException.class)
    public void stopWithoutStartBeforeThisStop() {
        StopWatch sw = new StopWatch();
        sw.startTimer();
        sw.stopTimer();       
        sw.stopTimer();
    }

}
