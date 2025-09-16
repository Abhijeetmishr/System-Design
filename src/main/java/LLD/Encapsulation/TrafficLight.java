package Encapsulation.TrafficLight;

public class TrafficLight {
    private String currentColor;
    private boolean redBulbOn;
    private boolean yellowBulbOn;
    private boolean greenBulbOn;

    TrafficLight(String color) {
        this.currentColor = "RED";
        updateBulbColor();
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public boolean isRedBulbOn() {
        return redBulbOn;
    }
    public boolean isYellowBulbOn() {
        return yellowBulbOn;
    }
    public boolean isGreenBulbOn() {
        return greenBulbOn;
    }
    public void changeColor() {
        switch (currentColor) {
            case "RED":
                currentColor = "GREEN";
                break;
            case "GREEN":
                currentColor = "YELLOW";
                break;
            case "YELLOW":
                currentColor = "RED";
                break;
        }
        updateBulbColor();
    }

    public void updateBulbColor() {
        redBulbOn = currentColor == "RED";
        yellowBulbOn = currentColor == "YELLOW";
        greenBulbOn = currentColor == "GREEN";
    }
}   