
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        P.rintln("""

                In this Lab 4 I will be creating custom Exceptions.
                First let me say what I have understood from Exceptions & custom Exceptions.
                Exceptions can be thrown & caught. To deal with it at the location of 'dangerous code' you do a try & catch.
                To deal with it somewhere else e.g in Main(), you can throw the exception from the class and 'try & catch' it from the Main()\s""");

        P.rintln("""

                I am going to;
                 (*) deal with normal Exceptions as (i) thrown & (ii) try & catch.
                 (*) deal with custom Exceptions as (i) thrown & (ii) try & catch.
                 and see the difference.""");

        // while we are on the topic . This webpage helped me finally write this code;
        // https://www.javatpoint.com/custom-exception



        P.rintln("\n\n------------------------------------------------------------------------");



        System.out.println("NOTE: After every input. Press ENTER to save it.");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the name of EMPLOYEE 1 ?");
        String name_1 = keyboard.nextLine();

        System.out.println("What is the surname of EMPLOYEE 1 ?");
        String surname_1 = keyboard.nextLine();

        Employee employee_1 = new Employee(name_1, surname_1);
        System.out.println("Printed from Main() " + employee_1);
        System.out.println("\n!! CHECKING !!\nHow many employees - " + Employee.nextId);


        // Custom Exception
// 'thrown' from Class
// this is what a try{} block will look like if there was no condition to check. It will hold the 'dangerous code' & 'catch' will give the alternative solution for if a problem occurs.

//       try {
//          Employee employee_1 = new Employee(name_1, surname_1);
//          System.out.println(employee_1);
//       }
//       catch (FieldLengthLimitException e) // already thrown in Class
//       {
//          System.out.println(e);
//       }
//       catch(Exception e)
//       {
//          throw new RuntimeException();
//       }

        P.rintln("\n\n------------------------------------------------------------------------");

        // A small cute communication box to tell the Terminal to Wait
        System.out.println("""
                   ,--./,-.
                    / #      \\     Enter
                   |          |    'TRUE' to continue 
                    \\        /     'FALSE' to stay
                     `._,._,'
                """);
        Scanner toContinue = new Scanner(System.in);
        boolean moveOn = toContinue.nextBoolean();
        for (int w = 0; moveOn != true; w++) {
                moveOn = toContinue.nextBoolean();
        }


        P.rintln("\n\n------------------------------------------------------------------------");




        Employee employee_2 = new Employee();
        try {
            employee_2.setName("Employee2s_name_but_too_long");
        } catch (FieldLengthLimitException ex)
        {
            System.out.println(employee_2.getName() + " is TOO LONG.");
            System.out.println(ex);
        }
        System.out.println("\n!! CHECKING !!\nHow many employees - " + Employee.nextId);



        employee_2.setSurname("Surname for employee 2");

        System.out.println("\n!! CHECKING !!\nHow many employees - " + Employee.nextId);

        System.out.println(employee_2);



        P.rintln("\n\n------------------------------------------------------------------------");

        // A small cute communication box to tell the Terminal to Wait
        System.out.println("""
                   ,--./,-.
                    / #      \\     Enter
                   |          |    'TRUE' to continue 
                    \\        /     'FALSE' to stay
                     `._,._,'
                """);
        moveOn = toContinue.nextBoolean();
        for (int w = 0; moveOn != true; w++) {
            moveOn = toContinue.nextBoolean();
        }


        P.rintln("\n\n------------------------------------------------------------------------");



        Employee Anna = new Employee("Anna", "One");
        Employee Bianca = new Employee("Bianca", "Two");

        P.rintln("I created 2 new Employees. \nWe will do some tests with them.");
        System.out.println("\n!! CHECKING !!\nHow many employees - " + Employee.nextId);

        System.out.println(Anna);
        System.out.println(Bianca);



        P.rintln("\n\n------------------------------------------------------------------------");



        System.out.println("\n Meet this Employee " + Bianca + "\nGive us the Percentage to raise Bianca's Salary to.");

        // I will take user input here.
        // I do not need to open a new scanner but ...
        // Sometimes scanners have words in them that were not removed. like a copy and paste. So when you do a nextLine() it will include the leftover words.
        // So just beware.

        double Biancas_percent = keyboard.nextInt(); // User input.
        double Biancas_raise = Bianca.raiseSalary(Biancas_percent);
        System.out.println(Biancas_raise);



        P.rintln("\n\n------------------------------------------------------------------------");


        // A small cute communication box to tell the Terminal to Wait
        System.out.println("""
                   ,--./,-.
                    / #      \\     Enter
                   |          |    'TRUE' to continue 
                    \\        /     'FALSE' to stay
                     `._,._,'
                """);
        moveOn = toContinue.nextBoolean();
        for (int w = 0; moveOn != true; w++) {
            moveOn = toContinue.nextBoolean();
        }


        P.rintln("\n\n------------------------------------------------------------------------");




        P.rintln("A 'try & catch' to set Anna's Salary is going on here.");
        P.rint("Give a new salary for Anna: (nothing less than €0 or more than \u20ac2000)\n" + "= "); //'\u20ac' is '€' symbol

        Scanner annasSalary = new Scanner(System.in);
        double Annas_set_salary = annasSalary.nextDouble();

        try {
            Anna.setSalary(Annas_set_salary);
        }
        catch (IncorrectSalaryException e) {
            System.out.println(e);

            Scanner inside_SetSalary = new Scanner(System.in);
            System.out.println("\tGive the Salary again: ");
            double correction = inside_SetSalary.nextDouble(); // User input

            if (correction == 0)
            {
                try {
                    Anna.setSalary(correction);
                } catch (IncorrectSalaryException r){
                    System.out.println(r);
                }
            }

            for (int j = 0; ((correction < 0) || (correction > 2000)); j++)
            {
                System.out.println("\tGive the Salary again: ");
                 correction = inside_SetSalary.nextDouble(); // User input


                if ((correction >= 0) && (correction <= 2000))
                {
                    try {
                        Anna.setSalary(correction);
                    } catch (IncorrectSalaryException r){
                        System.out.println(r);
                    }
                }
            }

        }


        P.rintln("\n\n------------------------------------------------------------------------");



    }
}