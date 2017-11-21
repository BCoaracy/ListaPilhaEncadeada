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
//            pilhaEncadeada2.push(i+1);
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
//        expressao = "A*2";
//        pe.posFixaPilha(expressao);
//        expressao = "(A*2+c-d)/2";
//        pe.posFixaPilha(expressao);
//        expressao = "(2*4/a^b)/(2*c)";
//        pe.posFixaPilha(expressao);

        String continua = "s";
        
        Carros car = new Carros();
//        Carros car2 = new Carros();
//        Carros car3 = new Carros();
//        Carros car4 = new Carros();
        Carros carAux = new Carros();
        int i = 0;
        /*car1.setMOV("E"); car1.setPlaca("123");
        car2.setMOV("E"); car2.setPlaca("456");
        car3.setMOV("E"); car3.setPlaca("789");
        car4.setMOV("E"); car4.setPlaca("111");
        carAux.setMOV("S"); carAux.setPlaca("456");
        
        pe.push(car1);
        pe.push(car2);
        pe.push(car3);
        pe.push(car4);
        
        pe.moveCarros(carAux);*/
        
        while(continua.equals("s")){
            
            System.out.println("Informe a placa do carro: ");
            car.setPlaca(sc.nextLine());
            System.out.println("Movimentacao?");
            car.setMOV(sc.nextLine());
            
            if(car.getMOV().equals("E")){
                pilhaEncadeada1.push(car);
            }else if((car.getMOV().equals("S"))){
                carAux = car;
                pilhaEncadeada1.moveCarros(carAux);
            }
            
            System.out.println("Deseja Continuar? ");
            continua = sc.nextLine();
        }
        


    }
    
    
    
}
