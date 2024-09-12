package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetworkEx4 {
	@Test
	public void test() {
		URL url = null;
		BufferedReader input = null;
		String address = "https://section.blog.naver.com/BlogHome.naver?directoryNo=0&currentPage=1&groupId=0";
		String line = "";

		try{
			url = new URL(address);
			InputStream inputStream = url.openStream();
			input = new BufferedReader(new InputStreamReader(inputStream));

			while ((line = input.readLine()) != null) {
				log.info(line);
			}

			input.close();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
