
/**
 * Write a description of class BankStatement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BankStatement
{
    //variable declaration
    private String date;
    private String description;
    private double amount;
    private double bal;
    
    //normal constructor
    public BankStatement(String date, String description, double amount, double bal)
    {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.bal = bal;
    }
    
    //getter method
    public String getDate(){return date;}

    public String getDescription(){return description;}

    public double getAmount(){return amount;}
    
    public double getBal(){return bal;}
    
    //to display each transaction details
    @Override
    public String toString() {
        return date + "    " + description + "          RM " + amount;
    }    
    
}
