package jquil.circuits;

import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class CNotGate extends Matrix {

    public CNotGate() {
        super(4, 4);
        setValue(0, 0, ComplexNumber.ONE);
        setValue(0, 1, ComplexNumber.ZERO);
        setValue(0, 2, ComplexNumber.ZERO);
        setValue(0, 3, ComplexNumber.ZERO);

        setValue(1, 0, ComplexNumber.ZERO);
        setValue(1, 1, ComplexNumber.ONE);
        setValue(1, 2, ComplexNumber.ZERO);
        setValue(1, 3, ComplexNumber.ZERO);

        setValue(2, 0, ComplexNumber.ZERO);
        setValue(2, 1, ComplexNumber.ZERO);
        setValue(2, 2, ComplexNumber.ZERO);
        setValue(2, 3, ComplexNumber.ONE);

        setValue(3, 0, ComplexNumber.ZERO);
        setValue(3, 1, ComplexNumber.ZERO);
        setValue(3, 2, ComplexNumber.ONE);
        setValue(3, 3, ComplexNumber.ZERO);
    }

    /**
     * Returns the matrix form of the CNOT gate.
     * @return 
     */
    public static Matrix getMatrix() {
        Matrix m = new Matrix(4, 4);
        m.setValue(0, 0, ComplexNumber.ONE);
        m.setValue(0, 1, ComplexNumber.ZERO);
        m.setValue(0, 2, ComplexNumber.ZERO);
        m.setValue(0, 3, ComplexNumber.ZERO);

        m.setValue(1, 0, ComplexNumber.ZERO);
        m.setValue(1, 1, ComplexNumber.ONE);
        m.setValue(1, 2, ComplexNumber.ZERO);
        m.setValue(1, 3, ComplexNumber.ZERO);

        m.setValue(2, 0, ComplexNumber.ZERO);
        m.setValue(2, 1, ComplexNumber.ZERO);
        m.setValue(2, 2, ComplexNumber.ZERO);
        m.setValue(2, 3, ComplexNumber.ONE);

        m.setValue(3, 0, ComplexNumber.ZERO);
        m.setValue(3, 1, ComplexNumber.ZERO);
        m.setValue(3, 2, ComplexNumber.ONE);
        m.setValue(3, 3, ComplexNumber.ZERO);
        return m;
    }
}
