package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;

import test.network.Receiver;
import test.network.Sender;

public class TCpIpServer4 {
	@Test
	public void serverTest() throws InterruptedException {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try{
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");

			socket = serverSocket.accept();

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.setDaemon(true);
			receiver.setDaemon(true);

			sender.start();
			receiver.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		synchronized (this) {
			this.wait(); // 무한 대기
		}
	}
}
