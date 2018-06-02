package se.kth.processSale.util;

/** Utility class which implements a list data structure  */
public class Node<T> {
    public T item;
    public Node next = null;

    /** Copy a list creating a new copy of it.
     * @param list the list that is to be copied
     * @return  Reference to the first <Code>Node<T></Code> in the copy */
    public static <E> Node<E> copyList(Node<E> list){
        if(list == null){
            return null;
        }
       Node<E> firstNodeInNewList = new Node<E>();
       Node<E> oldTraverse;
       Node<E> newTraverse = firstNodeInNewList;
       newTraverse.item = list.item;
       oldTraverse = list.next;
       while (oldTraverse != null){
            newTraverse.next = new Node<E>();
            newTraverse = newTraverse.next;
            newTraverse.item = oldTraverse.item;
            oldTraverse = oldTraverse.next;
       }
       return firstNodeInNewList;
    };

    /**
     *  @return The length of the list
     */
    public int getLength(){
        int length=1;
        Node<T> nextNode =  new Node<T>();
        nextNode.next = this.next;
        while(nextNode.next != null){
            length++;
            nextNode = nextNode.next;
        }

        return length;
    }

    /**
     * Prints out the list
     */
    public void printList(){
        Node listTraverse = this.next;
        System.out.println(this.item);
        while (listTraverse != null){
            System.out.println(listTraverse.item);
            listTraverse = listTraverse.next;
        }

    }
    /** Overloads the Object toString method
     * @return A String containing information about
     * the objects in the list */
    public String toString(){
        Node listTraverse = this.next;
        String listAsString = this.item.toString()+"\n";
        while (listTraverse != null){
            listAsString+=listTraverse.item.toString()+"\n";
            listTraverse = listTraverse.next;
        }
        return listAsString;

    }


}
