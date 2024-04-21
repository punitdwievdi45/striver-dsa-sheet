package designpatterns.builder;

/*While creating object when object contain many attributes there are many problem exists :
    1. We have to pass many arguments to create object.
    2. some parameters might be optional.
    3. factory class takes all responsibility for creating object, if the object is heavy then all comlexity
        is the part of factory class.*/

public class Client {
    public static void main(String[] args) {
        Phone phone = new PhoneBuilder().setPhoneId("1").setMemory("256Gb").setScreenSize("6.7").build();
        System.out.println(phone);
    }
}
