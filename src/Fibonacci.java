public class Fibonacci {
    public int fibonacci(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
//    Fibonacci fibo = new Fibonacci();
//    int result ;
//    int n=6;
//    result = fibo.fibonacci(n);
//        System.out.println(result);
}
