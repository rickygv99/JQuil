package jquil.test;

import jquil.circuits.HadamardGate;
import jquil.circuits.PauliXGate;
import jquil.core.Qubit;
import jquil.math.Basis;
import jquil.math.Matrix;

public class Demonstration {

    public static void main(String[] args) {
        //Math
        Matrix m = new Matrix(2, 2);
        m.setValue(0, 0, 4);
        m.setValue(0, 1, 3);
        m.setValue(1, 0, 2);
        m.setValue(1, 1, 1);
        System.out.println(m.getDeterminant());
        
        System.out.println(m.getInverse());
        
        System.out.println(m.conjugateTranspose());
        
        //Qubits
        Qubit q1 = new Qubit(Qubit.STANDARD_ZERO); //Creates qubit in superposition 1|0> + 0|1>
        q1.measure(Basis.STANDARD); //Should print out |0>
        System.out.println(q1);
        //Should print out either |+> or |-> with equal probability
        q1.measure(Basis.HADAMARD);
        System.out.println(q1);
        
        
        //Gates
        //Should print out either |0> or |1> depending on value of previous
        q1.applyGate(HadamardGate.getMatrix());
        System.out.println(q1);
        
        Qubit q2 = new Qubit(Qubit.STANDARD_ZERO);
        q2.applyGate(PauliXGate.getMatrix());
        System.out.println(q2);
    }
}