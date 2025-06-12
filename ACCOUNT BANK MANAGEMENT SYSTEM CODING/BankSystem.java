import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[10]; // Assuming a maximum of 10 accounts
        int accountCount = 0;

        // Read data from input file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null && accountCount < accounts.length) {
                String[] data = line.split(",");
                String type = data[0];
                String name = data[1];
                long accNum = Long.parseLong(data[2]);
                double balance = Double.parseDouble(data[3]);
                double interestRate = Double.parseDouble(data[4]);

                if (type.equals("SAVING")) {
                    Saving savingAccount = new Saving(type, name, accNum, balance, interestRate);
                    accounts[accountCount++] = savingAccount;

                    // Read transactions until "END" is encountered
                    while ((line = br.readLine()) != null && !line.equals("END")) {
                        String[] transactionData = line.split(",");
                        String date = transactionData[0];
                        String description = transactionData[1];
                        double amount = Double.parseDouble(transactionData[2]);
                        double bal = Double.parseDouble(transactionData[3]);
                        savingAccount.addTransaction(date, description, amount, bal);
                    }
                } else if (type.equals("CURRENT")) {
                    double transactionFee = Double.parseDouble(data[5]);
                    accounts[accountCount++] = new Current(type, name, accNum, balance, interestRate, transactionFee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Edit existing data (update)
        if (accountCount > 0) {
            accounts[0].balance += 1000; // Adding 1000 to the balance of the first account
        }

        // Print details of all accounts
        System.out.println(" ======================= ");
        System.out.println(" DETAILS OF ALL ACCOUNTS ");
        System.out.println(" ======================= ");

        // Perform a minimum of 3 tasks to objects applying inheritance and/or polymorphism
        for (int i = 0; i < accountCount; i++) {
            accounts[i].updateBalance(); // Task 1: Update balance using polymorphism
            System.out.println(accounts[i]); // Task 2: Print account details using polymorphism
        }

        // Perform calculation
        double totalBalance = 0;
        for (int i = 0; i < accountCount; i++) {
            totalBalance += accounts[i].getBalance();
        }
        System.out.println("\n Total balance of all accounts: RM " + String.format("%.1f", totalBalance));

        // Example transaction
        if (accountCount > 1) {
            Transaction transaction = new Transaction(accounts[1], 500);
            transaction.execute(); // Execute transaction (deposit 500)
            System.out.println("\n ================== " + "\n AFTER TRANSACTION " + "\n ================== " + "\n\n Transaction Description : DEPOSIT " + "\n Transaction Amount : RM " + transaction.getAmount() + " \n " + accounts[1]);
        }                          
    }
}

