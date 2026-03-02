package com.gildedrose;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItem_decreaseQualityByOne() {
        Item item = new Item("Normal Item", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void allItems_qualityNeverNegative() {
        Item item = new Item("Normal Item", 10, 0);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void allItems_qualityNeverExceedsFifty() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void agedBrie_increaseQualityByOne() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void backStagePasses_increaseQualityByOneWhenSellInGreaterThanTen() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void backStagePasses_increaseQualityByTwoWhenSellInBetweenSixAndTen() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backStagePasses_increaseQualityByThreeWhenSellInBetweenZeroAndFive() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void backStagePasses_qualityDropsToZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void sulfuras_qualityAndSellInNeverChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void normalItem_decreaseQualityByTwoAfterSellInDate() {
        Item item = new Item("Normal Item", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void agedBrie_increaseQualityByTwoAfterSellInDate() {
        Item item = new Item("Aged Brie", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(-1, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backStagePasses_qualityNeverAboveFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(4, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void conjuredItem_decreaseQualityByTwo() {
        Item item = new Item("Conjured", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void conjuredItem_decreaseQualityByFourWhenAfterSellInDate() {
        Item item = new Item("Conjured", -1, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(-2, item.sellIn);
        assertEquals(16, item.quality);
    }

    @Test
    void conjuredItem_qualityNeverNegative() {
        Item item = new Item("Conjured", 0, 1);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateInventoryItems();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
