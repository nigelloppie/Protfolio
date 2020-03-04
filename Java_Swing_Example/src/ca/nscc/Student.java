package ca.nscc;

import java.text.DecimalFormat;

public class Student extends Person {
    private int studentYear;

    //Student constructor with all parameters
    public Student(String name, String address, int studentYear) {
        super(name, address);
        this.studentYear = studentYear;
    }

    //Calculating the fees based on the student's year
    public double getFees(){

        double fees;
        if (studentYear == 1){
            fees = 3000/2.0;
        }
        else {
            fees = (3000 + (studentYear*100))/2.0;
        }
        fees = Math.round(fees * 100)/100.0;
        return fees;

    }

    //Adding the student's year and their fee to the string template
    @Override
    public String toString() {
        return super.toString() + ", year = "+ studentYear + ", fee = $" + getFees() + "\n";
    }
}


