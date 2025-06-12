
public class Transaction {
    //variable declaration
    private BankAccount account;
    private double amount;
    
    //constructor
    public Transaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }
    
    //getter method
    public double getAmount(){return amount;}
    
    //calculation method
    public void execute() {
        account.balance += amount;
        account.updateBalance();
    }
}
