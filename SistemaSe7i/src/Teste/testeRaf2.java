/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

/**
 *
 * @author rafae
 */
public class testeRaf2 {
    public static void main(String[] args) {
        String a = "00006726449836";
        
        System.out.println(a.substring(0, 3));
        if(a.substring(0, 3).equals("000")){
            System.out.println("é cpf");
            System.out.println(a.substring(3));
        }else{
            System.out.println("E cnpj");
            System.out.println(a);
        }

    }
}
