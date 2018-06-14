package jquil.circuits;

import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class PauliXGate extends Matrix {

    public PauliXGate() {
        super(2, 2);
        setValue(0, 0, ComplexNumber.ZERO);
        setValue(0, 1, ComplexNumber.ONE);
        setValue(1, 0, ComplexNumber.ONE);
        setValue(1, 1, ComplexNumber.ZERO);
    }

    /**
     * Returns the matrix form of the Pauli-X gate.
     * @return 
     */
    public static Matrix getMatrix() {
        Matrix m = new Matrix(2, 2);
        m.setValue(0, 0, ComplexNumber.ZERO);
        m.setValue(0, 1, ComplexNumber.ONE);
        m.setValue(1, 0, ComplexNumber.ONE);
        m.setValue(1, 1, ComplexNumber.ZERO);
        return m;
    }
}
