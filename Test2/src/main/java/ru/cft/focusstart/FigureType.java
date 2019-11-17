package ru.cft.focusstart;


import ru.cft.focusstart.figure.*;

public enum FigureType {

    CIRCLE("CIRCLE") {
        @Override
        public String printString(double radius, double radius2) {
            double[] parameters = new Circle(radius).getParameters();
            return String.format("Тип фигуры: Круг\nПлощадь: %.2f\nПериметр: %.2f\nРадиус: %.2f\nДиаметр %f\n",
                    parameters[0], parameters[1], parameters[2], parameters[3]);
        }
    },
    RECTANGLE("RECTANGLE") {
        @Override
        public String printString(double firstSide, double secondSide) {
            double[] parameters = new Rectangle(firstSide, secondSide).getParameters();
            return String.format("Тип фигуры: Прямоугольник\nПлощадь: %.2f\nПериметр: %.2f\nДлина: %.2f\nШирина: %.2f\nДлина диагонали %.2f\n",
                    parameters[0], parameters[1], parameters[2], parameters[3], parameters[4]);
        }
    },
    SQUARE("SQUARE") {
        @Override
        public String printString(double side, double side2) {
            double[] parameters = new Square(side).getParameters();
            return String.format("Тип фигуры: Квадрат\nПлощадь: %.2f\nПериметр: %.2f\nДлина стороны: %.2f\nДлина диагонали %.2f\n",
                    parameters[0], parameters[1], parameters[2], parameters[3]);
        }
    };
    private final String displayableType;

    FigureType(String displayableType) {
        this.displayableType = displayableType;
    }

    abstract String printString(double side, double side2);
}
