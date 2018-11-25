package execise.generic;

public class GenericStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericStack<String> genericStack = new GenericStack<>();
		genericStack.push("Hello");
		genericStack.push("China");
		genericStack.push("I will back");
		
		System.out.println(genericStack.toString());
		
		GenericStack<Integer> genericStack2 = new GenericStack<>();
		genericStack2.push(1);
		genericStack2.push(2);
		genericStack2.push(3);
		
		System.out.println(genericStack2.toString());
	}

}
