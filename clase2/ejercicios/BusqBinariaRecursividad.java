public class BusqBinariaRecursividad{
    public static int busquedaBinaria(int[] a, int n) {
	    return busquedaBinaria(a, 0, a.length-1,n);
	}
	public static int busquedaBinaria(int[] a, int i, int f, int n) {
		if(i>f) {
			return -1;
		}
		int medio = i+ (f-i)/2;
		System.out.println(medio);
		if(a[medio] == n) {
			return medio;
		} else if (a[medio] > n) {
			return busquedaBinaria(a, i, medio-1, n);
		} else {
			return busquedaBinaria(a, medio+1, f, n);
		}
	}
}