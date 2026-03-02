package com.gildedrose;

public class InventoryItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured";
    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createInventoryItem(Item item) {
        if (item.name.equals(AGED_BRIE)) { return new AgedBrie(item); }

        return new InventoryItem(item);
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
            case AGED_BRIE:
                increaseQuality();
                break;
            case BACKSTAGE_PASSES:
                increaseQuality();
                if (item.sellIn < 11 && item.quality < 50) {
                    increaseQuality();
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    increaseQuality();
                }
                break;
            case SULFURAS:
                return;
            case CONJURED:
                decreaseQuality();
                decreaseQuality();
                break;
            default:
                decreaseQuality();
                break;
        }
    }

    protected void updateSellIn() {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    protected void processExpiredItems() {
        switch (item.name) {
            case AGED_BRIE:
                increaseQuality();
                break;
            case BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case SULFURAS:
                return;
            case CONJURED:
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
