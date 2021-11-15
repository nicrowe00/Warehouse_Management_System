package warehouse;

public class Pallet {
    private String palletID;
    private String goodsDescription;
    private int numberOfGoods;
    private double maxTemperature;
    private double minTemperature;
    private int palletDepth;
    private int palletWidth;


    //Constructor
    public Pallet(String palletID, String goodsDescription, int numberOfGoods, double maxTemperature, double minTemperature, int palletDepth, int palletWidth){
        this.palletID = palletID;
        this.goodsDescription = goodsDescription;
        this.numberOfGoods = numberOfGoods;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.palletDepth = palletDepth;
        this.palletWidth = palletWidth;
    }

    //Getters and Setters
    public String getPalletID(){
        return palletID;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public int getNumberOfGoods() {
        return numberOfGoods;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public int getPalletDepth(){
        return palletDepth;
    }

    public int getPalletWidth(){
        return palletWidth;
    }

    public void setPalletID(String palletID){
        this.palletID = palletID;
    }

    public void setGoodsDescription(String goodsDescription){
        this.goodsDescription = goodsDescription;
    }

    public void setNumberOfGoods(int numberOfGoods){
        this.numberOfGoods = numberOfGoods;
    }

    public void setMaxTemperature(double maxTemperature){
        this.maxTemperature = maxTemperature;
    }

    public void setMinTemperature(double minTemperature){
        this.minTemperature = minTemperature;
    }

    public void setPalletDepth(int palletDepth){
        this.palletDepth = palletDepth;
    }

    public void setPalletWidth(int palletWidth){
        this.palletWidth = palletWidth;
    }

    //toString method
    @Override
    public String toString(){
        return "Pallet ID: " + palletID +
                ", \n Goods Description: " + goodsDescription +
                ", \n Number of Goods: " + numberOfGoods +
                ", \n Maximum Storage Temperature: " + maxTemperature +
                ", \n Minimum Storage Temperature: " + minTemperature +
                ", \n Pallet Depth: " + palletDepth +
                " and \n Pallet Width: " + palletWidth + "\n";
     }
}
