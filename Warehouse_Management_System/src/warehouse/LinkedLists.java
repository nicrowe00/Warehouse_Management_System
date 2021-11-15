package warehouse;
import java.util.Iterator;


public class LinkedLists<L> implements Iterable<L>{
    public Node<L> top = null, bottom=null;
    private int contentNumber = 0;

    public void addElement(L e){
        Node<L> newNode = new Node<>();
        newNode.setContents(e);

        if(top == null){
            top = bottom = newNode;
            top.next = null;
            bottom.previous = null;
        }
        else{
            bottom.next = newNode;
            newNode.previous = bottom;
            bottom = newNode;
            bottom.next = null;
        }
        contentNumber++;
    }

    public String printLinkedList(){
        Node<L> currentNode = top;
        String list = "";

        while (currentNode!= null){
            list += currentNode.getContents() + "\n";
            currentNode = currentNode.next;
        }
        return list;
    }

    public boolean empty(){
        return top == null;
    }

    public int lengthOfList(){
        return contentNumber;
    }

    public void deleteElement(int index){
        if(top!=null){
            Node<L> temp;
            if(index == 0){
                if(top.next == null){
                    top = bottom = null;
                }
                else{
                    top = top.next;
                }
                contentNumber--;
            }
            else if(index > 0 && index < contentNumber){
                temp = top;
                for(int i=1; i<index; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                contentNumber--;
            }
            else System.out.println("An invalid index was entered. Please enter a correct index.");
        }
        else System.out.println("An empty list was selected");
    }

    public Node<L> selectElement(int index){
        if(index < 0){
            return null;
        }
        Node<L> temp = top;
        if(top != null){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    public void resetLinkedList(){
        top = bottom = null;
        contentNumber = 0;
    }

    @Override
    public Iterator<L> iterator(){
        return new linkedListIterator<L>(top);
    }


}