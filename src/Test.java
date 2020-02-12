public class Test {
    public static void main(String args[]){
       LinkedBag<Integer> test1 = new LinkedBag();       //int 성질을 갖는 값이 들어간다.
        int i=10;
        while(i != 0){
            test1.add(i);
            i--;
        }
        test1.printNode();
    }
}
