package clase2.ejercicios;

public class ABB implements ITDAABB{
    NodoABB raiz;
	
	public int Raiz() {
		return raiz.dato;
	}

	public ITDAABB HijoIzq() {
		return raiz.hijoIzq;
	}

	public ITDAABB HijoDer() {
		return raiz.HijoDer;
	}

	public boolean ArbolVacio() {
		return raiz == null;
	}

	public void InicializarArbol() {
		raiz = null;
	}

	public void AgregarElem(int x) {
		if (raiz == null) {
			raiz = new NodoABB();
			raiz.dato = x;
			raiz.hijoIzq = new ABB();
			raiz.HijoDer = new ABB();
			raiz.hijoIzq.InicializarArbol();
			raiz.HijoDer.InicializarArbol();
		} else if (raiz.dato < x){
			raiz.HijoDer.AgregarElem(x);
		} else if (raiz.dato > x) {
			raiz.hijoIzq.AgregarElem(x);
		}
	}

	public void EliminarElem(int x) {
		if (raiz != null) {
			if (raiz.dato == x && raiz.HijoDer.ArbolVacio() && raiz.hijoIzq.ArbolVacio()) {
				raiz = null;
			} else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.dato = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.EliminarElem(raiz.dato);
			} else if (raiz.dato == x && !raiz.HijoDer.ArbolVacio()) {
				raiz.dato = this.menor(raiz.HijoDer);
				raiz.HijoDer.EliminarElem(raiz.dato);
			} else if (raiz.dato < x) {
				raiz.HijoDer.EliminarElem(x);
			} else {
				raiz.hijoIzq.EliminarElem(x);
			}
		}
	}

	private int mayor(ITDAABB a) {
		if (a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		} else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor(ITDAABB a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		} else {
			return menor(a.HijoIzq());
		}
	}
}
