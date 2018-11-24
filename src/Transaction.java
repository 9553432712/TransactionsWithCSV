
public class Transaction {
	int TRANS_ID;
	int DEBIT_ACCOUNT;
	int CREDIT_ACCOUNT;
	String DESCRIPTION;
	int AMOUNT;
	public int getTRANS_ID() {
        return TRANS_ID;
    }

    public int getDEBIT_ACCOUNT() {
        return DEBIT_ACCOUNT;
    }

    public int getCREDIT_ACCOUNT() {
        return CREDIT_ACCOUNT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public void setTRANS_ID(int TRANS_ID) {
        this.TRANS_ID = TRANS_ID;
    }

    public void setDEBIT_ACCOUNT(int DEBIT_ACCOUNT) {
        this.DEBIT_ACCOUNT = DEBIT_ACCOUNT;
    }

    public void setCREDIT_ACCOUNT(int CREDIT_ACCOUNT) {
        this.CREDIT_ACCOUNT = CREDIT_ACCOUNT;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setAMOUNT(int AMOUNT) {
        this.AMOUNT = AMOUNT;
    }
    public String toString() {
    	return DESCRIPTION+"\t"+AMOUNT;
    }
}
