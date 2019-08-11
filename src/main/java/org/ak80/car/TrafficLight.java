package org.ak80.car;

public class TrafficLight implements StreetObject {

    private Color color = Color.RED;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public enum Color {

        GREEN,
        YELLOW,
        RED

    }

}
