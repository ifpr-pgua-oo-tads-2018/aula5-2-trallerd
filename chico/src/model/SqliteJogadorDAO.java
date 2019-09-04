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

        return id;
    }

    @Override
    public boolean atualiza(Jogador p) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection,"UPDATE Jogador SET nome=?, email=? WHERE id=?",p.getNome(),p.getEmail(),p.getId());
        connection.close();
        return true;
    }

    @Override
    public boolean deleta(Jogador p) throws SQLException {
        Connection connection = FabricaConexao.getConnection();
        dbAccess.update(connection,"DELETE FROM Jogador where id=?",p.getId());
        connection.close();
        return true;
    }

    @Override
    public Jogador buscaId(int id) throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        Jogador p =dbAccess.query(connection,"SELECT * FROM Jogador WHERE id=?",new BeanHandler<Jogador>(Jogador.class),id);

        connection.close();
        return p;

    }

    @Override
    public List<Jogador> buscaAtributo(JogadorAtributoBusca atributo, Object email) throws SQLException {
        String where = "";
        String valorWhere = "";

        switch (atributo){
            case NOME:
                where = "where nome like ?";
                valorWhere = "%"+email.toString()+"%";
                break;
        }

        Connection connection = FabricaConexao.getConnection();
        List<Jogador> lista = dbAccess.query(connection,"SELECT * FROM Jogador "+where,new BeanListHandler<Jogador>(Jogador.class),valorWhere);

        connection.close();

        return lista;

    }
    public List<Jogador> buscaTodos() throws SQLException {
        Connection connection = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(connection,"SELECT * FROM Jogador",new BeanListHandler<Jogador>(Jogador.class));

        connection.close();

        return lista;
    }
}
