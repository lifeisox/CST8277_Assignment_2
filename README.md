# CST8277_Assignment_2
CST8277 Enterprise Application Programming
Assignment 2: Client/Server
Due Date: See Blackboard
• Due Date: see Blackboard for due date.
• Demo required in your own lab period. No Jar files are to be used for demo.
• Read the requirements carefully, if your program does not meet the requirements expect a loss of marks for the assignment, even though your program code runs without errors.
Lab Partner: Optional
• For this lab, you may work with a lab partner on the test plan portion and demonstration. (Optional)
• If demonstrating in lab, and passing in a shared test plan please place both you and your partner’s name at the top of the test plan. Each student should include this test plan document in their individual file upload.
Purpose:
In the first part of this exercise, you will compile and link a small C++ client and server to become familiar with compiling and linking outside the Java environment. Then we'll use our knowledge of Java syntax to make a small change to the C++ server, and recompile it. Because you know Java, you already know enough C++ to make some changes to a C++ program.
In the second part of this exercise we will work with client and server programs written in Java, but like the C++ programs from the first part. You'll make the same change to the Java server as you made to the C++ server, and then you'll go even further to use your knowledge of Java Multithreading to make the Java server multithreaded.
Part 1: Client/Server in C++
A. Compile and Link the given C++ code from the EchoServerAndAPI folder (see the Compiling and Linking section below). Then create a simple test plan, and begin your testing by testing the client and server running on the same computer. Use the computer name localhost and an application number (port) available on your computer (8080 or 8081 are often safe choices). Then, find a testing partner and test the programs by running the client and server on different machines (this situation should be added to your test plan if it's not there already). First run one partner's server on their machine, and connect with the other partner's client running on their machine. Then do the opposite, so that both servers have been tested with a different programmer's client running from a different machine.
B. You'll notice in Step A above that the Server as given will terminate after servicing just one client. Modify the server code so that the server can accept connections from multiple clients (only one at a time, one after the other - no multithreading needed). Recompile the Server, and test it again (be sure your test plan includes all the appropriate tests) with your testing partner, as you did in Step A.
C. Write a brief essay, in your own words, to explain the difference between preprocessing, compiling, and linking in C++. Look up the answer online and cite your sources using IEEE reference style.
Note:
• There is absolutely no need to add multithreading to the C++ program, just modify the code so that it handles more than one client sequentially.
Part 2: Multithreaded Server and Client in Java
A. Use the starter code within Eclipse, and read the code for the client and server to verify that you understand how the Java Networking code can connect two separate programs running in two different JVMs. To pass command line arguments to your Java programs, you will need to select Run As->Run Configurations... and select the Arguments tab in the resulting popup window.
B. Modify the Server to support more than one client (one after the other) as you did with the C++ Server. Test your Java Server as you did with the C++ version, and be sure your test plan includes running more than one client instance to attempt to simultaneously connect to the same server instance.
C. Use Multi-threading to make the Server support more than one client at a time. Use a separate class named ClientHandler that implements Runnable. Each instance of ClientHandler will interact with one client. Be sure there are no resource leaks in your programs - fix any resource leaks you can find. Note: Where possible use try-with-resources instead of a finally block with multiple close() statements. Also, redo the testing you performed in Part B with your modified Server.
D. In our Java network program, we are using Serialization to send objects between the client and server (Strings). If you were serializing your own class to pass it from client to server, e.g. class Sprite, why would using an explicit serialVersionUID be a good idea? You should read from the Effective Java book by Joshua Bloch to start looking for an answer, don’t forget to Cite your source using IEEE reference style.
Tip: Algonquin College Website  Current Students  Library  Beyond One Search Ebooks & Audiobooks  Safari (if on campus you access it directly, if off-campus you need your student number to log in)  Search: Effective Java Chapter 11: Serialization.
You might want to do general web searches for additional information as well.
Demonstration and Submission
Together with your partner (optional), demonstrate that you can run a server on one machine, and connect multiple clients to that server, with at least one of the clients on a different machine.
Submission Requirements
1. From Part I: screen shot of a successful compiler run of echoserver.cpp in a command line window. (Make sure your name is within the screen shot, see instructions below).
2. From Part I: your C++ server source file (echoserver.cpp).
3. From Part I: your essay on C++ preprocessor, compiler, linker
4. From Part II: your Java Project folder
5. From Part I and II: the simple test plan, and your essay on serialVersionUID.
Grading (10 points total)
Code C++ (4 points)
• Modified to handle multiple clients, in sequence (1 out of 4)
• Essay on C++ preprocessor, compiler, linker, with IEEE reference style to cite sources (1 out of 4)
• Screen shot, with your name, date, time within it of compiling EchoServer.cpp (1 out of 4)
• Test Plan (1 out of 4)
Code Java (5 Points)
• Server modified to handle multiple clients, in parallel, using multithreading (1 out of 5)
• Comment block at top of file(s), all classes, class-members have Javadoc comments (1 out of 5)
• Client and Server modified to not have resource leaks (1 out of 5)
• Short explanation of serialVersionUID and why use it (1 out of 5)
• Test Plan (1 out of 5)
Demo (2 Points)
• Demo in Lab of C++ and Java Programs (1 point each) Note: No Jar files allowed for demo.
