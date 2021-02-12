
class Fraction {
    //instance variables / fields
    private int num, den;
    
    public Fraction() {//nothing in middle bc no return type, no parameters for default
        this.num = 0;
        this.den = 1;
    }
    
    public Fraction(int num, int den) {
        this.num = num;
        if(den == 0) {
            System.out.println("Error: denominator was zero!");
            den = 1;
        }else{
            this.den = den;
        }
    }
    
    public Fraction(String f){
        int slashIndex = f.indexOf("/");
        String n = f.substring(0, slashIndex);
        String d = f.substring(slashIndex+1);
        this.num = Integer.parseInt(n);
        int tempd = Integer.parseInt(d);
        if (tempd == 0) {
            System.out.println("Error: denominator was zero!");
            den = 1;
        } else {
            den = tempd;
        }
    }
    
    public Fraction(Fraction f) {
        this.num = f.num; //refers to object that is currently doing what its supposed to be doing -- currently constructing
        this.den = f.den;
    }
    //Accessor Methods ====================================================
    
    public int getNum() {
        return this.num;
    }
    
    public int getDenom() {
        return this.den;
    }
    
    public String toString() {
        return this.getNum() + "/" + this.getDenom();
    }

    public double toDecimal() {
        double doubnum = this.num;
        return doubnum/this.den;
    }
    
    public void reduce() {
        int gcd = gcd(this.num, this.den);
        this.num = this.num / gcd;
        this.den = this.den / gcd;
    }
    
    public static Fraction add (Fraction a, Fraction b) {
        //returns a new fraction that is the sum of the parameter fractions.
        
        int newNum = a.num * b.den + b.num * a.den;
        int newDen = a.den * b.den;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();
        
        return ans;
    }
    
    public static Fraction subtract (Fraction a, Fraction b) {
        int newNum = a.num * b.den - b.num * a.den;
        int newDen = a.den * b.den;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();
        
        return ans;
    }
    
    public static Fraction multiply (Fraction a, Fraction b) {
        int newNum = a.num * b.num;
        int newDen = a.den * b.den;
        Fraction ans = new Fraction(newNum, newDen);
        ans.reduce();
        
        return ans;
    }
    
    public static Fraction divide (Fraction a, Fraction b) {
        if(b.num == 0) {
            System.out.println("Error, cannot divide by divide by zero; returning a default fraction");
            return new Fraction();
        } else {
            Fraction reciprocal = b.getReciprocal();
            Fraction ans = Fraction.multiply(a, reciprocal);
            ans.reduce();
            
            return ans;
        }
    }
    
    //Helper Methods ======================================================
    
    private Fraction getReciprocal() {
        //returns the reciprocal of this fraction 
        
        Fraction reciprocal = new Fraction(this.den, this.num);
        return reciprocal;
    }
    
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        if ( a == 0 || b == 0) {
            return 1;
        }
        while (a != b) {
            if (a > b)
            a = a - b;
            else
            b = b - a;
        }
        return a;
    }
}
 //int x = Integer.parseInt("2");
 
 //immutable = cannot change it --> 0 mutator methods 
 //fraction class --> immutable. what changes? String ans = str.substring(0,2); f1 = f1.setNum(5);
 
