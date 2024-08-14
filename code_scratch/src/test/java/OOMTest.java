import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OOMTest {
	static ArrayList list = new ArrayList();
	static StringBuilder dummyStr;

	@Test
	@DisplayName("Static OOM 테스트")
	public void OOMTest() {
		dummyStr = new StringBuilder("123123123");
		for (int i = 0; i < 100; i++) {
			dummyStr.append(dummyStr);
		}

		list.add(dummyStr.toString());
	}
}
