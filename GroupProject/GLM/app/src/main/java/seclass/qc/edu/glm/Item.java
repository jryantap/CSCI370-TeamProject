package seclass.qc.edu.glm;

/**
 * Item class setup - may need
 */

public class Item {

    long id_;
    String name;
    int id_category;
    int quantity;
    int price;
    boolean isObtained;

    public Item(int id_category, int quantity, int price, boolean isObtained)
    {
        this.id_category = id_category;
        this.quantity = quantity;
        this.price = price;
        this.isObtained = isObtained;
    }

    public Item(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCategory_id()
    {
        return id_category;
    }

    public void setCategory_id(int id_category)
    {
        this.id_category = id_category;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void incrementPrice()
    {
        this.price++;
    }

    public boolean isObtained()
    {
        return isObtained;
    }

    public void setObtained(boolean isObtained)
    {
        this.isObtained = isObtained;
    }

    @Override
    public String toString(){
        return "Item{" + "category_id" + id_category + ", quantity = " + quantity
                + ", price " + price + ", is obtained= " + isObtained + '}';
    }



}
