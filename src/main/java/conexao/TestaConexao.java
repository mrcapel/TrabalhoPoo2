package conexao;

import javax.swing.JOptionPane;

public class TestaConexao {
    
    public static void main(String[] args){
        
        try{
            new ConectaFactory().getConection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com banco de dados"+ erro);
        }
    }
    
    
}
