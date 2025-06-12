
public abstract class BankAccount
{
    //variable declaration
    protected String type;
    protected String name;
    protected long accNum;
    protected double balance;
    protected double interestRate;

    //default constructor
    public BankAccount() {}

    //normal constructor
    public BankAccount(String type, String name, long accNum, double balance, double interestRate) {
        this.type = type;
        this.name = name;
        this.accNum = accNum;
        this.balance = balance;
        this.interestRate = interestRate;
    }
    
    //setter method
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    //getter method
    public String getType(){return type;}

    public String getName(){return name;}

    public long getAccNum(){return accNum;}

    public double getBalance(){return balance;}

    public double getInterestRate(){return interestRate;}
    
    //to display bank account detail
    public String toString()
    {
        return("\n Type : " + type + "\n Name : " + name + "\n Account Number : " + accNum + "\n Balance : RM " + balance +"\n Interest Rate : " + interestRate + "%");
    }
    
    //method declaration
    public abstract void updateBalance();
}

