package network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TcpIpServer2 implements Runnable {
	ServerSocket serverSocket;
	Thread[] threadArr;

	public TcpIpServer2(int num) {
		try {
			serverSocket = new ServerSocket(7777);
			log.info("서버가 준비되었습니다.");

			threadArr = new Thread[num];
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void start() {
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}

	private String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date()) + name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				log.info("연결 요청을 기다립니다 {}", getTime());
				Socket socket = serverSocket.accept();
				log.info("연결 요청이 들어왔습니다 {} ", getTime());
				log.info("client {} ", socket.getInetAddress());

				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);

				dos.writeUTF("[NOTICE] Test Message from server");
				log.info("데이터를 전송했습니다. {}", getTime());

				dos.close();
				socket.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
