import java.util.Scanner;


public class CarryAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first value");
		int firstNum = sc.nextInt();
		System.out.println("Enter the second value");
		int secondNum = sc.nextInt();
		int numberOfCarries = findCarries(firstNum, secondNum, 0, 0);
		if(numberOfCarries > 0)
			System.out.println("There are " + numberOfCarries + " carries");
		else
			System.out.println("There are no carries");
	}
	
	private static int findCarries(int firstNum, int secondNum, int carry, int carryFlag){
		if(firstNum == 0 || secondNum == 0){
			if(carryFlag == 0)
				return carry;
			return carry + 1;
		}
		if(firstNum%10 + secondNum%10 + carryFlag > 9)
			return findCarries(firstNum/10, secondNum/10, carry + 1, 1);
		else
			return findCarries(firstNum/10, secondNum/10, carry + 1, 0);
	}

}
