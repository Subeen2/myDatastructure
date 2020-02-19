public class Tree<T> {
    private BinaryNode<T> root;

    public BinaryNode<T> root() {
        return root;
    }

    public void setRoot(T rootElement) {
        BinaryNode<T> RootNode = new BinaryNode(rootElement, null, null);
        this.root = RootNode;
    }

    public Tree() {
        this.setRoot(null);
    }

    public boolean isEmpty() {
        return this.root() == null;
    }

    public boolean leftAdd(T anElement, BinaryNode<T> root) {
        BinaryNode<T> newNode = new BinaryNode(anElement, null, null);
        root.setLeftChild(newNode);
        return true;
    }

    public boolean rightAdd(T anElement, BinaryNode<T> root) {
        BinaryNode<T> newNode = new BinaryNode(anElement, null, null);
        root.setRightChild(newNode);
        return true;
    }
//
//    public int height() {
//        return this.heightOfSubTree(this.root);
//    }

//    public int heightOfSubTree(BinaryNode<T> aSubTreeRoot){
//        int height = 0;
//        if(aSubTreeRoot)
//    }
}