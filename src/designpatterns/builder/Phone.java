package designpatterns.builder;

public class Phone {

    private final String phoneId;
    private final String screenSize;
    private final String ram;
    private final String memory;

    public Phone(String phoneId, String screenSize, String ram, String memory) {
        this.phoneId = phoneId;
        this.screenSize = screenSize;
        this.ram = ram;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId='" + phoneId + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", ram='" + ram + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }
}
