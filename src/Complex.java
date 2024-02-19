public class Complex {
    double real, imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(double real) {
        this.real = real;
        this.imag = 0;
    }

    public void initEl(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static Complex sumComplex(Complex first, Complex second) {
        return new Complex(first.real +  second.real, first.imag + second.imag);
    }

    public static Complex difComplex(Complex first, Complex second) {
        return new Complex(first.real - second.real, first.imag - second.imag);
    }

    public static Complex mulComplex(Complex first, Complex second) {
        return new Complex(
                first.real * second.real - first.imag * second.imag,
                first.real * second.imag + first.imag * second.real
        );
    }

    public static void printComplex(Complex number) {
        if (number.imag < 0) {
            System.out.print(number.real + "-" + (-number.imag) + "i ");
        }
        else {
            System.out.print(number.real + "+" + number.imag + "i ");
        }
    }
}

