public class MiListaDoble implements ListInterface {
    private DoubleNode cabeza;
    private DoubleNode cola;
    public MiListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        int contador = 0;
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.cola = null;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (this.cola == null) {
            return null;
        }
        return this.cola.dato;
    }

    @Override
    public Object get(DoubleNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public DoubleNode search(Object object) {
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            if (object == null) {
                if (iterador.dato == null) {
                    return iterador;
                }
            }else if (object.equals(iterador.dato)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        DoubleNode nuevoNode = new DoubleNode(object);
        if (this.cabeza == null) {
            this.cabeza = nuevoNode;
            this.cola= nuevoNode;
        } else {
            nuevoNode.anterior = this.cola;
            this.cola.siguiente = nuevoNode;
            this.cola = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean insert(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        DoubleNode nuevoNode = new DoubleNode(object);
        if(node == this.cola) {
            nuevoNode.anterior = this.cola;
            this.cola.siguiente = nuevoNode;
            this.cola = nuevoNode;
        } else {
            nuevoNode.siguiente = node.siguiente;
            nuevoNode.anterior = node;
            if (node.siguiente != null) {
                node.siguiente.anterior = nuevoNode;
            }
            node.siguiente = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode iterador = this.cabeza;
        DoubleNode nodoReferencia = null;
        while (iterador != null) {
            if (objectRef == null) {
                if (iterador.dato == null) {
                    nodoReferencia = iterador;
                    break;
                }
            } else if (objectRef.equals(iterador.dato)) {
                nodoReferencia = iterador;
                break;
            }
            iterador = iterador.siguiente;
        }
        if (nodoReferencia == null) {
            return false;
        }
        DoubleNode nuevoNodo = new DoubleNode(object);
        if (nodoReferencia == this.cola) {
            nuevoNodo.anterior = this.cola;
            this.cola.siguiente = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = nodoReferencia.siguiente;
            nuevoNodo.anterior = nodoReferencia;

            if (nodoReferencia.siguiente != null) {
                nodoReferencia.siguiente.anterior = nuevoNodo;
            }
            nodoReferencia.siguiente = nuevoNodo;
        }
        return true;
    }

    @Override
    public boolean insertHead(Object object) {
        DoubleNode nuevoNode = new DoubleNode(object);
        if (this.cabeza == null) {
            this.cabeza = nuevoNode;
            this.cola = nuevoNode;
        } else {
            nuevoNode.siguiente = this.cabeza;
            this.cabeza.anterior = nuevoNode;
            this.cabeza = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        DoubleNode nuevoNode = new DoubleNode(object);
        if (this.cabeza == null) {
            this.cabeza = nuevoNode;
            this.cola = nuevoNode;
        } else {
            nuevoNode.anterior = this.cola;
            this.cola.siguiente = nuevoNode;
            this.cola = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean set(DoubleNode node, Object object) {
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(DoubleNode node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        if (node == this.cabeza) {
            this.cabeza = this.cabeza.siguiente;
            if (this.cabeza != null) {
                this.cabeza.anterior = null;
            } else {
                this.cola = null;
            }
            return true;
        }
        if (node == this.cola) {
            this.cola = this.cola.anterior;
            if (this.cola != null) {
                this.cola.siguiente = null;
            } else {
                this.cabeza = null;
            }
            return true;
        }
        DoubleNode anteriorNode = node.anterior;
        DoubleNode siguienteNode = node.siguiente;
        if (anteriorNode != null) {
            anteriorNode.siguiente = siguienteNode;
        }
        if (siguienteNode != null) {
            siguienteNode.anterior = anteriorNode;
        }
        return true;
    }

    @Override
    public boolean contains(Object object) {
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            if (object == null) {
                if (iterador.dato == null) {
                    return true;
                }
            } else if (object.equals(iterador.dato)) {
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        int contador = 0;
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        Object[] arreglo = new Object[contador];
        iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int contador = 0;
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        Object[] resultado = object;
        if (object.length < contador) {
            resultado = new Object[contador];
        }
        iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            resultado[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        if (resultado.length > contador) {
            resultado[contador] = null;
        }
        return resultado;
    }

    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to) {
        MiListaDoble sublista = new MiListaDoble();
        if (from == null || to == null) {
            return sublista;
        }
        DoubleNode iterador = from;
        boolean alcanzado = false;
        while (iterador != null) {
            DoubleNode nuevoNodo = new DoubleNode(iterador.dato);
            if (sublista.cabeza == null) {
                sublista.cabeza = nuevoNodo;
                sublista.cola = nuevoNodo;
            } else {
                nuevoNodo.anterior = sublista.cola;
                sublista.cola.siguiente = nuevoNodo;
                sublista.cola = nuevoNodo;
            }
            if (iterador == to) {
                alcanzado = true;
                break;
            }
            iterador = iterador.siguiente;
        }
        if (!alcanzado) {
            sublista.cabeza = null;
            sublista.cola = null;
        }
        return sublista;
    }

    @Override
    public MiListaDoble sortList() {
        MiListaDoble listaOrdenada = new MiListaDoble();
        DoubleNode iterador = this.cabeza;
        while (iterador != null) {
            DoubleNode nuevoNodo = new DoubleNode(iterador.dato);
            if (listaOrdenada.cabeza == null) {
                listaOrdenada.cabeza = nuevoNodo;
                listaOrdenada.cola = nuevoNodo;
            } else {
                nuevoNodo.anterior = listaOrdenada.cola;
                listaOrdenada.cola.siguiente = nuevoNodo;
                listaOrdenada.cola = nuevoNodo;
            }
            iterador = iterador.siguiente;
        }
        if (listaOrdenada.cabeza == null) {
            return listaOrdenada;
        }
        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            DoubleNode actual = listaOrdenada.cabeza;
            while (actual != null && actual.siguiente != null) {
                if (actual.dato != null && actual.siguiente.dato != null) {
                    Comparable d1 = (Comparable) actual.dato;
                    Comparable d2 = (Comparable) actual.siguiente.dato;
                    if (d1.compareTo(d2) > 0) {
                        Object aux = actual.dato;
                        actual.dato = actual.siguiente.dato;
                        actual.siguiente.dato = aux;
                        huboIntercambio = true;
                    }
                }
                actual = actual.siguiente;
            }
        } while (huboIntercambio);
        return listaOrdenada;
    }
}
