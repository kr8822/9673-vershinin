package ru.cft.focusstart.reader;


import ru.cft.focusstart.figure.*;

public class ParametersFigureReader implements Reader {
    private Reader reader;

    public ParametersFigureReader(Reader reader) {
        this.reader = reader;
    }

    private enum FigureType {

        CIRCLE("CIRCLE") {
            @Override
            public String printString(double[] radius) {
                return new Circle(radius[0]).printDescription();
            }
        },
        RECTANGLE("RECTANGLE") {
            @Override
            public String printString(double[] sides) {
                return new Rectangle(sides[0], sides[1]).printDescription();
            }
        },
        SQUARE("SQUARE") {
            @Override
            public String printString(double[] side) {
                return new Square(side[0]).printDescription();
            }
        },
        NONE(null) {
            @Override
            public String printString(double[] side) {
                return "";
            }
        };
        private final String displayableType;

        FigureType(String displayableType) {
            this.displayableType = displayableType;
        }

        abstract String printString(double[] parameters);
    }

    @Override
    public String[] read() throws Exception {
        String[] args = reader.read();
        FigureType figureType = FigureType.valueOf(args[0]);
        double[] parameters = new double[args.length - 1];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = Double.valueOf(args[i + 1]);
            if (parameters[i] <= 0) {
                throw new IllegalArgumentException("One of parameters of Figure is negative number or zero");
            }
        }
        return new String[]{figureType.printString(parameters)};
    }
}
