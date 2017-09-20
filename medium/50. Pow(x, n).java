class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if(n ==0)
            return 1.0;
        else
            return myPowHelper(x, 1.0, n);
    }
    
    private double myPowHelper(double x, double sqrx, int n){
        if(n == 1 || n == -1){
            if(n > 0)
                return sqrx * x;
            else
                return sqrx/x;
        }
        if(sqrx == 1 && n >0)
            sqrx = x;
        if(sqrx == 1 && n <0)
            sqrx = 1/x;
        if(n == 2 || n == -2){
            return sqrx * sqrx;
        }
        else{
            return myPowHelper(x, sqrx * sqrx, n/2);
        }
    }
}