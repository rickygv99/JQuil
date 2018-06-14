package jquil.math;

public class DoubleMath {

    public static final double EPSILON = 0.001;

    /**
     * Takes as input two doubles. Returns zero if the two doubles are
     * essentially equivalent, a negative number if the first double is less
     * than the second double, and a positive number if the first double is
     * greater than the second double.
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int compare(double d1, double d2) {
        if (Math.abs(d1 - d2) < EPSILON) {
            return 0;
        } else if (d1 < d2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Takes as input a double and returns true if the double can be rounded to
     * the nearest integer and false otherwise.
     *
     * @param d
     * @return
     */
    public static boolean doesRound(double d) {
        int floor = (int) d;
        int ceil = floor + 1;
        return Math.abs(d - floor) < EPSILON || Math.abs(d - ceil) < EPSILON;
    }

    /**
     * Takes as input a double and rounds the double to the nearest integer.
     * Returns the rounded double.
     *
     * @param d
     * @return
     */
    public static int round(double d) {
        int floor = (int) d;
        int ceil = floor + 1;
        if (Math.abs(d - floor) < EPSILON) {
            return floor;
        }
        if (Math.abs(d - ceil) < EPSILON) {
            return ceil;
        }
        return Integer.MIN_VALUE;
    }
}
