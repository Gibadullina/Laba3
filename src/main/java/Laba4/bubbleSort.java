package Laba4;

public class bubbleSort {
	public int[] array;
	
	public bubbleSort(int[] _array) {
		array = _array;
	}
	
	//Сортировка массива
	public void sortArray() {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					array[j] += array[j+1];
					array[j+1] = array[j] - array[j+1];
					array[j] -= array[j+1];
				}
			}
		}
	}
	
	//Вывод массива
	public void printArray() {
		for(int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
