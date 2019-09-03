package model;

import java.sql.SQLException;
import java.util.List;

public class JogadorDAO extends DAO<Jogador> {
    @Override
    public long insere(Jogador jogador) throws SQLException {
        return 0;
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
