package DAO;

import DTO.ProjetoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProjetoDAO {

    Connection conn;
    PreparedStatement pstm;

    public void CriarProjeto(ProjetoDTO objprojetodto) throws SQLException {
        String sql = "INSERT INTO Projeto (NomeProjeto, Autor, Descricao, Complexidade, Versao, Estado, DataCriacao, DataModificacao, Esforco"
                + ", Prioridade, Funcionalidades, Modulo) VALUES (?, ?, ?, ?, ? , ? , ? , ?, ?, ?, ?, ?)";

        Connection conn = ConexaoDAO.ConectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objprojetodto.getNome_Projeto());
            pstm.setString(2, objprojetodto.getAutor());
            pstm.setString(3, objprojetodto.getDescricao());
            pstm.setString(4, objprojetodto.getComplexidade());
            pstm.setString(5, objprojetodto.getVersao());
            pstm.setString(6, objprojetodto.getEstado());
            pstm.setString(7, objprojetodto.getData_criacao());
            pstm.setString(8, objprojetodto.getData_modificacao());
            pstm.setString(9, objprojetodto.getEsforco());
            pstm.setString(10, objprojetodto.getPrioridade());
            pstm.setString(11, objprojetodto.getFuncionalidades());
            pstm.setString(12, objprojetodto.getModulo());
            
            pstm.execute();
            pstm.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "projetoDAO" + e);
        }
    }

}
