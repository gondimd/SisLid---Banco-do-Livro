/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.modelo;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public class ModeloLivro {
    
    private int registro;
    private String titulo;
    private int volume;
    private String serie;
    private int exemplar;
    private int ano_publicacao;
    private Date data_saida;
    private Date data_entrada;  
    private int autor;
    private int editora;
    private int area;
        
    private boolean contem; // variavel utilizada para verificar se existe registro no banco

    public ModeloLivro() {
        this.contem = false;
    }

    /**
     * @return the registro
     */
    public int getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(int registro) {
        this.registro = registro;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the ano_publicacao
     */
    public int getAno_publicacao() {
        return ano_publicacao;
    }

    /**
     * @param ano_publicacao the ano_publicacao to set
     */
    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    /**
     * @return the data_saida
     */
    public Date getData_saida() {
        return data_saida;
    }

    /**
     * @param data_saida the data_saida to set
     */
    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    /**
     * @return the data_entrada
     */
    public Date getData_entrada() {
        return data_entrada;
    }

    /**
     * @param data_entrada the data_entrada to set
     */
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * @return the autor
     */
    public int getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(int autor) {
        this.autor = autor;
    }

    /**
     * @return the editora
     */
    public int getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(int editora) {
        this.editora = editora;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * @return the exemplar
     */
    public int getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the exemplar to set
     */
    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the contem
     */
    public boolean isContem() {
        return contem;
    }

    /**
     * @param contem the contem to set
     */
    public void setContem(boolean contem) {
        this.contem = contem;
    }

}
