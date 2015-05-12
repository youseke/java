package ex09_03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

public class NewClass {
	public void process() throws FileNotFoundException, UnknownHostException {
		try {
			if (System.currentTimeMillis() % 2 == 0)
				throw new FileNotFoundException();
			else
				throw new UnknownHostException();
		} catch (FileNotFoundException | UnknownHostException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
