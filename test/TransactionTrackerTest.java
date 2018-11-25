import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionTrackerTest {
	
	List<Balance> mockResult = new ArrayList<Balance>();
	
	@Before
	public void setUp() {
		Balance b = new Balance(101,"LEISURE", 60);
		mockResult.add(b);
		b = new Balance(102,"SALARY", 950);
		mockResult.add(b);
		b = new Balance(103,"FOOD AND DRINK", 340);
		mockResult.add(b);
	}
	
	
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
	@Test
	public void checkTransactionsResults() {
		try {
			List<Balance> BalanceList = CSVOperations.readBalanceFile();
			List<Transaction> TransactionList = CSVOperations.readTransactionsFile();
			TransactionTracker transactionTrack = new TransactionTracker();
			List<Balance> resultBalanceList =  transactionTrack.resultTransaction(BalanceList, TransactionList);
			Assert.assertEquals(mockResult, resultBalanceList);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
