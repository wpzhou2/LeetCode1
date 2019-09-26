package LeetCode1; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* LC_215_KthLargestElementinanArray Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 30, 2019</pre> 
* @version 1.0 
*/ 
public class LC_215_KthLargestElementinanArrayTest { 
    
    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
        /** 
    * 
    * Method: findKthLargest(int[] nums, int k) 
    * 
    */ 
    @Test
    public void testFindKthLargest() throws Exception { 
    //TODO: Test goes here...
        LC_215_KthLargestElementinanArray test = new LC_215_KthLargestElementinanArray();
        int kthLargest = test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    } 
    
        /** 
    * 
    * Method: quickSort(int arr[], int left, int right) 
    * 
    */ 
    @Test
    public void testQuickSort() throws Exception { 
    //TODO: Test goes here...
    } 
    
        
    } 
