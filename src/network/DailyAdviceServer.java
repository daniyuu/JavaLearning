/**
 * 
 */
package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Daniyuu
 *
 */
public class DailyAdviceServer {

	/**
	 * 
	 */
	public DailyAdviceServer() {
		// TODO Auto-generated constructor stub
	}
	
	public void go(){
		try {
			ServerSocket serverSock = new ServerSocket(4242);
			while(true){
				Socket sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = "test";
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
