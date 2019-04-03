package entrega;

import java.util.Iterator;

public class MyLinkedList implements Iterable<Object> {
	protected Node first;
	private int size;

	public MyLinkedList() {
		first = null;
		size = 0;
	}

	public void insertFront(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		first = tmp;
		size++;
	}

	public Object extractFront() {
		Node aux = first;
		first = first.getNext();
		this.size--;
		return aux.getInfo();
	}

	public void print(int n) {
		if (!isEmpty() && (n <=this.getSize())){
			Node tmp = first;
			for ( int i = 0; i < n; i++) {
				if (tmp!=null) {
					System.out.println(tmp.getInfo());
					tmp = tmp.getNext();
				}
			}
		}
	}

	public Object get(int index) {
		int contador = 0;
		Node aux = first;
		while (contador < index) {
			aux = aux.getNext();
			contador++;
		}
		return aux.getInfo();
	}

	public Node getFirst() {
		Node aux = first;
		return aux;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
		return size;
	}

	protected class MyIterator implements Iterator<Object> {
		private Node tmp;

		public MyIterator(Node f) {
			tmp = f;
		}

		public boolean hasNext() {
			return tmp != null;
		}

		public Object next() {
			Node aux = tmp;
			tmp = tmp.getNext();
			return aux.getInfo();
		}
	}
	public boolean contiene(Object valor) {
		Iterator<Object> itLista = this.iterator();
		while (itLista.hasNext()) {
			Object i = itLista.next();
			if(i.equals(valor)) {
				return true;
			}
		}
		return false;
	}

	public Iterator<Object> iterator() {
		return new MyIterator(first);
	}

}
