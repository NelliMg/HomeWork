package sets.service;

import sets.implementation.MySet;
import sets.model.*;

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
        mySet.add(new MyCoffee(CoffeeType.ESPRESSO,8));
        mySet.add(new MyCoffee(CoffeeType.ESPRESSO,9));
        mySet.add(new MyCoffee(CoffeeType.CAPPUCCINO,10));
        mySet.add(new MyCoffee(CoffeeType.ESPRESSO,8));
        return mySet;
    }
    public static MySet<Glasses> initializeMySetGlasses(){
        MySet<Glasses> mySet= new MySet<>();
        mySet.add(new Glasses(Color.BLUE,Size.MEDIUM));
        mySet.add(new Glasses(Color.GREEN,Size.LARGE));
        mySet.add(new Glasses(Color.BLUE,Size.LARGE));
        return mySet;
    }
}
