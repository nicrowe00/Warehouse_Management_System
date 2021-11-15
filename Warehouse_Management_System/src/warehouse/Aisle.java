package warehouse;

public class Aisle {
    private String aisleIdentifier;
    private int aisleDepth;
    private int aisleWidth;
    LinkedLists<Shelf> shelfLinkedLists = new LinkedLists<>();

    //Constructor
    public Aisle(String aisleIdentifier, int aisleDepth, int aisleWidth){
        this.aisleIdentifier = aisleIdentifier;
        this.aisleDepth = aisleDepth;
        this.aisleWidth = aisleWidth;
    }

    //Getters and Setters
    public String getAisleIdentifier() {
        return aisleIdentifier;
    }

    public int getAisleDepth(){
        return aisleDepth;
    }

    public int getAisleWidth(){
        return aisleWidth;
    }

    public void setAisleIdentifier(String aisleIdentifier) {
        this.aisleIdentifier = aisleIdentifier;
    }

    public void setAisleDepth(int aisleDepth){
        this.aisleDepth = aisleDepth;
    }

    public void setAisleWidth(int aisleWidth){
        this.aisleWidth = aisleWidth;
    }

    //toString method
    @Override
    public String toString(){
        return "Aisle ID: " + aisleIdentifier + ", Aisle Depth: " + aisleDepth + " and Aisle Width: " + aisleWidth + "\n";
    }

    public String toString1(){
        return "Aisle ID: " + aisleIdentifier + "\n";
    }
}
