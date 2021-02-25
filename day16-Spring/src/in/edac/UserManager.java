package in.edac;

public class UserManager {
	private UserManager() {
		super();
	}
	
	public static UserManager createObject() {
		UserManager instance = new UserManager();
		return instance;
	}
}
