package network;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TcpIpServer3 {

	@Test
	public void testServerStart() throws InterruptedException {
		TcpIpServer2 server = new TcpIpServer2(5); // 5개의 스레드로 서버 시작
		// 서버를 백그라운드 스레드에서 실행
		Thread serverThread = new Thread(() -> {
			server.start(); // 서버 시작
		});
		serverThread.setDaemon(true); // 테스트 종료 시 서버 스레드도 종료되도록 데몬 스레드로 설정
		serverThread.start();

		// 메인 테스트 스레드가 서버가 실행되는 동안 종료되지 않도록 대기
		synchronized (this) {
			this.wait(); // 무한 대기
		}
	}

}

