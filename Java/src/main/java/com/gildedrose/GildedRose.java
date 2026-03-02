package com.gildedrose;

import static com.gildedrose.InventoryItem.createInventoryItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryItems() {
        for (Item item : items) {
            createInventoryItem(item).updateItem();
        }
    }
}
