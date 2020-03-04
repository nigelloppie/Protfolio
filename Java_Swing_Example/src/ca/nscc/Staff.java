package ca.nscc;

public class Staff extends Person{
    private int yearsActive;

    //Student constructor with all parameters
    public Staff(String name, String address, int yearsActive) {
        super(name, address);
        this.yearsActive = yearsActive;
    }

    //Calculating the staff's salary based on the number of years they've worked
    public double getSalary(){
        double salary;

        if (yearsActive <= 1){
            salary = 50000/26.0;
        }
        else{
            salary = (50000 + (yearsActive*500))/26.0;
        }
        salary = Math.round(salary * 100)/100.0;
        return salary;
    }

    //Adding the staff's years active and fee to the string template
    @Override
    public String toString() {
        return super.toString() + ", year = "+ yearsActive+ ", pay = $" + getSalary() + "\n";
    }

}



