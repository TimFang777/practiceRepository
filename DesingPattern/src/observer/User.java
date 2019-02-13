package observer;

public class User implements Observer {
	private String name;

	public User(String s) {
		this.name = s;
	}

	@Override
	public void update(String message) {
		System.out.println("User " + name + " has received info " + message);

	}

	@Override
	public String getName() {
		return name;
	}
}
