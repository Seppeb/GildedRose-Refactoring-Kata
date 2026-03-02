package com.gildedrose;

import java.util.List;

import static com.gildedrose.InventoryItem.createInventoryItem;

class GildedRose {

    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateInventoryItems() {
        items.forEach(item -> createInventoryItem(item).updateItem());
    }
}
