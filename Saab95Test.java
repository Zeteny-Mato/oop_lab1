import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

//TODO Fix getCurrentSpeed what do we compare the method too? Fix Saab95 specific cases
public class Saab95Test {
    private Saab95 saab95 = new Saab95();

    //Car testcases
    @Test
    void getNrDoors() {
        assertEquals(2,saab95.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(125,saab95.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(2,saab95.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.red,saab95.getColor());
    }

    @Test
    void getModelName() {
        assertEquals("Saab95",saab95.getModelName());
    }

    //SAAB specific testcases
    @Test
    void setTurboOn(){
        saab95.setTurboOn();
        assertTrue(null);
    }

    @Test
    void setTurboOff(){
        assertFalse(null);
    }

}
