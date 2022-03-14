package com.gl.credentialGeneration;


// this creates a class with name "Employee" for storing info about different employees
 public class Employee {

    // different characteristics/variables of object employee
    private String firstName;
    private String lastName;
    private String department;
    private String email;
     private String password;

     // setter and getter methods to set and view details of object employee
     public Employee (String firstName, String lastName, String department){
         this.firstName= firstName;
         this.lastName =lastName;
         this.department= department;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
