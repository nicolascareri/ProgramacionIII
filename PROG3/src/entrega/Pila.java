package entrega;

public class Pila {
	
	private MyLinkedList lista;
	
	public Pila() {
		lista = new MyLinkedList();
	}
	public void push(Object o) {
		lista.insertFront(o);
	}
	public void pop() {
		lista.extractFront();
	}
	public void top() {
		lista.get(0);
	}
	public void reverse() {
		MyLinkedList aux = new MyLinkedList();
		for(int i = 0; i < lista.getSize(); i++) {
			aux.insertFront(lista.extractFront());
		}
		lista = aux;
	}
}
