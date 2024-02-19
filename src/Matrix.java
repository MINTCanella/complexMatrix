public class Matrix {
    int r, c;
    Complex[][] matrix;

    //Создание матрицы и определение ее элементов
    public Matrix(int r, int c)
    {
        this.r = r;
        this.c = c;
        this.matrix = new Complex[this.r][this.c];
        for (int i = 0; i < this.r; i++) {
            for (int j = 0; j < this.c; j++) {
                matrix[i][j] = new Complex(0);
            }
        }
    }

    public Matrix(Complex [][] pMatrix)
    {
        this.r = pMatrix.length;
        this.c = pMatrix[0].length;
        this.matrix = pMatrix;
    }

    public Complex getEl(int n, int m) {
        return this.matrix[n][m];
    }


    public void putEl(int i, int j, Complex number) {
        matrix[i][j].initEl(number.real, number.imag);
    }

    //Транспонирование матрицы
    public static Matrix Transposition(Matrix pMatrix) {
        Matrix tMatrix = new Matrix(pMatrix.c, pMatrix.r);
        for(int i = 0; i < pMatrix.r; i++) {
            for(int j = 0; j < pMatrix.c; j++) {
                tMatrix.putEl(j, i, pMatrix.getEl(i,j));
            }
        }
        return tMatrix;
    }

    //Сумма или разность матриц
    public static Matrix sumMatrix(Matrix first, Matrix second, boolean sum) throws matrixSizesDoNotMatch {
        if (first.c != second.c || first.r != second.r) {
            throw new matrixSizesDoNotMatch();
        }
        Matrix sMatrix = new Matrix(first.r, first.c);
        if (sum) {
            for (int i = 0; i < first.r; i++) {
                for (int j = 0; j < first.c; j++) {
                    sMatrix.putEl(i, j, Complex.sumComplex(first.getEl(i, j), second.getEl(i, j)));
                }
            }
        }
        else {
            for(int i = 0; i < first.r; i++) {
                for(int j = 0; j < first.c; j++) {
                    sMatrix.putEl(i, j, Complex.difComplex(first.getEl(i,j), second.getEl(i,j)));
                }
            }
        }
        return sMatrix;
    }

    //Умножение матрицы на число
    public static Matrix mulMatrixNum(Matrix pMatrix, Complex num) {
        Matrix mMatrix = new Matrix(pMatrix.r, pMatrix.c);
        for(int i = 0; i < pMatrix.r; i++) {
            for(int j = 0; j < pMatrix.c; j++) {
                mMatrix.putEl(i, j, Complex.mulComplex(pMatrix.getEl(i, j), num));
            }
        }
        return mMatrix;
    }

    //Перемножение матриц
    public static Matrix mulMatrix(Matrix first, Matrix second) throws matrixSizesDoNotMatch {
        if (first.c != second.r) {
            throw new matrixSizesDoNotMatch();
        }
        Matrix sMatrix = new Matrix(first.r, second.c);
        for (int i = 0; i < first.r; i++) {
            for (int j = 0; j < second.c; j++) {
                Complex sumEl = new Complex(0);
                for (int l = 0; l < first.c; l++) {
                    sumEl = Complex.sumComplex(sumEl, Complex.mulComplex(first.getEl(i, l), second.getEl(l, j)));
                }
                sMatrix.putEl(i, j, sumEl);
            }
        }
        return sMatrix;
    }

    //Детерминант матрицы
    public static Matrix minorMatrix(int r, int c, Matrix pMatrix) {
        Matrix mMatrix = new Matrix(pMatrix.r - 1, pMatrix.c - 1);
        int mr = 0, mc = 0;
        for (int i = 0; i < pMatrix.r; i++) {
            if (i == r) {
                mr = 1;
                continue;
            }
            for (int j = 0; j < pMatrix.c; j++) {
                if (j == c) {
                    mc = 1;
                    continue;
                }
                mMatrix.putEl(i - mr, j - mc, pMatrix.getEl(i, j));
            }
            mc = 0;
        }
        return mMatrix;
    }

    public static Complex Determinant(Matrix pMatrix) throws matrixSizesDoNotMatch {
        if (pMatrix.c != pMatrix.r) {
            throw new matrixSizesDoNotMatch();
        }
        if (pMatrix.c < 2) {
            return pMatrix.getEl(0, 0);
        }
        Complex det = new Complex(0);
        int deg = 1;
        for (int j = 0; j < pMatrix.c; j++) {
            Complex mDet = Complex.mulComplex(pMatrix.getEl(0, j), Determinant(minorMatrix(0, j, pMatrix)));
            if (deg == 1) {
                det = Complex.sumComplex(det, mDet);
            }
            else {
                det = Complex.difComplex(det, mDet);
            }
            deg = -deg;
        }
        return det;
    }

    //Вывод матрицы
    public void printMatrix() {
        for(int i = 0; i < this.r; i++) {
            for(int j = 0; j < this.c; j++) {
                Complex.printComplex(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}

