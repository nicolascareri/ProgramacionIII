package arbol;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Arbol arbol = new Arbol();
		arbol.setRoot(20);
		arbol.insertNode(10);
		arbol.insertNode(80);
		arbol.insertNode(220);
		arbol.insertNode(4);
		arbol.insertNode(18);
		arbol.insertNode(9);
		arbol.insertNode(15);
		arbol.insertNode(17);
		arbol.insertNode(100);
		arbol.insertNode(300);
		arbol.insertNode(350);
		arbol.insertNode(200);
		arbol.insertNode(120);

//		arbol.print(arbol.getRoot());
//		
//		System.out.println(" ");
//		
		System.out.println(arbol.hasElem(9));
		System.out.println(arbol.hasElem(18));
		System.out.println(arbol.hasElem(5));
		System.out.println(arbol.hasElem(40));
//		
//		ArrayList <Object> rama = new ArrayList<Object>(arbol.getLongestBranch());
//		System.out.println(rama.size());
//		for ( int i = 0 ; i < rama.size(); i++) {
//			System.out.println(rama.get(i));
//		}

		ArrayList<Object> frontera = new ArrayList<Object>(arbol.getFrontera());
		System.out.println(frontera.size());

		for (int i = 0; i < frontera.size(); i++) {
			System.out.println(frontera.get(i));
		}
//		System.out.println(arbol.deleteNode(15));
//		arbol.print(arbol.getRoot());
	}
}

