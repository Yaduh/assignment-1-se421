public interface Builder {
    Item build();
    ItemBuilder setId(int libraryId);
    ItemBuilder setItemType(String itemType);
    ItemBuilder setTitle(String title);
    ItemBuilder setDescription(String description);
}
