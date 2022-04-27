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
public class ModeloExemplar {
    private int registro;
    private Date data_entrada;
    private Date data_saida;
    private int emprestimo;
    private int livro;
    private int quant; // quantidade de exeplares que serao cadastrados
    private String pesquisa;  // usado no metodo de busca classe controle exemplar
    public String titulo;    // usado no metodo de busca classe controle exemplar

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
     * @return the emprestimo
     */
    public int getEmprestimo() {
        return emprestimo;
    }

    /**
     * @param emprestimo the emprestimo to set
     */
    public void setEmprestimo(int emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     * @return the livro
     */
    public int getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(int livro) {
        this.livro = livro;
    }

    /**
     * @return the quant
     */
    public int getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(int quant) {
        this.quant = quant;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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
}
