package dao;

public class IDHandler {
	private static long id;

	public static long getId() {
		return id;
	}

	public static void setId(long id) {
		IDHandler.id = id;
	}
}
