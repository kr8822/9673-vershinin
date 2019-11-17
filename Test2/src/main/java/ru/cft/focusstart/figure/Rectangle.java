package ru.cft.focusstart.figure;


public class Rectangle implements Figure {
    private double largeSide;
    private double smallSide;

    public Rectangle(double firstSide, double secondSide) {
        if (firstSide >= secondSide) {
            this.largeSide = firstSide;
            this.smallSide = secondSide;
        } else {
            this.largeSide = secondSide;
            this.smallSide = firstSide;
        }
    }

    protected double calcArea() {
        return this.largeSide * this.smallSide;
    }

    protected double calcPerimeter() {
        return 2 * (this.smallSide + this.largeSide);
    }

    protected double calcDiagonal() {
        return Math.sqrt(this.largeSide * this.largeSide + this.smallSide * this.smallSide);
    }

    @Override
    public double[] getParameters() {
        return new double[]{this.calcArea(), this.calcPerimeter(), this.largeSide, this.smallSide, this.calcDiagonal()};
    }
}
