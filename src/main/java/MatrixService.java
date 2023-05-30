public class MatrixService
{

    public static void printMatrix(double[][] matrix)
    {
        System.out.println( " " );
        System.out.println( " a:" );
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double matrixCell(double[][] firstMatrix, double[][] secondMatrix, int row, int column)
    {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][column];
        }
        return cell;
    }

    public static double[][] sumMatrix(double[][] firstMatrix, double[][] secondMatrix){
        int i, j;
        double[][] retMatrix = new double[firstMatrix.length][secondMatrix.length];

        for (i = 0; i < firstMatrix.length; i++)
            for (j = 0; j < firstMatrix.length; j++) {
                retMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }

        return retMatrix;
    }

    public static double[][] divMatrix(double[][] firstMatrix, double[][] secondMatrix){
        int i, j;
        double[][] retMatrix = new double[firstMatrix.length][secondMatrix.length];

        for (i = 0; i < firstMatrix.length; i++)
            for (j = 0; j < firstMatrix.length; j++) {
                retMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }

        return retMatrix;
    }
    public static double[][] subtractionMatrix(double[][] firstMatrix, double[][] secondMatrix){
        int i, j;
        double[][] retMatrix = new double[firstMatrix.length][secondMatrix.length];

        for (i = 0; i < firstMatrix.length; i++)
            for (j = 0; j < firstMatrix.length; j++) {
                retMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }

        return retMatrix;
    }

    public static double matr_inf_norm ( double[][] a){
        int i,j;
        double s,norm = 0.;

        for( i = 0; i < a.length; i++ )
        {
            for( s = 0., j = 0; j < a.length; j++ ) s += Math.abs( a[i][j] );
            if( Double.compare(s, norm) > 0 ) norm = s;
        }

        return norm;
    }

    public static int UpTriangleMatrix(double[][] arr)
    {
        int size = arr.length;
        //Привидение к треугольному виду
        double mod;
        double cos, sin;
        double t;


        for(int k = 0; k < size-1; k++)
        {
            for(int i = k+1; i < size; i++)
            {
                mod = Math.sqrt(arr[k][k] * arr[k][k] + arr[i][k] * arr[i][k]);
                if(Double.compare(mod,0) != 0) {
                    sin = -arr[i][k] / mod;
                    cos = arr[k][k] / mod;
                    //System.out.println(sin);
                    //System.out.println(cos);
                } else
                {
                    return 0;
                }
                for(int j = k; j < size; j++)
                {
                    t = arr[k][j];
                    arr[k][j] = cos*t - sin * arr[i][j];
                    arr[i][j] = sin*t + cos*arr[i][j];

                }
                if(Double.compare(sin, 0) > 0) {
                    arr[i][k] = cos+1.;
                }else {
                    arr[i][k] = cos-1.;
                }

            }
        }
        return 1;
    }

    public static int reverseMatrix(double[][] upTriangle)
    {
        double sum = 0.;
        double[] arr = new double[upTriangle.length];
        for (int i = 0; i < upTriangle.length; i++)
        {
            upTriangle[i][i] = 1./upTriangle[i][i]; //right
        }

        /*for (int i = 0; i >= arr.length-1; i++)
        {
            for(int j = i+1; j<arr.length; j++) {
                arr[j] = upTriangle[i][j];
            }

            for(int j = i+1; j<arr.length; j++)
            {
                sum = -upTriangle[i][i]*upTriangle[i][j];
                for (int k = i+1; k<j; k++)
                {
                    sum -= upTriangle[i][k]*upTriangle[k][j];
                }
                upTriangle[i][j] = sum*upTriangle[j][j];
            }
         }
      */
        for(int i = 0 ; i < upTriangle.length-1; i++)
        {
            for(int j = i + 1; j < upTriangle.length; j++)
            {
                sum = -upTriangle[i][i]*upTriangle[i][j];
                for(int k = i+1; k < j; k++)
                {
                    sum -=upTriangle[i][k]*upTriangle[k][j];
                }
                upTriangle[i][j] = sum*upTriangle[j][j];
            }
        }
        return 1;
    }
    public static int reverse(double[][] arr)
    {
        double[] sigma = new double[arr.length];
        double cos =0;
        double sin = 0;
        double temp = 0;
        for(int k = arr.length-2; k >=0; k--)
        {
            for(int i = arr.length-1; i > k; i--)
            {
                sigma[i] = arr[i][k];
                arr[i][k] = 0.;
            }
            for (int i = arr.length-1; i>k; i--)
            {
                if(Double.compare(sigma[i], 0) > 0)
                {
                    cos = sigma[i] - 1.;
                    sin = Math.sqrt(1 - cos*cos);
                } else
                {
                    cos = sigma[i] + 1.;
                    sin = -Math.sqrt(1 - cos*cos);
                }
                for(int l = 0; l < arr.length; l++)
                {
                    temp = arr[l][k];
                    arr[l][k] = arr[l][k]*cos + arr[l][i]*sin;
                    arr[l][i] = temp*(-sin) + arr[l][i]*cos;
                }
            }
        }
        return 1;
    }
}
