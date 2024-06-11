public class Manager extends Employee{


    public Manager(String name, String surname) throws FieldLengthLimitException
    // throws the same exception as it's Parent. Any method that is the same as the Parent(super) will have to throw the same Exceptions.
    {
        super(name, surname);
    }



    private double bonus;

    public double setBonus (double b)
    {
        bonus = b + super.getSalary();
        System.out.println("Bonus : " + (bonus - super.getSalary()) +  ",  Salary after bonus for " + this.getName() + ": " + bonus);
        return bonus;
    }



    @Override
    public double getSalary()
    {
        if (bonus > 0.00)
        {
            return bonus;
        }
        else {
            return super.getSalary();
        }
    }



    @Override
    public String toString() {
        return "\nMANAGER ID: " + getID() +
                "\n | NAME: " + getName() +
                "\n | SURNAME: " + getSurname() +
                "\n | BASE SALARY: " + super.getSalary() +
                "\n | (after bonus) SALARY : " + getSalary();
    }

// OR

//    public String toString() {
//        return "\n" + super.toString();
//    }


//End of Manager class
}