/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.modelo;

/**
 *
 * @author Diego
 */
public class ModeloLocal {
    private int codigo;
    private String cidade;
    private String estado_sigla;

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
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado_sigla
     */
    public String getEstado_sigla() {
        return estado_sigla;
    }

    /**
     * @param estado_sigla the estado_sigla to set
     */
    public void setEstado_sigla(String estado_sigla) {
        this.estado_sigla = estado_sigla;
    }
    
}
