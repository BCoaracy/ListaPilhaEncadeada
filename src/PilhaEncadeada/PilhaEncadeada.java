
package PilhaEncadeada;

import listapilhaencadeada.Carros;


public class PilhaEncadeada {
    //Criar pilha Apontamento do topo, primeiramente ele aponta para NULL.
    //Quando é empilhado um novo elemento ele recebe o topo.
        
    private No topo;
    
    public void push(Object valor){
        No no = new No();
            no.setValor(valor);
        if(this.topo == null){
            no.setProximo(null);
            topo = no;
        }else{
            no.setProximo(topo);
            topo = no;
        }
            
    }
    
    public Object pop(){
        No no = new No();
        No aux = new No();
        if(topo != null){
            aux = topo.getProximo();
            no = topo;
            topo = aux;
            return no.getValor();
        }
        return null;
    }
    
    public boolean pilhaVazia(){
        if(this.topo==null){
            return true;
        }
        return false;
    }
    
    public Object getTopo(){
        return this.topo.getValor();
    }
    
    public void trasferePilha(PilhaEncadeada p2){
        //PilhaEncadeada p2 = new PilhaEncadeada();
        PilhaEncadeada pAux = new PilhaEncadeada();
        Object aux;
        while(!this.pilhaVazia()){
            aux = this.pop();
            p2.push(aux);
            pAux.push(aux);
        }
        while(!pAux.pilhaVazia()){
            aux = pAux.pop();
            this.push(aux);
        }
        
    }
    
    public int getTamanho(){
        PilhaEncadeada pe = new PilhaEncadeada();
        this.trasferePilha(pe);
        int i=0;
        Object valor = 0;
        while(!pe.pilhaVazia()){
            valor=pe.pop();
            i++;
        }
        
        return i-1;
    }
    
    public int moveCarros(Carros carOut){
        Carros carAux = new Carros();
        boolean pause = true;
        Object test;
        PilhaEncadeada pilhaAux = new PilhaEncadeada();
        int i=0;
                do{
                    test = this.pop();
                    carAux = (Carros)test;
                    pilhaAux.push(carAux);
                    i++;
                    if(carOut.getPlaca().equals(carAux.getPlaca()))
                        pause = false;
                }while(pause==true);
                
                while(!pilhaAux.pilhaVazia()){
                    this.push(pilhaAux.pop());
                }
                System.out.println("O carro foi manobrado " + (i-1) + " vezes.");
                return i;
    }
    
    public boolean pilhasIguais(PilhaEncadeada PE1, PilhaEncadeada PE2 ){
        PilhaEncadeada pe1 = new PilhaEncadeada();
        PilhaEncadeada pe2 = new PilhaEncadeada();
        PE1.trasferePilha(pe1);
        PE2.trasferePilha(pe2);
        Object valor1=0, valor2=0;
        if(pe1.getTamanho()!=(pe2.getTamanho())){
            return false;
        }
        PE1.trasferePilha(pe1);
        PE2.trasferePilha(pe2);
        while(!pe1.pilhaVazia()||!pe2.pilhaVazia()){
            valor1 = pe1.pop();
            valor2 = pe2.pop();
            if(!valor1.equals(valor2))
                return false;
        }
        return true;
    }
    
    public void posFixaPilha(String Expressao){//Imprime uma expressao pós fixa
        
        PilhaEncadeada p = new PilhaEncadeada();        
        int i = 0, x = 0;
        char c, t;
        
        p.push('(');

        do {
                c = Expressao.charAt(i);
                i++;
            if ((c >= 'A' && c <= 'Z')||(c >='0' && c <= '9')) {
                System.out.printf("%c", c);
            } else if (c == '(') {
                p.push('(');
            } else if (c == ')' || c == '\0') {
                do {
                    t = (char) p.pop();
                    if (t != '(') {
                        System.out.printf("%c", t);
                    }
                } while (t != '(');
            } else if (c == '+' || c == '-'
                    || c == '*' || c == '/'
                    || c == '^') {
                do{
                    t = (char) p.pop();
                    if (Prioridade(c, t)) {
                        p.push(t);
                        p.push(c);
                        break;
                    } else {
                        System.out.printf("%c", t);
                    }
                }while(Prioridade(c,t));
            }
        } while (i != (Expressao.length()));
        System.out.printf("\n");
        
        
    }
    
    public boolean Prioridade(char c, char t){
        int pc = 0, pt = 0; 
        if (c == '^') {
            pc = 4;
        } else if (c == '*' || c == '/') {
            pc = 2;
        } else if (c == '+' || c == '-') {
            pc = 1;
        } else if (c == '(') {
            pc = 4;
        }

        if (t == '^') {
            pt = 3;
        } else if (t == '*' || t == '/') {
            pt = 2;
        } else if (t == '+' || t == '-') {
            pt = 1;
        } else if (t == '(') {
            pt = 0;
        }

        return (pc > pt);
    }
    
}
