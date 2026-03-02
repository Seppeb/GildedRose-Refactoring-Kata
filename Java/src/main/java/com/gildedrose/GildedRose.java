package com.gildedrose;

class GildedRose {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventoryItems() {
        for (Item item : items) updateItem(item);
    }

    private void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        processExpiredItems(item);
    }

    private void updateQuality(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            increaseQuality(item);
            if (item.sellIn < 11 && item.quality < 50) {
                increaseQuality(item);
            }
            if (item.sellIn < 6 && item.quality < 50) {
                increaseQuality(item);
            }
        } else if (item.name.equals(SULFURAS)) {
            return;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    private void processExpiredItems(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                increaseQuality(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                item.quality = 0;
            } else if (item.name.equals(SULFURAS)) {
                return;
            } else {
                decreaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
