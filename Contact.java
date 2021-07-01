

public class Contact {

    private static int contactCounter = 0;

    public static int getContactCounter() {
        return contactCounter;
    }

    private Contact next;

    private String name;
    private long phone;
    private int id;


    public Contact(String name) {
        contactCounter++;
        id = contactCounter;
        this.name = name;
        this.next = null;
        this.phone = 0;
    }

    public Contact(String name, long phone) {
        this(name);
        this.phone = phone;
    }

    public String toString() {
        return (name + " " + phone);
    }

    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Contact getNext() {
        return next;
    }

    public void setNext(Contact next) {
        this.next = next;
    }
}
