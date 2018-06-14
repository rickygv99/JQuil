package jquil.math;

public class Matrix {

    private ComplexNumber[][] values;

    public Matrix(int numRows, int numColumns) {
        values = new ComplexNumber[numColumns][numRows];
    }

    public Matrix(ComplexNumber[][] values) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                this.values[j][i] = values[j][i];
            }
        }
    }

    public Matrix(Matrix m) {
        this(m.getValues());
    }

    /**
     * Takes as input a row index, a column index, a number of rows, and a
     * number of columns. Returns the submatrix bounded by these values.
     *
     * @param rowIndex
     * @param columnIndex
     * @param numRows
     * @param numColumns
     * @return
     */
    public Matrix getSubMatrix(int rowIndex, int columnIndex, int numRows, int numColumns) {
        if (numRows < 1 || numColumns < 1) {
            return null;
        }
        if (rowIndex < 0 || rowIndex + numRows > getNumRows()) {
            return null;
        }
        if (columnIndex < 0 || columnIndex + numColumns > getNumColumns()) {
            return null;
        }
        Matrix m = new Matrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                m.setValue(i, j, getValue(rowIndex + i, columnIndex + j));
            }
        }
        return m;
    }

    /**
     * Takes as input a row index. Returns the matrix minus the row marked by
     * the row index.
     *
     * @param rowIndex
     * @return
     */
    public Matrix getSubMatrixWithoutRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getNumRows()) {
            return null;
        }
        Matrix m = new Matrix(getNumRows() - 1, getNumColumns());
        for (int i = 0; i < m.getNumRows(); i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                if (i < rowIndex) {
                    m.setValue(i, j, getValue(i, j));
                } else {
                    m.setValue(i, j, getValue(i + 1, j));
                }
            }
        }
        return m;
    }

    /**
     * Takes as input a column index. Returns the matrix minus the column marked
     * by the column index.
     *
     * @param columnIndex
     * @return
     */
    public Matrix getSubMatrixWithoutColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= getNumColumns()) {
            return null;
        }
        Matrix m = new Matrix(getNumRows(), getNumColumns() - 1);
        for (int i = 0; i < m.getNumRows(); i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                if (j < columnIndex) {
                    m.setValue(i, j, getValue(i, j));
                } else {
                    m.setValue(i, j, getValue(i, j + 1));
                }
            }
        }
        return m;
    }

    /**
     * Takes as input a matrix m. Adds the matrix m to the current matrix.
     *
     * @param m
     * @return
     */
    public boolean add(Matrix m) {
        if (m.getNumRows() != getNumRows() || m.getNumColumns() != getNumColumns()) {
            return false;
        }
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].add(m.getValue(i, j));
            }
        }
        return true;
    }

    /**
     * Takes as input two matrices. Adds the matrices together and returns their
     * sum.
     *
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix getSum(Matrix m1, Matrix m2) {
        if (m2.getNumRows() != m1.getNumRows() || m2.getNumColumns() != m1.getNumColumns()) {
            return null;
        }
        Matrix m = new Matrix(m1.getNumRows(), m2.getNumColumns());
        for (int i = 0; i < m1.getNumRows(); i++) {
            for (int j = 0; j < m1.getNumColumns(); j++) {
                m.setValue(i, j, ComplexNumber.sum(m1.getValue(i, j), m2.getValue(i, j)));
            }
        }
        return m;
    }

    /**
     * Takes as input a matrix m. Subtracts the matrix m from the current
     * matrix.
     *
     * @param m
     * @return
     */
    public boolean subtract(Matrix m) {
        if (m.getNumRows() != getNumRows() || m.getNumColumns() != getNumColumns()) {
            return false;
        }
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].subtract(m.getValue(i, j));
            }
        }
        return true;
    }

    /**
     * Takes as input two matrices. Subtracts the second matrix from the first
     * matrix and returns their difference.
     *
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix getDifference(Matrix m1, Matrix m2) {
        if (m2.getNumRows() != m1.getNumRows() || m2.getNumColumns() != m1.getNumColumns()) {
            return null;
        }
        Matrix m = new Matrix(m1.getNumRows(), m2.getNumColumns());
        for (int i = 0; i < m1.getNumRows(); i++) {
            for (int j = 0; j < m1.getNumColumns(); j++) {
                m.setValue(i, j, ComplexNumber.difference(m1.getValue(i, j), m2.getValue(i, j)));
            }
        }
        return m;
    }

    /**
     * Takes as input a scalar. Multiplies the matrix by the scalar.
     *
     * @param num
     */
    public void multiply(double num) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].multiply(new ComplexNumber(num));
            }
        }
    }

    /**
     * Takes as input a complex number scalar. Multiplies the matrix by the
     * scalar.
     *
     * @param num
     */
    public void multiply(ComplexNumber num) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].multiply(num);
            }
        }
    }

    /**
     * Negates the matrix.
     */
    public void negate() {
        multiply(-1);
    }

    /**
     * Takes as input a scalar. Divides the matrix by the scalar.
     *
     * @param num
     */
    public void divide(double num) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].divide(new ComplexNumber(num));
            }
        }
    }

    /**
     * Takes as input a complex number scalar. Divides the matrix by the scalar.
     *
     * @param num
     */
    public void divide(ComplexNumber num) {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                values[j][i].divide(num);
            }
        }
    }

    /**
     * Takes as input a matrix m. Multiplies the current matrix by the matrix m.
     *
     * @param m
     * @return
     */
    public boolean multiply(Matrix m) {
        if (getNumColumns() != m.getNumRows()) {
            return false;
        }
        setValues(getProduct(this, m).getValues());
        return true;
    }

    /**
     * Takes as input two matrices. Returns the product of the two matrices.
     *
     * @param m1
     * @param m2
     * @return
     */
    public static Matrix getProduct(Matrix m1, Matrix m2) {
        if (m1.getNumColumns() != m2.getNumRows()) {
            return null;
        }
        Matrix m = new Matrix(m1.getNumRows(), m2.getNumColumns());
        for (int i = 0; i < m1.getNumRows(); i++) {
            for (int j = 0; j < m2.getNumColumns(); j++) {
                ComplexNumber value = new ComplexNumber(ComplexNumber.ZERO);
                for (int k = 0; k < m1.getNumColumns(); k++) {
                    value.add(ComplexNumber.product(m1.getValue(i, k), m2.getValue(k, j)));
                }
                m.setValue(i, j, value);
            }
        }
        return m;
    }

    /**
     * Returns the determinant of the matrix.
     *
     * @return
     */
    public ComplexNumber getDeterminant() {
        if (isSquare() == false) {
            return null;
        }
        if (getNumRows() == 1) {
            return getValue(0, 0);
        } else if (getNumRows() == 2) {
            ComplexNumber left = ComplexNumber.product(getValue(0, 0), getValue(1, 1));
            ComplexNumber right = ComplexNumber.product(getValue(1, 0), getValue(0, 1));
            return ComplexNumber.difference(left, right);
        } else {
            ComplexNumber determinant = new ComplexNumber(ComplexNumber.ZERO);
            for (int i = 0; i < getNumColumns(); i++) {
                determinant.add(ComplexNumber.product(getValue(0, i), getCofactor(0, i)));
            }
            return determinant;
        }
    }

    /**
     * Takes as input a cell (specified by a row index and a column index).
     * Returns the cofactor associated with that cell of the matrix.
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    public ComplexNumber getCofactor(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= getNumRows()) {
            return null;
        }
        if (columnIndex < 0 || columnIndex >= getNumColumns()) {
            return null;
        }
        ComplexNumber cofactor = getSubMatrixWithoutRow(rowIndex).
                getSubMatrixWithoutColumn(columnIndex).getDeterminant();
        if ((rowIndex + columnIndex) % 2 == 1) {
            cofactor.negate();
        }
        return cofactor;
    }

    /**
     * Returns the adjoint of the matrix.
     *
     * @return
     */
    public Matrix getAdjoint() {
        Matrix m = new Matrix(getNumRows(), getNumColumns());
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                m.setValue(i, j, getCofactor(i, j));
            }
        }
        m.transpose();
        return m;
    }

    /**
     * Returns the inverse of the matrix.
     *
     * @return
     */
    public Matrix getInverse() {
        if (isInvertible() == false) {
            return null;
        }
        Matrix inverse = getAdjoint();
        inverse.divide(getDeterminant());
        return inverse;
    }

    /**
     * Performs the transpose operation on this matrix.
     */
    public void transpose() {
        setValues(getTranspose(this).getValues());
    }

    /**
     * Takes as input a matrix. Returns the transpose of the matrix.
     *
     * @param old
     * @return
     */
    public static Matrix getTranspose(Matrix old) {
        Matrix m = new Matrix(old.getNumColumns(), old.getNumRows());
        for (int i = 0; i < m.getNumRows(); i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                m.setValue(i, j, old.getValue(j, i));
            }
        }
        return m;
    }

    /**
     * Performs the conjugate operation on this matrix.
     */
    public void conjugate() {
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                setValue(i, j, getValue(i, j).getComplexConjugate());
            }
        }
    }

    /**
     * Takes as input a matrix. Returns the conjugate of the matrix.
     *
     * @param old
     * @return
     */
    public static Matrix getConjugate(Matrix old) {
        Matrix m = new Matrix(old.getNumColumns(), old.getNumRows());
        for (int i = 0; i < m.getNumRows(); i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                m.setValue(i, j, old.getValue(i, j).getComplexConjugate());
            }
        }
        return m;
    }

    /**
     * Performs the conjugate transpose operation on this matrix.
     *
     * @return
     */
    public Matrix conjugateTranspose() {
        transpose();
        conjugate();
        return this;
    }

    /**
     * Takes as input a matrix. Returns the conjugate transpose of the matrix.
     *
     * @param old
     * @return
     */
    public static Matrix getConjugateTranspose(Matrix old) {
        Matrix m = getTranspose(old);
        return getConjugate(m);
    }

    /**
     * Takes as input a number of rows and a number of columns. Returns a zero
     * matrix with the specified number of rows and number of columns.
     *
     * @param numRows
     * @param numColumns
     * @return
     */
    public static Matrix getZeroMatrix(int numRows, int numColumns) {
        Matrix m = new Matrix(numRows, numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                m.setValue(j, i, ComplexNumber.ZERO);
            }
        }
        return m;
    }

    /**
     * Takes as input a size. Returns an identity matrix with the specified
     * size.
     *
     * @param size
     * @return
     */
    public static Matrix getIdentityMatrix(int size) {
        Matrix m = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    m.setValue(j, i, ComplexNumber.ONE);
                } else {
                    m.setValue(j, i, ComplexNumber.ZERO);
                }
            }
        }
        return m;
    }

    /**
     * Returns the trace of the matrix.
     *
     * @return
     */
    public ComplexNumber getTrace() {
        if (!isSquare()) {
            return null;
        }
        ComplexNumber trace = new ComplexNumber(ComplexNumber.ZERO);
        for (int i = 0; i < getNumRows(); i++) {
            trace.add(values[i][i]);
        }
        return trace;
    }

    /**
     * Returns true if the matrix is a row vector and false otherwise.
     *
     * @return
     */
    public boolean isRowVector() {
        return getNumRows() == 1;
    }

    /**
     * Returns true if the matrix is a column vector and false otherwise.
     *
     * @return
     */
    public boolean isColumnVector() {
        return getNumColumns() == 1;
    }

    /**
     * Returns true if the matrix is square and false otherwise.
     *
     * @return
     */
    public boolean isSquare() {
        return getNumRows() == getNumColumns();
    }

    /**
     * Returns true if the matrix is symmetric and false otherwise.
     *
     * @return
     */
    public boolean isSymmetric() {
        return getCopy().equals(getTranspose(this));
    }

    /**
     * Returns true if the matrix is skew-symmetric and false otherwise.
     *
     * @return
     */
    public boolean isSkewSymmetric() {
        Matrix copy = getCopy();
        copy.negate();
        return copy.equals(getTranspose(this));
    }

    /**
     * Returns true if the matrix is Hermitian and false otherwise.
     *
     * @return
     */
    public boolean isHermitian() {
        return getCopy().equals(getConjugateTranspose(this));
    }

    /**
     * Returns true if the matrix is skew-Hermitian and false otherwise.
     *
     * @return
     */
    public boolean isSkewHermitian() {
        Matrix copy = getCopy();
        copy.negate();
        return copy.equals(getConjugateTranspose(this));
    }

    /**
     * Returns true if the matrix is normal and false otherwise.
     *
     * @return
     */
    public boolean isNormal() {
        Matrix left = Matrix.getProduct(getConjugateTranspose(this), this);
        Matrix right = Matrix.getProduct(this, getConjugateTranspose(this));
        return left.equals(right);
    }

    /**
     * Returns true if the matrix is unitary and false otherwise.
     *
     * @return
     */
    public boolean isUnitary() {
        Matrix left = Matrix.getProduct(getConjugateTranspose(this), this);
        Matrix right = getIdentityMatrix(getNumRows());
        return left.equals(right) && isNormal();
    }

    /**
     * Returns true if the matrix is invertible and false otherwise.
     *
     * @return
     */
    public boolean isInvertible() {
        if (isSquare() == false) {
            return false;
        }
        return (getDeterminant() != ComplexNumber.ZERO);
    }

    /**
     * Returns a copy of the matrix.
     *
     * @return
     */
    public Matrix getCopy() {
        return new Matrix(getValues());
    }

    /**
     * Returns the number of rows of the matrix.
     *
     * @return
     */
    public int getNumRows() {
        return values[0].length;
    }

    /**
     * Returns the number of columns of the matrix.
     *
     * @return
     */
    public int getNumColumns() {
        return values.length;
    }

    /**
     * Takes as input a cell (specified by a row and column). Returns the value
     * contained in the cell.
     *
     * @param row
     * @param column
     * @return
     */
    public ComplexNumber getValue(int row, int column) {
        return new ComplexNumber(values[column][row]);
    }

    /**
     * Returns the values of the cells of the matrix as a two-dimensional array
     * of Complex Number objects.
     *
     * @return
     */
    public ComplexNumber[][] getValues() {
        return values;
    }

    /**
     * Takes as input a cell (specified by a row and column) and a value. Sets
     * the value of the cell in the matrix to be the inputted value.
     *
     * @param row
     * @param column
     * @param value
     */
    public void setValue(int row, int column, double value) {
        values[column][row] = new ComplexNumber(value);
    }

    /**
     * Takes as input a cell (specified by a row and column) and a value. Sets
     * the value of the cell in the matrix to be the inputted value.
     *
     * @param row
     * @param column
     * @param value
     */
    public void setValue(int row, int column, ComplexNumber value) {
        values[column][row] = new ComplexNumber(value);
    }

    /**
     * Takes as input a two-dimensional array of values. Sets the values of the
     * matrix to be the inputted values.
     *
     * @param values
     */
    public void setValues(ComplexNumber[][] values) {
        this.values = values;
    }

    /**
     * Returns the matrix as a Vector object.
     *
     * @return
     */
    public Vector toVector() {
        if (isRowVector() == false && isColumnVector() == false) {
            return null;
        } else if (isRowVector()) {
            Vector v = new Vector(getNumColumns());
            for (int i = 0; i < getNumColumns(); i++) {
                v.setValue(i, values[i][0]);
            }
            return v;
        } else {
            Vector v = new Vector(getNumRows());
            for (int i = 0; i < getNumRows(); i++) {
                v.setValue(i, values[0][i]);
            }
            return v;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Matrix) {
            Matrix m = (Matrix) o;
            if (getNumRows() != m.getNumRows() || getNumColumns() != m.getNumColumns()) {
                return false;
            }
            for (int i = 0; i < getNumRows(); i++) {
                for (int j = 0; j < getNumColumns(); j++) {
                    if (getValue(i, j).equals(m.getValue(i, j)) == false) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                s += "[" + getValue(i, j) + "], ";
            }
            s += "\n";

        }
        return s;
    }
}
