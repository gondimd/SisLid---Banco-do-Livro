/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl_biblioteca.visao;

import bl_biblioteca.controle.ConectaBanco;
import bl_biblioteca.controle.ControleExemplar;
import bl_biblioteca.modelo.ModeloExemplar;
import bl_biblioteca.modelo.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class JDExemplar extends javax.swing.JDialog {

    ConectaBanco conecta = new ConectaBanco();
    ConectaBanco conecta2 = new ConectaBanco();
    ModeloExemplar modExemplar = new ModeloExemplar();
    ControleExemplar controlExemplar = new ControleExemplar();

    public JDExemplar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        conecta.conexao();
        conecta2.conexao();
        // Atenção para vc mesclar colunas e setar o nome é necessario usar Aliases "ex: autor.nome as autor"
        preencherTabelaLivro("SELECT livro.registro as registro, livro.titulo as titulo, autor.nome as autor, "
                + "area.nome as area, livro.serie as serie, editora.nome as editora, livro.volume as volume ,"
                + "livro.ano_publicacao as publicacao\n"
                + "FROM single.livro as livro\n"
                + "inner join single.area as area\n"
                + "on livro.area = area.codigo\n"
                + "inner join single.editora as editora\n"
                + "on editora.codigo = livro.editora\n"
                + "inner join single.autor as autor \n"
                + "on autor.codigo = livro.autor\n"
                + "order by livro.registro");
    }

    public void preencherTabelaExemplar(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Título", "Autor", "Área", "Série", "Editora", "Volume", "Publicação", "Entrada"};
      //  String[] Colunas = new String[]{"Registro", "Título", "Área", "Série", "Entrada"};
        conecta2.executaSQL(sql);
        try {
            conecta2.rs.first();
            do {
                dados.add(new Object[]{conecta2.rs.getInt("exemplar"),
                    conecta2.rs.getString("titulo"), conecta2.rs.getString("autor"),
                    conecta2.rs.getString("area"), conecta2.rs.getString("serie"),
                    conecta2.rs.getString("editora"), conecta2.rs.getInt("volume"),
                    conecta2.rs.getInt("ano"), conecta2.rs.getString("entrada")});
            } while (conecta2.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao exibir tabela! \n ERRO:" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableExemplar.setModel(modelo);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableExemplar.getColumnModel().getColumn(0).setResizable(false);
        jTableExemplar.getTableHeader().setReorderingAllowed(false);
//        jTableExemplar.setAutoResizeMode(jTableExemplar.AUTO_RESIZE_OFF);
        jTableExemplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void preencherTabelaLivro(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Título", "Autor", "Área", "Série", "Editora", "Volume", "Publicação"};
        conecta.executaSQL(sql);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("registro"), conecta.rs.getString("titulo"), conecta.rs.getString("autor"), conecta.rs.getString("area"), conecta.rs.getString("serie"), conecta.rs.getString("editora"), conecta.rs.getInt("volume"), conecta.rs.getInt("publicacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //  JOptionPane.showMessageDialog(rootPane, "Erro ao exibir tabela! \n ERRO:" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableLivro.setModel(modelo);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(266);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableLivro.getColumnModel().getColumn(0).setResizable(false);
        jTableLivro.getTableHeader().setReorderingAllowed(false);
        //jTableLivro.setAutoResizeMode(jTableLivro.AUTO_RESIZE_OFF);
        jTableLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerExemplar = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jDateChooserEntrada = new com.toedter.calendar.JDateChooser();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableExemplar = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldRegistro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldArea = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldEditora = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldSerie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldVolume = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Exemplares");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableLivro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableLivro.setToolTipText("Clique em um livro, para que seja feito o cadastro de exmplares do mesmo");
        jTableLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLivro);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Selecione um livro, informe a quantidade e a data de entrada:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Quantidade:");

        jSpinnerExemplar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jSpinnerExemplar.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));
        jSpinnerExemplar.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Data de entrada:");

        jDateChooserEntrada.setEnabled(false);
        jDateChooserEntrada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jDateChooserEntrada.setPreferredSize(new java.awt.Dimension(97, 20));

        jButtonCadastrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setEnabled(false);
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancelar.setText("Cancelar");

        jLabel11.setText("* Campos Obrigatórios.  Obs: Para realizar um cadastro, clique em um livro na tabela ao lado.");

        jLabel12.setText("*");

        jLabel13.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCadastrar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel2))
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jDateChooserEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jSpinnerExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel12))))))))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jDateChooserEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCadastrar)
                            .addComponent(jButtonNovo)
                            .addComponent(jButtonCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableExemplar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableExemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableExemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableExemplarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableExemplar);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldRegistro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldRegistro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldRegistro.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Registro:");

        jTextFieldTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTitulo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldTitulo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Título:");

        jTextFieldAutor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldAutor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldAutor.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Autor:");

        jTextFieldArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldArea.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Área:");

        jTextFieldEditora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldEditora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldEditora.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Editora:");

        jTextFieldSerie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldSerie.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Série:");

        jTextFieldVolume.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldVolume.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldVolume.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Volume:");

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonExcluir)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTitulo)
                            .addComponent(jTextFieldAutor)
                            .addComponent(jTextFieldArea)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldSerie))))
                .addGap(17, 43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36)
                .addComponent(jButtonExcluir)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLivroMouseClicked
        int linhaSelecionada = jTableLivro.getSelectedRow();
        Date data_entrada = null;
        String registro = jTableLivro.getValueAt(linhaSelecionada, 0).toString();
        preencherTabelaExemplar("SELECT exemplar.registro as exemplar, to_char(exemplar.data_entrada, 'DD/MM/YYYY') as entrada, livro.registro as registro, livro.titulo as titulo, autor.nome as autor,\n"
                + "area.nome as area, livro.serie as serie, editora.nome as editora, livro.volume as volume, livro.ano_publicacao as ano\n"
                + "FROM single.livro as livro\n"
                + "inner join single.area as area\n"
                + "on livro.area = area.codigo\n"
                + "inner join single.editora as editora\n"
                + "on editora.codigo = livro.editora\n"
                + "inner join single.autor as autor\n"
                + "on autor.codigo = livro.autor\n"
                + "inner join single.exemplar as exemplar\n"
                + "on exemplar.livro = livro.registro\n"
                + "where livro.registro = " + registro + "\n"
                + "order by livro.registro");
    }//GEN-LAST:event_jTableLivroMouseClicked

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        try {
               int linhaSelecionada =  -1;
               linhaSelecionada = jTableLivro.getSelectedRow();
            Date temp = null;
            if (jDateChooserEntrada.getDate() == temp ||linhaSelecionada < 0 ) {
                JOptionPane.showMessageDialog(rootPane, "Campo(s) vazios! "
                        + "\nPor favor verifique se todos os campos foram preenchidos corretamente");
            } else {
                // É enviado para o objeto exemplar
                modExemplar.setQuant(Integer.parseInt(jSpinnerExemplar.getValue().toString()));
                Calendar c = Calendar.getInstance();
                c.setTime(jDateChooserEntrada.getDate());
                modExemplar.setData_entrada(new java.sql.Date(c.getTimeInMillis()));
                // pega o objeto da tabela clicada pelo usuário, e seta o valor do registro na variavel linha selecionada
            //    int linhaSelecionada = jTableLivro.getSelectedRow();
                linhaSelecionada = (int) jTableLivro.getValueAt(linhaSelecionada, 0);
                modExemplar.setLivro(linhaSelecionada);
                int reply = JOptionPane.showConfirmDialog(null, "Deseja efetuar o cadastro do exemplar informado?", "Confirmação de cadastro de exemplar", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    controlExemplar.inserirExemplar(modExemplar);
                    //LIMPA CAMPOS
                    jTextFieldTitulo.setText("");
                    jTextFieldSerie.setText("");
                    jTextFieldVolume.setText("");
                    jTextFieldRegistro.setText("");
                    jDateChooserEntrada.setDate(null);
                    jButtonNovo.setEnabled(true);
                    String registro = jTableLivro.getValueAt(linhaSelecionada, 0).toString();
                    atualizarTabelaLivro();
                } else {
                    //LIMPA CAMPOS
                    jTextFieldTitulo.setText("");
                    jTextFieldSerie.setText("");
                    jTextFieldVolume.setText("");
                    jTextFieldRegistro.setText("");
                    jDateChooserEntrada.setDate(null);
                    jButtonNovo.setEnabled(true);
                    String registro = jTableLivro.getValueAt(linhaSelecionada, 0).toString();
                    atualizarTabelaLivro();
                }
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        jTextFieldTitulo.setText("");
        jTextFieldVolume.setText("");
        jTextFieldSerie.setText("");
        jTextFieldRegistro.setText("");
        jTextFieldArea.setText("");
        jTextFieldAutor.setText("");
        jTextFieldEditora.setText("");
        jDateChooserEntrada.setEnabled(true);
        jSpinnerExemplar.setEnabled(true);

        jTextFieldRegistro.setEnabled(false);
        jDateChooserEntrada.setDate(null);
        jButtonExcluir.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonCadastrar.setEnabled(true);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableExemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableExemplarMouseClicked
        int linhaSelecionada = jTableExemplar.getSelectedRow();
        jTextFieldRegistro.setText(jTableExemplar.getValueAt(linhaSelecionada, 0).toString());
        jTextFieldTitulo.setText(jTableExemplar.getValueAt(linhaSelecionada, 1).toString());
        jTextFieldAutor.setText(jTableExemplar.getValueAt(linhaSelecionada, 2).toString());
        jTextFieldArea.setText(jTableExemplar.getValueAt(linhaSelecionada, 3).toString());
        jTextFieldSerie.setText(jTableExemplar.getValueAt(linhaSelecionada, 4).toString());
        jTextFieldEditora.setText(jTableExemplar.getValueAt(linhaSelecionada, 5).toString());
        jTextFieldVolume.setText(jTableExemplar.getValueAt(linhaSelecionada, 6).toString());
        jButtonExcluir.setEnabled(true);
    }//GEN-LAST:event_jTableExemplarMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o exemplar selecionado?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            modExemplar.setRegistro(Integer.parseInt(jTextFieldRegistro.getText()));
            controlExemplar.excluirExemplar(modExemplar);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    public void atualizarTabelaLivro() {
        preencherTabelaLivro("SELECT livro.registro as registro, livro.titulo as titulo, autor.nome as autor, "
                + "area.nome as area, livro.serie as serie, editora.nome as editora, livro.volume as volume ,"
                + "livro.ano_publicacao as publicacao\n"
                + "FROM single.livro as livro\n"
                + "inner join single.area as area\n"
                + "on livro.area = area.codigo\n"
                + "inner join single.editora as editora\n"
                + "on editora.codigo = livro.editora\n"
                + "inner join single.autor as autor \n"
                + "on autor.codigo = livro.autor\n"
                + "order by livro.registro");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDExemplar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDExemplar dialog = new JDExemplar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private com.toedter.calendar.JDateChooser jDateChooserEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerExemplar;
    private javax.swing.JTable jTableExemplar;
    private javax.swing.JTable jTableLivro;
    private javax.swing.JTextField jTextFieldArea;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldEditora;
    private javax.swing.JTextField jTextFieldRegistro;
    private javax.swing.JTextField jTextFieldSerie;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextField jTextFieldVolume;
    // End of variables declaration//GEN-END:variables
}
