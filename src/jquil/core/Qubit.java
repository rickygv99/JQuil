package jquil.core;

import jquil.math.Vector;
import java.util.Arrays;
import java.util.Random;
import jquil.math.Basis;
import jquil.math.ComplexNumber;
import jquil.math.DoubleMath;
import jquil.math.Matrix;

public class Qubit {

    public static final Qubit STANDARD_ZERO = new Qubit(Vector.STATE_ZERO);
    public static final Qubit STANDARD_ONE = new Qubit(Vector.STATE_ONE);
    public static final Qubit HADAMARD_PLUS = new Qubit(Vector.STATE_PLUS);
    public static final Qubit HADAMARD_MINUS = new Qubit(Vector.STATE_MINUS);
    public static final Qubit CIRCULAR_POSITIVE = new Qubit(Vector.STATE_CIRCULAR_POSITIVE);
    public static final Qubit CIRCULAR_NEGATIVE = new Qubit(Vector.STATE_CIRCULAR_NEGATIVE);

    public Vector[] states = new Vector[0];
    private final Random random;

    public Qubit(Vector... states) {
        random = new Random();

        double sum = 0;
        for (Vector s : states) {
            sum += s.getMagnitude() * s.getMagnitude();
        }
        if (DoubleMath.compare(sum, 1.0) != 0) {
            return;
        }
        this.states = Arrays.copyOf(states, states.length);
    }

    public Qubit(Qubit q) {
        this(q.getStates());
    }

    /**
     * Accepts as input a state vector s. Returns the probability of measuring
     * the qubit in the state vector s.
     *
     * @param s
     * @return
     */
    public double getMeasurementProbability(Vector s) {
        double probability = 0;
        for (Vector state : states) {
            ComplexNumber projection = ComplexNumber.quotient(state.getInnerProduct(s), s.getMagnitude());
            if (projection == null) {
                continue;
            }
            probability += Math.pow(projection.getMagnitude(), 2);
        }
        return probability;
    }

    /**
     * Measures the qubit in the basis provided by the user. Returns the state
     * that the qubit is measured in. Returns null if the qubit is not measured
     * to be in any state. Also transforms the qubit to be in the state that it
     * is measured into.
     *
     * @param b
     * @return
     */
    public Vector measure(Basis b) {
        double r = random.nextDouble();
        double probability = 0;
        for (Vector v : b.getVectors()) {
            probability += getMeasurementProbability(v);
            if (probability > r) {
                setStates(v);
                return v;
            }
        }
        return null;
    }

    /**
     * Applies the quantum gate represented by the matrix m to the qubit.
     *
     * @param m
     */
    public void applyGate(Matrix m) {
        for (int i = 0; i < states.length; i++) {
            states[i] = new Vector(Matrix.getProduct(m, states[i]).toVector());
        }
    }

    /**
     * Sets the states of the qubit.
     *
     * @param states
     */
    public void setStates(Vector... states) {
        this.states = Arrays.copyOf(states, states.length);
    }

    /**
     * Returns an array of vectors representing the states of the qubit.
     *
     * @return
     */
    public Vector[] getStates() {
        return states;
    }

    /**
     * Returns the number of states of the qubit.
     *
     * @return
     */
    public int getNumStates() {
        return states.length;
    }

    @Override
    public String toString() {
        String s = "";
        if (states.length != 0) {
            s += states[0].toString();
        }
        for (int i = 1; i < states.length; i++) {
            if (states[i].toString().equals("") == false && states[i - 1].toString().equals("") == false) {
                s += " + " + states[i].toString();
            } else if (states[i].toString().equals("") == false) {
                s += states[i].toString();
            }
        }
        return s;
    }
}
