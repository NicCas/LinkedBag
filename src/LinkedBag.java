public class LinkedBag<T> implements BagInterface <T> {
    private Node head = null;
    int qtyOfItems = 0;

    /** Gets the current number of entries in this bag.
    @return  The integer number of entries currently in the bag. */
    public int getCurrentSize() { return qtyOfItems;}

    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. */
    public boolean isEmpty() {
        return qtyOfItems == 0;
    }

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or false if not. */
    public boolean add(T newEntry){
        Node newNode = new Node(newEntry, head);
        head = newNode;
        qtyOfItems++;
        return true;
    }

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal.
     was successful, or null. */
    public T remove() {

        // Removes the node that head is pointing to

        if (isEmpty()){
            return null;
        }
        T returnItem = head.item;
        head = head.next;

        qtyOfItems--;

        return returnItem = head.item;
    }

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry) {

        // create a temp pointer that points to the same thing as head
        Node ptr = head;
        while (ptr != null) {
            if(ptr.item.equals(anEntry)) {
                ptr.item = head.item;
                remove();
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    /** Removes all entries from this bag. */
    public void clear(){
        Node ptr = head;
        while (head != null) {
            head = head.next;
            ptr.next = null;
            ptr = head;

        }

        qtyOfItems = 0;

    }

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        Node ptr = head;
        while(ptr != null) {
            if (ptr.item.equals(anEntry)){
                counter++;
            }
            ptr = ptr.next;
        }

        return counter;
    }

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry) {
        Node ptr = head;
        while(ptr != null) {
            if (ptr.item.equals(anEntry)){
                return true;
            }
            ptr = ptr.next;
        }

        return false;
    }

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in the bag.
     Note: If the bag is empty, the returned array is empty. */
    public T[] toArray() {
        int index = 0;
        T[] returnArray = (T[]) new Object[qtyOfItems];
        Node ptr = head;
        while (ptr != null) {
            returnArray[index++] = ptr.item;
            ptr = ptr.next;
        }
        return returnArray;
    }

    // Can copy this for homework
    private class Node
    {
        T item;
        Node next;

        private Node()
        {
            this(null, null);
        }

        private Node (T item)
        {
            this(item, null);
        }

        private Node (T item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }

}
