package ru.cft.focusstart.figure;

public class Square extends Rectangle{
    private double side;

    public Square(double side){
        super(side, side);
        this.side = side;
    }

    @Override
    public double[] getParameters() {
        return new double[]{this.calcArea(), this.calcPerimeter(), this.side, this.calcDiagonal()};
    }
}
