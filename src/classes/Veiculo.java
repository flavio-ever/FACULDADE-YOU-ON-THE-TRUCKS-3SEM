/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author elvis
 */
public class Veiculo {
    
    private String placa;
    private Integer marca_int;
    private String marca_str;
    private String modelo;
    private String cor;
    private Integer portas; //2 ou 4
    private String ano;
    private String classe;
    private float preco_dia;
    private String categoria;  //(hacth, sedan)

    public Integer getMarcaInt() {
        return marca_int;
    }

    public void setMarcaInt(Integer marca) {
        this.marca_int = marca;
    }
    
    public String getMarcaStr() {
        return marca_str;
    }

    public void setMarcaStr(String marca) {
        this.marca_str = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getPortas() {
        return portas;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public float getPrecoDia() {
        return preco_dia;
    }

    public void setPrecoDia(float preco) {
        this.preco_dia = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
