package sets.service;

import sets.implementation.MySet;
import sets.model.Coffee;
import sets.model.MyCoffee;
import sets.model.Student;

public class MainService {
    public static MySet<Student> initializeMysetStudent(){
        MySet<Student> mySet= new MySet<>();
        mySet.add(new Student("Will"," Weaton"));
        mySet.add(new Student("Sheldon","Smith"));
        mySet.add(new Student("Lili","Davis"));
        return mySet;
    }
    public static MySet<MyCoffee> initializeMysetCoffee(){
        MySet<MyCoffee> mySet= new MySet<>();
        mySet.add(new MyCoffee(Coffee.ESPRESSO,8));
        mySet.add(new MyCoffee(Coffee.ESPRESSO,9));
        mySet.add(new MyCoffee(Coffee.CAPPUCCINO,10));
        return mySet;
    }
}
