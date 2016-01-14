import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * A connection represents an interaction between two people, sending messages
 * 
 */
public class Connection {
	private OutputStream os1, os2;
	private InputStream is1, is2;

	public Connection(Socket s1, Socket s2) throws IOException {
		
		// outputStreams
		os1 = s1.getOutputStream();
		is1 = s1.getInputStream();
		// inputStreams
		os2 = s2.getOutputStream();
		is2 = s2.getInputStream();
	}

	/**
	 * Here the connection and interchange between messages ocurrs
	 * 
	 * @throws IOException
	 */
	public void workStuff() throws IOException {
		BufferedInputStream bis1, bis2;
		bis1 = new BufferedInputStream(is1);
		bis2 = new BufferedInputStream(is2);
		byte[] buffer = new byte[100000];
		int size;
		while (true) {
			if (is1.available() > 0) {
				size = bis1.read(buffer,0,buffer.length);
				os2.write(buffer, 0, size);
			}
			if (is2.available() > 0) {
				size = bis2.read(buffer,0,buffer.length);
				os1.write(buffer, 0, size);
			}
		}
	}

}
