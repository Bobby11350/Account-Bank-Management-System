public class Current extends BankAccount {
    //variable declaration
    private double transactionFee;
    
    //constructor
    public Current(String type, String name, long accNum, double balance, double interestRate, double transactionFee) {
        super(type, name, accNum, balance, interestRate);
        this.transactionFee = transactionFee;
    }
    
    //to update balance
    @Override
    public void updateBalance() {
        double newBalance = getBalance() - transactionFee;
        setBalance(newBalance);
    }
    
    //to display current details
    @Override
    public String toString() {
        return ("\n Type : " + type + "\n Name : " + name + "\n Account Number : " + accNum + "\n Transaction Fee : RM " + transactionFee + "\n Total Balance : RM " + balance);
    }

}
