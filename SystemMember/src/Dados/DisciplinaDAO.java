/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Disciplina;
import negocio.Membro;

/**
 *
 * @author Arlindo
 */
public class DisciplinaDAO {
    Statement stmt;
    
    //NO CADASTRA SE O CPF EXISTE NAO CADASTRO.
    public boolean cadastraDisciplina (Disciplina d){
        if(d != null){
                       
            String comandoSql = "INSERT INTO DISCIPLINA (ID_MEMBRO,DATA_INICIO,DATA_FIM,DESCRICAO,STATUS,STATUS_HISTORICO) " +
            "VALUES ('"+d.getMembro().getId()+"','"+d.getDataInicio()+"', '"+d.getDataFim()+"', '"+d.getDescricao()+"', '"+"Ativa"+"', '"+"Atual"+"');"; 
            System.out.println(comandoSql);
            try{
                java.sql.Statement stmt = (Statement)Myconnection.getStatement();
                
                stmt.executeUpdate(comandoSql);
                stmt.close();
               
                return true;
             
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
    public void AtualizarStatus(int id) {
        
            String comandoSQL = "UPDATE disciplina SET STATUS_HISTORICO='ANTIGA' WHERE id = "+id;
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                   // JOptionPane.showMessageDialog(null, "Alteração de cadastro efetuada com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    stmt.close();
            } catch (SQLException e) {
              //  JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        
    }
    
    public boolean cadastraDisciplina (Disciplina d, int id_antigo){
        if(d != null){
           
            String comandoSql = "INSERT INTO DISCIPLINA (ID_MEMBRO,DATA_INICIO,DATA_FIM,DESCRICAO,STATUS,STATUS_HISTORICO,ID_ANTERIOR) " +
            "VALUES ('"+d.getMembro().getId()+"','"+d.getDataInicio()+"', '"+d.getDataFim()+"', '"+d.getDescricao()+"', '"+"Ativa"+"', '"+"Atual"+"','"+id_antigo+"');"; 
            System.out.println(comandoSql);
            
            AtualizarStatus(id_antigo);
            
            try{
                java.sql.Statement stmt = (Statement)Myconnection.getStatement();
                
                stmt.executeUpdate(comandoSql);
                stmt.close();
               
                return true;
                
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
     public Disciplina buscaDisiciplina(String nome){ // fazer um inner join com o nome do cliente
        String sql = "SELECT * FROM disciplina INNER JOIN membro WHERE  membro.ID = disciplina.ID_MEMBRO AND membro.NOME like '%"+nome+"%'";
        
        ResultSet rs, rs2;
        try{
            java.sql.Statement  stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            String sql2 = "SELECT * FROM membro WHERE id ="+ rs.getInt("id");
            
            java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
            rs2 = stmt2.executeQuery(sql2);
            rs2.next();
            
            Membro m = new Membro(rs.getString("NOME"), rs.getString("DATABATISMO"),rs.getString("CONGREGACAO") , rs.getString("RG"), rs.getString("CPF"),rs.getString("DATANASCIMENTO"), rs.getString("NOMEPAI"), rs.getString("NOMEMAE"), rs.getString("NATURALIDADE"),rs.getString("SEXO"), "ATUAL",rs.getString("TELEFONE"));
            m.setId(rs.getInt("id"));
            Disciplina d = new Disciplina(m, rs.getString("DATA_INICIO"),rs.getString("DESCRICAO") , rs.getString("STATUS"));
            d.setId(rs.getInt("id"));
                if(rs.getString("DATA_FIM") != null){
                    d.setDataFim(rs.getString("DATA_FIM"));                           
                }

            //public Disciplina(Membro membro, int id, String dataInicio, String descricao, String status) {
            
            stmt.close();
            stmt2.close();
            
            return d;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    
    public List listaDisciplina(String nome){
        ResultSet rs, rs2;
        List lista = new ArrayList();
        String sql = "SELECT * FROM disciplina INNER JOIN membro WHERE  membro.ID = disciplina.ID_MEMBRO AND membro.NOME like '%"+nome+"%'";
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                String sql2 = "SELECT * FROM membro WHERE id ="+ rs.getInt("id");

                java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
                rs2 = stmt2.executeQuery(sql2);
                rs2.next();

                Membro m = new Membro(rs.getString("NOME"), rs.getString("DATABATISMO"),rs.getString("CONGREGACAO") , rs.getString("RG"), rs.getString("CPF"),rs.getString("DATANASCIMENTO"), rs.getString("NOMEPAI"), rs.getString("NOMEMAE"), rs.getString("NATURALIDADE"),rs.getString("SEXO"), "ATUAL",rs.getString("TELEFONE"));
                m.setId(rs.getInt("id"));
                Disciplina d = new Disciplina(m, rs.getString("DATA_INICIO"),rs.getString("DESCRICAO") , rs.getString("STATUS"));
                d.setId(rs.getInt("id"));
                if(rs.getString("DATA_FIM") != null){
                    d.setDataFim(rs.getString("DATA_FIM"));                           
                }
                lista.add(d);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    public List listaDisciplinaIdCliente(Membro m){
        ResultSet rs;
        List lista = new ArrayList();
        String sql = "SELECT * FROM disciplina WHERE ID_MEMBRO ="+ m.getId() + " ORDER BY id DESC";
//        System.out.println(sql);
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                            
                Disciplina d = new Disciplina(m, rs.getString("DATA_INICIO"),rs.getString("DESCRICAO") , rs.getString("STATUS"));
                d.setId(rs.getInt("id"));
                if(rs.getString("DATA_FIM") != null){
                    d.setDataFim(rs.getString("DATA_FIM"));                           
                }
                lista.add(d);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    public Disciplina getDisciplinaById(int id){
        Disciplina d = null;
        ResultSet rs, rs2;
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery("SELECT * FROM disciplina WHERE id = "+id);
            while(rs.next()){
                String sql2 = "SELECT * FROM membro WHERE id ="+ rs.getInt("id");

                java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
                rs2 = stmt2.executeQuery(sql2);
                rs2.next();

                Membro m = new Membro(rs.getString("NOME"), rs.getString("DATABATISMO"),rs.getString("CONGREGACAO") , rs.getString("RG"), rs.getString("CPF"),rs.getString("DATANASCIMENTO"), rs.getString("NOMEPAI"), rs.getString("NOMEMAE"), rs.getString("NATURALIDADE"),rs.getString("SEXO"), "ATUAL",rs.getString("TELEFONE"));
                m.setId(rs.getInt("id"));
                d = new Disciplina(m, rs.getString("DATA_INICIO"),rs.getString("DESCRICAO") , rs.getString("STATUS"));
                d.setId(rs.getInt("id"));
                if(rs.getString("DATA_FIM") != null){
                    d.setDataFim(rs.getString("DATA_FIM"));                           
                }
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return d;
    }    
    
}
