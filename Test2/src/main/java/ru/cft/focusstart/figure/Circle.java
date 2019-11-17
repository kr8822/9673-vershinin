package ru.cft.focusstart.figure;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    private double calcArea() {
        return Math.PI * this.radius * this.radius;
    }

    private double calcPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double[] getParameters() {
        return new double[]{calcArea(), calcPerimeter(), this.radius, 2 * this.radius};
    }
}
