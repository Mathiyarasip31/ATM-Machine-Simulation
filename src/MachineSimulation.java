import java.util.Scanner;

class InsufficientFundsException extends  Exception
{
    public InsufficientFundsException(String string)
    {
        super(string);
    }
}
class InvalidAmountException extends Exception
{
    public InvalidAmountException(String string)
    {
        super(string);
    }
}


class UserDetails
{
    private int balance;
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
public class MachineSimulation {
    public static void Check (int amount, int balance) throws InsufficientFundsException,InvalidAmountException
    {

        if(amount>balance)
        {
            throw new InsufficientFundsException("You didn't have sufficient balance");
        }

        if(amount<=0)
        {
            throw new InvalidAmountException("Invalid amount! Enter valid amount to withdraw");
        }
        else
        {
            System.out.println("You can withdraw your amount");
        }
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int account_number=scanner.nextInt();
        int amount=scanner.nextInt();
        String update= scanner.next();
        UserDetails userDetails=new UserDetails();
        userDetails.setBalance(10000);

        if(update.equals("deposit"))
        {
            System.out.println(userDetails.getBalance()+amount);
        }
        else
        {
            try
            {
                Check(amount,userDetails.getBalance());
            }
            catch (InsufficientFundsException exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (InvalidAmountException exception)
            {
                System.out.println(exception.getMessage());
            }
            System.out.println(userDetails.getBalance()-amount);
        }
    }
}
