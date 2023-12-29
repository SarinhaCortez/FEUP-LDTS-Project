package com.l03gr06.sagabi.model.map.entities;

import com.l03gr06.sagabi.model.Position;

@SuppressWarnings({"Immutable","JavaLangClash"})
public abstract class Entity {
    private Position position;

    public Entity(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition(){
        Position p = (Position) position.clone();
        return p;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
