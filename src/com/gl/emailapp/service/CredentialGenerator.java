package com.gl.emailapp.service;
// imported packages
import com.gl.credentialGeneration.*;
import java.util.*;

// this generates credentials (email and password) for the new employee
public class CredentialGenerator {

    private Employee employee;

    //constructor
    public CredentialGenerator (Employee employee){
        this.employee= employee;
    }

    //method to create an email ID for an object of class employee
    public void generateEmailID (){
        String dept = deptShortName();
        String emailID = employee.getFirstName().toLowerCase()+"."+employee.getLastName().toLowerCase()+"@"+dept+".gl.com";
        employee.setEmail(emailID);
    }

    //method to obtain short name for the department to generate email ID
    private String deptShortName (){
        String dept= employee.getDepartment();
        String shortName="";
        switch (dept){
            case "Technical": shortName ="tech";
                            break;
            case "Admin": shortName="adm";
                            break;
            case "Human Resource": shortName="hr";
                            break;
            case "Legal": shortName="lgl";
                            break;
        }
        return shortName;
    }

    //method to create a password for an object of class employee
    public void generatePassword(){
        String smallLetters="abcdefghijklmnopqrstuvwxyz";
        String capitalLetter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num="0123456789";
        String specialChar="!@#$%^&*|?/<>.,:;";
        String allValues= smallLetters+ capitalLetter+num+specialChar;
        Random randObj= new Random();
        String generatedPassword="";
        generatedPassword+=smallLetters.charAt(randObj.nextInt(smallLetters.length()));
        generatedPassword+=capitalLetter.charAt(randObj.nextInt(capitalLetter.length()));
        generatedPassword+=num.charAt(randObj.nextInt(num.length()));
        generatedPassword+=specialChar.charAt(randObj.nextInt(specialChar.length()));
        for (int i=0;i<4;i++){
            generatedPassword+=allValues.charAt(randObj.nextInt(allValues.length()));
        }
        employee.setPassword(generatedPassword);
    }

    //method to display the generated credentials
    public void showCredentials(){
        System.out.println("Dear "+ employee.getFirstName()+",");
        System.out.println("Your generated credentials are as follows:");
        System.out.println("Email ID: "+ employee.getEmail());
        System.out.println("Password: "+ employee.getPassword());
    }
}
