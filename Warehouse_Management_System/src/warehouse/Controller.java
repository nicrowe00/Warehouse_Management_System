package warehouse;

import javafx.fxml.FXML;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Controller{
    @FXML
    TextArea displayArea;
    @FXML
    TextField SecurityLevel, FloorTemperature, GetFloor, CurrentFloor;
    @FXML
    TextField AisleDepth1, AisleWidth1, GetAisle, CurrentAisle;
    @FXML
    TextField CurrentShelf, GetShelf;
    @FXML
    TextField PalletID, GoodsDescription, GoodsQuantity, MaximumStorageTemperature, MinimumStorageTemperature, PalletDepth, PalletWidth, PalletSearch;

    public int floorNumber(){
        if(Main.floorLinkedLists.top != null){
            return Main.floorLinkedLists.lengthOfList()+1;
        }
        else{
            return 1;
        }
    }

    public String aisleID(){
        Floor floorFound = getFloor();
        Node<Aisle> temp = floorFound.aisleLinkedLists.top;
        int integer = floorFound.getFloorNumber();
        int index;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        if(temp != null){
            index = floorFound.aisleLinkedLists.lengthOfList();
        }
        else{
            index = 0;
        }
        char letter = letters.charAt(index);
        return integer + String.valueOf(letter);
    }

    public String shelfID(){
        Aisle aisleFound = getAisle();
        Node<Shelf> temp = aisleFound.shelfLinkedLists.top;
        String integer = aisleFound.getAisleIdentifier();
        int index;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String blank = "-";
        if(temp != null){
            index = aisleFound.shelfLinkedLists.lengthOfList();
        }
        else{
            index = 0;
        }
        char letter = letters.charAt(index);
        return integer+blank+letter;
    }

    public String palletID(){
        Shelf shelfFound = getShelf();
        Node<Pallet> temp = shelfFound.palletLinkedLists.top;
        String first = shelfFound.getShelfNumber();
        int index;
        if(temp != null){
            index = shelfFound.palletLinkedLists.lengthOfList()+1;
        }
        else{
            index = 1;
        }
        return first+index;
    }

    public Floor getFloor(){
        try{
            int floorNumber = Integer.parseInt(GetFloor.getText());
            Node<Floor> tempFloor = Main.floorLinkedLists.top;
            while(tempFloor != null){
                if(tempFloor.getContents().getFloorNumber() == floorNumber){
                    displayArea.setText("Floor " + floorNumber + " selected." + "\n");
                    CurrentFloor.setText(tempFloor.getContents().toString1());
                    return tempFloor.getContents();
                }
                tempFloor = tempFloor.next;
            }
            displayArea.appendText("Floor does not exist" + "\n");
            return null;
        }
        catch(Exception e){
            return null;
        }
    }

    public Aisle getAisle(){
        try {
            String ID = GetAisle.getText();
            Node<Aisle> smallAisle = getFloor().aisleLinkedLists.top;
            while (smallAisle != null) {
                if (smallAisle.getContents().getAisleIdentifier().equals(ID)) {
                    displayArea.setText("Aisle " + ID + " selected." + "\n");
                    CurrentAisle.setText(smallAisle.getContents().toString1());
                    return smallAisle.getContents();
                }
                smallAisle = smallAisle.next;
            }
            displayArea.appendText("Aisle does not exist" + "\n");
            return null;
        }
        catch(Exception e){
            return null;
        }
    }

    public Shelf getShelf(){
        try{
            String shelfID = GetShelf.getText();
            Node<Shelf> smallShelf = getAisle().shelfLinkedLists.top;
            while(smallShelf != null){
                if(smallShelf.getContents().getShelfNumber().equals(shelfID)){
                    displayArea.setText(("Shelf " + shelfID + " successfully selected." + "\n"));
                    CurrentShelf.setText(smallShelf.getContents().toString());
                    return smallShelf.getContents();
                }
                smallShelf = smallShelf.next;
            }
            displayArea.appendText("Shelf does not exist" + "\n");
            return null;
        }
        catch(Exception e){
            return null;
        }
    }

    public void addFloor(){
        String SecurityLevel1 = SecurityLevel.getText();
        Double FloorTemperature1 = Double.parseDouble(FloorTemperature.getText());
        if(SecurityLevel1.equalsIgnoreCase("High") || SecurityLevel1.equalsIgnoreCase("Low")){
            Main.floorLinkedLists.addElement(new Floor(floorNumber(), SecurityLevel1, FloorTemperature1));
            displayArea.setText(Main.floorLinkedLists.printLinkedList());
        }
        else{
            displayArea.appendText("Security level is only high or low." + "\n");
        }
    }

    public void addAisle(){
        int aisleDepth = Integer.parseInt(AisleDepth1.getText());
        int aisleWidth = Integer.parseInt(AisleWidth1.getText());
        Floor floorFound = getFloor();
        if(floorFound != null){
            floorFound.aisleLinkedLists.addElement(new Aisle(aisleID(), aisleDepth, aisleWidth));
            displayArea.setText(("These are the aisles in Floor " + floorFound.getFloorNumber() + ": " + "\n" + "\n" + floorFound.aisleLinkedLists.printLinkedList() + "\n"));
        }
        else{
            displayArea.appendText("Floor does not exist therefore the Aisle cannot be added." + "\n");
        }
    }

    public void addShelf(){
        Aisle aisleFound = getAisle();
        if(aisleFound != null){
            aisleFound.shelfLinkedLists.addElement(new Shelf(shelfID()));
            displayArea.setText(getAisle().shelfLinkedLists.printLinkedList());
        }
        else{
            displayArea.setText("You have selected an invalid aisle.");
        }
    }

    public void addPallet(){
        String GoodsDescription1 = GoodsDescription.getText();
        int GoodsQuantity1 = Integer.parseInt(GoodsQuantity.getText());
        double MaximumStorageTemperature1 = Double.parseDouble(MaximumStorageTemperature.getText());
        double MinimumStorageTemperature1 = Double.parseDouble(MinimumStorageTemperature.getText());
        int PalletDepth1 = Integer.parseInt(PalletDepth.getText());
        int PalletWidth1 = Integer.parseInt(PalletWidth.getText());
        Aisle aisleFound = getAisle();
        Shelf shelfFound = getShelf();
        if(PalletDepth1 <= aisleFound.getAisleDepth() && PalletDepth1 > 0) {
            if (PalletWidth1 <= aisleFound.getAisleWidth() && PalletWidth1 > 0) {
                if (shelfFound != null) {
                    shelfFound.palletLinkedLists.addElement(new Pallet(palletID(), GoodsDescription1, GoodsQuantity1, MaximumStorageTemperature1, MinimumStorageTemperature1, PalletDepth1, PalletWidth1));
                    displayArea.setText(shelfFound.palletLinkedLists.printLinkedList());
                } else {
                    displayArea.appendText("You entered an invalid shelf." + "\n");
                }
            } else {
                displayArea.appendText("The pallet's width is too big for the chosen aisle." + "\n");
            }
        }
        else {
            displayArea.appendText("The pallet's depth is too big for the chosen aisle." + "\n");
        }
    }

    public void deletePallet(){
        try {
            String PalletID1 = PalletID.getText();
            LinkedLists<Pallet> palletLinkedLists = getShelf().palletLinkedLists;
            for (int i = 0; i < palletLinkedLists.lengthOfList(); i++) {
                if (palletLinkedLists.selectElement(i).getContents().getPalletID().equals(PalletID1)) {
                    palletLinkedLists.deleteElement(i);
                    displayArea.setText("Pallet was deleted" + "\n");
                }
            }
        }catch(Exception e){
            displayArea.setText("Pallet was not deleted." + "\n");
            }
        }

        public void palletSearch(){
        String search = PalletSearch.getText();
        for(Floor smallFloor : Main.floorLinkedLists){
            for(Aisle smallAisle: smallFloor.aisleLinkedLists){
                for(Shelf smallShelf : smallAisle.shelfLinkedLists){
                    for(Pallet smallPallet : smallShelf.palletLinkedLists){
                        if(smallPallet.getGoodsDescription().equalsIgnoreCase(search)){
                            displayArea.setText("The pallet was found in " + smallFloor.toString1() + ", " + smallAisle.toString1() + ", " + smallShelf.toString() + "\n" + "\n" + smallPallet.toString() + "\n");
                            return;
                        }
                    }
                }
            }
        }
    }

    public void listFloors(){
        displayArea.setText(Main.floorLinkedLists.printLinkedList());
    }

    public void listAisles(){
        try{
            Floor smallFloor = getFloor();
            if(smallFloor.aisleLinkedLists.top != null){
                displayArea.setText("These are the Aisles in Floor " + smallFloor.getFloorNumber() + ": " + "\n" + "\n" + smallFloor.aisleLinkedLists.printLinkedList() + "\n");
            }
            else{
                displayArea.setText("There are no aisles on this floor." + "\n");
            }
        }
        catch(Exception e){
            displayArea.appendText("There is no floor selected." + "\n");
        }
    }

    public void listShelves(){
        try{
            Aisle smallAisle = getAisle();
            if(smallAisle.shelfLinkedLists.top != null){
                displayArea.setText("These are the shelves in Aisle " + smallAisle.getAisleIdentifier() + ": " + "\n" + "\n" + smallAisle.shelfLinkedLists.printLinkedList() + "\n");
            }
            else{
                displayArea.setText("There are no shelves in this aisle." + "\n");
            }
        }
        catch(Exception e){
            displayArea.setText("There is no aisle selected." + "\n");
        }
    }

    public void save() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("WarehouseInventory.xml"));
        out.writeObject(Main.floorLinkedLists);
        out.close();
        displayArea.appendText("Your file has been saved." + "\n");
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("WarehouseInventory.xml"));
        Main.floorLinkedLists = (LinkedLists<Floor>) in.readObject();
        in.close();
        displayArea.setText(Main.floorLinkedLists.printLinkedList());
    }

    public void reset(){
        Main.floorLinkedLists.empty();
        displayArea.setText("System has been reset." + "\n");
    }

    public void deleteSelections(){
        GetFloor.clear();
        CurrentFloor.clear();
        GetAisle.clear();
        CurrentAisle.clear();
        GetShelf.clear();
        CurrentAisle.clear();
        displayArea.setText("All selections have been cleared." + "\n");
    }

    public void exit(){
        System.exit(0);
    }




}
