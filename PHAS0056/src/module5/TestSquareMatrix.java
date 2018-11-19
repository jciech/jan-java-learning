package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {

		// Create double arrays containing matrix data
        double[][] matDataA = { { 2,  1,  0},
                                { 0,  1,  0},
                                {-1,  0,  2} };
        
        double[][] matDataB = { { 1,  3,  1},
                                { 0,  2,  0},
                                { 1,  0, -1} };

		double[][] matDataC = { {2, 3},
                                {3, 4} };

		double[][] matDataD = { {-4, 3},
                                {3, -2} };

		try {
			// Instantiate SquareMatrix object for matrix 'A'
			System.out.println("A:");
			SquareMatrix squareMatA = new SquareMatrix(matDataA);
			System.out.println(squareMatA);

			// Display number of rows and columns in 'A'
			System.out.println("A has "+squareMatA.nCols()+" columns and "+squareMatA.nRows()+" rows");
			System.out.println();

			// Transpose 'A'
			System.out.println("A':");
			System.out.println(squareMatA.transpose());
			System.out.println();

			// Diagonalise 'A'
			System.out.println("diag(A):");
			System.out.println(squareMatA.diagonal());
			System.out.println();

			// Instantiate SquareMatrix object for matrix 'B'
			System.out.println("B:");
			SquareMatrix squareMatB = new SquareMatrix(matDataB);
			System.out.println(squareMatB);
			System.out.println();

			// Instantiate SquareMatrix object for matrix 'C'
			System.out.println("C:");
			SquareMatrix squareMatC = new SquareMatrix(matDataC);
			System.out.println(squareMatC);
			System.out.println();

			// Instantiate SquareMatrix object for matrix 'D'
			System.out.println("D:");
			SquareMatrix squareMatD = new SquareMatrix(matDataD);
			System.out.println(squareMatD);
			System.out.println();

			// Display 2x2 unit matrix I
			System.out.println("I (2x2):");
			System.out.println(SquareMatrix.unitMatrix(2));
			System.out.println();

			// Calculate A+B
			System.out.println("A+B:");
			System.out.println(squareMatA.add(squareMatB));
			System.out.println();

			// Calculate A-B
			System.out.println("A-B:");
			System.out.println(squareMatA.subtract(squareMatB));
			System.out.println();

			// Calculate A*B
			System.out.println("A*B:");
			System.out.println(SquareMatrix.multiply(squareMatA,squareMatB));
			System.out.println();

			// Calculate B*A
			System.out.println("B*A:");
			System.out.println(SquareMatrix.multiply(squareMatB,squareMatA));
			System.out.println();

			// Calculate commutator of A and B
			// [A,B] = AB - BA
			System.out.println("[A,B] = AB - BA:");
			System.out.println(SquareMatrix.commutator(squareMatA,squareMatB));
			System.out.println();

			// Calculate C*D
			System.out.println("C*D");
			System.out.println(SquareMatrix.multiply(squareMatC,squareMatD));
			System.out.println();

			// Check if C*D == I
			System.out.println("Is C*D equal to I? "+SquareMatrix.equals(SquareMatrix.multiply(squareMatC,squareMatD),SquareMatrix.unitMatrix(2)));
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println();
		}

	}

}