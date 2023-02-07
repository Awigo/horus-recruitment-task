package com.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final String COLOR_RED = "red";
    private static final String COLOR_BLUE = "blue";

    private Wall wall;

    @BeforeEach
    void setUp() {
        wall = new Wall();
    }

    @Test
    void shouldFindBlockByColorRed() {
        //given
        wall.setBlocks(getBlock(COLOR_RED));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_RED);

        //then
        assertTrue(result.isPresent());
        assertEquals(COLOR_RED, result.get().getColor());
    }

    @Test
    void shouldFindBlockByColorBlue() {
        //given
        wall.setBlocks(getBlock(COLOR_BLUE));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_BLUE);

        //then
        assertTrue(result.isPresent());
        assertEquals(COLOR_BLUE, result.get().getColor());
    }

    private List<Block> getBlock(String color) {
        return List.of(new Block() {
            @Override
            public String getColor() {
                return color;
            }

            @Override
            public String getMaterial() {
                return null;
            }
        });
    }
}