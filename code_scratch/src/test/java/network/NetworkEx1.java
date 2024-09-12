package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkEx1 {
	@Test
	public void testNetwork() {
		InetAddress ip = null;
		InetAddress[] ipArr = null;

		try {
			ip = InetAddress.getByName("www.naver.com");
			log.info("get host name () : {}", ip.getHostName());
			log.info("get host address () : {}", ip.getHostAddress());
			log.info("toString() : {}", ip.toString());

			byte[] ipAddr = ip.getAddress();
			log.info("getAddress() : {}", Arrays.toString(ipAddr));

			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			log.info("get Address() + 256 : {} ", result);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		try {
			ip = InetAddress.getLocalHost();
			log.info("get host name () : {}", ip.getHostName());
			log.info("get host address () : {}", ip.getHostAddress());
			log.info("toString() : {}", ip.toString());
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		try{
			ipArr = InetAddress.getAllByName("www.naver.com");
			for (int i = 0; i < ipArr.length; i++) {
				log.info("ipArr {} : {}", i, ipArr[i]);
			}
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
}
