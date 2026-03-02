package com.gildedrose;

public class InventoryItem {

    protected final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public static InventoryItem createInventoryItem(Item item) {
        switch (item.name) {
            case AgedBrie.AGED_BRIE:
                return new AgedBrie(item);
            case BackstagePasses.BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            case Sulfuras.SULFURAS:
                return new Sulfuras(item);
            case Conjured.CONJURED:
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
