package arbol;

import java.util.ArrayList;

public class Node {
	private Object info;
	private Node izq;
	private Node der;

	public Node(Object info) {
		this.info = info;
		der = null;
		izq = null;
	}

	public Node(Object o, Node izq, Node der) {
		setInfo(o);
		setDer(izq);
		setIzq(der);
	}

	public ArrayList<Object> getLongestBranch() {
		ArrayList<Object> lista1 = new ArrayList<Object>();
		ArrayList<Object> lista2 = new ArrayList<Object>();

		if (getIzq() != null) {
			lista1.add(this.getInfo());
			lista2.add(this.getInfo());
			lista1.addAll(izq.getLongestBranch());
			if (getDer() != null) {
				lista2.addAll(der.getLongestBranch());
			}
		} else if (getDer() != null) {
			lista1.add(this.getInfo());
			lista1.addAll(der.getLongestBranch());
		} else {
			lista1.add(this.getInfo());
		}
		if (lista1.size() > lista2.size()) {
			return lista1;
		} else {
			return lista2;
		}
	}

	public ArrayList<Object> getElemAtLvl(int index) {
		int corte = 1;
		ArrayList<Object> lista = new ArrayList<Object>();
		if (index > corte) {
			if (izq != null) {
				lista.addAll(izq.getElemAtLvl(index - 1));
			}
			if (der != null) {
				lista.addAll(der.getElemAtLvl(index - 1));
			}
		} else if (corte == index) {
			lista.add(this.getInfo());
		}
		return lista;
	}

	public ArrayList<Object> getFrontera() {
		ArrayList<Object> lista = new ArrayList<Object>();
		if (getIzq() != null) {
			lista.addAll(izq.getFrontera());
			if (getDer() != null) {
				lista.addAll(der.getFrontera());
			}
		} else if (getDer() != null) {
			lista.addAll(der.getFrontera());
		} else {

			lista.add(this.getInfo());
		}
		return lista;

	}

//	public boolean delete(Object o) {
//		if (this.getIzq() != null) {
//			if (this.getIzq().getInfo().equals(o)) {
//				if ((this.getIzq().getIzq() == null) && (this.getIzq().getDer() == null)) {
//					this.setIzq(null);
//					return true;
//				} else if ((this.getIzq().getIzq() != null) && (this.getIzq().getDer() == null)) {
//					Node tmp = this.getIzq().getIzq();
//					this.setIzq(tmp);
//					return true;
//				} else if ((this.getIzq().getDer() != null) && (this.getIzq().getIzq() == null)) {
//					Node tmp = this.getIzq().getDer();
//					this.setIzq(tmp);
//					return true;
//				} else {
//					Node tmp = this.getIzq().getIzq().masDerecho();
//					this.getIzq().setInfo(tmp.getInfo());
//					if (tmp.getIzq() != null) {
//						this.getIzq().getIzq().setDer(tmp.getIzq());
//						return true;
//					} else {
//						this.getIzq().getIzq().setDer(null);
//						return true;
//					}
//				}
//			} else {
//				if (this.getIzq().delete(o)) {
//					return this.getIzq().delete(o);
//				} else {
//					if (this.getDer() != null) {
//						if (this.getDer().getInfo().equals(o)) {
//							if ((this.getDer().getIzq() == null) && (this.getDer().getDer() == null)) {
//								this.setDer(null);
//								return true;
//							} else if ((this.getDer().getIzq() != null) && (this.getDer().getDer() == null)) {
//								Node tmp = this.getDer().getIzq();
//								this.setDer(tmp);
//								return true;
//							} else if ((this.getDer().getDer() != null) && (this.getIzq().getIzq() == null)) {
//								Node tmp = this.getDer().getDer();
//								this.setDer(tmp);
//								return true;
//							} else {
//								Node tmp = this.getDer().getDer().masIzquierdo();
//								this.getDer().setInfo(tmp.getInfo());
//								if (tmp.getDer() != null) {
//									this.getDer().getDer().setIzq(tmp.getDer());
//									return true;
//								} else {
//									this.getDer().getDer().setIzq(null);
//									return true;
//								}
//							}
//						} else {
//							return this.getDer().delete(o);
//						}
//					} else {
//						return false;
//					}
//				}
//			}
//		} else {
//			return false;
//		}
//	}

	public void insertNode(Node n) {
		if ((int) n.getInfo() < (int) this.info) {
			if (getIzq() == null) {
				setIzq(n);
			} else {
				izq.insertNode(n);
			}
		} else {
			if (getDer() == null) {
				setDer(n);
			} else {
				der.insertNode(n);
			}
		}
	}

	public Node masDerecho() {
		if (this.getDer() == null) {
			return this;
		} else {
			return this.getDer().masDerecho();
		}
	}

	public Node masIzquierdo() {
		if (this.getIzq() == null) {
			return this;
		} else {
			return this.getIzq().masIzquierdo();
		}
	}

//	public Node delete(Object o) {
//		Node response = this;
//		if ((int) o < (int) this.getInfo()) {
//			this.izq = this.izq.delete(o);
//		} else if ((int) o > (int) this.getInfo()) {
//			this.der = this.der.delete(o);
//		} else {
//			if (this.izq != null && this.der != null) {
//				Node temp = this;
//				Node mdi = this.izq.masDerecho();
//				this.setInfo(mdi.getInfo());
//				temp.izq = temp.izq.delete(mdi.getInfo());
//			} else if (this.izq != null) {
//				response = this.izq;
//			} else if (this.der != null) {
//				response = this.der;
//			} else {
//				response = null;
//			}
//		}
//		return response;
//	}

	public boolean hasElem(Object o) {
		if (getInfo().equals(o)) {
			return true;
		} else {
			if ((int) o < (int) this.info) {
				if (getIzq() == null) {
					return false;
				} else {
					return izq.hasElem(o);
				}
			} else {
				if (getDer() == null) {
					return false;
				} else {
					return der.hasElem(o);
				}
			}
		}
	}

	public void setInfo(Object o) {
		info = o;
	}

	public void setDer(Node n) {
		der = n;
	}

	public void setIzq(Node n) {
		izq = n;
	}

	public Object getInfo() {
		return info;
	}

	public Node getIzq() {
		return izq;
	}

	public Node getDer() {
		return der;
	}
}
