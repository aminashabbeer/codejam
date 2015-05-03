package codejam;


import org.junit.*;

import static org.junit.Assert.*;


public class QuickSortTest {
	private QuickSort tester;

	
	 /**
     * Sets up the test fixture. 
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
    	Comparable[] arr;
        arr = new Comparable[10];
        for(int i=0;i<10;++i)
        {
        	arr[i]=10-i;
        }
        tester=new QuickSort(arr);
    }

    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
    	this.tester.arr = null;
    }
    
    @Test
    public void testLess()
    {
    	 assertTrue("0 is less than 1",this.tester.less(0, 1));    	 
    }
    @Test
    public void testSwap() {
    	int i=0;
    	int j=1;
    	Comparable oldi=this.tester.arr[i];
    	Comparable oldj=this.tester.arr[j];
    	this.tester.swap(i,j);
        assertEquals("Element"+this.tester.arr[j]+"equals old val @ arr[i]"+oldi, this.tester.arr[j], oldi);
        assertEquals("Element"+this.tester.arr[i]+"equals new val @ arr[j]"+oldj, this.tester.arr[i], oldj);
    }
    @Test
    public void testIsPartitioned() {
    	int lo=0;
    	int hi=this.tester.arr.length-1;
    	int p=this.tester.partition(lo, hi);
    	Comparable pivotVal=this.tester.arr[p];
        for(int i=lo;i<p;++i){
        	assertTrue("Element in first partition "+this.tester.arr[i]+ "must be less than "+pivotVal,this.tester.arr[i].compareTo(pivotVal)<=0);
        }
        for(int i=p+1;i<=hi;++i){
        	assertTrue("Element in first partition "+this.tester.arr[i]+ "must be greater than "+pivotVal,this.tester.arr[i].compareTo(pivotVal)>0);
        }
    }
    
    @Test
    public void testIsSorted(){
    	this.tester.sort(0,this.tester.arr.length-1);
    	for(int i=0;i<this.tester.arr.length-1;++i){
    		assertTrue(this.tester.arr[i]+"less than next element"+this.tester.arr[i+1],this.tester.arr[i].compareTo(this.tester.arr[i+1])<=0);
    	}    
    }

}
