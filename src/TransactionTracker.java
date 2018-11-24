import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class TransactionTracker {
	
	public static void main(String ar[]) {
		readBalanceFile();
		readTransactionsFile();
		resultTransaction();
	}
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static List<Balance> Balances = new ArrayList<Balance>();
	private static List<Transaction> Transactions = new ArrayList<Transaction>();
	
	public static void readBalanceFile() {

		BufferedReader fileReader = null;
     
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("balance.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new Balance object and fill his  data
                	Balance balance = new Balance(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
                	Balances.add(balance);
				}
            }
            
            //Print the new Balance list
            for (Balance balance : Balances) {
				System.out.println(balance.toString());
			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

	}
	public static void readTransactionsFile() {
		BufferedReader fileReader = null;     
        try {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader("transaction.csv"));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new Transaction object and fill his  data
                	Transaction transaction = new Transaction();
                	transaction.setTRANS_ID(Integer.parseInt(tokens[0]));
                	transaction.setDEBIT_ACCOUNT(Integer.parseInt(tokens[1]));
                	transaction.setCREDIT_ACCOUNT(Integer.parseInt(tokens[2]));
                	transaction.setDESCRIPTION(tokens[3]);
                	transaction.setAMOUNT(Integer.parseInt(tokens[4]));
                	Transactions.add(transaction);
				}
            }
            
            //Print the new Transaction list
            for (Transaction transaction : Transactions) {
				System.out.println(transaction.toString());
			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
	}
	public static void resultTransaction() {
    	for(int i=0;i<Transactions.size();i++) {
    		for(int j=0;j<Balances.size();j++) {
    			if(Balances.get(j).getACCOUNT_NO()==Transactions.get(i).getDEBIT_ACCOUNT()) {
    				Balances.get(j).setBALANCE(Balances.get(j).getBALANCE()-Transactions.get(i).getAMOUNT());
    			}
    			if(Balances.get(j).getACCOUNT_NO()==Transactions.get(i).getCREDIT_ACCOUNT()) {
    				Balances.get(j).setBALANCE(Balances.get(j).getBALANCE()+Transactions.get(i).getAMOUNT());
    			}
    		}
    	}
    	//Print the new Balance list
        for (Balance balance : Balances) {
			System.out.println(balance.toString());
		}
    }

}