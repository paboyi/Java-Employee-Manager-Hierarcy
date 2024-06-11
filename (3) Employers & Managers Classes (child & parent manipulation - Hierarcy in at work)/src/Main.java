
public class Main {
    public static void main(String[] args) {

       Employee Anna = new Employee("Anna", "One");
       Employee Bianca = new Employee("Bianca", "Two");
       Employee Camil = new Employee("Camil", "Three");
       Employee Daniel = new Employee("Daniel", "Four");


       // Creating Managers (they are also employee objects, check with nextId)
       Manager manager_1 = new Manager("Hugh", "Man_One");
       Manager manager_2 = new Manager("Ali", "Man_Two");
       Manager manager_3 = new Manager("Jasmine", "Man_Three");
       Manager manager_4 = new Manager("Ola", "Man_Four");
       Manager manager_5 = new Manager("Julia", "Man_Five");
       Manager manager_6 = new Manager("Thomas", "Man_Six");

        // Setting managers for employees
       Anna.manager = manager_1; //setting an ordinary Employee's manager

       Bianca.manager = manager_1;
       Camil.manager = manager_2;

       manager_1.manager = manager_2; //setting manager to a Manager

       Daniel.manager = manager_3;

       manager_3.manager = manager_4;
       manager_4.manager = manager_5;
       manager_5.manager = manager_6;


       P.rintln("\n\n------------------------------------------------------------------------");
       // checking to see if Managers are counted as Employees
       System.out.println("\nEmployee count = " + Employee.nextId + ".");


       P.rintln("\n\n------------------------------------------------------------------------");
       // List all Employees
       System.out.println(Anna);
       System.out.println(Bianca);
       System.out.println(Camil);
       System.out.println(Daniel);
       System.out.println(manager_1);
       System.out.println(manager_2);
       System.out.println(manager_3);
       System.out.println(manager_4);
       System.out.println(manager_5);
       System.out.println(manager_6);

       P.rintln("\n\n------------------------------------------------------------------------");
       // change salary of normal employees
       Anna.setSalary(800.00);
       System.out.println("Salary for " + Anna.getName() + " = " + Anna.getSalary());
       P.rint("     ----------     ");

       Daniel.setSalary(700.00);
       Daniel.raiseSalary(10);
       System.out.println("Salary for " + Daniel.getName() + " = " + Daniel.getSalary());
       P.rint("     ----------     ");


       // change salary of Managers
       P.rintln("\n");
       manager_4.raiseSalary(2);
       manager_4.setBonus(200);
       System.out.println("Salary for " + manager_4.getName() + " = " + manager_4.getSalary());
       P.rint("     ----------     ");


       System.out.println("\nChanging default salary for a Manager");
       System.out.println("Salary for " + manager_6.getName() + " = " + manager_6.getSalary());
       manager_6.setSalary(950.00);
       System.out.println("Salary for " + manager_6.getName() + " = " + manager_6.getSalary());


       // Getting the Manager of an Employee
       P.rintln("\n\n------------------------------------------------------------------------");
       // normal manager
       P.rintln(manager_3.getManagerName());
       P.rintln(Bianca.getManagerName());
       P.rintln(manager_6.getManagerName());


       // Top manager
       P.rintln("\n\n------------------------------------------------------------------------");
       P.rintln(String.valueOf(manager_3.getTopManager()));
       P.rint("     ----------     ");
       P.rintln(String.valueOf(manager_6.getTopManager()));
       P.rint("     ----------     ");
       P.rintln(String.valueOf(Camil.getTopManager()));
       P.rint("     ----------     ");

    }

}