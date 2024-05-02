package designpatterns.adapterpattern;


/*The Adapter design pattern in Java is a structural design pattern
that allows you to make incompatible interfaces work together.
It acts as a bridge between two classes or objects with different
interfaces by providing a wrapper that translates calls between them.*/

public class School {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork assignmentWork = new AssignmentWork();
        assignmentWork.setPen(p);
        assignmentWork.doAssignment("I am bit tired to write assignment");
    }
}
