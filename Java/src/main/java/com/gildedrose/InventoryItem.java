package com.gildedrose;

public class InventoryItem {

    protected final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createInventoryItem(Item item) {
        return switch (item.name) {
            case AgedBrie.NAME -> new AgedBrie(item);
            case BackstagePasses.NAME -> new BackstagePasses(item);
            case Sulfuras.NAME -> new Sulfuras(item);
            case Conjured.NAME -> new Conjured(item);
            default -> new InventoryItem(item);
        };
    }

    public void updateItem() {
        updateQuality();
        updateSellIn();
        if (isExpired()) {
            processExpiredItems();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void processExpiredItems() {
        decreaseQuality();
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }
}
