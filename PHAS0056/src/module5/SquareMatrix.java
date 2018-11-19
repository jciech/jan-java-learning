package module5;

// Represents a square matrix 
public class SquareMatrix {

    // Initialise variable containing matrix data
    // Private to prevent modification after instantiation
    private double[][] matData;

    // Class constructor
    public SquareMatrix(double[][] elements) throws Exception {

        // Add values to data array in SquareMatrix object
        this.matData = elements;

        // Check if matrix is square, otherwise throw an Exception
        if ((this.matData == null) || (this.nRows() == 0) || (this.nCols() == 0)) {
            throw new Exception("Matrix does not contain any data.");
        } else if (!this.isSquare()) {
            throw new Exception(
                    "Matrix is not square: contains " + this.nRows() + " rows but " + this.nCols() + " columns.");
        }
    }

    // Return number of rows in SquareMatrix
    public int nRows() {
        return this.matData.length;
    }

    // Return number of columns in SquareMatrix
    public int nCols() {

        int numCols = 0;

        // Loop over every row, just in case rows are different lengths (Java
        // arrays do not have to be rectangular)
        for (int i = 0; i < this.nRows(); i++) {

            // Select the row with the most elements
            if (this.matData[i].length > numCols) {
                numCols = this.matData[i].length;
            }

        }

        return numCols;
    }

    // Check if SquareMatrix is actually square
    // Private because only needed during construction.
    private boolean isSquare() {
        // Compare number of rows and columns
        return (this.nCols() == this.nRows());
    }

    // Static method for adding 2 SquareMatix objects
    public static SquareMatrix add(SquareMatrix m1, SquareMatrix m2) throws Exception {

        // Check if input matrices have the same dimensions
        if ((m1.nRows() != m2.nRows()) || (m1.nCols() != m2.nCols())) {
            throw new Exception("Cannot add matrices: they are different sizes.");
        } else {
            // Initialise variable for new SquareMatrix values
            double[][] addMat = new double[m1.nRows()][m1.nCols()];

            // Loop over all values in each matrix and add them one by one
            for (int i = 0; i < m1.nRows(); i++) {
                for (int j = 0; j < m1.nCols(); j++) {
                    addMat[i][j] = m1.matData[i][j] + m2.matData[i][j];
                }
            }

            // Instantiate new SquareMatrix object containing summed values
            return new SquareMatrix(addMat);
        }
    }

    // Non-static version of add method
    public SquareMatrix add(SquareMatrix m1) throws Exception {
        return add(this, m1);
    }

    // Static method for subtracting 2 SquareMatrix objects
    public static SquareMatrix subtract(SquareMatrix m1, SquareMatrix m2) throws Exception {

        // Check if input matrices have the same dimensions
        if ((m1.nRows() != m2.nRows()) || (m1.nCols() != m2.nCols())) {
            throw new Exception("Cannot subtract matrices: they are different sizes.");
        } else {
            // Initialise variable for new SquareMatrix values
            double[][] subMat = new double[m1.nRows()][m1.nCols()];

            // Loop over all values in each matrix and subtract them one by one
            for (int i = 0; i < m1.nRows(); i++) {
                for (int j = 0; j < m1.nCols(); j++) {
                    subMat[i][j] = m1.matData[i][j] - m2.matData[i][j];
                }
            }

            // Instantiate new SquareMatrix object containing subtracted values
            return new SquareMatrix(subMat);
        }
    }

    // Non-static version of subtract method
    public SquareMatrix subtract(SquareMatrix m1) throws Exception {
        return subtract(this, m1);
    }

    // Static method for multiplying 2 SquareMatrix objects
    // P_ij = A_ik*B_kj
    public static SquareMatrix multiply(SquareMatrix m1, SquareMatrix m2) throws Exception {

        // Check if input matrices have matching dimensions
        if ((m1.nRows() != m2.nCols()) || (m1.nCols() != m2.nRows())) {
            throw new Exception("Cannot multiply matrices: their dimensions do not match.");
        } else {
            // Initialise variable for new SquareMatrix values
            double[][] inmat = new double[m1.nRows()][m2.nCols()];

            // Loop over all values in each matrix
            for (int i = 0; i < m1.nRows(); i++) {
                for (int j = 0; j < m2.nCols(); j++) {

                    // Loop over, multiply and sum each value in a given
                    // row/column
                    for (int k = 0; k < m1.nCols(); k++) {
                        inmat[i][j] += m1.matData[i][k] * m2.matData[k][j];
                    }

                }
            }

            // Instantiate new SquareMatrix object containing multiplied values
            return new SquareMatrix(inmat);
        }

    }

    // Non-static version of multiply method
    public SquareMatrix multiply(SquareMatrix m1) throws Exception {
        return multiply(this, m1);
    }

    // Static method for calculating commutator between two SquareMatrix objects
    // [A,B] = A*B - B*A
    public static SquareMatrix commutator(SquareMatrix m1, SquareMatrix m2) throws Exception {

        // Instantiate new SquareMatrix object containing calculated values
        return SquareMatrix.subtract(multiply(m1, m2), multiply(m2, m1));

    }

