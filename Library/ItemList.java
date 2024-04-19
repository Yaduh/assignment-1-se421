package Library;

import java.util.ArrayList;
import java.util.List;

class ItemList {
    private List<Item> itemList;

    public ItemList() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(Item item){
        itemList.remove(item);
    }
    public List<Item> getItemList() {
        return itemList;
    }

    public Item getItemById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        System.out.println("the Item ID is invalid"); // If item with given id is not found
        return null; 
    }
    public void displayItemList() {
        System.out.println("Items in the list:");
        for (Item item : itemList) {
            System.out.println("ID: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Type: " + item.getItemType());
            System.out.println("Fine Per Day: " + item.getFinePerDay());
            System.out.println("____________");
        }
    }
}

