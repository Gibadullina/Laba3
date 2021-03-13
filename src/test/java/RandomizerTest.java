
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;


import Laba4.Randomizer;

public class RandomizerTest {

	Randomizer Randomize;
	
	@Before
	public void test1() {
		Randomize = new Randomizer();
	}
	
	boolean checking() {
		int i = 10;
		boolean check = false;
		while (i < 70) {
			while (check == false) {
				if (i == Randomize.rand_num()) {
					check = true;
				}
			}
			i++;
		}
		return check;
	}

	@Test
	public void testRandom() {

	assertEquals(true, checking());
	}
	
	
	@After
	public void test2() {
		
	}
	


}
