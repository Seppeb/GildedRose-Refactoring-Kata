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

    protected void processExpiredItems(Item item) {
        switch (item.name) {
            case GildedRose.AGED_BRIE:
                increaseQuality(item);
                break;
            case GildedRose.BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case GildedRose.SULFURAS:
                return;
            case GildedRose.CONJURED:
                decreaseQuality(item);
                decreaseQuality(item);
                break;
            default:
                decreaseQuality(item);
                break;
        }
    }

    protected void updateSellIn(Item item) {
        if (item.name.equals(GildedRose.SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    protected void updateQuality(Item item) {
        switch (item.name) {
            case GildedRose.AGED_BRIE:
                increaseQuality(item);
                break;
            case GildedRose.BACKSTAGE_PASSES:
                increaseQuality(item);
                if (item.sellIn < 11 && item.quality < 50) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    increaseQuality(item);
                }
                break;
            case GildedRose.SULFURAS:
                return;
            case GildedRose.CONJURED:
                decreaseQuality(item);
                decreaseQuality(item);
                break;
            default:
                decreaseQuality(item);
                break;
        }
    }

    public void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            processExpiredItems(item);
        }
    }
}
