public class Tree<T> {
    private BinaryNode<T> root;

    public BinaryNode<T> root() {
        return root;
    }

    public void setRoot(T rootElement) {
        BinaryNode<T> RootNode = new BinaryNode(rootElement, null, null);
        this.root = RootNode;
    }

    public Tree(){      //생성자
        this.setRoot(null);
    }

    public boolean isEmpty(){
        return this.root() == null;
    }

    public boolean leftAdd(T anElement, BinaryNode<T> root){       //왼쪽에 추가
        BinaryNode<T> newNode = new BinaryNode(anElement, null, null);
        root.setLeftChild(newNode);
        return true;
    }

    public boolean rightAdd(T anElement, BinaryNode<T> root){      //오른쪽에 추가
        BinaryNode<T> newNode = new BinaryNode(anElement, null, null);
        root.setRightChild(newNode);
        return true;
    }

    public int height(){
        return this.heightOfSubTree(this.root);
    }

    private int heightOfSubTree(BinaryNode<T> aSubTreeRoot){
        int height = 0;
        if(aSubTreeRoot != null){
            int rightHeight = heightOfSubTree(aSubTreeRoot.rightChild());
            int leftHeight = heightOfSubTree(aSubTreeRoot.leftChild());
            int maxSubTreeHeight = rightHeight >= leftHeight ? rightHeight : leftHeight;
            height = 1+ maxSubTreeHeight;           //root 포함
        }
        return height;
    }

    public int size(){
        return this.sizeOfSubTree(this.root());
    }

    public int sizeOfSubTree(BinaryNode<T> aSubTreeNode){     //
        int size = 0;
        if(aSubTreeNode!=null){
            int leftSize = this.sizeOfSubTree(aSubTreeNode.leftChild());
            int rightSize = this.sizeOfSubTree(aSubTreeNode.rightChild());
            size = 1 + leftSize + rightSize;
        }
        return size;
    }

    public T rootElement(){     //root element 반환
        return this.root().element();
    }

    public Tree leftSubTree(){      //왼쪽 subtree 반환
        Tree subTree = new Tree();
        subTree.setRoot(this.root().leftChild());
        return subTree;
    }

    public Tree rightSubTree(){         //오른쪽 subtree 반환
        Tree subTree = new Tree();
        subTree.setRoot(this.root().rightChild());
        return subTree;
    }

    public void visit(T anElement){
        System.out.println(anElement);
    }

//    public void inOrderRecursively(BinaryNode<T> aRoot){
//        if(aRoot != null){
//
//        }
//    }
}