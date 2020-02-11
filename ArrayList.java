public class ArrayList<T> {
    private int size;
    private int capacity;
    private T[] element;

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

    public T[] element() {
        return element;
    }

    public void setElement(T[] element) {
        this.element = element;
    }

    public ArrayList(){
        this.setSize(0);
        this.setCapacity(100);
        this.setElement((T[]) new Object[100]);
    }

    public boolean isEmpty(){
        return this.size()==0;
    }

    public boolean isFull(){
        return this.size()==100;
    }

    public boolean anElementDoesExistAt(int anOrder){
        return (anOrder>=0 && anOrder<this.size());
    }

    public T elementAt(int anOrder){
        if(this.isEmpty()){
            return null;
        }else {
            if(this.anElementDoesExistAt(anOrder)){
                return this.element()[anOrder];
            }else {
                return null;
            }
        }
    }

    public T first(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.element()[0];
        }
    }

    public T last(){
        if(this.isEmpty()){
            return null;
        }else {
            return this.element()[this.size()-1];
        }
    }

    public boolean doesContain(T anElement){
        if(this.isEmpty()){
            return false;
        }else {
            boolean found = false;
            for(int i=0; i<this.size(); i++){
                if(this.element()[i].equals(anElement)){
                    return true;
                }
            }
        }
        return false;
    }

    public int orderOf(T anElement){
        if(this.isEmpty()){
            return -1;
        }else {
            int i=0;
            while(i<this.size()){
                if(this.element()[i].equals(anElement)){
                    return i;
                }else {
                    i++;
                }
            }
        }
        return -1;
    }

    public void makeRoomAt(int order){
        for(int i=order; i<this.size(); i++){
            this.element()[i+1] = this.element()[i];
        }
        this.element()[order]= null;
    }

    public boolean addTo(T anElement, int anOrder){
        if(this.isFull()){
            return false;
        }else {
            this.makeRoomAt(anOrder);
            this.element()[anOrder]= anElement;
            this.setSize(this.size()+1);
            return true;
        }
    }

    public boolean addToFirst(T anElement){
        return this.addTo(anElement,0);
    }

    public boolean addToLast(T anElement){
        return this.addTo(anElement,this.size());
    }

    public void removeGetAt(int order){

        for(int i=order+1; i<this.size(); i++){
            this.element()[i-1]=this.element()[i];
        }
        this.element()[this.size()-1]=null;
    }

    public T removeFrom(int anOrder){
        if(this.isEmpty()){
            return null;
        }else {
            T removeElement = null;
            if(this.anElementDoesExistAt(anOrder)){
                removeElement= this.element()[anOrder];
                this.removeGetAt(anOrder);
                this.setSize(this.size()-1);
            }
            return removeElement;
        }
    }

    public T removeFirst(){
        return this.removeFrom(0);
    }

    public T removeLast(){
        return this.removeFrom(this.size()-1);
    }

    public boolean replaceAt(T anElement, int anOrder){
        if(this.isEmpty()){
            return false;
        }else {
            if(this.anElementDoesExistAt(anOrder)){
                this.element()[anOrder]= anElement;
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void clear(){
        int i=0;
        while(i<this.size()){
            this.element()[i]= null;
            i++;
        }
        this.setSize(0);
    }
}
