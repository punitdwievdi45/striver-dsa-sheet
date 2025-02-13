package designpatterns.factory;


/*Imagine a fancy restaurant with a hostess.
 You tell the hostess what kind of food you're in the mood for (Italian, Mexican, etc.),
  and she directs you to the right section. You don't have to know exactly where the kitchen
   is or how they prepare the food.

The factory design pattern is similar. It's a system where you tell a
"factory" what kind of object you need (like a circle, square, or triangle),
 and the factory creates that object for you, hiding the creation details.
 This makes your code more flexible and easier to change in the future.*/

/*Benefits of FactoryDesignPatter

Easier to Change: You can add new object types without modifying existing code.
More Flexible: Code only cares about what the object does, not the specific type.
Cleaner Code: Creation logic is centralized and hidden, making code easier to understand.*/

/*when there is superclass and multiple subclasses and we want to get object
of subclasses based on input and requirement. Then we create a factory class  which takes
the reaponsibility of creating object of class based on input.*/

public class FactoryPattern {

    public static void main(String[] args) {

        Employee employee1 = EmployeeFactory.getInstance("Android Developer");
        if (employee1 instanceof AndroidDeveloper) {
            System.out.println("Android Developer salary is : " + employee1.salary());
        }
        Employee employee2 = EmployeeFactory.getInstance("IOS Developer");
        if (employee2 instanceof IosDeveloper) {
            System.out.println("IOS Developer salary is :" + employee2.salary());
        }

        Employee employee3 = EmployeeFactory.getInstance("Web Developer");
        System.out.println("Web Developer salary is :" + employee3.salary());
    }
}
