package com.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final String COLOR_RED = "red";
    private static final String COLOR_BLUE = "blue";
    private static final String MATERIAL_WOOD = "wood";
    private static final String MATERIAL_BRICK = "brick";

    private Wall wall;

    @BeforeEach
    void setUp() {
        wall = new Wall();
    }

    @Test
    void shouldFindBlockByColorRed() {
        //given
        wall.setBlocks(getBlockByColor(COLOR_RED));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_RED);

        //then
        assertTrue(result.isPresent());
        assertEquals(COLOR_RED, result.get().getColor());
    }

    @Test
    void shouldFindBlockByColorBlue() {
        //given
        wall.setBlocks(getBlockByColor(COLOR_BLUE));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_BLUE);

        //then
        assertTrue(result.isPresent());
        assertEquals(COLOR_BLUE, result.get().getColor());
    }

    @Test
    void whenThereAreNoBlocksInProvidedColorReturnedOptionalShouldBeEmpty() {
        //given
        wall.setBlocks(getBlockByColor(COLOR_RED));

        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_BLUE);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void whenThereAreNoBlocksReturnedOptionalShouldBeEmpty() {
        //when
        Optional<Block> result = wall.findBlockByColor(COLOR_BLUE);

        //then
        assertTrue(result.isEmpty());
    }

    @Test
    void whenColorIsNullShouldThrowInvalidColorException() {
        InvalidColorException exception = assertThrows(InvalidColorException.class, () -> wall.findBlockByColor(null));
        assertEquals(exception.getMessage(), "Color cannot be null!");
    }

    @Test
    void shouldFindBlockByMaterialWood() {
        //given
        wall.setBlocks(getBlockByMaterial(MATERIAL_WOOD));

        //when
        List<Block> result = wall.findBlocksByMaterial(MATERIAL_WOOD);

        //then
        assertEquals(1, result.size());
        assertEquals(MATERIAL_WOOD, result.get(0).getMaterial());
    }

    @Test
    void shouldFindBlockByMaterialBrick() {
        //given
        wall.setBlocks(getBlockByMaterial(MATERIAL_BRICK));

        //when
        List<Block> result = wall.findBlocksByMaterial(MATERIAL_BRICK);

        //then
        assertEquals(1, result.size());
        assertEquals(MATERIAL_BRICK, result.get(0).getMaterial());
    }

    @Test
    void shouldFindAllBlocksByMaterialWood() {
        //given
        wall.setBlocks(getWoodenAndBrickBlocks(10, 5));

        //when
        List<Block> result = wall.findBlocksByMaterial(MATERIAL_WOOD);

        //then
        assertEquals(10, result.size());
        assertEquals(getWoodenAndBrickBlocks(10, 0), result);
    }

    private List<Block> getWoodenAndBrickBlocks(int woodenBlocks, int brickBlocks) {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < woodenBlocks; i++) {
            blocks.add(new Block() {
                @Override
                public String getColor() {
                    return null;
                }

                @Override
                public String getMaterial() {
                    return MATERIAL_WOOD;
                }
            });
        }

        for (int i = 0; i < brickBlocks; i++) {
            blocks.add(new Block() {
                @Override
                public String getColor() {
                    return null;
                }

                @Override
                public String getMaterial() {
                    return MATERIAL_BRICK;
                }
            });
        }
        return blocks;
    }

    private List<Block> getBlockByColor(String color) {
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

    private List<Block> getBlockByMaterial(String material) {
        return List.of(new Block() {
            @Override
            public String getColor() {
                return null;
            }

            @Override
            public String getMaterial() {
                return material;
            }
        });
    }
}