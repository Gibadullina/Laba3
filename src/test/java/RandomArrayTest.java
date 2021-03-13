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
		RegenerateArray(); //���������� ������� � �������� �����
	}
	
	static void RegenerateArray()
	{
		for(int i=0; i<testClass.getRandomArray().length; i++)
		{
			testClass.setArrayValue(i, (int)(Math.random()*5)); //���������� ������� � �������� �����
		}
	}
	@Test
	public void testClass() {
		assertNotNull(testClass);//�������� ���������� �� ��������� ������
		assertNotNull(testClass.getRandomArray());//�������� ���������� �� ������
	}
	@Test
	public void testArray() {
		assertEquals(5,testClass.getRandomArray().length); //�������� ����� �������
		for(int i=0; i<testClass.getRandomArray().length; i++)
		{
			assertNotNull(testClass.getRandomArray()[i]);//�������� ��������� �� ����
		}
	}

}
