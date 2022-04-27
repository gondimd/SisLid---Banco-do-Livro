/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.modelo;

/**
 *
 * @author Diego
 */
public class ModeloEditora {
    private int codigo;
    private String nome;
    private int local; // Armazena o código do local(cidade, estado_sigla)

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the local
     */
    public int getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(int local) {
        this.local = local;
    }
    
}
