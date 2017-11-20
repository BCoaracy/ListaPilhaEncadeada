/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilhaEncadeada;

/**
 *
 * @author Bruno
 */
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
    
    public PilhaEncadeada posFixaPilha(String Expressao){//Imprime uma expressao pós fixa
        
        PilhaEncadeada pilhaPos = new PilhaEncadeada();
        PilhaEncadeada pilhaAux = new PilhaEncadeada();
        Object aux = null, pos = null;
        for(int n = 0;n<(Expressao.length()-1);n++){
                  aux = Expressao.charAt(n);    
              if(Expressao.charAt(n)==('*')||Expressao.charAt(n)==('+')||Expressao.charAt(n)==('-')
                      ||Expressao.charAt(n)==('/')||Expressao.charAt(n)==('^')){
                  pos = Expressao.charAt(n+1);
                  pilhaPos.push(pos);
                  pilhaPos.push(aux);
              }else if(!aux.equals('(')||!aux.equals(')')){
                  pilhaPos.push(aux);
              }else if(aux.equals(')')){
                  n=n-2;
              }
              
//            aux = Expressao.charAt(n);
//            if(aux.equals('*')||aux.equals('/')||aux.equals('+' )||aux.equals('-')){
//                pos = aux;
//            }else{
//                pilhaPos.push(aux);
//            }
        }
        //pilhaPos.push(pos);
        while(!pilhaPos.pilhaVazia()){
            aux=pilhaPos.pop();
            pilhaAux.push(aux);
        }
        System.out.println("Pilha dentro do método ");
        while(!pilhaAux.pilhaVazia()){
            System.out.print("" + pilhaAux.pop());
        }
        System.out.println("");
        return pilhaPos;
        
    }
}
