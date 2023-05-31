// Review project (Bank App) by "Jinho Nam"

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    // 8. read bank accounts from file
    public static void readAccountsFromFile(ArrayList<Account> accounts) throws IOException {
        FileInputStream fileByteStream = new FileInputStream("bank3.csv");
        Scanner inFS = new Scanner(fileByteStream);
        // CSV: Comma-Separated Values
        while (inFS.hasNextLine()) {
            String line = inFS.nextLine();
            String[] arrayOfEachLine = line.split(", "); // split method

            for (int i = 0; i < arrayOfEachLine.length; i++ ) {
                // System.out.println(arrayOfEachLine[i]);
                // Integer accountNum = Integer.parseInt(arrayOfEachLine[0]);
                Account a = new Account(Integer.parseInt(arrayOfEachLine[0]), arrayOfEachLine[1], arrayOfEachLine[2], Double.parseDouble(arrayOfEachLine[3]));
                accounts.add(a);
            }
        }
        inFS.close();
        fileByteStream.close();
    }

    // 7. save bank accounts to file
    public static void saveAccountsToFile(ArrayList<Account> accounts) throws IOException {
        FileOutputStream fileOutStream = new FileOutputStream("bank3.csv");
        PrintWriter outFS = new PrintWriter(fileOutStream);
        
        for (Account eachAccount : accounts) {
            outFS.println(eachAccount);
        }

        outFS.close();
        fileOutStream.close();
    }

    // 6. transfer between accounts
    public static void transferring(ArrayList<Account> accounts) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type the \"from\" account number.");
        int from_account = scnr.nextInt();
        System.out.println("Type the \"to\" account number.");
        int to_account = scnr.nextInt();
        System.out.println("Type the amount of money you would like to pop.");
        int amountOfPop = scnr.nextInt();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == from_account) {
                if (accounts.get(i).getAccountFunds() >= amountOfPop) {
                    accounts.get(i).setAccountFunds(accounts.get(i).getAccountFunds() - amountOfPop);

                    for (int j = 0; j < accounts.size(); j++) {
                        if (accounts.get(j).getAccountNumber() == to_account) {
                            accounts.get(j).setAccountFunds(accounts.get(j).getAccountFunds() + amountOfPop);
                        }
                    }
                    
                }
            }
        }
        scnr.close();
    }

    // 5. withdraw from account
    public static void withDrawing(ArrayList<Account> accounts) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type the account number.");
        int accountNumber = scnr.nextInt();
        System.out.println("Type the amount of deposit");
        double amountOfWithdraw = scnr.nextDouble();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                if (accounts.get(i).getAccountFunds() > amountOfWithdraw) {
                    accounts.get(i).setAccountFunds(accounts.get(i).getAccountFunds() - amountOfWithdraw);
                }
            }
        }
        scnr.close();
    }
    
    // 4. deposit to account
    public static void depositing(ArrayList<Account> accounts) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type the account number.");
        int accountNumber = scnr.nextInt();
        System.out.println("Type the amount of deposit");
        double amountOfDeposit = scnr.nextDouble();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.get(i).setAccountFunds(accounts.get(i).getAccountFunds() + amountOfDeposit);
            }
        }
        scnr.close();
    }

    // 3. account details for account number
    public static void getDetailByAccountNum(ArrayList<Account> accounts) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type the account number.");
        int accountNumber = scnr.nextInt();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                System.out.println(accounts.get(i));
            }
        }
        scnr.close();
    }

    // 2. account details for user
    public static void getDetailByUserName(ArrayList<Account> accounts) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Type the username.");
        String userName = scnr.nextLine();
        
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountOwner().equalsIgnoreCase(userName)) {
                System.out.println(accounts.get(i));
            }
        }
        scnr.close();
    }

    // 1. add account
    public static Account accountCreate() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Provide information for the new account: ");
        System.out.print("Account owner: ");
        String owner = scnr.nextLine();
        System.out.print("Account type: ");
        String type = scnr.nextLine();
        System.out.print("Initial funds: ");
        Double money = scnr.nextDouble();

        scnr.close();
        return new Account(owner, type, money);
    }

    public static void printMenu() {
        System.out.println("1. add account");
        System.out.println("2. account details for user");
        System.out.println("3. account details for account number");
        System.out.println("4. deposit to account");
        System.out.println("5. withdraw from account");
        System.out.println("6. transfer between accounts");
        System.out.println("7. save bank accounts to file");
        System.out.println("8. read bank accounts from file");
        System.out.println("9. show all accounts");
        System.out.println("10. exit program");
    }

    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int userChoice = 0;
        boolean keepPrompting = true;
        ArrayList<Account> accounts = new ArrayList<>();

        do {
            while (keepPrompting) {                
                userChoice = 0;
                printMenu();
                try {
                    userChoice = scnr.nextInt(); // Prompt user for input
                } catch (Exception e) {
                    System.out.println("Invalid data type given. Expected integer.");
                    System.out.println(e.getMessage());
                    scnr.next();
                    System.out.println("");
                    continue;
                }
                // all possible user input with switch statement
                switch (userChoice) {
                    case 1: 
                            // Account newAccount = accountCreate();
                            accounts.add(accountCreate());
                            System.out.println("");
                            break;
                    case 2: 
                            getDetailByUserName(accounts);
                            System.out.println("");
                            break;
                    case 3: 
                            getDetailByAccountNum(accounts);
                            System.out.println("");
                            break;
                    case 4: 
                            depositing(accounts);
                            System.out.println("");
                            break;
                    case 5: 
                            withDrawing(accounts);
                            System.out.println("");
                            break;
                    case 6: 
                            transferring(accounts);
                            System.out.println("");
                            break;
                    case 7: 
                            saveAccountsToFile(accounts);
                            System.out.println("");
                            break;
                    case 8: 
                            readAccountsFromFile(accounts);
                            System.out.println("");
                            break;
                    case 9: 
                            Collections.sort(accounts);
                            // System.out.println(accounts.toString()); *** NO ****
                            for (Account a : accounts) {
                                System.out.println(a);
                            }
                            break;
                    case 10: 
                            scnr.close();
                            System.exit(0);
                            break;
                    default: 
                            System.out.println(userChoice + " is not an option.");
                            break;
                } // switch statement brace
            } // while loop brace
        } while (userChoice != 10); // do-while loop brace

        scnr.close();
    } // main method brace

}
