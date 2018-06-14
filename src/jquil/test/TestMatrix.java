package jquil.test;

import jquil.circuits.PauliXGate;
import jquil.math.ComplexNumber;
import jquil.math.Matrix;

public class TestMatrix {

    public static void main(String[] args) {
        Matrix m = new Matrix(2, 1);
        m.setValue(0, 0, 1);
        m.setValue(1, 0, 0);
        System.out.println(m);
        System.out.println(Matrix.getProduct(PauliXGate.getMatrix(), m));
        
        Matrix m1 = new Matrix(2, 2);
        m1.setValue(0, 0, 4);
        m1.setValue(0, 1, 3);
        m1.setValue(1, 0, 2);
        m1.setValue(1, 1, 1);

        if (m1.getDeterminant().equals(new ComplexNumber(-2)) == false) {
            System.out.println("ERROR: Determinant evaluated to " + m1.getDeterminant());
        }

        Matrix m2 = new Matrix(3, 3);
        m2.setValue(0, 0, 3);
        m2.setValue(0, 1, -5);
        m2.setValue(0, 2, 3);

        m2.setValue(1, 0, 2);
        m2.setValue(1, 1, 1);
        m2.setValue(1, 2, -1);

        m2.setValue(2, 0, 1);
        m2.setValue(2, 1, 0);
        m2.setValue(2, 2, 4);

        if (m2.getDeterminant().equals(new ComplexNumber(54)) == false) {
            System.out.println("ERROR: Determinant evaluated to " + m2.getDeterminant());
        }

        Matrix m3 = new Matrix(4, 4);
        m3.setValue(0, 0, 1);
        m3.setValue(0, 1, 3);
        m3.setValue(0, 2, -2);
        m3.setValue(0, 3, 1);

        m3.setValue(1, 0, 5);
        m3.setValue(1, 1, 1);
        m3.setValue(1, 2, 0);
        m3.setValue(1, 3, -1);

        m3.setValue(2, 0, 0);
        m3.setValue(2, 1, 1);
        m3.setValue(2, 2, 0);
        m3.setValue(2, 3, -2);

        m3.setValue(3, 0, 2);
        m3.setValue(3, 1, -1);
        m3.setValue(3, 2, 0);
        m3.setValue(3, 3, 3);

        if (m3.getTrace().equals(new ComplexNumber(5)) == false) {
            System.out.println("ERROR: Trace evaluated to " + m3.getTrace());
        }

        if (m3.getDeterminant().equals(new ComplexNumber(-6)) == false) {
            System.out.println("ERROR: Determinant evaluated to " + m3.getDeterminant());
        }

        Matrix m4 = new Matrix(3, 3);
        m4.setValue(0, 0, 3);
        m4.setValue(0, 1, 0);
        m4.setValue(0, 2, 2);

        m4.setValue(1, 0, 2);
        m4.setValue(1, 1, 0);
        m4.setValue(1, 2, -2);

        m4.setValue(2, 0, 0);
        m4.setValue(2, 1, 1);
        m4.setValue(2, 2, 1);

        Matrix m5 = new Matrix(3, 3);
        m5.setValue(0, 0, 0.2);
        m5.setValue(0, 1, 0.2);
        m5.setValue(0, 2, 0);

        m5.setValue(1, 0, -0.2);
        m5.setValue(1, 1, 0.3);
        m5.setValue(1, 2, 1);

        m5.setValue(2, 0, 0.2);
        m5.setValue(2, 1, -0.3);
        m5.setValue(2, 2, 0);

        if (m4.getInverse().equals(m5) == false) {
            System.out.println("ERROR: Inverse evaluated to " + m4.getInverse());
        }
    }
}
