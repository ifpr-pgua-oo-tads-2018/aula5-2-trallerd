package model;

import java.sql.SQLException;
import java.util.List;

public interface JogadorDAO extends DAO<Jogador> {



    List<Jogador> buscaAtributo(JogadorAtributoBusca atributo, Object email) throws SQLException;
}
