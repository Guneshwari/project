package in.edac;

public class SingletonDemo {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		UserDao ref1 = UserDao.getIntance();
		System.out.println(ref1);
		
		UserDao ref2 = UserDao.getIntance();
		System.out.println(ref2);
	}
}