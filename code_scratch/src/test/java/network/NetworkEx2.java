package network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkEx2 {
	@Test
	public void test1() {
		try {
			URL url = new URL("https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0");
			log.info("url.getAuthority() : {}", url.getAuthority());
			log.info("url.getContent() : {}", url.getContent());
			log.info("url.getDefaultPort() : {}", url.getDefaultPort());
			log.info("url.getFile() : {}", url.getFile());
			log.info("url.getHost() : {}", url.getHost());
			log.info("url.getPath() : {}", url.getPath());
			log.info("url.getProtocol() : {}", url.getProtocol());
			log.info("url.getQuery() : {}", url.getQuery());
			log.info("url.getRef() : {}", url.getRef());
			log.info("url.getUserInfo(): {}", url.getUserInfo());
			log.info("url.toExternalForm() : {}", url.toExternalForm());
			log.info("url.getPort() : {}", url.getPort());
			log.info("url.toURI() : {}", url.toURI());
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
