public class LinkedStack<T> {

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

   public LinkedStack(){
        this.setSize(0);
        this.setHead(null);
   }

   public boolean isEmpty(){
        return this.size()==0;
   }

   public boolean isFull(){
        return false;
   }

   public boolean push(T anElement){
       LinkedNode<T> addNode = new LinkedNode(anElement);
        if(this.isEmpty()){
            this.setSize(this.size()+1);
            this.setHead(addNode);
            return true;
        }else{
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.head();
            while (current != null) {
                previous = current;
                current = current.next();
            }
            previous.setNext(addNode);
            this.setSize(this.size() + 1);
            return true;
        }
   }

   public T peek(){
        if(this.isEmpty()){
            return null;
        }else{

            LinkedNode<T> current = this.head();
            while(current.next()!=null){
                current = current.next();
            }
            return current.element();
        }
   }

   public T pop(){

    if(this.isEmpty()){
        return null;
    }else {
        LinkedNode<T> previous = null;
        LinkedNode<T> current = this.head();
        while(current.next()!=null){
            previous = current;
            current = current.next();
        }
        T removeElement = current.element();
        previous.setNext(null);
        this.setSize(this.size()-1);
        return removeElement;
    }
   }
}
