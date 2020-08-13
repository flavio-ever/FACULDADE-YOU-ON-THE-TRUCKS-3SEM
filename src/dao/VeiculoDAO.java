package dao;

import classes.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Util;

public class VeiculoDAO {

    private Util util = new Util();

    /**
     * Metodo lista os itens por titulo ou data
     *
     * @author Flavio Ever
     * @param marca marca do veiculo
     * @param modelo modelo do veiculo
     * @return List Lista de Veiculo
     * @since 10/05/2020
     */
    public List<Veiculo> index(String marca, String modelo) {
        List<Veiculo> veiculosList = new ArrayList<>();

        // Se houver algo então usar condição;
        String wMarca = marca.equals("") ? "" : "AND marca LIKE ?";
        String wTitulo = modelo.equals("") ? "" : "AND modelo LIKE ?";

        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM veiculos_view WHERE placa NOT IN (SELECT veiculo_placa FROM alugados) " + wMarca + wTitulo;
            PreparedStatement ps = con.prepareStatement(sql);

            if (!marca.equals("")) {
                ps.setString(1, "%" + marca + "%");
            }

            if (!modelo.equals("")) {
                ps.setString(1, "%" + modelo + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();

                // All
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setMarcaStr(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setPortas(rs.getInt("portas"));
                veiculo.setAno(rs.getString("ano"));
                veiculo.setClasse(rs.getString("classe"));
                veiculo.setPrecoDia(Float.parseFloat(rs.getString("preco_dia")));
                veiculo.setCategoria(rs.getString("categoria"));

                // Cria lista
                veiculosList.add(veiculo);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return veiculosList;
    }

    /**
     * Metodo lista os itens por titulo ou data
     *
     * @author Flavio Ever
     * @return List Lista de Marcas
     * @since 10/05/2020
     */
    public List<Veiculo> ListaMarcas() {
        List<Veiculo> marcasList = new ArrayList<>();
        try {

            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM marcas;";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veiculo marca = new Veiculo();

                // All
                marca.setMarcaStr(rs.getString("marca"));
                marca.setMarcaInt(rs.getInt("id"));
                // Cria lista
                marcasList.add(marca);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return marcasList;
    }

    /**
     * Metodo cria Veiculo
     *
     * @author Flavio Ever
     * @param veiculo objeto estrutura
     * @return String resultado da criacao
     * @since 10/05/2020
     */
    public String store(Veiculo veiculo) {
        String resp = "";

        try {
            Connection conn = Conecta.getConexao();

            // Estrutura objeto
            PreparedStatement psmtOut = conn.prepareStatement("SELECT * FROM veiculos WHERE placa=?");
            PreparedStatement psmtIn = conn.prepareStatement("INSERT INTO veiculos VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Incrementa objeto
            psmtOut.setString(1, veiculo.getPlaca());

            psmtIn.setString(1, veiculo.getPlaca());
            psmtIn.setInt(2, veiculo.getMarcaInt());
            psmtIn.setString(3, veiculo.getModelo());
            psmtIn.setString(4, veiculo.getCor());
            psmtIn.setInt(5, veiculo.getPortas());
            psmtIn.setString(6, veiculo.getAno());
            psmtIn.setString(7, veiculo.getClasse());
            psmtIn.setFloat(8, veiculo.getPrecoDia());
            psmtIn.setString(9, veiculo.getCategoria());

            ResultSet rs = psmtOut.executeQuery();
            if (rs.next()) {
                resp = "Ops! Placa já cadastrada";
            } else {
                psmtIn.execute();
                resp = "ok";
            }

            // Fecha possíveis conexões
            psmtOut.close();
            psmtIn.close();
            conn.close();
        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    }

    /**
     * Metodo atualiza o veiculo a partir da chave primaria
     *
     * @author Flavio Ever
     * @param veiculo objeto estrutura
     * @return String resultado da ataulizacao
     * @since 10/05/2020
     */
    public String update(Veiculo veiculo) {
        String resp = "";

        try {
            Connection conn = Conecta.getConexao();
            // Estrutura objeto
            PreparedStatement psmtIn = conn.prepareStatement("UPDATE veiculos SET marca_id=?, modelo=?, cor=?, portas=?, ano=?, classe=?, preco_dia=?, categoria=? WHERE placa=?");

            psmtIn.setInt(1, veiculo.getMarcaInt());
            psmtIn.setString(2, veiculo.getModelo());
            psmtIn.setString(3, veiculo.getCor());
            psmtIn.setInt(4, veiculo.getPortas());
            psmtIn.setString(5, veiculo.getAno());
            psmtIn.setString(6, veiculo.getClasse());
            psmtIn.setFloat(7, veiculo.getPrecoDia());
            psmtIn.setString(8, veiculo.getCategoria());
            
            // Primary Key
            psmtIn.setString(9, veiculo.getPlaca());

            psmtIn.execute();
            resp = "ok";

            // Fecha possíveis conexões
            psmtIn.close();
            conn.close();
        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    }

    /**
     * Metodo remove o veiculo a partir da chave primaria (placa)
     *
     * @author Flavio Ever
     * @param placa placa chave primaria
     * @return String resultado da remocao
     * @since 10/05/2020
     */
    public String remove(String placa) {
        String resp = "";

        try {
            Connection conn = Conecta.getConexao();

            // Estrutura objeto
            PreparedStatement psmtIn = conn.prepareStatement("DELETE FROM veiculos WHERE placa=?");

            // Primary Key
            psmtIn.setString(1, placa);

            psmtIn.execute();
            resp = "ok";

            // Fecha possíveis conexões
            psmtIn.close();
            conn.close();
        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    }

}
