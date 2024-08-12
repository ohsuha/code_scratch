import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("String + 테스트")
	public void StringTest() {
		long startTime = System.nanoTime();

		String strSQL = "";
		for (int i = 0; i <= 1000; i++) {
			strSQL += i;
		}

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("nano seconds :" +  timeElapsed);
	}

	@Test
	@DisplayName("String builder append 테스트")
	public void StringBuilderTest() {
		long startTime = System.nanoTime();

		StringBuilder strSQL = new StringBuilder("");
		for (int i = 0; i <= 1000; i++) {
			strSQL.append(i);
		}

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("nano seconds :" +  timeElapsed);
	}

	@Test
	@DisplayName("String buffer append 테스트")
	public void StringBufferTest() {
		long startTime = System.nanoTime();

		StringBuffer strSQL = new StringBuffer("");
		for (int i = 0; i <= 1000; i++) {
			strSQL.append(i);
		}

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("nano seconds :" +  timeElapsed);
	}
}
