package com.gildedrose;

public class Sulfuras extends InventoryItem {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        // Quality of Sulfuras does not change
    }

    @Override
    protected void updateSellIn() {
        // SellIn of Sulfuras does not change
    }

    @Override
    protected void processExpiredItems() {
        // Quality of Sulfuras does not change even after expiration
    }
}
