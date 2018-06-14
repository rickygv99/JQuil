package jquil.circuits;

import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class PauliZGate extends Matrix {

    public PauliZGate() {
        super(2, 2);
        setValue(0, 0, ComplexNumber.ONE);
        setValue(0, 1, ComplexNumber.ZERO);
        setValue(1, 0, ComplexNumber.ZERO);
        setValue(1, 1, ComplexNumber.NEGATIVE_ONE);
    }

    /**
     * Returns the matrix form of the Pauli-Z gate.
     * @return 
     */
    public static Matrix getMatrix() {
        Matrix m = new Matrix(2, 2);
        m.setValue(0, 0, ComplexNumber.ONE);
        m.setValue(0, 1, ComplexNumber.ZERO);
        m.setValue(1, 0, ComplexNumber.ZERO);
        m.setValue(1, 1, ComplexNumber.NEGATIVE_ONE);
        return m;
    }
}
