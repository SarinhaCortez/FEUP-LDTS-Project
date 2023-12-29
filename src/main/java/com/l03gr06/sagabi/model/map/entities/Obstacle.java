package com.l03gr06.sagabi.model.map.entities;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class Obstacle extends Entity {
    private String id;

    public Obstacle(int x, int y, String id) {
        super(x, y);
        this.id = id;
    }


    public String getId() {
        return id;
    }

}
