import java.util.Iterator;

public class LinkedList<T> {
    private int size;
    private LinkedNode<T> head;


    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> head() {
        return head;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public LinkedList(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean doesContain(T anElement){
        if(this.isEmpty()){
            return false;
        }else {
            LinkedNode<T> current = this.head();
            while(current!=null){
                if(current.element().equals(anElement)){
                 return true;
                }
            }
            return false;
        }
    }

    public T elementAt(int anOrder){
        if(this.isEmpty()){
            return null;
        }else {
            LinkedNode<T> current = this.head();
            int i=0;
            while(i<anOrder){
                current = current.next();
                i++;
            }
            return current.element();
        }
    }

    public T firstElement(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.head().element();
        }
    }

    public T lastElement(){
        if(this.isEmpty()){
            return null;
        }else {
            LinkedNode<T> current = this.head();
            while (current != null) {
                current = current.next();
            }
            return current.element();
        }
    }

    public int orderOf(T anElement){
        if(this.isEmpty()){
            return -1;
        }else {
            LinkedNode<T> current = this.head();
            int i=0;
            while(current!=null){
                if(current.element().equals(anElement)){
                    return i;
                }
                else{
                    current = current.next();
                    i++;
                }
            }
            return i;
        }
    }

    public boolean addTo(T anElement, int anOrder) {
        if(anOrder<0 && anOrder>this.size()) {
            return false;
        }else {
            LinkedNode<T> addNode = new LinkedNode(anElement);
            LinkedNode<T> current = this.head();
            LinkedNode<T> previous = null;

            if(anOrder==0){
                addNode.setNext(this.head());
                this.setHead(addNode);
                this.setSize(this.size()+1);
                return true;
            }else{
                for(int i=1; i<anOrder; i++){
                    previous = current;
                    current = current.next();
                }
                addNode.setNext(current);
                previous.setNext(addNode);
                this.setSize(this.size()+1);
                return true;
            }
        }

    }

    public boolean addToFirst(T anElement){
        return this.addTo(anElement, 0);
    }

    public boolean addToLast(T anElement){
        return this.addTo(anElement, this.size());
    }


    public T removeFrom (int anOrder){
        if(anOrder<0 && anOrder>this.size()){
            return null;
        }else {
            LinkedNode<T> current = this.head();
            LinkedNode<T> previous = null;

            if(!this.isEmpty()){
                int i=0;
                while(current!=null){
                    i++;
                }
                if(i==1){
                    setHead(null);
                }else {
                    for(int j=2; j<anOrder; j++){
                        previous=current;
                        current= current.next();
                    }
                    previous.setNext(current.next());
                    this.setSize(this.size()-1);
                    return current.element();
                }
            } return null;
        }

    }

    public T removeFirst(){
        return this.removeFrom(0);
    }

    public T removeLast(){
        return this.removeFrom(this.size()-1);
    }

    public boolean replaceAt(T anElement, int anOrder){
        LinkedNode<T> current = this.head();
        int i=0;
        if(anOrder<0 && anOrder>this.size()){
            return false;
        }else if(this.isEmpty()){
           return false;
        }
        else {
                while(i<anOrder){
                    current = current.next();
                    i++;
            }
                current.setElement(anElement);
                return true;
        }
    }

    public void clear(){
        this.setHead(null);
        this.setSize(0);
    }



}
