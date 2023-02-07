package com.horus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        validateColor(color);
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    private void validateColor(String color) {
        if (color == null) {
            throw new InvalidColorException("Color cannot be null!");
        }
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material.equals("wood")) {
            return List.of(new Block() {
                @Override
                public String getColor() {
                    return null;
                }

                @Override
                public String getMaterial() {
                    return "wood";
                }
            });
        } else {
            return List.of(new Block() {
                @Override
                public String getColor() {
                    return null;
                }

                @Override
                public String getMaterial() {
                    return "brick";
                }
            });
        }
    }

    @Override
    public int count() {
        return 0;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
