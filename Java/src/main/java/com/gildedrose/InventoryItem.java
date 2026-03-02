package com.gildedrose;

public class InventoryItem {

    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void updateItem() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            processExpiredItems();
        }
    }

    protected void updateQuality() {
        switch (item.name) {
            case GildedRose.AGED_BRIE:
                increaseQuality();
                break;
            case GildedRose.BACKSTAGE_PASSES:
                increaseQuality();
                if (item.sellIn < 11 && item.quality < 50) {
                    increaseQuality();
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    increaseQuality();
                }
                break;
            case GildedRose.SULFURAS:
                return;
            case GildedRose.CONJURED:
                decreaseQuality();
                decreaseQuality();
                break;
            default:
                decreaseQuality();
                break;
        }
    }

    protected void updateSellIn() {
        if (item.name.equals(GildedRose.SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    protected void processExpiredItems() {
        switch (item.name) {
            case GildedRose.AGED_BRIE:
                increaseQuality();
                break;
            case GildedRose.BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case GildedRose.SULFURAS:
                return;
            case GildedRose.CONJURED:
                decreaseQuality();
                decreaseQuality();
                break;
            default:
                decreaseQuality();
                break;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
