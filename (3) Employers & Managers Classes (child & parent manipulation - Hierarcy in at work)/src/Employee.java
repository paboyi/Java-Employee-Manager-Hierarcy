import javax.swing.*;

public class Employee {
    private int ID;
    static int nextId = 0;
    private String name;
    private String surname;

    private double salary = 1000.00;
    Manager manager;



    /* Setters */ //Setters are void

    public void setName (String name1)
    {
        this.name = name1; //this.name (class attribute), name1 (argument to be given from Main)

    }

    public void setSurname (String surname1)
    {
        this.surname = surname1;
    }

    public void setSalary (double salary1)
    {
        this.salary = salary1;
    } // You can chnage the salary if you don't like it. Default is 1000.00

    /* End of Setters */





    /* Getters */
    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    /*End of Getters */



    Employee(String name, String surname)
    {
        nextId++;
        this.ID = nextId;
        this.setName(name);
        this.setSurname(surname);
    }


    double raise;
    double raiseSalary(double percentage)
    {
       double increase = ((double) percentage / 100) * (getSalary()/1);
        System.out.println("\nSalary - " + getSalary() + ",Increase - " + increase);

        raise = (increase + getSalary());
        return raise;
    }

    public double getSalary()
    {
        if (raise > 0)
        {
            return raise;
        }
        else {
            return salary;
        }
    }



    public String getManagerName(){
        String managerNameResult = null;

        if (this.manager != null)
        {
            managerNameResult = "' " + getName() +" "+ getSurname() + "'s ' " + " Manager's name is  '" + manager.getName() + " " + manager.getSurname() + "'.";
            return managerNameResult;
        }
        else {
            if (this.manager == null)
            {
                managerNameResult = "No manager";
            }
        }
        return managerNameResult;
    }


    //manger.getName();

    public Employee getTopManager() {

        Employee now = null;

        if (this.manager == null) {
             now = this;
             System.out.println("\nNo Top Manager. The Same Employee.");
        }
        else
        {
            Employee next = this.manager;
           for (int i = 0; next.manager != null; i++)
           {
               next = next.manager;
           }
           now = next;
            System.out.println("\nTop Manager for " + this.getName() + " " + this.getSurname() + " is ->");

        }

        return now;
    }




    public String toString() {
        return "\nEMPLOYEE ID: " + ID +
                "\n | NAME: " + name +
                "\n | SURNAME: " + surname +
                "\n | SALARY : " + salary;

    }

    /*
    • getters, setters;
• constructor with parameters for initialization of the corresponding fields of the class;
• increase salary by n% raiseSalary (double p); // method
• setting the number value for the object setId (); // method
• get a string representation of the object toString (); // method
     */



//End of Employees class
}
