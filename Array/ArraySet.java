public class ArraySet<T> {
    private int size;
    private int capacity;
    private T[] elements;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] elements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public ArraySet(){
       this.setCapacity(100);
       this.setSize(0);
       this.setElements((T[]) new Object[100]);
    }

    public boolean isEmpty(){
        if(this.size() == 0) return true;
        else return false;
    }

    public boolean isFull(){
        return this.size()==100;
    }

    public boolean doesContain(T anElement){
        if(this.isEmpty()){
            return false;
        }
        else {
            for (int i = 1; i < this.size(); i++) {
                if (this.elements()[i-1].equals(anElement)) {
                    return true;
                }
            }
            return false;
        }
    }

    public T any(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.elements()[0];
        }
    }

    public boolean add(T anElement){
        if(this.isFull()){
            return false;
        }else {
            if(!this.doesContain(anElement)){

               this.elements()[this.size()]=anElement;
               this.setSize(this.size()+1);
               return true;
            }
        }
        return false;
    }

    public T removeAny(){
        if(isEmpty()){
            return null;
        }else {
            T a = this.elements()[this.size()];
            this.elements()[this.size()]=null;
            this.setSize(this.size()-1);
            return a;
        }
    }

    public boolean remove(T anElement){
        if(isEmpty()){
            return false;
        }else{
            int i=0;
            while(i<this.size()){
                if(this.elements()[i].equals(anElement)){
                    this.elements()[i] = null;
                    break;
                }
                i++;
            }
            for(int j=i; j<this.size(); j++){
                this.elements()[j-1] = this.elements()[j];
            }
            return true;
        }
    }

    public void clear(){
            int i=0;
            while(i<this.size()){
                this.elements()[i] = null;
                i++;
            }
            this.setSize(0);
    }

}
