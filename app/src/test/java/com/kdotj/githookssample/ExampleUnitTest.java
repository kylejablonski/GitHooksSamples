package com.kdotj.githookssample;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    // sut
    private CalculatorModel mCalculatorModel;

    @Before
    public void setup(){
        mCalculatorModel = new CalculatorModel();
    }

    @Test
    public void subtractTwoNumbersShouldResultInExpectedDifference(){
        double expected = 23.0;
        double first = 30;
        double second = 7;

        assertEquals(expected, mCalculatorModel.subtractNumbers(first,second), 0.0);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}