package com.gildedrose;

public class InventoryItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String CONJURED = "Conjured";
    protected final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createInventoryItem(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            case SULFURAS:
                return new Sulfuras(item);
            case CONJURED:
                return new Conjured(item);
            default:
                return new InventoryItem(item);
        }
    }

    public void updateItem() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            processExpiredItems();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void processExpiredItems() {
        decreaseQuality();
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
