// Review project (Bank App) by "Jinho Nam"

import java.util.*;
import java.lang.Comparable;

public class Account implements Comparable<Account> {
  private Integer accountNumber;
  private String accountOwner;
  private String accountType;
  private Double money;

  public Account() {
    accountNumber = 0;
    accountOwner = "None";
    accountType = "None";
    money = (double) 0;
  }

  public Account(String owner, String type, Double money) {
    this.accountOwner = owner;
    this.accountType = type;
    this.money = money;
    this.accountNumber = generateAccountNumber(owner);
  }

  public Account(Integer accountNumber, String owner, String type, Double money) {
    this.accountNumber = accountNumber;
    this.accountOwner = owner;
    this.accountType = type;
    this.money = money;
  }

  // Get/Set methods for account number
  private Integer generateAccountNumber(String s) {
    Random randGen = new Random();
    Integer accountNum = s.hashCode() + randGen.nextInt(2000);
    System.out.println("Generate account number " + Math.abs(accountNum));
    return Math.abs(accountNum);
  }

  public int getAccountNumber() {
    return this.accountNumber;
  }

  // Get/Set methods for account owner
  public void setAccountOwner(String newOwner) {
    this.accountOwner = newOwner;
  }

  public String getAccountOwner() {
    return this.accountOwner;
  }

  // Get/Set methods for account funds
  public Double getAccountFunds() {
    return this.money;
  }

  public void setAccountFunds(Double money) {
    this.money = money;
  }
  
  // Set method for account type
  public void setAccountType(String type) {
    this.accountType = type;
  }

  @Override
  public int compareTo(Account a) {
    // sort accounts by owner in the ascending order
    if (this.accountOwner.compareToIgnoreCase(a.accountOwner) > 0) {
      return 1;
    }
    else if (this.accountOwner.compareToIgnoreCase(a.accountOwner) < 0) {
      return -1;
    }
    // if owner has same name, sort by account number
    else {
        if ((this.accountNumber - a.accountNumber) > 0) {
          return 1;
        }
        else if ((this.accountNumber - a.accountNumber) < 0) {
          return -1;
        }
        else {
          return 0;
        }
    }
  }

  @Override
  public String toString() {
    return this.accountNumber + ", " + this.accountOwner + ", " + this.accountType + ", " + this.money;
  }

}
