package com.tzonesoft.door;

public class Door {

    public Integer getId() {
        return id;
    }

    private final Integer id;
    private EnumState state = EnumState.CLOSE;


    public EnumState getState() {
        return state;
    }
    public Door(int id) {
        this.id = id;
    }

    public void changeState() {
        this.state = state == EnumState.CLOSE ? EnumState.OPEN : EnumState.CLOSE;
    }
}
