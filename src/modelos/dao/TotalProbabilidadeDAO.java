/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import FabricaDeConexao.ConexaoFireBird;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;

/**
 *
 * @author Pituba
 */
public class TotalProbabilidadeDAO {
    
    int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    public void salvar_probabilidades(String probabilidade){
   
        Connection con = ConexaoFireBird.getConnection();
        PreparedStatement stmt = null;
        //Combinacoes combinacoes = new Combinacoes();
        
        try{
            stmt = con.prepareStatement("INSERT INTO TOTALPROBABILIDADES(TOTAL_PROBABILIDADES) VALUES (?)");
            stmt.setString(1, probabilidade.trim());
            stmt.executeUpdate();
            quantidade += 1;
            //combinacoes.setTotal(quantidade);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex + "\n ao tentar salvar probabilidades");
                    //"Bingo", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(quantidade == 3268760){
                   ConexaoFireBird.closeConnection(con, stmt);
            }
                /*if(quantidade % 64999 == 0){
                    ConexaoFireBird.closeConnection(con, stmt);
                    try {
                        ConexaoFireBird conec = new ConexaoFireBird();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TotalProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(TotalProbabilidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                
        }
        
    }
    
    
    }
