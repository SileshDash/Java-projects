import java.util.Scanner;

public class ATM {
    float Balance;
    int PIN=204560;
    
    
    public void checkPin(){
        System.out.println("Enter Your PIN");
        Scanner sc=new Scanner(System.in);
        int pin=sc.nextInt();
        if(pin==PIN){
            menu();
        }
        else{
            System.out.println("Wrong PIN Entered");
        }
    }
    public void menu(){
        System.out.println("1: Check A/C Balance");
        System.out.println("2: Withdraw Money");
        System.out.println("3: Deposit Money");
        System.out.println("4: EXIT");
        Scanner sc=new Scanner(System.in);
        int Option=sc.nextInt();
        if(Option==1){
            checkBalance();
        }
        else if(Option==2){
            withdrawMoney();
        }
        else if(Option==3){
            depositMoney();
        }
        else if(Option==4){
            exit();
        }
       else{
        System.out.println("Please Choose the valid Option");
       } 
    

    }
    public void checkBalance(){
        System.out.println("Balance"+Balance);
        menu();
    }
    public void withdrawMoney(){
        System.out.println("Enter Amount to Withdraw");
        Scanner sc=new Scanner(System.in);
      float Amount=sc.nextFloat();
        if(Amount>Balance){
            System.out.println("In sufficient Balance");
        }
        else{
            Balance= Balance-Amount;
            System.out.println(Balance+" "+"withdrawal money sucsssfully");
            menu();
        }
    }
    public void depositMoney(){
        System.out.println("Deposit the Amount");
        Scanner sc=new Scanner(System.in);
        float Amount=sc.nextFloat();
        Balance= Balance+Amount;
        System.out.println("Successfully added amount"+" "+Amount);
        System.out.println("your total Balance is"+" "+Balance);
        menu();

    }
    public void exit(){
        System.out.println(" you are exited from the menu");

    }

    public static void main(String[] args) {
        ATM a=new ATM();
        a.menu();
    }
    

    
}
