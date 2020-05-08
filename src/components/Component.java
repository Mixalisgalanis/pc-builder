package components;

public abstract class Component {

    //Class variables
    //Product details
    private String name;
    private String componentLink;
    private Double averageReview;
    //Store details (The one with the lower product price)
    private String storeName;
    private String storeProductLink;
    private String availability;
    private Double initialPrice;
    /*private Double deliveryFee;
    private Double cashFee;*/

    //Buildable score
    private double score;

    //Constructors
    Component(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getComponentLink() {
        return componentLink;
    }
    public Double getAverageReview() {
        return averageReview;
    }
    public Object[] getStoreDetails(){
        return new Object[] {
                this.storeName
                , this.storeProductLink
                , this.availability
                , this.initialPrice};
    }


    //Setters
    public void setComponentLink(String componentLink) {
        this.componentLink = componentLink;
    }
    public void setAverageReview(Double averageReview) {
        this.averageReview = averageReview;
    }

    //Other Methods
    public void setStoreDetails(Object[] storeDetails){
        int counter = 0;
        this.storeName = (String) storeDetails[counter++];
        this.storeProductLink = (String) storeDetails[counter++];
        this.availability = (String) storeDetails[counter++];
        this.initialPrice = (Double) storeDetails[counter++];
        /*this.deliveryFee = (Double) storeDetails[counter++];
        this.cashFee = (Double) storeDetails[counter];*/
    }

    public abstract void buildScore();

    public abstract Object[] buildSpecArray();
}
