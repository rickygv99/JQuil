package jquil.math;

public class Vector extends Matrix {

    public static final Vector STATE_ZERO = new Vector(2, 1, 0);
    public static final Vector STATE_ONE = new Vector(2, 0, 1);
    public static final Vector STATE_PLUS = new Vector(2, 1.0 / Math.sqrt(2), 1.0 / Math.sqrt(2));
    public static final Vector STATE_MINUS = new Vector(2, 1.0 / Math.sqrt(2), -1.0 / Math.sqrt(2));
    public static final Vector STATE_CIRCULAR_POSITIVE = new Vector(2, new ComplexNumber(1.0 / Math.sqrt(2)),
            new ComplexNumber(0, 1.0 / Math.sqrt(2)));
    public static final Vector STATE_CIRCULAR_NEGATIVE = new Vector(2, new ComplexNumber(1.0 / Math.sqrt(2)),
            new ComplexNumber(0, -1.0 / Math.sqrt(2)));

    private int size;

    public Vector(int size) {
        super(size, 1);
        this.size = size;
    }

    public Vector(int size, double... states) {
        super(size, 1);
        this.size = size;
        for (int i = 0; i < size; i++) {
            setValue(i, 0, states[i]);
        }
    }

    public Vector(int size, ComplexNumber... states) {
        super(size, 1);
        this.size = size;
        for (int i = 0; i < size; i++) {
            setValue(i, 0, states[i]);
        }
    }

    public Vector(Vector v) {
        this(v.getSize());
        setValues(v.getValues());
    }

    /**
     * Returns the magnitude of the vector.
     *
     * @return
     */
    public double getMagnitude() {
        double sumSquared = 0;
        for (int i = 0; i < size; i++) {
            sumSquared += Math.pow(getValue(i, 0).getMagnitude(), 2);
        }
        return Math.sqrt(sumSquared);
    }

    /**
     * Performs the normalization operation on the vector.
     */
    public void normalize() {
        divide(getMagnitude());
    }

    /**
     * Takes as input a vector v. Returns the normalized form of the vector.
     *
     * @param v
     * @return
     */
    public static Vector getNormalizedVector(Vector v) {
        Vector copy = (Vector) v.getCopy();
        copy.divide(v.getMagnitude());
        return copy;
    }

    /**
     * Takes as input a vector s. Performs the inner product operation on the
     * current vector and the vector s. Returns the calculated inner product.
     *
     * @param s
     * @return
     */
    public ComplexNumber getInnerProduct(Vector s) {
        if (size != s.getSize()) {
            return null;
        }
        ComplexNumber sum = new ComplexNumber(ComplexNumber.ZERO);
        for (int i = 0; i < size; i++) {
            sum.add(ComplexNumber.product(getValue(i).getComplexConjugate(), s.getValue(i)));
        }
        return sum;
    }

    /**
     * Takes as input a vector s. Returns true if the current vector is
     * orthogonal to s and false otherwise.
     *
     * @param s
     * @return
     */
    public boolean isOrthogonalTo(Vector s) {
        return getInnerProduct(s).equals(ComplexNumber.ZERO);
    }

    /**
     * Takes as input a vector s. Returns true if the current vector is
     * orthonormal to s and false otherwise.
     *
     * @param s
     * @return
     */
    public boolean isOrthonormalTo(Vector s) {
        return isOrthogonalTo(s) && isUnitVector() && s.isUnitVector();
    }

    /**
     * Takes as input a vector s. Returns true if the current vector is opposite
     * to s and false otherwise.
     *
     * @param s
     * @return
     */
    public boolean isOppositeTo(Vector s) {
        Vector negation = (Vector) s.getCopy();
        negation.negate();
        return getCopy().equals(negation);
    }

    /**
     * Returns true if the vector is a unit vector and false otherwise.
     *
     * @return
     */
    public boolean isUnitVector() {
        return DoubleMath.compare(getMagnitude(), 1) == 0;
    }

    /**
     * Returns true if the vector is a zero vector and false otherwise.
     *
     * @return
     */
    public boolean isZeroVector() {
        return DoubleMath.compare(getMagnitude(), 0) == 0;
    }

    /**
     * Returns the size of the matrix.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Takes as input a size and sets the size of the matrix to the inputted
     * size.
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Takes as input an index of the vector. Returns the value in that index of
     * the vector.
     *
     * @param index
     * @return
     */
    public ComplexNumber getValue(int index) {
        return getValue(index, 0);
    }

    /**
     * Takes as input an index of the vector and a value. Sets the corresponding
     * index of the vector to the inputted value.
     *
     * @param index
     * @param value
     */
    public void setValue(int index, ComplexNumber value) {
        setValue(index, 0, value);
    }

    /**
     * Takes as input an index of the vector and a value. Sets the corresponding
     * index of the vector to the inputted value.
     *
     * @param index
     * @param value
     */
    public void setValue(int index, double value) {
        setValue(index, 0, value);
    }

    @Override
    public String toString() {
        String s = "";
        if (getValue(0).isNegativeOne()) {
            s += "-";
        }
        if (!getValue(0).isZero() && !getValue(0).isPositiveOne()) {
            s += getValue(0);
        }
        if (!getValue(0).isZero()) {
            s += "|0>";
        }
        if (!getValue(0).isZero() && !getValue(1).isZero()) {
            s += " + ";
        }
        if (!getValue(1).isZero() && !getValue(1).isPositiveOne()) {
            s += getValue(1);
        }
        if (!getValue(1).isZero()) {
            s += "|1>";
        }
        return s;
    }
}
