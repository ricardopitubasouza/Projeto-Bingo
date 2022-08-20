/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Pituba
 */
public class Combinacoes {
    
    String combinacao, total;
    

    public Combinacoes() {
    }

    public Combinacoes(String combinacao, String total) {
        this.combinacao = combinacao;
        this.total = total;
    }
    
     public String getCombinacao(){
         return combinacao;
     }
     
     public void setCombinacao(String combinacao){
         this.combinacao = combinacao;
     }
    
     public String getTotal(){
         return total;
     }
     
     public void setTotal(String total){
         this.total = total;
     }

    @Override
    public String toString() {
        return combinacao + " " + total;
    }
     
     
}
