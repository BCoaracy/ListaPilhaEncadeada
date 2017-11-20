package listapilhaencadeada;

import PilhaEncadeada.*;
import java.util.*;

public class ListaPilhaEncadeada {

    
    public static void main(String[] args) {
        PilhaEncadeada pe = new PilhaEncadeada();
        PilhaEncadeada pilhaEncadeada1 = new PilhaEncadeada();
        PilhaEncadeada pilhaEncadeada2 = new PilhaEncadeada();
        Scanner sc = new Scanner(System.in);
        
//        for (int i=0;i<5;i++){
//            System.out.println("Informe o " + (i+1) + " valor");
//            pilhaEncadeada1.push(i);
//            
//        }
//        System.out.println("Aqui começa a segunda pilha");
//        for (int i=0;i<5;i++){
//            System.out.println("Informe o " + (i+1) + " valor");
//            pilhaEncadeada2.push(i);
//            
//        }
//        
//        //System.out.println("Tamanho da pilha 1 " + pilhaEncadeada1.getTamanho());
//        
//        if(pe.pilhasIguais(pilhaEncadeada1, pilhaEncadeada2)){
//            System.out.println("Pilhas Iguais");
//        }else{
//            System.out.println("Pilhas Diferentes");
//        }
//Exercicio 2
//        String expressao;
//        expressao = sc.nextLine();
//        pe.posFixaPilha(expressao);

        String continua = "s";
        Carros car = new Carros();
        while(continua.equals("s")){
            
            System.out.println("Informe a placa do carro: ");
            car.setPlaca(sc.nextLine());
            System.out.println("Movimentacao?");
            car.setMOV(sc.nextLine());
            System.out.println("Deseja Continuar? ");
            continua = sc.nextLine();
            pilhaEncadeada1.push(car);
            
        }
        PilhaEncadeada pteste = new PilhaEncadeada();
        pilhaEncadeada1.trasferePilha(pteste);


    }
    
    
    
}
