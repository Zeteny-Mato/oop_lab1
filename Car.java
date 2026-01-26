import java.awt.*;  
// Importerar Color-klassen så vi kan använda färger på bilarna.

public abstract class Car {
    // === Fält (privata för inkapsling) ===

    private int nrDoors;          // Antal dörrar på bilen
    private double enginePower;   // Motorns maxeffekt
    private double currentSpeed;  // Bilens nuvarande hastighet
    private Color color;          // Bilens färg
    private String modelName;     // Modellnamn

    // === Konstruktor (protected → bara subklasser får använda den) ===
    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;           // Sätter antal dörrar
        this.enginePower = enginePower;   // Sätter motoreffekten
        this.color = color;               // Sätter färgen
        this.modelName = modelName;       // Sätter modellnamnet
        stopEngine();                     // Alla bilar startar med avstängd motor
    }

    // === Publika getters (användaren får läsa men inte ändra) ===

    public int getNrDoors() {
        return nrDoors;                   // Returnerar antal dörrar
    }

    public double getEnginePower() {
        return enginePower;               // Returnerar motoreffekten
    }

    public double getCurrentSpeed() {
        return currentSpeed;              // Returnerar nuvarande hastighet
    }

    public Color getColor() {
        return color;                     // Returnerar bilens färg
    }

    public String getModelName() {
        return modelName;                 // Returnerar modellnamnet
    }

    public void setColor(Color clr) {
        color = clr;                      // Tillåter användaren att ändra färg
    }

    // === Motorhantering ===

    public void startEngine() {
        currentSpeed = 0.1;               // Startar motorn med en liten fart
    }

    public void stopEngine() {
        currentSpeed = 0;                 // Stänger av motorn helt
    }

    // === Gas och broms ===

    public void gas(double amount) {
        // Säkerhetskontroll: amount måste vara mellan 0 och 1
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        }
        incrementSpeed(amount);           // Ökar hastigheten
    }

    public void brake(double amount) {
        // Samma säkerhetskontroll som gas
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("Amount must be between 0 and 1");
        }
        decrementSpeed(amount);           // Minskar hastigheten
    }

    // === Abstrakt metod som subklasser måste implementera ===

    public abstract double speedFactor();
    // Varje biltyp har sin egen acceleration → därför abstract.

    // === Skyddade metoder för hastighetsändring ===

    protected void incrementSpeed(double amount) {
        // Ökar hastigheten men aldrig över enginePower
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        // Minskar hastigheten men aldrig under 0
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
public class Volvo240 extends Car {
    private final double trimFactor = 1.25; // Trimfaktor för Volvo240

    public Volvo240() {
        super(4, 100, Color.pink, "Volvo240"); // Anropar baskonstruktorn
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor; // Beräknar speedFactor
    }
}

public class Saab95 extends Car {
    private boolean turboOn; // Turbo status

    public Saab95() {
        super(2, 125, Color.red, "Saab95"); // Anropar baskonstruktorn
        turboOn = false;                    // Turbo är avstängd som standard
    }

    public void setTurboOn() {
        turboOn = true;                     // Sätter turbo på
    }

    public void setTurboOff() {
        turboOn = false;                    // Sätter turbo av
    }

    @Override
    public double speedFactor() {
        double turbo = turboOn ? 1.3 : 1.0; // Turbo påverkar speedFactor
        return getEnginePower() * 0.01 * turbo;
    }
}