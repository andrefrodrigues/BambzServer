import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static final int PORT = 3125;
	
	
	private static Connection c;
	private static Socket[] sockets = new Socket[2];
	private static ServerSocket serv;

	public static void main(String[] args) throws IOException {
		System.out.println("Server desu.");
		serv = new ServerSocket(PORT);
		int connected=0;
		System.out.println("Awaiting connection");
		while(connected<2){
			sockets[connected++]=serv.accept();
			System.out.println(connected+ "Person connected!");
		}
		System.out.println(connected+"People Connected!");
		System.out.println("You can now talk");
		c=new Connection(sockets[0],sockets[1]);
		c.workStuff();
	}

}
