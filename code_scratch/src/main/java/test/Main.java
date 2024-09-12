package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import test.network.TcpMultichatClient;
import test.network.TcpMultichatServer;

public class Main {
	public static void main(String[] args) {
		TcpMultichatServer server = new TcpMultichatServer();
		server.start();

		if (args.length != 1) {
			System.out.println("USAGE : java TcpIpMultichatClient 대화명");
			System.exit(1);
		}

		try {
			String serverIp = "127.0.0.1";
			Socket socket = new Socket(serverIp, 7777);
			System.out.println();
			Thread sender = new Thread(new TcpMultichatClient.ClientSender(socket, args[0]));
			Thread receiver = new Thread(new TcpMultichatClient.ClientReceiver(socket));

			sender.start();
			receiver.start();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
