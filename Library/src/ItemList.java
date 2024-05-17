import java.util.ArrayList;
import java.util.List;

class ItemList implements ListInterface<Item>{
    private List<Item> itemList;
    
    public ItemList() {
        itemList = new ArrayList<>();
    }
    @Override
    public void addEntity(Item item) {
        itemList.add(item);
    }
    @Override
    public void removeEntity(Item item){
        itemList.remove(item);
    }
    @Override
    public Item getEntityById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) {
                return item;
            }
        }
        System.out.println("the Item ID is invalid"); // If item with given id is not found
        return null; 
    }
    @Override
    public List<Item> getEntityList() {
        return itemList;
    }
    
    
}

