package clase2.ejercicios.Actividad1alter;

public class Act1_alter {

    public static int getHeight(ITDAABB arbol) {
        if(arbol.ArbolVacio()) {
            return -1;
        } else {
            return 1+ Math.max(getHeight(arbol.HijoIzq()), getHeight(arbol.HijoDer()));
        }
    }

    public static void main(String[] args) {

        ITDAABB a = new ABB();
		a.InicializarArbol();
		
		//lado izquierdo del árbol
		
		a.AgregarElem(90);
		a.AgregarElem(64);
		a.AgregarElem(21);
		a.AgregarElem(10);
		a.AgregarElem(70);
		
		//lado derecho del árbol
		
		a.AgregarElem(110);
		a.AgregarElem(95);
		a.AgregarElem(111);
		a.AgregarElem(123);
		a.AgregarElem(200);
		
		System.out.println(getHeight(a));
    }		
}
