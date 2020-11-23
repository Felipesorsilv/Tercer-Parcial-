public class quick_sort {
    
    public static void main(String[] args){
        
        lista listita = new lista();
        
        for(int i = 0; i <1_000_001;i++){
            int num = (int) (Math.random()*10000-100);
            listita.insertar(num);
            //System.out.println("#"+i+" :"+num);
        }
        
        listita.quicksort();
        System.out.println("\n Ordenados: \n");
        //listita.recorrer();
    }
}
class lista{
    
    nodo inicio = null, fin = null;
    public void insertar(int dato){
        nodo nuevo = new nodo();
        nuevo.dato = dato;
        nuevo.sig = null;
        nuevo.acomodado=false;
        nuevo.prev = null;
        if(inicio == null){
            inicio = nuevo;
            fin = nuevo;
        }else{
            fin.sig = nuevo;
            nuevo.prev = fin;
            fin = fin.sig;
        }
    }
    
    public void recorrer(){
        nodo aux = inicio;
        while(aux != null){
            System.out.println(aux.dato);
            aux = aux.sig;
        }
    }
    
    public void quicksort(){
       nodo in = inicio;
       nodo fi = fin;
       quicksort_c(in, fi);
    }
    
    public void quicksort_c(nodo izq, nodo der){
        nodo pivote = izq;
        nodo izq_aux=izq, der_aux= der;
        
        while(izq_aux!=der_aux&&izq_aux!=null&&der_aux!=null){
            if(pivote == izq_aux){
                if(pivote.dato<=der_aux.dato){
                    der_aux=der_aux.prev;
                }else{
                    int temp = izq_aux.dato;
                    izq_aux.dato = der_aux.dato;
                    der_aux.dato = temp;
                    pivote = der_aux;
                }
            }else{
                if(pivote.dato>=izq_aux.dato){
                    izq_aux=izq_aux.sig;
                    
                }else{
                    int temp = izq_aux.dato;
                    izq_aux.dato = der_aux.dato;
                    der_aux.dato = temp;
                    pivote = izq_aux;
                }
            }
        }
        if(izq_aux==der_aux){
            izq_aux.acomodado=true;
            if(izq_aux.prev!=null&&izq_aux.prev.acomodado!=true){
                quicksort_c(izq, izq_aux.prev);
            }
            if(der_aux!=null&&der_aux.sig!=null&&der_aux.sig.acomodado!=true){
                    quicksort_c(der_aux.sig, der);
            }
        }
    }
}

class nodo{
    int dato;
    boolean acomodado;
    nodo sig;
    nodo prev;
}
