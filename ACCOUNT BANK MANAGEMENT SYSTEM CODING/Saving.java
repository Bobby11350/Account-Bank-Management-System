import java.util.ArrayList;

public class Saving extends BankAccount {
    //variable declaration
    private BankStatement[] bankStatements;
    private int statementCount;
    
    //constructor
    public Saving(String type, String name, long accNum, double balance, double interestRate) {
        super(type, name, accNum, balance, interestRate);
        this.bankStatements = new BankStatement[10]; // Assuming a maximum of 10 transactions initially
        this.statementCount = 0;
    }
    
    //to add transaction to bank statement
    public void addTransaction(String date, String description, double amount, double bal) {
        BankStatement statement = new BankStatement(date,description,amount,bal);
        bankStatements[statementCount++] = statement;
    }
    
    //to update balance
    @Override
    public void updateBalance() {
        for (int i = 0; i < statementCount; i++){
        BankStatement statement = bankStatements[i];
        double newBalance = 0;
        newBalance = statement.getBal() + (statement.getBal()*(getInterestRate()/100));
        setBalance(newBalance);
    }
    }
    
    //to display bank statement details
    @Override
    public String toString() {
        String header = "\n Type : " + type +
            "\n Name : " + name +
            "\n Account Number : " + accNum + 
            "\n Interest Rate : " + interestRate + " % " + 
            "\n Total Balance : RM " + String.format("%.1f", balance) + 
            "\n Bank Statement : " +  
            "\n \n -----------------------------------------------------------------------------------" +
            "\n ENTRY DATE     TRANSACTION DESCRIPTION     TRANSACTION AMOUNT     STATEMENT BALANCE" +
            "\n -----------------------------------------------------------------------------------";

        String entries = "";
        for (int i = 0; i < statementCount; i++) {
            BankStatement statement = bankStatements[i];
            entries += String.format("\n %-14s %-27s -RM %-19.1f RM %.1f" ,
                                      statement.getDate(),
                                      statement.getDescription(),
                                      statement.getAmount(),
                                      statement.getBal());
        }

        return header + entries + "\n -----------------------------------------------------------------------------------";
    }
}
