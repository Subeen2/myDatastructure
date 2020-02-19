public class LinkedQueue<T> {
    private int size;
    private LinkedNode<T> frontNode;
    private LinkedNode<T> rearNode;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> frontNode() {
        return frontNode;
    }

    public void setFrontNode(LinkedNode<T> frontNode) {
        this.frontNode = frontNode;
    }

    public LinkedNode<T> rearNode() {
        return rearNode;
    }

    public void setRearNode(LinkedNode<T> rearNode) {
        this.rearNode = rearNode;
    }

    public LinkedQueue(){
        this.setSize(0);
        this.setFrontNode(null);
        this.setRearNode(null);
    }

    public boolean isEmpty(){
        return this.frontNode()==null;
    }

    public boolean isFull(){
        return false;
    }

    public T front(){
        return this.frontNode().element();
    }

    public T rear(){
        return this.rearNode().element();
    }

    public boolean enQueue(T anElement){
        LinkedNode<T> addNode = new LinkedNode(anElement);
        if(this.isEmpty()){
            this.setFrontNode(addNode);
        }else{
            this.rearNode.setNext(addNode);
        }
        this.setRearNode(addNode);
        this.setSize(this.size()+1);
        return true;
    }

    public T deQueue(){
        T removeElement = this.frontNode.element();
        if(this.isEmpty()){
            return null;
        }else if(this.size()==1){
            this.setFrontNode(null);
            this.setSize(this.size()-1);
            return removeElement;
        }else{
            this.setFrontNode(this.frontNode().next());
            this.setSize(this.size()-1);
            return removeElement;
        }
    }

    public void clear(){
        this.setFrontNode(null);
        this.setRearNode(null);
        this.setSize(0);
    }
}
