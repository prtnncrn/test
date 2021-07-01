/**
 *
 * Übung 06: Warteschlangen, JUnit
 *
 * @author Benedikt Braun
 * @version 1.0
 */

public class Queue {

    //Anzahl Kontakte
    private int numContacts;

    //Neuster Kontakt
    private Contact head;

    //Ältester Kontakt
    private Contact tail;


    /**
     * Erstellt leere Warteschlange
     */
    public Queue() {
        head = null;
        tail = null;
        numContacts = 0;
    }

    /**
     *  Fügt der Warteschlange einen neuen Kontakt hinzu
     * @param c einzufügender Kontakt
     */
    public void enqueue(Contact c) {
        c.setNext(null);                    //Element zeigt nicht auf auf anderes Element

        if(tail == null) {                  //Warteschlange ist Leer
            head = c;
        }
        else {                              //Mindestens ein Element
            tail.setNext(c);
        }
        tail = c;
        numContacts++;
    }

    public Contact dequeue() {

        if(numContacts > 0) {               //Element nur dann entfernen wenn mind. eins
            Contact c = head;
            head = head.getNext();
            numContacts--;


            if (numContacts == 0) {         //Warteschlange ist leer
                tail = null;
            }
            return c;
        }
        return null;
    }


    /**
     *
     * @return Anzahl Kontakte
     */
    public int getNumContacts() {
        return numContacts;
    }

    /**
     *
     * @return Ende
     */
    public Contact getTail() {
        return tail;
    }

    /**
     *
     * @return Anfang
     */
    public Contact getHead() {
        return head;
    }
}
