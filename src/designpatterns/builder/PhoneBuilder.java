package designpatterns.builder;

public class PhoneBuilder {

    private String phoneId;
    private String screenSize;
    private String ram;
    private String memory;

    public PhoneBuilder setPhoneId(String phoneId) {
        this.phoneId = phoneId;
        return this;
    }

    public PhoneBuilder setScreenSize(String screenSize) {
        this.screenSize = screenSize;
        return this;

    }

    public PhoneBuilder setRam(String ram) {
        this.ram = ram;
        return this;

    }

    public PhoneBuilder setMemory(String memory) {
        this.memory = memory;
        return this;
    }


    public Phone build() {
        return new Phone(phoneId, screenSize, ram, memory);
    }
}
