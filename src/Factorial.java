public class Factorial {
    public int fact(int n){
        if(n==0){
            return 1;
        }else {
            return n*fact(n-1);
        }
    }

//    Factorial number = new Factorial();
//    int nFact;
//    int n=5;
//    nFact = number.fact(n);
//        System.out.println(nFact);
}
