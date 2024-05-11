

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
        System.out.println("---------------------------------------------------");
        System.out.println("ID | Type              | Title              | Description          | Fine Per Day");
        System.out.println("---------------------------------------------------");
        for (Item item : itemList) {
            System.out.printf("%-3d| %-18s| %-20s| %-20s| %.2f%n",
                item.getId(),
                item.getItemType(),
                item.getTitle(),
                item.getDescription(),
                item.getFinePerDay());
        }
        System.out.println("---------------------------------------------------");
    }
    
}

