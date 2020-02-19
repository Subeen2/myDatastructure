public class ArrayStack<T> {
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

    public void setElement(T[] elements) {
        this.elements = elements;
    }

    public ArrayStack(){
        this.setSize(0);
        this.setCapacity(100);
        this.setElement((T[])new Object[100]);
    }

    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean isFull(){
        return this.size()==100;
    }

    public boolean push(T anElement){
        if(this.isEmpty()){
            this.elements()[0]=anElement;
            this.setSize(this.size()+1);
            return true;
        }else if(this.isFull()){
            return false;
        }else {
            this.elements()[this.size()] = anElement;
            this.setSize(this.size()+1);
            return true;
        }
    }

    public T peek(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.elements()[this.size()-1];
        }
    }

    public T pop(){
        if(this.isEmpty()){
            return null;
        }else{
            T a = this.elements()[this.size()-1];
            this.elements()[this.size()]=null;
            this.setSize(this.size()-1);
            return a;
        }
    }
}
