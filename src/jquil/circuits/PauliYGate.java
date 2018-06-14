package jquil.circuits;

import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class PauliYGate extends Matrix {

    public PauliYGate() {
        super(2, 2);
        setValue(0, 0, ComplexNumber.ZERO);
        setValue(0, 1, ComplexNumber.NEGATIVE_IMAGINARY);
        setValue(1, 0, ComplexNumber.IMAGINARY);
        setValue(1, 1, ComplexNumber.ZERO);
    }

    /**
     * Returns the matrix form of the Pauli-Y gate.
     * @return 
     */
    public static Matrix getMatrix() {
        Matrix m = new Matrix(2, 2);
        m.setValue(0, 0, ComplexNumber.ZERO);
        m.setValue(0, 1, ComplexNumber.NEGATIVE_IMAGINARY);
        m.setValue(1, 0, ComplexNumber.IMAGINARY);
        m.setValue(1, 1, ComplexNumber.ZERO);
        return m;
    }
}
