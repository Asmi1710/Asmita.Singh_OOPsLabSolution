package com.gl.emailapp.UserUI;
// imported packages
import com.gl.credentialGeneration.*;
import com.gl.emailapp.service.*;
import java.util.Scanner;

// this creates a user UI for getting details from the user
public class UserUI {

    //this method generates the credentials by firstly building UI, accepting info and then displaying the details
    public void initiation(){
        Employee employee= buildUI();
        callService(employee);
    }

    // this method calls welcomes section and then section taking inputs from the user
    private Employee buildUI(){
        welcomeSection();
        Employee employee= buildEmployeeCredentials();
        return employee;
    }

    //this method displays the welcome message to the user
    private void welcomeSection(){
        System.out.println("*************************************************************");
        System.out.println("******* Welcome to Credential Generation Application ********");
        System.out.println("*************************************************************");
        System.out.println();
    }

    //this method converts department ID into department's name
    private String getDepartment (int deptNum){
        String deptName="";
        switch (deptNum){
            case 1: deptName ="Technical";
                break;
            case 2: deptName="Admin";
                break;
            case 3: deptName="Human Resource";
                break;
            case 4: deptName="Legal";
                break;
        }
        return deptName;
    }

    //this method take info from the user and creates corresponding object of class employee
    private Employee buildEmployeeCredentials(){
        String firstName, lastName,department;
        int deptNum;
        Scanner userInput= new Scanner(System.in);
        System.out.println("Enter employee's first name:");
        firstName =userInput.next();
        System.out.println("Enter employee's last name:");
        lastName =userInput.next();
        System.out.println("Employee's department:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.println("Select 1/2/3/4 for employee's department");
        deptNum=userInput.nextInt();
        department = getDepartment (deptNum);
        userInput.close();
        Employee employee= new Employee(firstName,lastName,department);
        return employee;
    }

    //this method calls functions generating email ID and password and displaying new credentials
    private void callService(Employee employee) {
        CredentialGenerator generator = new CredentialGenerator(employee);
        generator.generateEmailID();
        generator.generatePassword();
        generator.showCredentials();
    }
}
