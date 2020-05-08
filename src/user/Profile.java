package user;

public class Profile {

    //Class variables
    private String name;
    private Double budget;
    private Boolean offsetAllowance;
    private int offset;
    private Boolean gaming;


    //Constructor
    public Profile(String name) {
        this.name = name;
    }

    public Profile(String name, Double budget, Boolean offsetAllowance, int offset, Boolean gaming) {
        this.name = name;
        this.budget = budget;
        this.offsetAllowance = offsetAllowance;
        this.offset = offset;
        this.gaming = gaming;
    }

    //Setter Methods
    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public void setOffsetAllowance(Boolean offsetAllowance) {
        this.offsetAllowance = offsetAllowance;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setGaming(Boolean gaming) {
        this.gaming = gaming;
    }

}

