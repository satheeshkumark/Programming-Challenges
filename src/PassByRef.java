import java.util.Scanner;


public class PassByRef {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray = {1,2};
		passByRef(inputArray);
		for(int i:inputArray)
			System.out.println("i value : " + i);
	}
	
	static void passByRef(int[] input){
		int temp = input[0];
		input[0] = input[1];
		input[1] = temp;
	}

}
