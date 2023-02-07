package com.horus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        validateMaterial(material);
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    private void validateMaterial(String material) {
        if (material == null) {
            throw new InvalidMaterialException("Material cannot be null!");
        }
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(block -> block instanceof CompositeBlock
                        ? ((CompositeBlock) block).getBlocks().size()
                        : 1)
                .sum();
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
