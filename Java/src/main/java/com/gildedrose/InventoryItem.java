package com.gildedrose;

public class InventoryItem {

    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
