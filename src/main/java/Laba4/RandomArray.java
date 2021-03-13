package Laba4;

public class RandomArray {
	
	int[] intsArray = new int[5];
	public RandomArray ()
	{
		FillArrayFromRandomizer();
	}
	
	public int[] getRandomArray()
	{
		if(intsArray==null) FillArrayFromRandomizer();
		else if(intsArray.length==0) FillArrayFromRandomizer();
		return intsArray;
	}
	
	public void setArrayValue(int id, int value)
	{
		if(intsArray.length>=id) return;
		intsArray[id] = value;
	}
	void FillArrayFromRandomizer()
	{
		// раскомментить при слиянии
		Randomizer rnd = new Randomizer();
		for(int i=0; i<intsArray.length; i++)
		{
			intsArray[i] = rnd.rand_num();
		}
	}
}
