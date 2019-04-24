package arbol;

import java.util.ArrayList;

//import java.util.ArrayList;
//import java.util.List;

public class Arbol {
	private Node root;

	public Arbol(Node r) {
		this.root = r;
	}

	public Arbol() {
		root = null;
	}

	public Node getRoot() {
		return this.root;
	}

	public void print(Node node) {
		if (node == null) {
			return;
		}
		print(node.getIzq());
		System.out.print(node.getInfo() + " ");
		print(node.getDer());
	}

	public void setRoot(Object n) {
		Node nodo = new Node(n);
		root = nodo;
	}

	public void insertNode(Object info) {
		Node nodo = new Node(info);
		root.insertNode(nodo);
	}

	public boolean hasElem(Object o) {
		return root.hasElem(o);
	}

	public ArrayList<Object> getLongestBranch() {

		return root.getLongestBranch();

	}

	public ArrayList<Object> getElemAtLvl(int index) {
		return root.getElemAtLvl(index);
	}

	public ArrayList<Object> getFrontera() {
		return root.getFrontera();
	}

//	public boolean deleteNode(Object o) {
//		if (root.getInfo().equals(o)) {
//			if ((root.getIzq() != null) && (root.getDer() == null)) {
//				root = root.getIzq();
//				return true;
//			} else if ((root.getDer() != null) && (root.getIzq() == null)) {
//				root = root.getDer();
//				return true;
//			} else if ((root.getIzq() == null)&&(root.getDer() == null)) {
//				root = null;
//				return true;
//			}
//			else {
//				Node tmp = root.getIzq().masDerecho();
//				root.setInfo(tmp.getInfo());
//				root.getIzq().setDer(tmp.getIzq());
//				return true;
//			}
//		}
//		else {
//			return root.delete(o);
//		}
//	}

	public Object getMaxElem() {
		return root.masDerecho();
	}
}
