package model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqliteJogadorDAO implements JogadorDAO {

    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public long insere(Jogador p) throws SQLException {

        Connection connection = FabricaConexao.getConnection();
        long id = dbAccess.insert(connection,"INSERT INTO Jogador(email,nome,senha) VALUES (?,?,?)",
                            new ScalarHandler<Integer>(),p.getEmail(),p.getNome(),p.getSenha()).longValue();
        connection.close();
        throw new SQLException("SQL Inválido...");

        return id;
    }

    @Override
    public boolean atualiza(Jogador p) throws SQLException {
        return false;
    }

    @Override
    public boolean deleta(Jogador p) throws SQLException {
        return false;
    }

    @Override
    public Jogador buscaId(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Jogador> buscaTodos() throws SQLException {
        return null;
    }
}
