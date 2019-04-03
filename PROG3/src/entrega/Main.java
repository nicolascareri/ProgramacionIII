package entrega;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		MyLinkedList lista1 = new MyLinkedList();
		MyLinkedList lista2 = new MyLinkedList();
		MyLinkedList lista3 = new MyLinkedList();
			
		lista1.insertFront(4);
		lista1.insertFront(1);
		lista1.insertFront(3);
		lista1.insertFront(8);
		lista1.insertFront(5);
		
		lista2.insertFront(2);
		lista2.insertFront(4);
		lista2.insertFront(1);
		lista2.insertFront(7);
		lista2.insertFront(5);
		
		Iterator<Object> it1=lista1.iterator();
		
		while(it1.hasNext()) {
			Object o = it1.next();
			if(!lista2.contiene(o)) {
				lista3.insertFront(o);
			}
		}
		
		lista1.print(lista1.getSize());
		System.out.println("");
		lista2.print(lista2.getSize());
		System.out.println("");
		lista3.print(lista3.getSize());
	}


}
