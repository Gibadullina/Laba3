package Laba4;

public class Randomizer {
	public int rand_num() {
		double x = Math.random() * ((70 - 10) + 1)+ 10;
		int y = (int)x;
		return y;
	}
}
