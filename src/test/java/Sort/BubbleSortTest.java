package Sort;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import javax.swing.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * BubbleSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 17, 2019</pre>
 */
public class BubbleSortTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: bubbleSort(int[] arr)
     */
    @Test
    public void testBubbleSort() throws Exception {
        //TODO: Test goes here...

        double[] ten = new double[10];
        double[] hundred = new double[100];
        double[] tenThousand = new double[10000];
        double[] zero = {};
        double[] million = new double[1000000];

        for(int i=0;i<10;i++){
            ten[i] = Math.random()*10;
        }
        for(int i=0;i<100;i++){
            hundred[i] = Math.random()*10;
        }
        for(int i=0;i<10000;i++){
            tenThousand[i] = Math.random()*10;
        }
        for(int i=0;i<20000;i++){
            million[i] = Math.random()*10;
        }

        double[] bubbleTen = BubbleSort.bubbleSort(ten);
        double[] bubbleHundred = BubbleSort.bubbleSort(hundred);
        double[] bubbleTenThousand = BubbleSort.bubbleSort(tenThousand);
        double[] bubbleMillion = BubbleSort.bubbleSort(million);
        double[] bubbleZero = BubbleSort.bubbleSort(zero);

        Arrays.sort(ten);
        Arrays.sort(hundred);
        Arrays.sort(tenThousand);
        Arrays.sort(zero);
        Arrays.sort(million);

        assertEquals(bubbleTen, ten);
        assertEquals(bubbleHundred, hundred);
        assertEquals(bubbleTenThousand, tenThousand);
        assertEquals(bubbleZero, zero);
        assertEquals(bubbleMillion, million);
    }


}
