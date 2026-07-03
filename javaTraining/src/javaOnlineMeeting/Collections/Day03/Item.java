package javaOnlineMeeting.Collections.Day03;

public class Item implements Comparable<Item> {

    private String itemName;
    private int itemId;
    private double itemCost;

    // Default Constructor
    public Item() {
        super();
    }

    // Parameterized Constructor
    public Item(String itemName, int itemId, double itemCost) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemCost = itemCost;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for itemId
    public int getItemId() {
        return itemId;
    }

    // Setter for itemId
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    // Getter for itemCost
    public double getItemCost() {
        return itemCost;
    }

    // Setter for itemCost
    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    // toString() method
    @Override
    public String toString() {
        return "Item [itemName=" + itemName
                + ", itemId=" + itemId
                + ", itemCost=" + itemCost + "]";
    }

    // Natural ordering by itemName (ascending)
    @Override
    public int compareTo(Item o) {
        return this.getItemName().compareTo(o.getItemName());
    }
}