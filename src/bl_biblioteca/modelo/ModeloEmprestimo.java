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
public class ModeloEmprestimo {
    private int codigo;
    private int atendente;
    private int users;
    private int exemplar;
    private Date data_hora;
    private boolean status;

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
     * @return the atendente
     */
    public int getAtendente() {
        return atendente;
    }

    /**
     * @param atendente the atendente to set
     */
    public void setAtendente(int atendente) {
        this.atendente = atendente;
    }

    /**
     * @return the users
     */
    public int getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(int users) {
        this.users = users;
    }

    /**
     * @return the data_hora
     */
    public Date getData_hora() {
        return data_hora;
    }

    /**
     * @param data_hora the data_hora to set
     */
    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    /**
     * @return the exemplar
     */
    public int getExemplar() {
        return exemplar;
    }

    /**
     * @param exemplar the livro to set
     */
    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
