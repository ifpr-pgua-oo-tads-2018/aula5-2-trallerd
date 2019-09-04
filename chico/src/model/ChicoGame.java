package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChicoGame {

    private static String ARQ = "chicogame.bin";

    private ObservableList<Jogador> cadastro;
    private ObservableList<Jogador> clientes;


   private JogadorDAO Jogadordao = new SqliteJogadorDAO();


    private static ChicoGame instance = new ChicoGame();


    private ChicoGame(){
        cadastro = FXCollections.observableArrayList();
        clientes = FXCollections.observableArrayList();
    }

    public static ChicoGame getInstance(){
        return instance;
    }

    public void cadastra(String nome, String email,String senha) throws SQLException{
        Jogador p;
        p = new Jogador();
        p.setNome(nome);
        p.setEmail(email);
        p.setSenha(senha);


        long id = Jogadordao.insere(p);

        p.setId((int)id);

    }

    public void cadastraJogador(Jogador c){
        try{
            Connection con = FabricaConexao.getConnection();

            PreparedStatement stm = con.prepareStatement("INSERT INTO Jogador(NOME,email,senha) VALUES (?,?,?)");

            stm.setString(1,c.getNome());
            stm.setString(2,c.getEmail());
            stm.setString(3,c.getSenha());

            stm.executeUpdate();

            stm.close();
            con.close();


            cadastro.add(c);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }




    public ObservableList buscaJogadores(String texto) throws SQLException{
        cadastro.clear();

        List<Jogador> lista = Jogadordao.buscaAtributo(JogadorAtributoBusca.NOME,texto);

        cadastro.addAll(lista);

        return cadastro;
    }

    public ObservableList buscaJogador(String texto){
        clientes.clear();

        try{

            Connection con = FabricaConexao.getConnection();

            PreparedStatement stm = con.prepareStatement("SELECT * FROM Jogador where NOME like ?");

            stm.setString(1,"%"+texto+"%");

            ResultSet res = stm.executeQuery();

            while(res.next()){
                int id = res.getInt("ID");
                String nome = res.getString("NOME");
                String email = res.getString("email");
                String senha = res.getString("senha");
                long nJogadas = res.getLong("nJgadas");
                long pontos  = res.getLong("pontos");


                Jogador c = new Jogador();

                clientes.add(c);
            }

            res.close();
            stm.close();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return clientes;
    }



    public ObservableList listaJogadores(){
        clientes.clear();

        try{

            Connection con = FabricaConexao.getConnection();

            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM JOGADOR");

            while(res.next()){
                int id = res.getInt("ID");
                String nome = res.getString("NOME");
                String email = res.getString("email");
                String senha = res.getString("senha");
                long nJogadas = res.getLong("nJgadas");
                long pontos  = res.getLong("pontos");


                Jogador c = new Jogador();

                clientes.add(c);
            }

            res.close();
            stm.close();
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return clientes;
    }


    public void salva() throws IOException {

        File f = new File(ARQ);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new ArrayList<Jogador>(cadastro));

        oos.close();
        fos.close();

    }

    public void carrega() throws IOException,ClassNotFoundException{

        File f = new File(ARQ);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);


        ArrayList jogador = (ArrayList) ois.readObject();

        cadastro.addAll(jogador);


        ois.close();
        fis.close();

    }





}
