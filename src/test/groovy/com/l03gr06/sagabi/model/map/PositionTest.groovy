package com.l03gr06.sagabi.model.map

import com.l03gr06.sagabi.model.Position
import net.jqwik.api.*


import spock.lang.Specification
import spock.lang.Unroll

//using jqwik
class PositionTest {

    @Property
    boolean "testingRight should return a Position to the right"(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        return position.right().x == x + 1 && position.right().y == y;
    }

    @Property
    boolean  "testingLeft should return a Position to the left"(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        return position.left().x == x - 1 && position.left().y == y;
    }
    @Property
    boolean "testingUp should return a Position above"(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        return position.up().x == x && position.up().y == y - 1;
    }

    @Property
    boolean "testingDown should return a Position below"(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        return position.down().x == x && position.down().y == y + 1;
    }
    
    @Property
    boolean "testingAdjacent should return a Position adjacent to the current one"(@ForAll int x, @ForAll int y) {
        Position position = new Position(x, y);
        Position adjacent = position.adjacent();

        boolean isAdjacent = (adjacent.x == x && Math.abs(adjacent.y - y) == 1) ||
                            (adjacent.y == y && Math.abs(adjacent.x - x) == 1);

        return isAdjacent;
    }
}
