/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1a1;

public class Tugas1A1 {
    int Temp;
    double E_0, Ecurrent, X1, X2, BSF1, BSF2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tugas1A1 AI = new Tugas1A1();
        AI.proses();
    }
    public double F(double x1, double x2){
        double Fungsi_Sin = Math.sin(x1);
        double Fungsi_Cos = Math.cos(x2);
        double E = Math.exp(Math.abs(1-Math.sqrt(Math.pow(x1, 2)+Math.pow(x2, 2))/Math.PI));
        
        return Math.abs(Fungsi_Sin*Fungsi_Cos*E) * -1;
    }
    
    public void proses(){
        X1 = -10;
        X2 = -10;
        Temp = 197;
        E_0 = F(X1, X2);
        Ecurrent = E_0;
       
        for (int i = Temp; i > 0; i--) {
            X1 = X1 + 0.01;
            X2 = X2 + 0.1;
            double Ebaru = F(X1, X2);
            double DeltaE = Ebaru - Ecurrent;
            if (DeltaE<0) {
                Ecurrent = Ebaru;
                BSF1=X1; BSF2=X2;
            }else{
                double P = Math.exp(DeltaE/Temp);
                double r = 234;
                if (r< P){
                    Ecurrent=Ebaru;
                }
            }
        }
        System.out.println(BSF1);
        System.out.println(BSF2);
        System.out.println(Ecurrent);
        
    }
    
}
