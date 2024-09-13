import java.util.Arrays;
public class Nmayores {
	public static int[] mayores(int[]a,int n) {
		int[] f = new int[n];
		for (int i = n-1; i>=0;i--) {
			f[i] = a[i];
		}
		mayores(a,a.length-1,f,n-1);
		return f;
	}
	public static int[] mayores (int[]a, int i, int[] f,int n) {
		if (i == n) {
			return f;
		}
		Arrays.sort(f);
		if(a[i] > f[0]) {
			f[0] = a[i];
		}
		return mayores(a,i-1,f,n);
	}
	public static void main(String[] args) {
		int[] a = {4,3,7,2,6,8,5,9,1};
		int n = 4;
		int[] f = mayores(a,n);
		for (int i = 0; i<f.length; i++) {
			System.out.print(f[i] + " , ");
		}
	}
}

