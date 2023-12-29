package com.l03gr06.sagabi.model;

import java.util.Objects;

@SuppressWarnings({"Immutable","JavaLangClash"})
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Object clone() {
        return new Position(x, y);
    }

    public Position up() {
        return new Position(x, y - 1);
    }

    public Position down() {
        return new Position(x, y + 1);
    }


    public Position right() {
        return new Position(x + 1, y);
    }

    public Position left() {
        return new Position(x - 1, y);
    }


    public Position adjacent() {
        int n = (int) (Math.random() * 4);
        switch (n) {
            case 0: return up();
            case 1:return  right();
            case 2:return down();
            default:return left();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position=(Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

   }