/* File Name: EchoClient.java
 * Author Name: Algonquin College
 * Modified By: Byung Seon Kim
 * Date: 6 Febrary 2017
 * Description: This class handles the client input for one server socket connection.
 */
package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import server.ClientHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class handles the client input for one server socket connection.
 * @author Byung Seon Kim
 *
 */
public class EchoClient {
	/** Default server name */
	public static final String DEFAULT_SERVER_NAME = "localhost";
	/** String variable for server name (IP) */
	private String serverName;
	/** Instance variable for server port number */
	private int portNum;

	/**
	 * Entry point of the EchoClient program
     * @param args command line parameters, (ex) EchoClient ServerName, PortNumber
	 */
	public static void main(String[] args) {
		switch (args.length) {
		case 2: // when two arguments
			(new EchoClient(args[0], Integer.parseInt(args[1]))).runClient();
			break;
		case 1: // when one argument
			(new EchoClient(DEFAULT_SERVER_NAME, Integer.parseInt(args[0]))).runClient();
			break;
		default: // no argument
			(new EchoClient(DEFAULT_SERVER_NAME, server.EchoServer.DEFAULT_PORT)).runClient();
		}
	}

	/**
	 * constructor of EchoClient
	 * @param serverName Server name
	 * @param portNum Port number server use
	 */
	public EchoClient(String serverName, int portNum) {
		this.serverName = serverName;
		this.portNum = portNum;
	}

	/**
	 * The runClient() implements the client input and output for one server socket connection.
	 */
	public void runClient() {
		
		try ( // Use try-with-resources to prevent resource leak
			/* 
			 * Creates a stream socket and connects it to the specified port number at the specified IP address.
			 * -----------------
			 * InetAddress class represents an Internet Protocol (IP) address. An IP address is either a 32-bit or 
			 * 128-bit unsigned number used by IP, a lower-level protocol on which protocols like UDP and TCP are built.
			 */
			Socket clientSocket = new Socket(InetAddress.getByName(serverName), portNum);
			// open output stream to be written data to streams
			ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
			// open input stream to be read data from streams
			ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
			// BufferedReader object to read text from a character-input stream, buffering characters so as to provide 
			// for the efficient reading of characters, arrays, and lines.
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
		) {
			String message = ""; // String variable to input from keyboard
			// display the message to quit EchoClient
			System.out.println("To Quit, press ^Z or type 'exit'");
			
			do {
				System.out.print("Input> ");
				message = keyboard.readLine(); // stay and read keyboard input
				
				if (message != null){
					output.writeObject(message); // send message to server
					if (!message.equals(ClientHandler.EXIT_MESSAGE)) {
						message = (String) input.readObject(); // read message from server
						System.out.println(message);
					}
				} else {
					output.writeObject(ClientHandler.EXIT_MESSAGE); // send message to let server quit
				}
				// Since I don't want to send data before the buffer is full, I just Flush It. 
				output.flush();
			} while (message != null && !message.equals(ClientHandler.EXIT_MESSAGE)); // if keyboard input is ^Z or type "exit", exit the program
			System.out.print("Stopped by user's request!");
		} catch (Exception ex) {
			System.err.println(ex.getMessage() + "\n");
			ex.printStackTrace();
		}
	}
} // End of EchoClient class
