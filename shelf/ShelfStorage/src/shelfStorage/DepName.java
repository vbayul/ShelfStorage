package shelfStorage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DepName {

	private static int depName;
	
	public static int getDepName() {
		try {
			depName = Integer.parseInt(InetAddress.getLocalHost().getHostName().substring(3, 6));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return depName;
	}
}
