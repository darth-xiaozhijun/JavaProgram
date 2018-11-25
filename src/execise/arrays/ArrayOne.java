package execise.arrays;

public class ArrayOne {

	public static void main(String[] args) {
		int[] intArray;
		String[] stringArray;
		
		User[] users;
		
		intArray = new int[10];
		stringArray = new String[10];
		users = new User[3];
		
		String[] strings = {"1","2","3"};
		for (String string : strings) {
			System.out.println(string);
		}
	}
}
