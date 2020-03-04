package ca.nscc;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        boolean continueUse = true;
        boolean isValid = false;

        //ArrayList where the new student and staff will be saved
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        ArrayList<Staff> staffArrayList = new ArrayList<Staff>();

        //Determines if the is done entering new staff/students
        while (continueUse == true) {
            //Buttons text
            Object[] buttons = {"Student", "Staff", "Finish"};
            //Asking if the users wants to input and student, staff or if they are done
            int studentOrStaff = JOptionPane.showOptionDialog(null,
                    "Select Student or Staff", "Accounting App",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, buttons, buttons[0]);

            //Asking for student inputs
            if (studentOrStaff == 0) {
                int studentYear = 0;
                //Asking user for the year of the student
                do {
                    String inputYear = JOptionPane.showInputDialog(null,
                            "Enter student year (1-4)",
                            "Input", JOptionPane.QUESTION_MESSAGE);
                    //If cancel is selected user will return to staff or student prompt
                    if (inputYear == null){
                        break;
                    }
                    //Data validation to see if user input a valid year
                    try {
                        studentYear = Integer.parseInt(inputYear);
                        if (studentYear >= 1 && studentYear <= 4) {
                            isValid = true;
                        }
                        if (studentYear > 4 || studentYear <= 0) {
                            JOptionPane.showMessageDialog(null, "Please enter a number between 1-4", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Asking the user to enter student name
                        String name = JOptionPane.showInputDialog(null,
                                "Enter student name",
                                "Input", JOptionPane.QUESTION_MESSAGE);
                    //If cancel is selected user will return to staff or student prompt
                        if (name == null){
                            break;
                        }
                        //Data validation if user tries to enter a blank name
                        else {
                            while (name.equals("")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid name", "Error", JOptionPane.ERROR_MESSAGE);
                                name = JOptionPane.showInputDialog(null,
                                        "Enter student name",
                                        "Input", JOptionPane.QUESTION_MESSAGE);
                                if (name == null) {
                                    break;
                                }
                            }
                        }
                    //Asking the user to enter student address
                        String address = JOptionPane.showInputDialog(null,
                                "Enter student address",
                                "Input", JOptionPane.QUESTION_MESSAGE);
                    //If cancel is selected user will return to staff or student prompt
                        if (address == null) {
                            break;
                        }
                        //Data validation if user tries to enter a blank address
                        else {
                            while (address.equals("")) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid address", "Error", JOptionPane.ERROR_MESSAGE);
                                address = JOptionPane.showInputDialog(null,
                                        "Enter student address",
                                        "Input", JOptionPane.QUESTION_MESSAGE);
                                if (address == null) {
                                    break;
                                }
                            }
                        }
                        //Creating a student object with the input information
                        Student eachStudent = new Student(name, address, studentYear);
                        studentArrayList.add(eachStudent);
                } while (isValid == false);
            }

            //Asking for Staff inputs
            if (studentOrStaff == 1) {
                do {
                    String name = JOptionPane.showInputDialog(null,
                            "Enter Staff name",
                            "Input", JOptionPane.QUESTION_MESSAGE);
                    if (name== null){
                        break;
                    }
                    //Data validation if user tries to enter a blank name
                    else {
                        while (name.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid name", "Error", JOptionPane.ERROR_MESSAGE);
                            name = JOptionPane.showInputDialog(null,
                                    "Enter Staff name",
                                    "Input", JOptionPane.QUESTION_MESSAGE);
                            if (name == null) {
                                break;
                            }
                        }
                    }
                //Asking the user to enter a staff address
                    String address = JOptionPane.showInputDialog(null,
                            "Enter Staff address",
                            "Input", JOptionPane.QUESTION_MESSAGE);
                    //If cancel is selected user will return to staff or student prompt
                    if (address == null) {
                        break;
                    }
                    //Data validation if user tries to enter a blank address
                    else {
                        while (address.equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid address", "Error", JOptionPane.ERROR_MESSAGE);
                            address = JOptionPane.showInputDialog(null,
                                    "Enter staff address name",
                                    "Input", JOptionPane.QUESTION_MESSAGE);
                            if (address == null) {
                                break;
                            }
                        }
                    }
                //Asking the user for the staff years of service
                    String inputYears = JOptionPane.showInputDialog(null,
                        "Enter staff years of service",
                        "Input", JOptionPane.QUESTION_MESSAGE);
                //Data validation for if the user enters a value with the appropriate range
                try {
                    int yearsActive = Integer.parseInt(inputYears);
                    if (yearsActive > 0 && yearsActive < 30) {
                        isValid = true;
                        Staff eachStaff = new Staff(name, address, yearsActive);
                        staffArrayList.add(eachStaff);
                    }
                    if (yearsActive > 30 || yearsActive <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a number between 1-30", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
                while (isValid == false);
            }
        //Once user selects "Finish" they won't be asked for more inputs
            if (studentOrStaff == 2) {
                continueUse = false;
            }
        }
        //String for the students results that have has the total
            String studentResults = "Students: [Total: " + studentArrayList.size() + "]\n";

            int i = 1;
            double fees = 0.00;

        //Goes through each student object in the array list
            for (Student x : studentArrayList) {
                //Appends the student information to the student results string
                studentResults = studentResults + i + ". " + x.toString();
                //Adds all the fees together
                fees = fees + x.getFees();
                i++;
            }
            //String for incoming
            String incoming = "Incoming: $" + fees + "\n";

        //String for the staff results that have has the total
            String staffResults = "Staff: [Total: " + staffArrayList.size() + "]\n";

            int k = 1;
            double salary = 0.00;

        //Goes through each staff object in the array list
            for (Staff y : staffArrayList) {
                //Appends the staff information to the student results string
                staffResults = staffResults + k + ". " + y.toString();
                //Adds all the salaries together
                salary = salary + y.getSalary();
                k++;
            }

        // outgoing and total messages
            String outgoing = "Outgoing: $" + salary + "\n";
            String total = "Total: $" + (fees - salary);
        //Message that will appear if the user presses finish concatenating all the student and staff information together
            JOptionPane.showMessageDialog(null, studentResults + staffResults + "\n\nResults:\n"
                    + outgoing + incoming + total, "Report", JOptionPane.INFORMATION_MESSAGE);

    }
}
