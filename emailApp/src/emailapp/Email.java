package emailapp;
import java.util.*;
public class Email {
    private String firstName, lastName, password, department, alternateEmail, email, companySuffix = "aeyPvtLtd.com";
    private int mailboxCapacity = 500, defaultPasswordLength = 10;

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

//      Call a method asking for the department, which return the department
        this.department = setDepartment();

//      Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

//      Combine element to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + '@' + department + "." + companySuffix;
    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("New Worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "Sales";
        }
        else if(depChoice == 2){
            return "Dev";
        }
        else if(depChoice == 3){
            return "Acct";
        }
        else{
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

//  Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

//  Set the alternate email
    public void setAlternateEmail(String altEmail){
    this.alternateEmail = altEmail;
    }

//  Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
