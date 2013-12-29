/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Membro;

/**
 *
 * @author Arlindo
 */
public class MembroDAO {
    
    Statement stmt;
    
    //NO CADASTRA SE O CPF EXISTE NAO CADASTRO.
    public boolean cadastraMembro (Membro m){
        if(m != null){
            ResultSet rs_cpf;
            String comandoSql_cpf = "SELECT * FROM MEMBRO WHERE CPF like '"+m.getCpf()+"'";
            String comandoSql = "INSERT INTO MEMBRO (NOME,NOMEPAI,NOMEMAE,CPF,RG,DATABATISMO,DATANASCIMENTO,CONGREGACAO,NATURALIDADE,STATUS,SEXO,TELEFONE) " +
            "VALUES ('"+m.getNome()+"','"+m.getNomeDoPai()+"', '"+m.getNomeDaMae()+"', '"+m.getCpf()+"', '"+m.getRg()+"', '"+m.getDataBatismo()+"', '"+m.getDataNascimento()+"', '"+m.getCongregacao()+"', '"+m.getNaturalidade()+"', 'ATUAL', '"+m.getSexo()+"', '"+m.getTelefone()+"');"; 
            System.out.println(comandoSql_cpf);
            System.out.println(comandoSql);
            try{
                java.sql.Statement stmt = (Statement)Myconnection.getStatement();
                rs_cpf = stmt.executeQuery(comandoSql_cpf);
                if(rs_cpf.first() == false){ // SE NÃO EXISTE CPF -> CADASTRE Se for para atualizar mudo o q achou para velho e adiciono
                    stmt.executeUpdate(comandoSql);
                    stmt.close();
                    System.out.println(rs_cpf.first());
                    return true;
                }
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
    public void AtualizarStatus(int id) {
        
            String comandoSQL = "UPDATE membro SET STATUS='ANTIGO' WHERE id = "+id;
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
    
    public boolean cadastraMembro (Membro m, int id_antigo){
        if(m != null){
           
            String comandoSql = "INSERT INTO MEMBRO (NOME,NOMEPAI,NOMEMAE,CPF,RG,DATABATISMO,DATANASCIMENTO,CONGREGACAO,NATURALIDADE,STATUS,SEXO,TELEFONE,ID_ANTERIOR) " +
            "VALUES ('"+m.getNome()+"','"+m.getNomeDoPai()+"', '"+m.getNomeDaMae()+"', '"+m.getCpf()+"', '"+m.getRg()+"', '"+m.getDataBatismo()+"', '"+m.getDataNascimento()+"', '"+m.getCongregacao()+"', '"+m.getNaturalidade()+"', 'ATUAL', '"+m.getSexo()+"', '"+m.getTelefone()+"', '"+id_antigo+"');"; 
            
             AtualizarStatus(id_antigo);
            
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
    
     public void cadastrarMembroAux(String cpf, String nome) throws Exception {
        
            ResultSet rs_crm;
            String comandoSQL_crm ="SELECT * FROM membro_aux WHERE cpf_membro =" + cpf ;
            String comandoSQL = "insert into membro_aux(cpf_membro,nome_membro) values('"+cpf+"','"+nome+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    rs_crm = stmt.executeQuery(comandoSQL_crm);
                    
                    if(rs_crm.first() == false){
                        stmt.executeUpdate(comandoSQL);
           
                    }
                    else{
                        System.out.println("Erro em mebro aux");
                    }
                    stmt.close();
            } catch (SQLException e) {
               //JOptionPane.showMessageDialog(null,"Erro ao cadastrar medico."+e.getMessage());
                e.getStackTrace();
            }
        
    }
     
     public void excluirMembroAux() throws Exception {
        
            String comandoSQL;
            String comandoSQL2;
            comandoSQL ="DELETE FROM `mebro_aux` WHERE 1";
            
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                           e.printStackTrace();
            }
         
       
    }
     
      
    
    public Membro buscaMembro(String cpf){
        String sql = "SELECT * FROM MEMBRO WHERE STATUS like 'ATUAL' AND CPF like '"+ cpf+"'";
        ResultSet rs;
        try{
            stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
           /* InputStream input = rs.getBinaryStream("FOTO");
            ByteArrayOutputStream output = new ByteArrayOutputStream();  
            // set read buffer size  

            byte[] rb = new byte[1024];  
            int ch = 0;  

            while ((ch = input.read(rb)) != -1){   
                output.write(rb, 0, ch);  
            }  

            // transfer to byte buffer  
            byte[] foto = output.toByteArray();  
            input.close();  
            output.close();  */
  
            Membro m = new Membro(rs.getString("NOME"), rs.getString("DATABATISMO"),rs.getString("CONGREGACAO") , rs.getString("RG"), cpf,rs.getString("DATANASCIMENTO"), rs.getString("NOMEPAI"), rs.getString("NOMEMAE"), rs.getString("NATURALIDADE"),rs.getString("SEXO"), "ATUAL",rs.getString("TELEFONE"));
            m.setId(rs.getInt("id"));
            stmt.close();
            return m;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    
    public List listaMembro(String nome){
        ResultSet rs;
        List lista = new ArrayList();
        String sql = "SELECT * FROM MEMBRO WHERE STATUS like 'ATUAL' AND nome like '%"+ nome +"%' ORDER BY NOME";
        try{
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
               /* InputStream input = rs.getBinaryStream("FOTO");
                ByteArrayOutputStream output = new ByteArrayOutputStream();  
                // set read buffer size  

                byte[] rb = new byte[1024];  
                int ch = 0;  

                while ((ch = input.read(rb)) != -1){   
                    output.write(rb, 0, ch);  
                }  

                // transfer to byte buffer  
                byte[] foto = output.toByteArray();  
                input.close();  
                output.close();  */
                Membro m = new Membro(rs.getString("NOME"), rs.getString("DATABATISMO"),rs.getString("CONGREGACAO") , rs.getString("RG"), rs.getString("CPF"),rs.getString("DATANASCIMENTO"), rs.getString("NOMEPAI"), rs.getString("NOMEMAE"), rs.getString("NATURALIDADE"),rs.getString("SEXO"), "ATUAL", rs.getString("TELEFONE"));
                 m.setId(rs.getInt("id"));
                lista.add(m);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    
    
}
