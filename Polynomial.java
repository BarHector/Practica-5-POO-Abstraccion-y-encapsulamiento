import java.util.ArrayList;

public class Polynomial {
    private int degree;
    private int value;
    private ArrayList<Double> coeff;
    private ArrayList<Double> resultA;
    private ArrayList<Double> resultS;
    private ArrayList<Double> resultM;
    private String vals;
    
    public Polynomial(){
        degree = 0;
        vals="";
    }

    public Polynomial(int degree, String vals){
        this.degree = degree;
        this.vals = vals;
    }

    public void createList(){
        coeff = new ArrayList<>(); //INICIALIZANDO EL ARRAYLIST

        for (int i = 0; i <= degree; i++){ //CREANDO ESPACIOS
            coeff.add(0.0);
        }

        //AÑADIENDO NUMEROS AL ARRAYLIST
        for(int i=0; i < vals.length(); i++){
            if(!vals.substring(i,i+1).equals(" ") && !vals.substring(i,i+1).equals(",")){
                if(vals.substring(i,i+1).equals("-") && Double.parseDouble(vals.substring(i+1,i+2)) >= 0){ //REVISANDO SI ES NEGATIVO
                    coeff.set(degree, Double.parseDouble(vals.substring(i, i+2))); 
                    i=i+2;
                }else if(Double.parseDouble(vals.substring(i,i+1)) >= 0){//REVISANDO SI ES POSITIVO
                    coeff.set(degree, Double.parseDouble(vals.substring(i,i+1)));
                }

                degree--;
            }
        }
    }

    public void add(Polynomial lista1, Polynomial lista2){
        double suma=0.0;

        resultA = new ArrayList<>();

        if(lista1.getCoeff().size() < lista2.getCoeff().size()){
            for (int i = lista1.getCoeff().size(); i < lista2.getCoeff().size(); i++) {
                lista1.getCoeff().add(0.0);
            }
        }else if(lista1.getCoeff().size() > lista2.getCoeff().size()){
            for (int i = lista2.getCoeff().size(); i < lista1.getCoeff().size(); i++) {
                lista2.getCoeff().add(0.0);
            }
        }

        for (int i = 0; i < lista1.getCoeff().size(); i++) {
            suma = lista1.getCoeff().get(i) + lista2.getCoeff().get(i);
            resultA.add(suma);
        }
    }

    public void substract(Polynomial lista1, Polynomial lista2){
        double resta=0.0;

        resultS = new ArrayList<>();
        
        if(lista1.getCoeff().size() < lista2.getCoeff().size()){
            for (int i = lista1.getCoeff().size(); i < lista2.getCoeff().size(); i++) {
                lista1.getCoeff().add(0.0);
            }
        }else if(lista1.getCoeff().size() > lista2.getCoeff().size()){
            for (int i = lista2.getCoeff().size(); i < lista1.getCoeff().size(); i++) {
                lista2.getCoeff().add(0.0);
            }
        }

        for (int i = 0; i < lista1.getCoeff().size(); i++) {
            resta = lista1.getCoeff().get(i) - lista2.getCoeff().get(i);
            resultS.add(resta);
        }
    }

    public void multiplication(Polynomial po, int escalar){
        resultM = new ArrayList<>();
        
        for (int i = 0; i < po.getCoeff().size(); i++) {
            resultM.add(po.getCoeff().get(i) * escalar);
        }
        
        System.out.println("Multiplicacion: " + resultM);
    }

    public void printP(ArrayList<Double> polinomioR, int valX){
        String finalR="", agregar="";
        int converI=0;
        double valorD=0.0, resultado=0.0;

        for (int i = polinomioR.size()-1; i >= 0; i--) {
            valorD = polinomioR.get(i);

            if(valorD != 0){
                if(valorD%1==0){ //REVISANDO SI EL NÚMERO SOLO TIENE PARTE ENTERA
                    converI = (int)valorD;
    
                    if(converI == 1){ //SI EL NUMERO ES 1
                        finalR = finalR.concat("x").concat("^").concat(String.valueOf(i));
                    }else{ //SI EL NUMERO ES DIFERENTE DE UNO
                        finalR = finalR.concat(String.valueOf(converI)).concat("x").concat("^").concat(String.valueOf(i));
                    }
                }else{
                    finalR = finalR.concat(String.valueOf(valorD)).concat("x").concat("^").concat(String.valueOf(i));
                }
    
                //REVISANDO SI EL SIGUIENTE NÚMERO EXISTE Y ES POSITIVO
                if(i-1 > 0 && polinomioR.get(i-1) > 0){
                    finalR = finalR.concat("+");
                }
    
                //REVISANDO SI LAS ITERACIONES DEL FOR ACABARON PARA HACER LA IMPRESIÓN CORRECTA
                if(i==0){
                    finalR = finalR.substring(0, finalR.length()-3);
                    agregar = finalR.substring(finalR.length()-2, finalR.length());
                    finalR = finalR.substring(0, finalR.length()-4).concat(agregar);
                }
            }
        }
    
        for (int i = 0; i < polinomioR.size(); i++){
            if(i==0){
                resultado = polinomioR.get(i);
            }else{
                resultado = resultado + polinomioR.get(i) * Math.pow(valX, i);
            }
        }

        //IMPRESION DEL POLINOMIO
        System.out.println(finalR);
        
        //IMPRESION DE LA SUMA
        if (resultado%1==0) {
            converI = (int)resultado;
            System.out.println(converI);
        }else{
            System.out.println(resultado);
        }
    }

    public int getDegree(){
        return degree;
    }

    public int getValue(){
        return value;
    }

    public ArrayList<Double> getResultA(){
        return resultA;
    }

    public ArrayList<Double> getResultS(){
        return resultS;
    }

    public ArrayList<Double> getCoeff(){
        return coeff;
    }

    public void setDegree(int degree){
        this.degree = degree;
    }

    public void setValue(int value){
        this.value = value;
    }
}