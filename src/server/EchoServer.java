/* File Name: EchoServer.java
 * Author Name: Algonquin College
 * Modified By: Byung Seon Kim
 * Date: 6 Febrary 2017
 * Description: The class implements multithreading echo server (one server to multi-client).
 */
package server;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * The class implements multithreading echo server (one server to multi-client).
 * @author Byung Seon Kim
 *
 */
public class EchoServer {
	/** Instance variable for server port number */
	private int portNum;
	/** define default server port number */
	public static final int DEFAULT_PORT = 8081;
	/** Socket object for client */
	Socket clientSocket;
	/**
	 * Entry point of the EchoServer program
     * @param args command line parameters, (ex) EchoServer PortNumber
	 */
	public static void main(String[] args) {
		if (args.length > 0) { // when parameters exist
			(new EchoServer(Integer.parseInt(args[0]))).runServer();
		} else { // no parameter
			(new EchoServer(DEFAULT_PORT)).runServer();
		}
	}

	/**
	 * constructor of EchoServer
	 * @param portNum Port number server use
	 */
	public EchoServer(int portNum) {
		this.portNum = portNum;
	}

	/**
	 * The runServer() supports to the client server socket connection.
	 */
	public void runServer() {
		
		System.out.println("Multithreading Echo Server Started...");
		
		try ( // Use try-with-resources to prevent resource leak
			// Creates a stream socket and connects it to the specified port number
			ServerSocket server = new ServerSocket(portNum)
		) {
			System.out.println("Listenting for connections...");
			while (true) {
				try {	// Creates a stream socket and connects to client
					clientSocket = server.accept();
					(new Thread(new ClientHandler(clientSocket))).start(); // invoke thread
				} catch (IOException ex) {
					System.err.println(ex.getMessage() + "\n");
					ex.printStackTrace();
				}
			}
		} catch (IOException ex){
			System.err.println(ex.getMessage() + "\n");
			ex.printStackTrace();
		}
	}
}
