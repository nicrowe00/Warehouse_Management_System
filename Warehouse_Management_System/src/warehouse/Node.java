package warehouse;

public class Node<n> {
    public Node<n> next = null;
    public Node<n> previous = null;

    private n contents;

    public n getContents(){
        return contents;
    }

    public void setContents(n c){
        this.contents = c;
    }
}
