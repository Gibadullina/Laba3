import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Laba4.RandomArray;

public class RandomArrayTest {

	static RandomArray testClass;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testClass = new RandomArray();
		RegenerateArray(); //заполнение массива в тестовых целях
	}
	
	static void RegenerateArray()
	{
		for(int i=0; i<testClass.getRandomArray().length; i++)
		{
			testClass.setArrayValue(i, (int)(Math.random()*5)); //заполнение массива в тестовых целях
		}
	}
	@Test
	public void testClass() {
		assertNotNull(testClass);//проверка существует ли экземпляр класса
		assertNotNull(testClass.getRandomArray());//проверка существует ли массив
	}
	@Test
	public void testArray() {
		assertEquals(5,testClass.getRandomArray().length); //проверка длины массива
		for(int i=0; i<testClass.getRandomArray().length; i++)
		{
			assertNotNull(testClass.getRandomArray()[i]);//проверка элементов на нулл
		}
	}

}
