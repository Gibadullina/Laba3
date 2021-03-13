package Laba4; 

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Laba4.bubbleSort;

public class bubbleSortTest {

	static bubbleSort sorter;;
	static int[] checkArr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		checkArr = new int[] {1,2,3,4,5,6,7,8,9};
		sorter = new bubbleSort(new int[] {2,4,6,8,1,3,5,7,9});
		sorter.sortArray();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Check array:");
		for(int element: checkArr) {
			System.out.print(element+" ");
		}
		System.out.println("\nSorted array:");
		sorter.printArray();
	}
	
	@Test
	public void testBubbleSort() {
		assertArrayEquals(sorter.array, checkArr);
	}

}
