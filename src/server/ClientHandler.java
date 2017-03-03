/* File Name: EchoThread.java
 * Author Name: Algonquin College
 * Modified By: Byung Seon Kim
 * Date: 6 Febrary 2017
 * Description: The EchoThread is the thread class to implement multi client echo server 
 */
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * The EchoThread is the thread class to implement multi client echo server 
 * @author Byung Seon Kim
 *
 */
public class ClientHandler implements Runnable {
	/** Socket object to create a client socket */
	private Socket clientConnection = null;
	private String clientAddress = null;
	private int messagenum;
	public static final String EXIT_MESSAGE = "exit";
	
	/**
	 * constructor of EchoThread class
	 * @param connection Socket object of a client
	 */
	public ClientHandler(Socket clientConnection) {
		this.clientConnection = clientConnection;
		// Returns the address of the end-point this socket is connected to, or null if it is unconnected.
		SocketAddress remoteAddress = clientConnection.getRemoteSocketAddress();
		clientAddress = remoteAddress.toString().replace("/", "");

		System.out.println("[" + clientAddress + "] Ready to client input!");
	}

	/**
	 * The run() is the main process of EchoServer. Detect a client input and send server message
	 */
	@Override
	public void run() {
		try ( // Use try-with-resources to prevent resource leak	
			// open output stream to be written data to streams
			ObjectOutputStream output = new ObjectOutputStream (clientConnection.getOutputStream());
			// open input stream to be read data from streams
			ObjectInputStream input = new ObjectInputStream(clientConnection.getInputStream())
		) {
			String message = ""; // variable to get data read from client
			
			do {
				message = (String) input.readObject(); // read the data from input stream
				if (!message.equals(EXIT_MESSAGE)) {
					System.out.println("[" + clientAddress + "] " + message);
					output.writeObject("Output:" + ++messagenum + "> " + message);
					// Since I don't want to send data before the buffer is full, I just Flush It.
					output.flush();
				}
			} while (!message.contains(EXIT_MESSAGE));
			
			System.out.println("[" + clientAddress + "] Disconnected via request");

        } catch (Exception exception) {
            System.err.println(exception.getMessage() + "\n");
            exception.printStackTrace();
        } 
	}
}
