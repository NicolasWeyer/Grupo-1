public class SumarNumeros(1.3){
    public static int sumarElementos(int n) {
		if (n==0) {
			return 0;
		} else {
			return (n + sumarElementos(n-1));
		}
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(sumarElementos(n));
	}
}