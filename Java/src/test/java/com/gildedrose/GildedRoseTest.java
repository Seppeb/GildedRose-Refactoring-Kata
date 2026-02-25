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
}
