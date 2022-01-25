import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner nao = new Scanner(System.in);
        
        String grade, pol, value="", ext="";
        ArrayList <Polynomial> pols = new ArrayList<>();

        Polynomial p1;

        while(nao.hasNextLine()){
            ext = nao.nextLine();

            if(nao.hasNextLine() == false){
                value = ext;
            }else{
                grade = ext;
                pol = nao.nextLine();
                p1 = new Polynomial(Integer.parseInt(grade), pol);
                pols.add(p1);
                p1.createList();
            }
        }

        Polynomial R = new Polynomial();

        R.add(pols.get(0), pols.get(1));
        R.substract(pols.get(0), pols.get(1));
        R.printP(R.getResultA(), Integer.parseInt(value));
        R.printP(R.getResultS(), Integer.parseInt(value));

        // System.out.println("pols1: " + pols.get(0).getCoeff());
        // pols.get(0).multiplication(pols.get(0), 3);
        
        nao.close();
    }
}