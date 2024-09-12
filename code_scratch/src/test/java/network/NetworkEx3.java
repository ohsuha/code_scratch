package network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkEx3 {
	@Test
	public void testNetworkEx3() {
		URL url = null;
		String address = "https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0";

		try{
			url = new URL(address);
			URLConnection connection = url.openConnection();
			log.info("connection: {}", connection);
			log.info("getAllowUserIntercation() :{}", connection.getAllowUserInteraction());
			log.info("getConnectTimeout():{}", connection.getConnectTimeout());
			log.info("getContentEncoding():{}", connection.getContentEncoding());
			log.info("getContentLength():{}", connection.getContentLength());
			log.info("getContentType():{}", connection.getContentType());
			log.info("getHeaderFields():{}", connection.getHeaderFields());
			log.info("getContent() :{}", connection.getContent());
			log.info("getHeaders():{}", connection.getHeaderFields());
			log.info("getDate() : {}", connection.getDate());
			log.info("getDefatulUserCaches() : {}", connection.getDefaultUseCaches());
			log.info("getDoInput() : {}", connection.getDoInput());
			log.info("getDoOutput() : {}", connection.getDoOutput());
			log.info("getExpiration() : {}", connection.getExpiration());
			log.info("getLastModified() : {}", connection.getLastModified());
			log.info("getURL() : {}", connection.getURL());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
