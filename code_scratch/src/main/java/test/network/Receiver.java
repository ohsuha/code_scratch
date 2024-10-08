package test.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	Socket socket;
	DataInputStream dis;

	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void run() {
		while (dis != null) {
			try{
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
