package com.gildedrose;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11 && item.quality < 50) {
            increaseQuality();
        }
        if (item.sellIn < 6 && item.quality < 50) {
            increaseQuality();
        }
    }

    @Override
    protected void processExpiredItems() {
        item.quality = 0;
    }
}
