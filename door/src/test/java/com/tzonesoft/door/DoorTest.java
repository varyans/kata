package com.tzonesoft.door;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.tzonesoft.door.EnumState.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoorTest {


    @Test
    void checkDoors() {
        assertDoors(1, OPEN);
        assertDoors(2, OPEN, CLOSE);
        assertDoors(3, OPEN, CLOSE, CLOSE);
        assertDoors(4, OPEN, CLOSE, CLOSE, OPEN);
        assertDoors(5, OPEN, CLOSE, CLOSE, OPEN, CLOSE);
        assertDoors(6, OPEN, CLOSE, CLOSE, OPEN, CLOSE, CLOSE);
        assertDoors(7, OPEN, CLOSE, CLOSE, OPEN, CLOSE, CLOSE, CLOSE);
        assertDoors(8, OPEN, CLOSE, CLOSE, OPEN, CLOSE, CLOSE, CLOSE,CLOSE);
        assertDoors(9, OPEN, CLOSE, CLOSE, OPEN, CLOSE, CLOSE, CLOSE,CLOSE,OPEN);
        assertDoors(10, OPEN, CLOSE, CLOSE, OPEN, CLOSE, CLOSE, CLOSE,CLOSE,OPEN,CLOSE);
    }

    private void assertDoors(int numberOfDoors,EnumState... states) {
        assertEquals(List.of(states),changeState(numberOfDoors).stream().map(Door::getState).collect(Collectors.toList()));
    }

    List<Door> changeState(int numberOfDoor) {
        List<Door> doors = createDoors(numberOfDoor);
        for (int i = 0; i < numberOfDoor; i++) {
            for (int j = 0; j < numberOfDoor ; j++) {
                if ((doors.get(j).getId() % (i+1)) == 0)
                    doors.get(j).changeState();
            }
        }
        return doors;
    }

    List<Door> createDoors(Integer numberOfDoors) {
        return IntStream.range(1, numberOfDoors+1).mapToObj(Door::new).collect(Collectors.toList());
    }
}