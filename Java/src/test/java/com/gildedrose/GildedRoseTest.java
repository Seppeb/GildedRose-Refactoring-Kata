package com.gildedrose;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItem_decreaseQualityByOne() {
        Item item = new Item("Normal Item", 10, 20);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void allItems_qualityNeverNegative() {
        Item item = new Item("Normal Item", 10, 0);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void allItems_qualityNeverExceedsFifty() {
        Item item = new Item("Aged Brie", 10, 50);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void agedBrie_increaseQualityByOne() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }
}
