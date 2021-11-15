package warehouse;

public class Shelf {
    private String shelfNumber;
    LinkedLists<Pallet> palletLinkedLists = new LinkedLists<>();

    //Constructor
    Shelf(String shelfNumber){
        this.shelfNumber = shelfNumber;
    }

    //Getters and Setters
    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    @Override
    public String toString(){
        return "Shelf ID: " + shelfNumber + "\n";
    }
}