    // Non-static version of commutator method
    public SquareMatrix commutator(SquareMatrix m1) throws Exception {
        return commutator(this, m1);
    }

    // Static method for checking if two SquareMatrix objects are equal
    public static boolean equals(SquareMatrix m1, SquareMatrix m2) {

        // Initialise Boolean variable indicating equality
        // Initially assume matrices ARE equal
        boolean eqmat = true;

        // If number of rows and columns do not match, matrices cannot be equal.
        if ((m1.nRows() != m2.nRows()) || (m1.nCols() != m2.nCols())) {
            eqmat = false;
        } else {
            // Loop over every element in first matrix
            eqloop: for (int i = 0; i < m1.nRows(); i++) {
                for (int j = 0; j < m1.nCols(); j++) {

                    // Compare every element in first matrix to corresponding
                    // element in second matrix
                    if (m1.matData[i][j] != m2.matData[i][j]) {
                        // If any do not match, they are not equal
                        eqmat = false;
                        // Break loop as soon as a non-matching element is found
                        break eqloop;
                    }
                }
            }
        }
        return eqmat;
    }

    // Non-static version of equals method
    public boolean equals(SquareMatrix m1) {
        return equals(this, m1);
    }

    // Method for generating unit matrix of a given size
    public static SquareMatrix unitMatrix(int size) throws Exception {

        // Check if size is feasible
        if (size <= 0) {
            throw new Exception("Cannot specify a unit matrix with zero or negative size.");
        } else {
            // Initialise variable containing all zeros of defined size
            double[][] unitMatData = new double[size][size];

            // Loop over diagonal elements and set them equal to 1
            for (int i = 0; i < size; i++) { // Loops over rows
            	unitMatData[i][i] = 1;                        
            }

            // Instantiate new SquareMatrix object containing unit matrix data
            return new SquareMatrix(unitMatData);
        }
    }

    // toString method for displaying matrix data in nicely formatted way
    public String toString() {

        // Initialise empty StringBuilder object
        StringBuilder outStringB = new StringBuilder();

        // If matrix is empty, don't try and fill the string with null values
        if ((this.nRows() == 0) || (this.nCols() == 0)) {
            outStringB.append("[ Empty matrix ]");
        } else {
            // Loop over every single row in matrix
            for (int i = 0; i < this.nRows(); i++) {

                // If we're not on the first row, start a new line and add a |
                // to indicate the left-hand edge of that row
                if (i > 0) {
                    outStringB.append(System.lineSeparator());
                    outStringB.append(" |");
                }

                // If we're on the first row, add a | to indicate the left-hand
                // edge of that row
                else {
                    outStringB.append(" |");
                }

                // Loop over each element in a row, add that value to the String
                // and
                // insert a space before and after to make numbers easier to
                // read
                for (int j = 0; j < this.nCols(); j++) {
                    outStringB.append(" " + this.matData[i][j] + " ");
                }

                // Add | to indicate right-hand edge of row
                outStringB.append("|");
            }
        }

        return outStringB.toString();
    }

    // Some extra methods that are not required by the question but carry out
    // useful matrix operations

    // Method for tranposing a matrix B_ij = A_ji
    // Throws an Exception if the matrix to transpose isn't square
    public static SquareMatrix transpose(SquareMatrix m1) throws Exception {

        // Initialise variable to contain transposed data
        double[][] transmat = new double[m1.nCols()][m1.nRows()];

        // Loop over every element in the matrix and tranpose it into the new
        // matrix
        for (int i = 0; i < m1.nRows(); i++) {
            for (int j = 0; j < m1.nCols(); j++) {
                transmat[j][i] = m1.matData[i][j];
            }
        }

        // Instantiate new SquareMatrix object containing tranposed data
        // Will throw an Exception if matrix isn't square
        return new SquareMatrix(transmat);

    }

    // Non-static version of transpose method
    public SquareMatrix transpose() throws Exception {
        return transpose(this);
    }

    // Method for returning diagonal matrix
    // Diagonal matrices only contain the diagonal elements
    public static SquareMatrix diagonal(SquareMatrix m1) throws Exception {

        // Check if matrix is square
        if (!m1.isSquare()) {
            throw new Exception("Cannot create a diagonal matrix: matrix is not square.");
        } else {
            // Initialise variable to contain diagonal matrix data
            double[][] diagMat = new double[m1.nRows()][m1.nCols()];

            // Loop over diagonal elements and copy these to the new array
            for (int i = 0; i < m1.nRows(); i++) {
                for (int j = 0; j < m1.nCols(); j++) {
                    if ( i == j ) { // Copy diagonal elements
                        diagMat[i][j] = m1.matData[i][j];                        
                    } else { // Set non-diagonal elements = 0
                        diagMat[i][j] = 0;
                    }
                }
            }

            // Instantiate new SquareMatrix object containing diagonalised
            // matrix
            return new SquareMatrix(diagMat);
        }
    }

    // Non-static version of diagonal method
    public SquareMatrix diagonal() throws Exception {
        return diagonal(this);
    }

}
