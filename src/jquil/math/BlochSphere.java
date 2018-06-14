package jquil.math;

import jquil.core.Qubit;

public class BlochSphere {

    /**
     * Takes as input a single-state qubit q and returns the mapping of the
     * qubit q onto the extended complex plane.
     *
     * @param q
     * @return
     */
    public static ComplexNumber mapToExtendedComplexPlane(Qubit q) {
        if (q.getStates()[0].getValue(0).isZero() && q.getStates()[0].getValue(1).isPositiveOne()) {
            return new ComplexNumber(Double.POSITIVE_INFINITY);
        }
        return ComplexNumber.quotient(q.getStates()[0].getValue(1), q.getStates()[0].getValue(0));
    }

    /**
     * Takes as input a single-state qubit q and returns the mapping of the
     * qubit q onto the Bloch sphere.
     *
     * @param q
     * @return
     */
    public static Vector mapToBlochSphere(Qubit q) {
        ComplexNumber num = mapToExtendedComplexPlane(q);
        Vector v = new Vector(3);
        v.setValue(0, 2 * num.getRealPart() / (num.getMagnitude() * num.getMagnitude() + 1));
        v.setValue(1, 2 * num.getImaginaryPart() / (num.getMagnitude() * num.getMagnitude() + 1));
        v.setValue(2, (1 - num.getMagnitude() * num.getMagnitude()) / (num.getMagnitude() * num.getMagnitude() + 1));
        return v;
    }
}