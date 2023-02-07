package com.horus;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final String COLOR_RED = "red";
    private static final String COLOR_BLUE = "blue";

    @Test
    void shouldFindBlockByColorRed() {
        //given
        Wall wall = new Wall();
        wall.setBlocks(getBlock(COLOR_RED));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_RED);

        //then
        assertTrue(result.isPresent());
        assertEquals("red", result.get().getColor());
    }

    @Test
    void shouldFindBlockByColorBlue() {
        //given
        Wall wall = new Wall();
        wall.setBlocks(getBlock(COLOR_BLUE));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_BLUE);

        //then
        assertTrue(result.isPresent());
        assertEquals("blue", result.get().getColor());
    }

    private List<Block> getBlock(String colorRed) {
        return List.of(new Block() {
            @Override
            public String getColor() {
                return colorRed;
            }

            @Override
            public String getMaterial() {
                return null;
            }
        });
    }
}