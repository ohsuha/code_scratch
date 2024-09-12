package test.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void clientTest() throws UnknownHostException, IOException {
		try{
			String serverIp = "127.0.0.1";
			Socket socket = new Socket(serverIp,7777);

			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
