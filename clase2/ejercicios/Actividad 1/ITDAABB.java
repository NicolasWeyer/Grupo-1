package clase2.ejercicios;

public interface ITDAABB {
    int Raiz();
	ITDAABB HijoIzq();
	ITDAABB HijoDer();
	boolean ArbolVacio();
	void InicializarArbol();
	void AgregarElem(int x);
	void EliminarElem(int x);
}
