import java.util.List;

public class TransactionTracker {
	
	public static void main(String ar[]) {
		List<Balance> BalanceList = CSVOperations.readBalanceFile();
		List<Transaction> TransactionList = CSVOperations.readTransactionsFile();
		TransactionTracker transactionTrack = new TransactionTracker();
		System.out.println("\n====================RESULT BALANCE=============================\n");
		List<Balance> resultBalanceList =  transactionTrack.resultTransaction(BalanceList, TransactionList);
	}
	public List resultTransaction(List<Balance> Balances, List<Transaction> Transactions) {
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
        return Balances;
    }

}
