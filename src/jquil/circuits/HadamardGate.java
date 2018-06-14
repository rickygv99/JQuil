package jquil.circuits;

import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class HadamardGate extends Matrix {

    public HadamardGate() {
        super(2, 2);
        setValue(0, 0, new ComplexNumber(1.0D / Math.sqrt(2)));
        setValue(0, 1, new ComplexNumber(1.0D / Math.sqrt(2)));
        setValue(1, 0, new ComplexNumber(1.0D / Math.sqrt(2)));
        setValue(1, 1, new ComplexNumber(-1.0D / Math.sqrt(2)));
    }

    /**
     * Returns the matrix form of the Hadamard gate.
     * @return 
     */
    public static Matrix getMatrix() {
        Matrix m = new Matrix(2, 2);
        m.setValue(0, 0, new ComplexNumber(1.0D / Math.sqrt(2)));
        m.setValue(0, 1, new ComplexNumber(1.0D / Math.sqrt(2)));
        m.setValue(1, 0, new ComplexNumber(1.0D / Math.sqrt(2)));
        m.setValue(1, 1, new ComplexNumber(-1.0D / Math.sqrt(2)));
        return m;
    }
}
