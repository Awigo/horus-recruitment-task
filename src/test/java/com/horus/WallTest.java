package com.horus;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final String COLOR_RED = "red";

    @Test
    void shouldFindBlockByColor() {
        //given
        Wall wall = new Wall();
        wall.setBlocks(getRedBlock());

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_RED);

        //then
        assertTrue(result.isPresent());
        assertEquals("red", result.get().getColor());
    }

    private List<Block> getRedBlock() {
        return List.of(new Block() {
            @Override
            public String getColor() {
                return COLOR_RED;
            }

            @Override
            public String getMaterial() {
                return null;
            }
        });
    }
}