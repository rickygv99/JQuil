package jquil.math;

public class ComplexNumber {

    public static final ComplexNumber ZERO = new ComplexNumber(0, 0);
    public static final ComplexNumber ONE = new ComplexNumber(1, 0);
    public static final ComplexNumber NEGATIVE_ONE = new ComplexNumber(-1, 0);
    public static final ComplexNumber IMAGINARY = new ComplexNumber(0, 1);
    public static final ComplexNumber NEGATIVE_IMAGINARY = new ComplexNumber(0, -1);

    private double realPart;
    private double imaginaryPart;

    public ComplexNumber() {
    }

    public ComplexNumber(double realPart) {
        this.realPart = realPart;
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber num) {
        this.realPart = num.realPart;
        this.imaginaryPart = num.imaginaryPart;
    }

    /**
     * Returns the real component of the complex number.
     * @return 
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Sets the real component of the complex number.
     * @param realPart 
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * Returns the imaginary component of the complex number.
     * @return 
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Sets the imaginary component of the complex number.
     * @param imaginaryPart 
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Takes as input a complex number c and adds c to the current
     * complex number.
     * @param c 
     */
    public void add(ComplexNumber c) {
        realPart += c.realPart;
        imaginaryPart += c.imaginaryPart;
    }

    /**
     * Takes as input a scalar d and adds d to the current complex number.
     * @param d 
     */
    public void add(double d) {
        realPart += d;
    }

