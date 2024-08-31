public class Factorial{
    public static int getFactorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return (n * getFactorial(n-1));
		}
	}
	public static void main(String[] args) {
		int n = 10;
		System.out.println("factorial de " + n + " es " + getFactorial(n));
	}
}