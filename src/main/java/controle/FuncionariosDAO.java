package controle;

import conexao.ConectaFactory;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Funcionarios;
import visao.*;


public class FuncionariosDAO {
    private Connection con;
    
    public FuncionariosDAO(){
        
    this.con = new ConectaFactory().getConection();
    }
    
    public void cadastrarFuncionario(Funcionarios obj){
        try{
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, "
                    + "senha, cargo, nivel_acesso, telefone, celular, cep, "
                    + "endereco, numero, complemento, bairro, cidade, estado )"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt = con.prepareStatement(sql);
{
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getSenha());
                stmt.setString(6, obj.getCargo());
                stmt.setString(7, obj.getNivel_acesso());
                stmt.setString(8, obj.getTelefone());
                stmt.setString(9, obj.getCelular());
                stmt.setString(10, obj.getCep());
                stmt.setString(11, obj.getEndereco());
                stmt.setInt(12, obj.getNumero());
                stmt.setString(13, obj.getComplemento());
                stmt.setString(14, obj.getBairro());
                stmt.setString(15, obj.getCidade());
                stmt.setString(16, obj.getEstado());
                
                stmt.execute();
                stmt.close();
            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao efetuar o cadastro" +erro);
        }
        
        
    }
    
    public List<Funcionarios> listarFuncionario(){
        try{
            List<Funcionarios> lista = new ArrayList<>();
            
            String sql = "select * from tb_funcionarios";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
        }
        
       catch(SQLException erro){
           JOptionPane.showMessageDialog(null, "Erro ao listar os Dados  " +erro);
           return null;
       }
    }
    
    public void excluirFuncionarios(Funcionarios obj){
        try{
            String sql = "delete from tb_funcionarios where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir" +erro);
        }
    }
    
    public void alterarFuncionarios(Funcionarios obj){
        
        try{
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, "
                    + "nivel_acesso=?, telefone=?, celular=?, "
                    + "cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getSenha());
                stmt.setString(6, obj.getCargo());
                stmt.setString(7, obj.getNivel_acesso());
                stmt.setString(8, obj.getTelefone());
                stmt.setString(9, obj.getCelular());
                stmt.setString(10, obj.getCep());
                stmt.setString(11, obj.getEndereco());
                stmt.setInt(12, obj.getNumero());
                stmt.setString(13, obj.getComplemento());
                stmt.setString(14, obj.getBairro());
                stmt.setString(15, obj.getCidade());
                stmt.setString(16, obj.getEstado());
                stmt.setInt(17, obj.getId());
                
                stmt.execute();
            }
            
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        }
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar  " +erro);
        }
    }
    
    public Funcionarios ConsultarPorNome(String nome){
        try{
            
            String sql = "select * from tb_funcionarios where nome=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            Funcionarios obj = new Funcionarios();
            
            if(rs.next()){
             obj.setId(rs.getInt("id"));
             obj.setNome(rs.getString("nome"));
             obj.setRg(rs.getString("rg"));
             obj.setCpf(rs.getString("cpf"));
             obj.setEmail(rs.getString("email"));
             obj.setSenha(rs.getString("senha"));
             obj.setCargo(rs.getString("cargo"));
             obj.setNivel_acesso(rs.getString("nivel_acesso"));
             obj.setTelefone(rs.getString("telefone"));
             obj.setCelular(rs.getString("Celular"));
             obj.setCep(rs.getString("cep"));
             obj.setEndereco(rs.getString("endereco"));
             obj.setNumero(rs.getInt("numero"));
             obj.setComplemento(rs.getString("complemento"));
             obj.setBairro(rs.getString("bairro"));
             obj.setCidade(rs.getString("cidade"));
             obj.setEstado(rs.getString("estado"));
            }
            
            return obj;
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Funcionario Não Encontrado!  " +erro);
            return null;
        }
    }
    
    public List<Funcionarios> buscaClientePorNome(String nome){
        try{
            List<Funcionarios> lista= new ArrayList<>();
            
            String sql = "select * from tb_funcionarios where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao pesquisar!  " +erro);
            return null;
        }
    }
    
    public void efetuarLogin(String email, String senha){
        try{
            
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja Bem Vindo Ao Sistema!");
                frmMenu tela = new frmMenu();
                tela.usuarioLogado = rs.getString("nome");
                tela.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dados Incorretos");
                new frmLogin().setVisible(true);
            }
        }
        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro  " +erro);
        }
    }
    
}
