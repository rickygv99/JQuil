package jquil.test;

import jquil.math.Vector;
import jquil.core.Qubit;
import jquil.math.Basis;

public class TestMeasurement {

    public static void main(String[] args) {
        Qubit q1 = new Qubit(Qubit.HADAMARD_PLUS);
        System.out.println("Measurement in State Zero:");
        for (int i = 0; i < 10; i++) {
            System.out.println(q1.measure(Basis.STANDARD));
        }
        
        Qubit q2 = new Qubit(Qubit.HADAMARD_PLUS);
        for (int i = 0; i < 10000; i++) {
            if (q2.measure(Basis.HADAMARD).equals(Vector.STATE_PLUS) == false) {
                System.out.println("ERROR: Plus state didn't measure in plus state!");
                System.exit(0);
            }
        }
    }
}
