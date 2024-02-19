class Main {
    public static void main(String[] args) {
        System.out.println("Создание двух матриц");
        //Тест для детерминанта, матрицы взяты с mathprofi и abakbot
        /*
        Complex[][] fArr = {
                {new Complex(3), new Complex(-3), new Complex(-5), new Complex(8)},
                {new Complex(-3), new Complex(2), new Complex(4), new Complex(-6)},
                {new Complex(2), new Complex(-5), new Complex(-7), new Complex(5)},
                {new Complex(-4), new Complex(3), new Complex(5), new Complex(-6)},
        };
        Complex[][] sArr = {
                {new Complex(-1), new Complex(2.2, -2), new Complex(-7), new Complex(11)},
                {new Complex(3), new Complex(4, 0.1), new Complex(1), new Complex(0, 1)},
                {new Complex(7), new Complex(7), new Complex(-1.4533), new Complex(5)},
                {new Complex(0), new Complex(11), new Complex(-1, -1), new Complex(1)},
        };
        */

        //Тест на эксепшены
        /*
        Complex[][] fArr = {
                {new Complex(1,1), new Complex(2,2)},
                {new Complex(3,3), new Complex(4,4)},
                {new Complex(5,5), new Complex(6,6)},
        };
        Complex[][] sArr = {
                {new Complex(1,1), new Complex(2,2)}
        };
         */
        //Стандартный тест
        Complex[][] fArr = {
                {new Complex(1,1), new Complex(2,2)},
                {new Complex(3,3), new Complex(4,4)}
        };
        Complex[][] sArr = {
                {new Complex(1,1), new Complex(2,2)},
                {new Complex(3,3), new Complex(4,4)}
        };

        Matrix fMat = new Matrix(fArr);
        fMat.printMatrix();
        Matrix sMat = new Matrix(sArr);
        sMat.printMatrix();

        System.out.println("Транспонирование первоначальных матриц");
        System.out.println("Первая матрица:");
        Matrix tfMat = Matrix.Transposition(fMat);
        tfMat.printMatrix();
        System.out.println("Вторая матрица:");
        Matrix tsMat = Matrix.Transposition(sMat);
        tsMat.printMatrix();

        try {
            System.out.println("Сумма первоначальных матриц:");
            Matrix sumMat = Matrix.sumMatrix(fMat, sMat, true);
            sumMat.printMatrix();
        } catch (matrixSizesDoNotMatch e) {
            System.out.println("У матриц разные размеры. Невозможно сложить.\n");
        }

        try {
            System.out.println("Разница первоначальных матриц");
            Matrix difMat = Matrix.sumMatrix(fMat, sMat, false);
            difMat.printMatrix();
        } catch (matrixSizesDoNotMatch e) {
            System.out.println("У матриц разные размеры. Невозможно вычесть.\n");
        }

        Complex numMul = new Complex(3, 1);
        System.out.print("Умножение первоначальных матриц на ");
        Complex.printComplex(numMul);
        System.out.println("\nПервая матрица:");
        Matrix mnfMat = Matrix.mulMatrixNum(fMat, numMul);
        mnfMat.printMatrix();
        System.out.println("Вторая матрица:");
        Matrix mnsMat = Matrix.mulMatrixNum(sMat, numMul);
        mnsMat.printMatrix();

        try {
            System.out.println("Перемножение первоначальных матриц");
            Matrix mMat = Matrix.mulMatrix(fMat, sMat);
            mMat.printMatrix();
        } catch (matrixSizesDoNotMatch e) {
            System.out.println("Количество столбцов первой матрицы не совпадает с количеством строк второй матрицы. Невозможно умножить.\n");
        }

        try {
            System.out.println("Детерминанты матриц");
            System.out.print("Первой матрицы: ");
            Complex fDet = Matrix.Determinant(fMat);
            Complex.printComplex(fDet);
        } catch (matrixSizesDoNotMatch e) {
            System.out.println("матрица не квадратная. Невозможно найти детерминант");
        }
        try {
            System.out.print("\nВторой матрицы: ");
            Complex sDet = Matrix.Determinant(sMat);
            Complex.printComplex(sDet);
        } catch (matrixSizesDoNotMatch e) {
            System.out.println("матрица не квадратная. Невозможно найти детерминант\n");
        }
    }
}