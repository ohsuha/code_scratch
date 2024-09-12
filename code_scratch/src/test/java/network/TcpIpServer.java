package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TcpIpServer {
	@Test
	public void test() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
		log.info("서버가 준비되었습니다 {}", getTime());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		while(true) {
			try{
				log.info("연결 요청을 기다립니다 {}", getTime());
				//서버 소켓은 클라의 연결 요청이 올때까지 계속 기다린다.
				// 클라이언트의 연결 요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSocket.accept();
				log.info("연결 요청이 들어왔습니다 {} ", getTime());
				log.info("client {} ", socket.getInetAddress());

				// 소켓의 출력 스트림을 생성한다.
				OutputStream outputStream = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(outputStream);

				//원격 소켓에 데이터를 보낸다.
				dos.writeUTF("[NOTICE] Test Message from server");
				log.info("데이터를 전송했습니다. {}", getTime());

				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date());
	}


	@Test
	public void clientTest() {
		try {
			String serverIp = "127.0.0.1";
			log.info("서버에 연결중입니다. 서버 IP : {}", serverIp);

			Socket socket = new Socket(serverIp, 7777);

			// 소켓의 입력 스틞을 얻는다.
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);

			//소켓으로부터 받은 데이터를 출력한다.
			log.info("서버로부터 받은 메시지 : {}", dataInputStream.readUTF());
			log.info("연결을 종료합니다.");
			dataInputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}