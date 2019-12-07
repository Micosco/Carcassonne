package com.mcsc.carcassonne.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    public void printTileInfo() throws IOException {
        TileStack stack = new TileStack("inn");
        System.out.println(stack);
    }
}