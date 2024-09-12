package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class UdpTest {
	@Test
	public void udpServer() throws IOException {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(7777);
			DatagramPacket inPacket, outPacket;

			byte[] inMsg = new byte[10];
			byte[] outMsg;

			while(true) {
				//데이터 수신을 위한 패킷
				inPacket = new DatagramPacket(inMsg, inMsg.length);

				// 패킷을 통해 데이터 수신
				datagramSocket.receive(inPacket);

				/// 수신한 패킷에서 client 의 IP 와 port 얻기
				InetAddress address = inPacket.getAddress();
				int port = inPacket.getPort();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
				outMsg = time.getBytes();

				outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
				datagramSocket.send(outPacket);
			}
		} catch (SocketException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void udpClient() throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("127.0.0.1");

		byte[] msg = new byte[100];
		DatagramPacket outPacket = new DatagramPacket(msg, 1, address, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		datagramSocket.send(outPacket);
		datagramSocket.receive(inPacket);

		System.out.println("current server tiem : " + new String(inPacket.getData()));
		datagramSocket.close();
	}
}
