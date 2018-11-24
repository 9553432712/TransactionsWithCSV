
public class Balance {
	int ACCOUNT_NO;
	String ACCOUNT_NAME;
	int BALANCE;
	
	Balance(int acc,String name, int bal){
		this.ACCOUNT_NAME=name;
		this.ACCOUNT_NO=acc;
		this.BALANCE=bal;
	}
	
	public void setACCOUNT_NO(int ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public void setBALANCE(int BALANCE) {
        this.BALANCE = BALANCE;
    }

    public int getACCOUNT_NO() {
    
        return ACCOUNT_NO;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public int getBALANCE() {
        return BALANCE;
    }
    public String toString() {
    	return ACCOUNT_NAME+"\t"+ACCOUNT_NO+"\t"+BALANCE;
    }

}
