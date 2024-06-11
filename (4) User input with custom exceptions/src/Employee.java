import java.util.Scanner; //I want to collect user input when a method is called.

public class Employee {
        private int ID;
        static int nextId = 0;
        private String name;
        private String surname;

        private double salary = 1000.00;
        Manager manager;




    //*******************************************************************************
        // SETTER(s)


    // This will be unique. because I am dealing with EXCEPTION(s)
    // on the side also with Scanner and condition checking ((i.e. if, else, for).


    // Unique SetName().
    // Example of 'throwing' without 'try & catch'.
    // It will 'throw' a custom Exception that will 'be dealt with' in the Main()
    // Because this method 'throws' the Exception, it leaves the responsibility of 'try & catch' to every place where setName() is called. That means for every place You use a setName() you will do a 'try & catch'




    public void setName(String name1) throws FieldLengthLimitException
    { //throws
        if (name1.length() > 10)
        {
            this.name = "Default Name"; //if we use the setName() and the name is > 10. change that name to "Default".
            throw new FieldLengthLimitException("\n ! ! You CANNOT set a name > 10"); // throw new //this is the custom Exception that will be thrown. You have to define it here, and then it will be called in main by a 'try & catch'
        }
        else { // if everything is okay and name is !< 10. then proceed as usual
            this.name = name1;
            //this.name (class attribute), name1 (argument to be given from Main)
        }
    }

    // Unique SetSurname()
    // Example of 'try & catch' without 'throwing'.
    // It will 'try & catch' an exception (custom or ordinary) to catch errors (runtime or conditional).
    // Because it does the 'try & catch' by itself. Anywhere else where you use setSurname() you won't be asked to do a 'try & catch'




    public void setSurname(String surname1) {
        if (surname1.length() > 10)
        {
            try // block of dangerous code that causes issue is usually here. but I have a conditional statement.
                // meaning I only want to catch error is a condition happens therefore things change a little bit.
                // instead of putting the setSurname() inside the try{} block. I am saying if this condition is true (i.e. if my error is true) then try to do this :
                // In this case. If error is true, then try to set that name to default and throw an Exception.
            {
                this.surname = "Default Surname";
                throw new FieldLengthLimitException("\n ! ! You CANNOT set a surname > 10");
            }
            catch (FieldLengthLimitException e) // catch statement means do this instead after the error is found. So you can put a new solution here that the code can take.
            // Exceptions can be called without using a parameter. This is an Object of that Exception class. Since I have already defined which exception to 'throw new' and that has it's parameters. this 'e' is just calling that exact one.
            {
                System.out.println(e); // will print out the particular error // e will get Error name + message // e.getMessage() will get only the message
            }
        }
        else //If no error detected. Proceed as usual
        {
            this.surname = surname1;
            //this.name (class attribute), name1 (argument to be given from Main)
        }
    }




    // Unique setSalary()
    // throws custom IncorrectSalaryException
    // 'throws' responsibility to whoever 'uses' setSalary()
    public void setSalary(double salary1) throws IncorrectSalaryException
    {

        if ((salary1 < 0) || (salary1 > 2000))
        {
            throw new IncorrectSalaryException("\n CANNOT setSalary to < 0 (or) > 2000.");
        }
        else if (salary1 == 0)
        {
            System.out.print("Default Salary - ");
            System.out.println(salary); // Default 1000
        } else {
            System.out.print("(Answer from Class) \nThis is Anna's new Salary - ");
            System.out.println(salary1); // new setSalary
        }
    }



//    salary1 = 1000.0; //which is the default I set at the beginning.
//            throw new IncorrectSalaryException("\n CANNOT setSalary to a negative number.");


//    public double setSalary() throws IncorrectSalaryException
//    {
//        if ((raise < 0) || (raise > 2000))
//        {
//            throw
//        }
//        else if (raise == 0)
//        {
//            raise = salary;
//        }
//        return raise;
//    }

    // End of SETTER(s)
    //*******************************************************************************






    // GETTER(s)
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    //End of GETTER(s)

    //*******************************************************************************







    // CONSTRUCTOR(s)
    Employee ()
    {
        // empty constructor
        // I made this because we have set() methods that I would like to check.
        // If we do not have a way to create an Employee without first initializing the parameters.
        // There might be no way to really test our Set() method ERRORS.
    }






