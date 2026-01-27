//Please help me boss, im dying, or something....
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


class Volvo240Test {
    private final Volvo240 volvo240 = new Volvo240();
    {
        @Test
        void getNrDoors() {
        assertEquals(2, volvo240.getNrDoors());
        }
        @Test
        void getEnginePower() {
        assertEquals(100, volvo240.getEnginePower());
        }
        @Test
        void getCurrentSpeed() {assertEquals(0, volvo240.getCurrentSpeed());}

        @Test
        void getColor() {assertEquals(Color.pink, volvo240.getColor());}

        @Test
        void getModelName() {assertEquals("Volvo240", volvo240.getModelName());}








    }