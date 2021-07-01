import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.time.Duration.ofMillis;


public class QueueTest {

    private Queue queue;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    @BeforeEach
    public void setUp() {
        queue = new Queue();
        contact1 = new Contact("Hans", 623787);
        contact2 = new Contact("Peter", 586343);
        contact3 = new Contact("Anna", 832783);

    }

    @Test
    public void testCreateQueue() {
        assertNull(queue.getTail(),"Tail");
        assertNull(queue.getHead(),"Head");
        assertEquals(0, queue.getNumContacts(), "NumContacts");
    }

    @Test public void testEnqueue() {
        queue.enqueue(contact1);
        queue.enqueue(contact2);
        queue.enqueue(contact3);
        assertEquals(3, queue.getNumContacts(), "Number contacts");
        assertSame(contact3, queue.getTail(), "Tail");
        assertSame(contact1, queue.getHead(), "Head");
    }

    @Test
    public void testDequeue() {
        queue.enqueue(contact1);
        queue.enqueue(contact2);
        queue.enqueue(contact3);
        Contact c = queue.dequeue();
        assertSame(contact1, c, "Removed elem");
        assertSame(contact3, queue.getTail(), "Tail");
        assertSame(contact2, queue.getHead(), "Head");
    }

    @Test
    public void testDequeueLastElement() {
        queue.enqueue(contact1);
        Contact c = queue.dequeue();
        assertEquals(0, queue.getNumContacts(), "Number of queue elements");  // vielleicht streichen
        assertNull(queue.getTail(), "Tail");
        assertNull(queue.getHead(), "Head");
    }




    @Test
    public void testPerformance() {
        assertTimeoutPreemptively(ofMillis(50), () -> {
            for (int i=0; i < 100000000; i++) {
                Contact c = new Contact("Name" + i, i);
                queue.enqueue(c);
            }
        });
    }




    @Test
    public void testContactCounter() {
        int before = Contact.getContactCounter();
        Contact c = new Contact("Mustermann", 32168);
        int after = Contact.getContactCounter();
        assertEquals(1, after-before);
    }



}
