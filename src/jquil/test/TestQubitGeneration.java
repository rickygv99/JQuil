package jquil.test;

import jquil.math.Vector;
import jquil.core.Qubit;

public class TestQubitGeneration {

    public static void main(String[] args) {
        Qubit zero = Qubit.STANDARD_ZERO;
        System.out.println("Qubit Standard_Zero: " + zero.toString());
        System.out.println("Measure in State Zero: " + zero.getMeasurementProbability(Vector.STATE_ZERO));
        System.out.println("Measure in State One: " + zero.getMeasurementProbability(Vector.STATE_ONE));
        System.out.println("Measure in State Plus: " + zero.getMeasurementProbability(Vector.STATE_PLUS));
        System.out.println("Measure in State Minus: " + zero.getMeasurementProbability(Vector.STATE_MINUS));
        Qubit one = Qubit.STANDARD_ONE;
        System.out.println("Qubit Standard_One: " + one.toString());
        System.out.println("Measure in State Zero: " + one.getMeasurementProbability(Vector.STATE_ZERO));
        System.out.println("Measure in State One: " + one.getMeasurementProbability(Vector.STATE_ONE));
        System.out.println("Measure in State Plus: " + one.getMeasurementProbability(Vector.STATE_PLUS));
        System.out.println("Measure in State Minus: " + one.getMeasurementProbability(Vector.STATE_MINUS));
        Qubit plus = Qubit.HADAMARD_PLUS;
        System.out.println("Qubit Hadamard_Plus: " + plus.toString());
        System.out.println("Measure in State Zero: " + plus.getMeasurementProbability(Vector.STATE_ZERO));
        System.out.println("Measure in State One: " + plus.getMeasurementProbability(Vector.STATE_ONE));
        System.out.println("Measure in State Plus: " + plus.getMeasurementProbability(Vector.STATE_PLUS));
        System.out.println("Measure in State Minus: " + plus.getMeasurementProbability(Vector.STATE_MINUS));
        Qubit minus = Qubit.HADAMARD_MINUS;
        System.out.println("Qubit Hadamard_Minus: " + minus.toString());
        System.out.println("Measure in State Zero: " + minus.getMeasurementProbability(Vector.STATE_ZERO));
        System.out.println("Measure in State One: " + minus.getMeasurementProbability(Vector.STATE_ONE));
        System.out.println("Measure in State Plus: " + minus.getMeasurementProbability(Vector.STATE_PLUS));
        System.out.println("Measure in State Minus: " + minus.getMeasurementProbability(Vector.STATE_MINUS));
        Qubit positive = Qubit.CIRCULAR_POSITIVE;
        System.out.println(positive.toString());
        Qubit negative = Qubit.CIRCULAR_NEGATIVE;
        System.out.println(negative.toString());
    }
}