    // Unique Constructor, with parameters(arguments)
    // We will check for Error in input. Because our user will give us the names in certain occassions.
    Employee(String name, String surname)
    // no 'thrown' Exception. I will do the 'try & catch' here.
    //Imagine how hard it will be to do a try & catch' everytime you want to create an Employee object. It's better to do it here.
    {
        if (name.length() > 10  || surname.length() > 10 || name.isBlank() || surname.isBlank())
        // If the name is Empty or greater than 10. That's the error
        {
            try
            {
                throw new FieldLengthLimitException("Name / Surname field is > 10 (or) < 0");
            }
            catch (FieldLengthLimitException e) // what type of Exception are we catching. Name it above in try{}
            {
                if (name.length() > 10) {
                    this.name = "--[Blank]--";
                    this.surname = surname;
                }
                else {
                    this.name = name;
                    this.surname = "--[Blank]--";
                }
                System.out.println(e); // print Exception
                System.out.println("This Employee has not been created. You need to try again.");

            }
        }
        else // If no Error is !true. Proceed as Usual.
        {
            try // see what I mean? to use setName() now I have to do the 'try & catch' myself.
            {
                this.setName(name);
            }
            catch (FieldLengthLimitException ex)
            {
                System.out.println(ex);
            }
            this.setSurname(surname);
            nextId++;
            this.ID = nextId;
        }


        // Unique 'for loop' to keep asking the User for a correct name
        // until it is given. Then an Employee is created.

        // If no error we will proceed as Usual, with else{} above. // If there is an error we will do this below.

        // You might ask. But Philippa how? This code is located below so that means the constructor will read it whether there is Error or not.
        // That is why the 'condition' matters. We will check the same condition that detects error.
        // That means if there was no error above and the constructor moved on as usual, when it gets here it won't run this because it does not meet these conditions.
        // However, if there was an error. That condition and this condition is the same. So this will run.

        for (int i = 0; ((name.length() > 10) || (name.isBlank()) || surname.length() > 10 || surname.isBlank()); i++)
        {
            Scanner classscanner = new Scanner(System.in);
            System.out.println("Write Name again: ");
            name = classscanner.nextLine();

            for (int j = 0; ((name.isBlank()) || (name.length() > 10)); j++)
            {
                System.out.println("\t Name again: ");
                name = classscanner.nextLine();
            }
            this.name = name;



            System.out.println("Write Surname again: ");
            surname = classscanner.nextLine();

            for (int j = 0; ((surname.isBlank()) || (surname.length() > 10)); j++)
            {
                System.out.println("\t Surname again: ");
                surname = classscanner.nextLine();
            }
            this.surname = surname;




            if ((name.length() < 10) && (!name.isBlank()) && (surname.length() < 10) && (!surname.isBlank()))
            // If and only if after all the conditions above are met. Then create an ID.
            {
                nextId++;
                this.ID = nextId;
                System.out.println("\n!! CHECKING from CLASS!!\nHow many employees - " + Employee.nextId);
            }
        }

    }



    // End of CONSTRUCTOR(s)
//******************************************************************************














    // METHODs

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





    double raise;


    double raiseSalary(double percentage)
    {
        if (percentage <= 0)
        {
            try
            {
                throw new IncorrectSalaryException("\n The Percent for increase CANNOT be a negative number !");
            }
            catch (IncorrectSalaryException h)
            {
                System.out.println(h);

                for(int k = 0; percentage <= 0; k++) // as long as percent is less than 0 keep doing this
                {
                    System.out.println("\nTry again. (+)number.");

                    Scanner raiseKeyboard = new Scanner(System.in);
                    percentage = raiseKeyboard.nextInt();

                    if(percentage > 0) // catch the moment when percentage is > 0 before the for loop closes
                    {
                        double increase = ((double) percentage / 100) * (getSalary() / 1);
                        System.out.print("\nFor " + this.getName() + " : Salary - " + getSalary() + ", Increase - " + increase +
                                "\nFinal total = ");

                        raise = (increase + getSalary());
                    }
                }
            }
        }
        else // else (no error?), then carry on as Usual
        {
            double increase = ((double) percentage / 100) * (getSalary() / 1);
            System.out.print("\nFor " + this.getName() + " : Salary - " + getSalary() + ", Increase - " + increase +
                    "\nFinal total = ");

            raise = (increase + getSalary());

        }

        return raise; // but no matter what. Return the value of raise. Because this method is not void.
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



    //******************************************************************************
// End of Employee Class
}