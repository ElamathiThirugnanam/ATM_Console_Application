import java.lang.*;
import java.util.*;
public class ATM
{
    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");
        Scanner ip=new Scanner(System.in);
        System.out.println("Choose any one:");
        System.out.println("1 if you are an Admin");
        System.out.println("2 if you are a Customer");
        System.out.println("3 if you are a Bank");
        int role=ip.nextInt();
        List<bankDetails> banks=new ArrayList<>();
        List<customerDetails> customerDetailsList=new ArrayList<>();
        int amountInATM=0;
        switch(role)
        {
            case 1:
                Admin admin=new Admin();
                System.out.println("Choose any one function to do");
                System.out.println("1 - To add Bank details");
                System.out.println("2 - To add Customer details");
                System.out.println("3 - To deposit amount in ATM");
                int function=ip.nextInt();
                switch(function)
                {
                    case 1:
                        System.out.println("Enter Bank Name:");
                        if(!ip.hasNextLine())
                        {
                            System.out.println("Invalid Bank Name");
                            break;
                        }
                        String bankName=ip.nextLine();
                        System.out.println("Enter IFSC code");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Invalid IFSC code");
                            break;
                        }
                        int ifscCode=ip.nextInt();
                        admin.addBank(bankName,ifscCode,banks);
                        break;
                    case 2:
                        System.out.println("Enter your user name");
                        if(!ip.hasNextLine())
                        {
                            System.out.println("Invalid User Name");
                            break;
                        }
                        String userName=ip.nextLine();
                        System.out.println("Enter PIN Number ");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Invalid PIN Number");
                            break;
                        }
                        int pin=ip.nextInt();
                        System.out.println("Enter the account balance");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Invalid Balance");
                            break;
                        }
                        int balance=ip.nextInt();
                        admin.addCustomer(userName,pin,balance,customerDetailsList);
                        break;
                    case 3:
                        System.out.println("Enter the amount to deposit");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid amount");
                            break;
                        }
                        int amount=ip.nextInt();
                        admin.addAmount(amountInATM,amount);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                break;
            case 2:
                Customer customer=new Customer();
                System.out.println("Choose any one function to do");
                System.out.println("1-Pin Change");
                System.out.println("2-Cash withdrawal");
                System.out.println("3-Check the balance");
                System.out.println("4-Amount deposit");
                int pin=2024;
                int balance=2400;
                function=ip.nextInt();
                switch(function)
                {
                    case 1:
                        System.out.println("Enter your new PIN");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid PIN Number");
                            break;
                        }
                        pin=ip.nextInt();
                        System.out.println("Pin changed successfully");
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid amount");
                            break;
                        }
                        int withdrawAmount=ip.nextInt();
                        System.out.println("Enter your PIN Number");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid PIN Number");
                            break;
                        }
                        int userPin=ip.nextInt();
                        customer.withdraw(pin,balance,withdrawAmount,userPin);
                        break;
                    case 3:
                        System.out.println("Enter your PIN Number");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid PIN Number");
                            break;
                        }
                        userPin=ip.nextInt();
                        customer.checkBalance(userPin,pin,balance);
                        break;
                    case 4:
                        System.out.println("Enter your PIN Number");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid PIN Number");
                            break;
                        }
                        userPin=ip.nextInt();
                        System.out.println("Enter amount to be deposited");
                        if(!ip.hasNextInt())
                        {
                            System.out.println("Enter valid amount");
                            break;
                        }
                        int depositAmount=ip.nextInt();
                        customer.deposit(userPin,pin,balance,depositAmount);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                break;
            case 3:
                Bank bank=new Bank();
                System.out.println("Choose any one function to do");
                System.out.println("1-Bank Details");
                System.out.println("2-User Details");
                function=ip.nextInt();
                switch(function)
                {
                    case 1:
                        bank.bankdetails(banks);
                        break;
                    case 2:
                        bank.userdetails(customerDetailsList);
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }
                break;
            default:
                System.out.println("Kindly enter valid choice");
        }
    }
}
class Admin
{
    public static void addBank(String bankName,int ifscCode,List<bankDetails> banks)
    {
        banks.add(new bankDetails(bankName,ifscCode));
        System.out.println("Bank added successfully");
    }
    public static void addCustomer(String userName, int pin, int balance,List <customerDetails> customerDetailsList)
    {
        customerDetailsList.add(new customerDetails(userName,pin,balance));
        System.out.println("Customer details added successfully");
    }
    public static void addAmount(int amountInATM,int amount)
    {
        amountInATM+=amount;
        System.out.println("Amount added successfully");
        System.out.println("Current amount in ATM: "+amountInATM);
    }

}
class customerDetails
{
    String userName;
    int pin;
    int balance;
    public customerDetails(String userName,int pin,int balance)
    {
        this.userName=userName;
        this.pin=pin;
        this.balance=balance;
    }
}
class bankDetails {
    String bankName;
    int IFSCcode;

    public bankDetails(String bankName, int IFSCcode)
    {
        this.bankName=bankName;
        this.IFSCcode=IFSCcode;
    }
}
class Customer
{
    public static void withdraw(int pin,int balance,int withdrawAmount,int userPin)
    {
        if(pin!=userPin)
        {
            System.out.println("Incorrect PIN");
        }
        else if(withdrawAmount>balance)
        {
            System.out.println("Insufficient balance");
        }
        else
        {
            balance-=withdrawAmount;
            System.out.println("Amount withdrew successfully "+"remaining balance: "+balance);

        }
    }

    public static void checkBalance(int userPin, int pin,int balance) {
        if (userPin != pin) {
            System.out.println("Incorrect pin");
        } else
        {
            System.out.println("Your current balance is: "+balance);
        }
    }
    public static void deposit(int userPin,int pin,int balance,int depositAmount)
    {
        if (userPin != pin) {
            System.out.println("Incorrect pin");
        } else
        {
            balance+=depositAmount;
            System.out.println("Successful deposition of amount");
        }
    }
}
class Bank
{
    public static void bankdetails(List<bankDetails> banks)
    {
       for(int i=0;i<banks.size();i++)
       {
           System.out.println((i+1)+" "+banks.get(i).bankName+" "+banks.get(i).IFSCcode);
       }
    }
    public static void userdetails(List<customerDetails> customerDetailsList)
    {
        for(int i=0;i<customerDetailsList.size();i++)
        {
            System.out.println((i+1)+" "+customerDetailsList.get(i).userName+" "+customerDetailsList.get(i).pin+" "+customerDetailsList.get(i).balance);
        }
    }
}




