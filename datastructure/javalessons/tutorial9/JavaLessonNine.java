package tutorial9;

import java.util.Arrays;
public class JavaLessonNine {

		public static void main(String[] args){
			
			int[] randomArray;
			int[] numberArray = new int[10];
			
			randomArray = new int[20];
			
			randomArray[1] = 2;
			
			String[] stringArray = {"just", "random", "words"};
			
			for(int i=0; i < numberArray.length; i++){
				numberArray[i] = i;
			}
			
			int k = 1;
			
			while(k <= 41){
				System.out.println('-');
				k++;
			}
			
			for(int j=0;j < numberArray.length; j++){
				System.out.print("| " + j + " ");
			}
			System.out.print("|");
			
			
			String[][] multiArray = new String[10][10];
			for(int i = 0; i < multiArray.length; i++){
				for(int j = 0; j < multiArray[i].length; j++){
					multiArray[i][j] = "(" + i + ", " + j +")";
				}
			}
			System.out.println("\nMy multiArray: ");
			
			for(int i = 0; i < multiArray.length; i++){
				for(int j = 0; j < multiArray[i].length; j++){
					System.out.print("|  " + multiArray[i][j] + "  ");
				}
				System.out.println();
			}
			
			for(int row : numberArray){
				System.out.print(row + ", ");
			}
			System.out.println();
			
			//enhance for loop  for(dataType[] varforRow : arrayName){}
			for(String[] rows : multiArray){
				for(String column : rows){
					System.out.print("|  " + column + "  ");
				}
				System.out.println();
			}
			
			
			int[] numberCopy = Arrays.copyOf(numberArray, 5);
			for(int row : numberCopy){
				System.out.print(row);
			}
			System.out.println();
			
			System.out.println(Arrays.toString(numberCopy));
			
			int[] moreNumbers = new int[100];
			Arrays.fill(moreNumbers, 32);
			System.out.println(Arrays.toString(moreNumbers));
			
			int[] numToSort = new int[10];
			for(int i = 0; i < 10; i++){
				numToSort[i] = (int) (Math.random()*100);
			}
			
			Arrays.sort(numToSort);
			System.out.println(Arrays.toString(numToSort));
			
			int whereIs50 = Arrays.binarySearch(numToSort, 50);
			System.out.println(whereIs50);
		}
}
