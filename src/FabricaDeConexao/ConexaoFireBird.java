/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricaDeConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pituba
 */
public class ConexaoFireBird {
    private static Connection conexaobingo;
    
      public  ConexaoFireBird() throws ClassNotFoundException, SQLException{
          
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            String url = "jdbc:firebirdsql:localhost/3050:C:/BingoLotofacil/LOTOFACILBD.fdb?encoding=WIN1252";
            conexaobingo = DriverManager.getConnection(url, "SYSDBA", "masterkey");
      }
      
    public static Connection getConnection(){
        
        try{
            //JOptionPane.showMessageDialog(null, conexaobingo);
            return conexaobingo;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex + "\n ao tenrar conectar!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        return conexaobingo;
    }
    
    public static void closeConnection(Connection con){
       
                try {
                    if(con != null){
                    con.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! " + ex, "Bingo",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public static void closeConnection(Connection con, PreparedStatement stmt){
       
            closeConnection(con);
                try {
                  if(stmt != null){
                    stmt.close();
                  }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar conexão e/ou Statement! " + ex,
                            "Bingo", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
       
            closeConnection(con, stmt);
                try {
                  if(rs != null){
                    rs.close();
                  }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Erro ao fechar conexão e/ou Statement e/ou Resultset! " + ex,
                            "Bingo", JOptionPane.ERROR_MESSAGE);
            }
        }
}
