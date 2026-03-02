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
                increaseQuality(item, inventoryItem);
                break;
            case BACKSTAGE_PASSES:
                increaseQuality(item, inventoryItem);
                if (item.sellIn < 11 && item.quality < 50) {
                    increaseQuality(item, inventoryItem);
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    increaseQuality(item, inventoryItem);
                }
                break;
            case SULFURAS:
                return;
            case CONJURED:
                decreaseQuality(item, inventoryItem);
                decreaseQuality(item, inventoryItem);
                break;
            default:
                decreaseQuality(item, inventoryItem);
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
                increaseQuality(item, inventoryItem);
                break;
            case BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case SULFURAS:
                return;
            case CONJURED:
                decreaseQuality(item, inventoryItem);
                decreaseQuality(item, inventoryItem);
                break;
            default:
                decreaseQuality(item, inventoryItem);
                break;
        }
    }

    private void increaseQuality(Item item, InventoryItem inventoryItem) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item, InventoryItem inventoryItem) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
