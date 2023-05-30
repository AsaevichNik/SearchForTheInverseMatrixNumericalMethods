import org.junit.Test;

public class Testing
{
    final int size = 3;
    final double[][] E = {{1,0,0}, {0,1,0},{0,0,1}};
    /*
0.5005689380030791 -0.4994310619969207 -1.3787600615856394E-4
-0.4994310619969207 0.5005689380030793 -1.3787600615856394E-4
-1.3787600615856394E-4 -1.3787600615856394E-4 0.001275752012317128
    * */
    @Test
    public void TestModule() {
        double[][] matrix = new double[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new double[size];
        }
        matrix[0][0] = 3;
        matrix[0][1] = 2;
        matrix[0][2] = 1 ;

        matrix[1][0] = 2;
        matrix[1][1] = 2;
        matrix[1][2] = 1 ;

        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;

        double[][] matrixInverse = new double[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrixInverse[i] = new double[size];
        }

        matrixInverse[0][0] = 1;
        matrixInverse[0][1] = -1;
        matrixInverse[0][2] = 0;

        matrixInverse[1][0] = -1;
        matrixInverse[1][1] = 2;
        matrixInverse[1][2] = -1;

        matrixInverse[2][0] = 0;
        matrixInverse[2][1] = -1;
        matrixInverse[2][2] = 2;

       /*double[][] matrixInverse1 = new double[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrixInverse1[i] = new double[size];
        }

        matrixInverse1[0][0] = 1;
        matrixInverse1[0][1] = -1;
        matrixInverse1[0][2] = 0;

        matrixInverse1[1][0] = -1;
        matrixInverse1[1][1] = 2;
        matrixInverse1[1][2] = -1;

        matrixInverse1[2][0] = 0;
        matrixInverse1[2][1] = -1;
        matrixInverse1[2][2] = 2; */

        double[][] result = new double[matrix.length][matrixInverse[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = MatrixService.matrixCell(matrix, matrixInverse, row, col);
            }
        }

        double[][] R = result;
        R = MatrixService.divMatrix(R, E);
        double[][] Z = MatrixService.divMatrix(matrixInverse, matrixInverse);



        MatrixService.UpTriangleMatrix(matrix);

        MatrixService.reverseMatrix(matrix);

        MatrixService.printMatrix(matrix);

        MatrixService.reverse(matrix);

        MatrixService.printMatrix(matrix);


        double[][] arr = MatrixService.divMatrix(matrix, matrixInverse);


        double zNorm = MatrixService.matr_inf_norm(matrix);
        double reverseNorm = MatrixService.matr_inf_norm(matrixInverse);
        double dzetta = zNorm/reverseNorm;

        double norm = MatrixService.matr_inf_norm(matrix);

        //System.out.println(norm);
        System.out.println(zNorm);
        System.out.println(reverseNorm);
        System.out.println(dzetta);

    }
}