    /**
     * Takes as input two complex numbers and returns their sum.
     * @param c1
     * @param c2
     * @return 
     */
    public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() + c2.getRealPart());
        c.setImaginaryPart(c1.getImaginaryPart() + c2.getImaginaryPart());
        return c;
    }

    /**
     * Takes as input a complex number and a real number and returns their sum.
     * @param c1
     * @param d
     * @return 
     */
    public static ComplexNumber sum(ComplexNumber c1, double d) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() + d);
        c.setImaginaryPart(c1.getImaginaryPart());
        return c;
    }

    /**
     * Takes as input a complex number c and subtracts c from the current
     * complex number.
     * @param c 
     */
    public void subtract(ComplexNumber c) {
        realPart -= c.realPart;
        imaginaryPart -= c.imaginaryPart;
    }

    /**
     * Takes as input a double d and subtracts d from the current
     * complex number.
     * @param d 
     */
    public void subtract(double d) {
        realPart -= d;
    }

    /**
     * Takes as input two complex numbers and subtracts the second complex
     * number from the first complex number and returns their difference.
     * @param c1
     * @param c2
     * @return 
     */
    public static ComplexNumber difference(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() - c2.getRealPart());
        c.setImaginaryPart(c1.getImaginaryPart() - c2.getImaginaryPart());
        return c;
    }

    /**
     * Takes as input a complex number and a real number and subtracts the
     * real number from the complex number and returns their difference.
     * @param c1
     * @param d
     * @return 
     */
    public static ComplexNumber difference(ComplexNumber c1, double d) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() - d);
        c.setImaginaryPart(c1.getImaginaryPart());
        return c;
    }

    /**
     * Takes as input a complex number c and multiplies the current complex
     * number by c.
     * @param c 
     */
    public void multiply(ComplexNumber c) {
        realPart = realPart * c.realPart - imaginaryPart * c.imaginaryPart;
        imaginaryPart = imaginaryPart * c.realPart + realPart * c.imaginaryPart;
    }

    /**
     * Takes as input a real number d and multiplies the current complex number
     * by d.
     * @param d 
     */
    public void multiply(double d) {
        realPart = realPart * d;
        imaginaryPart = imaginaryPart * d;
    }

    /**
     * Negates the complex number.
     */
    public void negate() {
        realPart = realPart * -1;
        imaginaryPart = imaginaryPart * -1;
    }

    /**
     * Takes as input two complex numbers and returns their product.
     * @param c1
     * @param c2
     * @return 
     */
    public static ComplexNumber product(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() * c2.getRealPart() - c1.getImaginaryPart() * c2.getImaginaryPart());
        c.setImaginaryPart(c1.getImaginaryPart() * c2.getRealPart() + c1.getRealPart() * c2.getImaginaryPart());
        return c;
    }

    /**
     * Takes as input a complex number and a real number and returns their
     * product.
     * @param c1
     * @param d
     * @return 
     */
    public static ComplexNumber product(ComplexNumber c1, double d) {
        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() * d);
        c.setImaginaryPart(c1.getImaginaryPart() * d);
        return c;
    }

    /**
     * Takes as input a complex number c and divides the current complex number
     * by c.
     * @param c
     * @return 
     */
    public boolean divide(ComplexNumber c) {
        if (c.realPart == 0 && c.imaginaryPart == 0) {
            return false;
        }
        realPart = (realPart * c.realPart + imaginaryPart * c.imaginaryPart)
                / (c.realPart * c.realPart + c.imaginaryPart * c.imaginaryPart);
        imaginaryPart = (imaginaryPart * c.realPart - realPart * c.imaginaryPart)
                / (c.realPart * c.realPart + c.imaginaryPart * c.imaginaryPart);
        return true;
    }

    /**
     * Takes as input a real number d and divides the current complex number
     * by d.
     * @param d
     * @return 
     */
    public boolean divide(double d) {
        if (d == 0) {
            return false;
        }
        realPart /= d;
        imaginaryPart /= d;
        return true;
    }

    /**
     * Takes as input two complex numbers and returns the quotient of the
     * two complex numbers.
     * @param c1
     * @param c2
     * @return 
     */
    public static ComplexNumber quotient(ComplexNumber c1, ComplexNumber c2) {
        if (c2.getRealPart() == 0 && c2.getImaginaryPart() == 0) {
            return null;
        }

        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() * c2.getRealPart() + c1.getImaginaryPart() * c2.getImaginaryPart()
                / (c2.getRealPart() * c2.getRealPart() + c2.getImaginaryPart() * c2.getImaginaryPart()));
        c.setImaginaryPart(c1.getImaginaryPart() * c2.getRealPart() - c1.getRealPart() * c2.getImaginaryPart()
                / (c2.getRealPart() * c2.getRealPart() + c2.getImaginaryPart() * c2.getImaginaryPart()));
        return c;
    }

    /**
     * Takes as input a complex number and a real number and returns the quotient
     * of the two numbers.
     * @param c1
     * @param d
     * @return 
     */
    public static ComplexNumber quotient(ComplexNumber c1, double d) {
        if (d == 0) {
            return null;
        }

        ComplexNumber c = new ComplexNumber();
        c.setRealPart(c1.getRealPart() / d);
        c.setImaginaryPart(c1.getImaginaryPart() / d);
        return c;
    }

    /**
     * Returns the reciprocal of the complex number.
     * @return 
     */
    public ComplexNumber getReciprocal() {
        ComplexNumber c = new ComplexNumber(realPart, imaginaryPart);
        c.realPart = realPart / (realPart * realPart + imaginaryPart * imaginaryPart);
        c.imaginaryPart = -imaginaryPart / (realPart * realPart + imaginaryPart * imaginaryPart);
        return c;
    }

    /**
     * Returns the complex conjugate of the complex number.
     * @return 
     */
    public ComplexNumber getComplexConjugate() {
        return new ComplexNumber(realPart, -imaginaryPart);
    }

    /**
     * Returns the magnitude of the complex number.
     * @return 
     */
    public double getMagnitude() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    /**
     * Returns true if the complex number is real and false otherwise.
     * @return 
     */
    public boolean isReal() {
        return imaginaryPart == 0;
    }

    /**
     * Returns true if the complex number is zero and false otherwise.
     * @return 
     */
    public boolean isZero() {
        return realPart == 0 && imaginaryPart == 0;
    }

    /**
     * Returns true if the complex number is positive one and false otherwise.
     * @return 
     */
    public boolean isPositiveOne() {
        return realPart == 1 && imaginaryPart == 0;
    }

    /**
     * Returns true if the complex number is negative one and false otherwise.
     * @return 
     */
    public boolean isNegativeOne() {
        return realPart == -1 && imaginaryPart == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ComplexNumber) {
            ComplexNumber c = (ComplexNumber) o;
            if (DoubleMath.compare(realPart, c.realPart) == 0
                    && DoubleMath.compare(imaginaryPart, c.imaginaryPart) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (realPart == 0 && imaginaryPart == 0) {
            return "0";
        }

        String s = "";
        boolean realPartNonZero = false;
        if (realPart != 0) {
            realPartNonZero = true;
            if (DoubleMath.doesRound(realPart)) {
                s += DoubleMath.round(realPart);
            } else {
                s += realPart;
            }
        }
        if (imaginaryPart != 0) {
            if (realPartNonZero) {
                s += " + ";
            }
            if (DoubleMath.doesRound(imaginaryPart)) {
                s += DoubleMath.round(imaginaryPart) + " * i";
            } else {
                s += imaginaryPart + " * i";
            }
        }
        return s;
    }

    public String toString(boolean showZeroes) {
        if (showZeroes == false && toString().equals("0")) {
            return "";
        } else {
            return toString();
        }
    }
}
