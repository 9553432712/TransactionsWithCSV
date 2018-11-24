import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TransactionTrackerTest {
	
	@Test
	public void checkBalanceFileExist() {
		
		try {
			File tmpDir = new File("balance.csv");
			boolean exists = tmpDir.exists();
			Assert.assertTrue(exists);
			Assert.assertTrue(tmpDir.isFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void checkTransactionsFileExist() {
		try {
			File tmpDir = new File("transaction.csv");
			boolean exists = tmpDir.exists();
			Assert.assertTrue(exists);
			Assert.assertTrue(tmpDir.isFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
