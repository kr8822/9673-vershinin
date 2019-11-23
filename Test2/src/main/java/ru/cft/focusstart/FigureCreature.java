package ru.cft.focusstart;

import ru.cft.focusstart.figure.*;

public enum FigureCreature {

    CIRCLE("CIRCLE") {
        @Override
        public Circle createFigure(String[] parametersInString) {
            double[] radius = getParameters(parametersInString);
            return new Circle(radius[0]);
        }
    },
    RECTANGLE("RECTANGLE") {
        @Override
        public Rectangle createFigure(String[] parametersInString) {
            double[] sides = getParameters(parametersInString);
            return new Rectangle(sides[0], sides[1]);
        }
    },
    SQUARE("SQUARE") {
        @Override
        public Square createFigure(String[] parametersInString) {
            double[] side = getParameters(parametersInString);
            return new Square(side[0]);
        }
    };
    private final String displayableType;

    FigureCreature(String displayableType) {
        this.displayableType = displayableType;
    }

    abstract Figure createFigure(String[] parameters);

    double[] getParameters(String[] args) {
        double[] parameters = new double[args.length - 1];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = Double.parseDouble(args[i + 1]);
            if (parameters[i] <= 0) {
                throw new IllegalArgumentException("One of parameters of Figure is negative number or zero");
            }
        }
        return parameters;
    }

}