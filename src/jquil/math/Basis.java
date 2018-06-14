package jquil.math;

import java.util.Arrays;

public class Basis {

    public static final Basis STANDARD = new Basis(Vector.STATE_ZERO, Vector.STATE_ONE);
    public static final Basis HADAMARD = new Basis(Vector.STATE_PLUS, Vector.STATE_MINUS);
    public static final Basis CIRCULAR = new Basis(Vector.STATE_CIRCULAR_POSITIVE, Vector.STATE_CIRCULAR_NEGATIVE);
    
    private Vector[] vectors;

    public Basis(Vector... vectors) {
        this.vectors = Arrays.copyOf(vectors, vectors.length);
    }

    /**
     * Returns an array of vectors - representing the vectors that make up
     * the set of vectors in the basis.
     * @return 
     */
    public Vector[] getVectors() {
        return vectors;
    }
}
