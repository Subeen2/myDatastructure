public class LinkedSet<T> {
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

    public LinkedSet(){
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
            while(current != null){
                if(current.element().equals(anElement)){
                    return true;
                }
                current = current.next();
            }
            return false;
        }
    }

    public T any(){
        if(this.isEmpty()){
            return null;
        }
        else {
            return this.head().element();
        }
    }

    public boolean add(T anElement){
        LinkedNode<T> addNode = new LinkedNode(anElement);
        if(this.isEmpty()){
            this.setSize(size+1);
            this.setHead(addNode);
            return true;
        }else if(!this.doesContain(anElement)){
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.head();
            while (current != null) {
                previous = current;
                current = current.next();
            }
            previous.setNext(addNode);
            this.setSize(this.size() + 1);
            return true;
        }else return false;
    }

    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }else {
            T removeElement = this.head().element();
            this.setHead(this.head().next());
            this.setSize(this.size()-1);
            return removeElement;
        }
    }

    public boolean remove(T anElement) {
        if (this.isEmpty()) {       //비어있다면
            return false;
        } else {    //비어있지 않다면
            LinkedNode<T> current = this.head();
            LinkedNode<T> previous = null;
            if (current.next() == null) {   //1개밖에 없으면
                this.setHead(null);
                this.setSize(0);
               return true;
            } else {    //2개 이상이면
                while (current != null) {       //끝을 찾아
                    if (current.element().equals(anElement) && current == this.head()) {      //삭제할 대상 찾았으면
                        this.setHead(this.head.next());
                        this.setSize(this.size() - 1);
                        return true;
                    }else if(current.element().equals(anElement)){
                        previous = current;
                        current = current.next();
                        this.setSize(this.size()-1);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void clear(){
        this.setHead(null);
        this.setSize(0);
    }
}
