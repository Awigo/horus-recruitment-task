package com.horus;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.of(new Block() {
            @Override
            public String getColor() {
                return "red";
            }

            @Override
            public String getMaterial() {
                return null;
            }
        });
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
