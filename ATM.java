/*
    Task Name ---> ATM INTERFACE

    Task Description ---> We have all come across ATMs in our cities and it is built on Java. This complex project consists of
    five different classes and is a console-based application. When the system starts the user is
    prompted with user id and user pin. On entering the details successfully, then ATM functionalities
    are unlocked. The project allows to perform following operations:

    1.Transactions History

    2.Withdraw

    3.Deposit

    4.Transfer

    5.Quit

    Topics : Java Core Concepts like Data Types , Variables, Conditional Statements, Strings etc.

 */
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isUserAuthenticated = false;
        int userId = 12345;
        int userPin = 1234;
        int choice;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\t\t********Welcome to the ATM**********");
        
        // Authenticate the user
        while (!isUserAuthenticated) {
            System.out.print("Please Enter user ID: \n");
            int enteredId = scanner.nextInt();
            System.out.print("Please Enter user PIN: \n");
            int enteredPin = scanner.nextInt();
            
            if (enteredId == userId && enteredPin == userPin) {
                isUserAuthenticated = true;
                System.out.println("User authenticated.");
            } else {
                System.out.println("Invalid user ID or PIN. Please try again.");
            }
        }
        int balance=0;
        String[] trans=new String[100];
        int t1=0;
        // User authenticated, show options
        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Transactions History\n");
            System.out.println("2. Withdraw\n");
            System.out.println("3. Deposit\n");
            System.out.println("4. Transfer\n");
            System.out.println("5. Quit\n");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Show transaction history
                    int i1=0;
                    if(trans[i1]==null)
                    {
                        System.out.println("\nNo Transaction History\n");
                        break;
                    }
                    while(trans[i1]!=null)
                    {
                        System.out.println(trans[i1]+"\n");
                        i1+=1;
                    }
                    break;
                case 2:
                    // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    if(withdrawAmount>balance)
                    {
                        System.out.println("Unavailable Balance");
                        break;
                    }
                    System.out.println("Withdrawing " + withdrawAmount + "...");
                    balance-=withdrawAmount;
                    trans[t1]="Withdrawing"+"\t"+String.valueOf(withdrawAmount);
                    t1+=1;
                    System.out.println("After Withdrawing , Your Current Balance is :"+balance);
                    break;
                case 3:
                    // Deposit
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    System.out.println("Depositing " + depositAmount + "...");
                    balance+=depositAmount;
                    trans[t1]="Depositing"+"\t"+String.valueOf(depositAmount);
                    t1+=1;
                    System.out.println("After Depositing , Your Current Balance is :"+balance);
                    break;
                case 4:
                    // Transfer
                    System.out.print("Enter amount to transfer: ");
                    int transferAmount = scanner.nextInt();
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccount = scanner.nextInt();
                    if(transferAmount>balance)
                    {
                        System.out.println("No sufficient money\n");
                    }
                    System.out.println("Transferring " + transferAmount + " to account " + recipientAccount + "...");
                    balance-=transferAmount;
                    trans[t1]="Withdrawing"+"\t"+String.valueOf(transferAmount);
                    t1+=1;
                    System.out.println("After Transferring , Your Current Balance is :"+balance);
                    break;
                case 5:
                    // Quit
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
