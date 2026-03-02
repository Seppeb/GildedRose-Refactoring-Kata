package com.gildedrose;

class GildedRose {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryItems() {
        for (Item item : items) {
            InventoryItem inventoryItem = new InventoryItem(item);
            updateItem(item, inventoryItem);
        }
    }

    private void updateItem(Item item, InventoryItem inventoryItem) {
        updateQuality(item, inventoryItem);
        updateSellIn(item, inventoryItem);
        if (item.sellIn < 0) {
            processExpiredItems(item, inventoryItem);
        }
    }

    private void updateQuality(Item item, InventoryItem inventoryItem) {
        switch (item.name) {
            case AGED_BRIE:
                inventoryItem.increaseQuality(item);
                break;
            case BACKSTAGE_PASSES:
                inventoryItem.increaseQuality(item);
                if (item.sellIn < 11 && item.quality < 50) {
                    inventoryItem.increaseQuality(item);
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    inventoryItem.increaseQuality(item);
                }
                break;
            case SULFURAS:
                return;
            case CONJURED:
                inventoryItem.decreaseQuality(item);
                inventoryItem.decreaseQuality(item);
                break;
            default:
                inventoryItem.decreaseQuality(item);
                break;
        }
    }

    private void updateSellIn(Item item, InventoryItem inventoryItem) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    private void processExpiredItems(Item item, InventoryItem inventoryItem) {
        switch (item.name) {
            case AGED_BRIE:
                inventoryItem.increaseQuality(item);
                break;
            case BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case SULFURAS:
                return;
            case CONJURED:
                inventoryItem.decreaseQuality(item);
                inventoryItem.decreaseQuality(item);
                break;
            default:
                inventoryItem.decreaseQuality(item);
                break;
        }
    }
}
