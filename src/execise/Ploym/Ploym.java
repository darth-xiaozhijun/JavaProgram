package execise.Ploym;

public class Ploym {

	public static void main(String[] args) {
		
		Animal animal = new Dog();//强制向上转型
		animal.shut();
		
		Animal animal2 = new Animal();
		shut(animal2);
		Dog dog = new Dog();
		Cat cat = new Cat();
		shut(dog);
		shut(cat);
		
		Dog dog2 = (Dog) animal;//强制向下转型
		dog2.watchDoor();
	}
	
	public static void shut(Animal animal){
		animal.shut();
	}
}
