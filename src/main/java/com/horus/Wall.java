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
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
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
