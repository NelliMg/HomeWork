package sets;

import sets.implementation.MySet;
import sets.model.MyCoffee;
import sets.model.Student;
import sets.service.MainService;

public class Main{
    public static void main(String[] args) {
        MySet<Student> mySetStudent= new MySet<>();
        mySetStudent= MainService.initializeMysetStudent();
        mySetStudent.print();

        MySet<MyCoffee> mySetCoffee= new MySet<>();
        mySetCoffee=MainService.initializeMysetCoffee();
        mySetCoffee.print();



    }
}
