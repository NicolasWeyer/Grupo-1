package clase2.ejercicios.Actividad1alter;

public interface ITDAABB {
    int Raiz();
	ITDAABB HijoIzq();
	ITDAABB HijoDer();
	boolean ArbolVacio();
	void InicializarArbol();
	void AgregarElem(int x);
	void EliminarElem(int x);
}
