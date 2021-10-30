package zad6;

public class Zespolona {
    double re;
    double im;

    public Zespolona(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public Zespolona(){}
    public double modul(){
        return Math.sqrt(Math.pow(this.re,2)+Math.pow(this.im,2));
    }
    public void kwadrat(){
        double T_re,T_im;
        T_re = Math.pow(this.re,2)-Math.pow(this.im,2);
        T_im = 2*this.re*this.im;

        this.re=T_re;
        this.im=T_im;
    }
    public void suma(Zespolona p){
        this.re=this.re+p.re;
        this.im=this.im+p.im;
    }
}
