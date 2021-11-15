package warehouse;

import java.util.Iterator;

public class linkedListIterator<I> implements Iterator<I> {
    private Node<I> position;

    public linkedListIterator(Node<I> node){
        position = node;
    }

    @Override
    public boolean hasNext() {
        return false;
    }


    @Override
    public I next(){
        Node<I> temp = position;
        position = position.next;
        return temp.getContents();
    }
}