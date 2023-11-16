package commonLibraries;

import java.sql.Timestamp;


public class UtilitiesLibrary {

	public static String getCurrentTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = timestamp.toString();
		System.out.println("Time: " + time);
		time = time.replace("-", "_");
		time = time.replace(" ", "_");
		time = time.replace(":", "_");
		time = time.replace(".", "_");
		System.out.println("Time: " + time);
		return time;
	}
}
