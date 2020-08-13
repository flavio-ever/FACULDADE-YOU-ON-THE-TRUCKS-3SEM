/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Veiculo;
import dao.VeiculoDAO;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Util;

/**
 *
 * @author flavi
 */
public class frmVeiculos extends javax.swing.JFrame {

    /**
     * Creates new form frmVeiculo
     */
    public frmVeiculos() {
        initComponents();
        
        loadVeiculos("", "");
        loadMarcas();
    }
    
    // Imports Globais
    private Util util = new Util();
    private Veiculo gVeiculo = new Veiculo();
    private boolean modoEdicao = false;
    private ArrayList<Veiculo> veiculoRequest = null;
    private ArrayList<Veiculo> marcasRequest = null;
    
    /**
     * Metodo que limpa todos os campos necessários
     *
     * @author Flavio Ever
     * @since 10/05/2020
     */
    public void resetCampos() {
        txtModelo.setText("");
        cbMarca.setSelectedIndex(0);
        opt2.isSelected();
        txtCor.setText("");
        cbCategoria.setSelectedIndex(0);
        txtAno.setText("");
        txtPlaca.setText("");
        cbCategoria.setSelectedIndex(0);
        txtPrecoDia.setText("0");
        
        tbVeiculo.getSelectionModel().clearSelection();
        
        // Restaura os botões
        modoEdicao(false);
    }
    

    /**
     * Metodo que pega o que foi clicado na Grid e transmite nos Inputs do
     * cadastro para edição ou restaura o estado anterior do programa
     *
     * @author Flavio Ever
     * @param modo modo de edicao
     * @since 10/05/2020
     */
    public void modoEdicao(Boolean modo) {
        // Muda sentido
        modoEdicao = modo;

        // Entra com os dados nos inputs
        if (modo) {
            txtModelo.setText(gVeiculo.getModelo());
            cbMarca.setSelectedItem(gVeiculo.getMarcaStr());
            
            // Portas
            if (gVeiculo.getPortas().equals(2)) {
                opt2.setSelected(true);
            }
            if (gVeiculo.getPortas().equals(4)) {
                opt4.setSelected(true);
            }
            
            txtCor.setText(gVeiculo.getCor());
            cbCategoria.setSelectedItem(gVeiculo.getCategoria());
            txtAno.setText(gVeiculo.getAno());
            txtPlaca.setText(gVeiculo.getPlaca());
            cbClasse.setSelectedItem(gVeiculo.getClasse());
            txtPrecoDia.setText(String.valueOf(gVeiculo.getPrecoDia()));
            
            // Obs: O restante dos itens como valor, qtd e total já estão carregados no objeto;

            // Muda sentido botoes
            btnCadastrar.setText("Alterar");
            mnCadastrar.setText("Alterar");

            btnVoltar.setEnabled(true);
            mnVoltar.setEnabled(true);

            btnRemover.setEnabled(true);
            mnRemover.setEnabled(true);
            
            txtPlaca.setEnabled(false);
            
            return;
        }

        // Falso
        btnVoltar.setEnabled(false);
        mnVoltar.setEnabled(false);

        btnRemover.setEnabled(false);
        
        mnRemover.setEnabled(false);

        txtPlaca.setEnabled(true);
        
        btnCadastrar.setText("Cadastrar");
        mnCadastrar.setText("Cadastrar");
    }
    
    /**
     * Metodo que carrega os veiculos
     *
     * @author Flavio Ever
     * @param marca marca do veiculo
     * @param modelo modelo do veiculo
     * @since 10/05/2020
     */
    public void loadVeiculos(String marca, String modelo) {
        String titulos[] = {"Placa", "Marca", "Modelo", "Cor", "Portas", "Ano", "Classe", "Preço Dia", "Categoria"};

        DefaultTableModel modelGrid = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Desabilita edição da jTable
                return false;
            }
        };

        veiculoRequest = (ArrayList<Veiculo>) new VeiculoDAO().index(marca, modelo);

        for (int i = 0; i < veiculoRequest.size(); i++) {
            modelGrid.addRow(new Object[]{
                veiculoRequest.get(i).getPlaca(),
                veiculoRequest.get(i).getMarcaStr(),
                veiculoRequest.get(i).getModelo(),
                veiculoRequest.get(i).getCor(),
                veiculoRequest.get(i).getPortas(),
                veiculoRequest.get(i).getAno(),
                veiculoRequest.get(i).getClasse(),
                "R$" + veiculoRequest.get(i).getPrecoDia(),
                veiculoRequest.get(i).getCategoria()}
            );
        }

        tbVeiculo.setModel(modelGrid);
     }
    
    /**
     * Metodo que carrega os veiculos
     *
     * @author Flavio Ever
     * @since 10/05/2020
     */
    public void loadMarcas() {
        marcasRequest = (ArrayList<Veiculo>) new VeiculoDAO().ListaMarcas();

        cbMarca.addItem("Escolha");
        cbMarcaPesq.addItem("Escolha");
        for (int i = 0; i < marcasRequest.size(); i++) {
            cbMarca.addItem(marcasRequest.get(i).getMarcaStr());
            cbMarcaPesq.addItem(marcasRequest.get(i).getMarcaStr());
        }
     }
    
    /**
     * Metodo que consiste os inputs principais
     *
     * @author Flavio Ever
     * @return Boolean se está ok ou não
     * @since 10/05/2020
     */
    public boolean consistir() {
        
        if (txtModelo.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "Modelo: Escreva um modelo!");
            return false;
        }
        
        if (cbMarca.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Marca: Es colha uma marca válida!");
            return false;
        }
        
        if (txtCor.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "Cor: Cor inválida!");
            return false;
        }
        
        if (txtAno.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Ano: Ano inválido!");
            return false;
        }
        
        if (txtPlaca.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Placa: Placa inválida!");
            return false;
        }
        
        if (Float.parseFloat(txtPrecoDia.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "Preço dia: Valor inválido!");
            return false;
        }

        return true;
    }

    /**
     * Metodo que monta o objeto Veiculo
     *
     * @author Flavio Ever
     * @return Veiculo estrutura do Veiculo
     * @since 10/05/2020
     */
    public Veiculo objVeiculo() {
        gVeiculo.setModelo(txtModelo.getText());
        gVeiculo.setMarcaInt(marcasRequest.get(cbMarca.getSelectedIndex() -1).getMarcaInt()); // Marca do veiculo a partir de outro request
        
        // Portas
        if (opt2.isSelected()) {
            gVeiculo.setPortas(2);
        }
        if (opt4.isSelected()) {
            gVeiculo.setPortas(4);
        }
        
        gVeiculo.setCor(txtCor.getText());
        gVeiculo.setCategoria(cbCategoria.getSelectedItem().toString());
        gVeiculo.setAno(txtAno.getText());
        gVeiculo.setPlaca(txtPlaca.getText());
        gVeiculo.setClasse(cbClasse.getSelectedItem().toString());
        gVeiculo.setPrecoDia(Float.parseFloat(txtPrecoDia.getText()));

        // Obs: O restante dos itens como valor, qtd e total já estão carregados no objeto;
        return gVeiculo;
    }
    

    /**
     * Metodo que remove o ToDo
     *
     * @author Flavio Ever
     * @since 10/05/2020
     */
    public void remover() {
        VeiculoDAO todo = new VeiculoDAO();

        if (modoEdicao) {
            String rs = todo.remove(gVeiculo.getPlaca());

            if (!rs.equals("ok")) {
                JOptionPane.showMessageDialog(null, rs);
                return;
            }

            // Carrega items
            loadVeiculos("", "");

            JOptionPane.showMessageDialog(null, "Veiculo removido com sucesso!");

            // Limpa
            modoEdicao(false);
        }
    }
    /**
     * Metodo que cadastra o ToDo ou Altera o ToDo dependendo do que está
     * flegado na Grid
     *
     * @author Flavio Ever
     * @since 10/05/2020
     */
    public void cadastrar() {
        VeiculoDAO veiculos = new VeiculoDAO();

        if (consistir()) {
            if (!modoEdicao) {
                String rs = veiculos.store(objVeiculo());

                if (!rs.equals("ok")) {
                    JOptionPane.showMessageDialog(null, rs);
                    return;
                }

                // Carrega items
                loadVeiculos("", "");

                JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
                
                // Limpa
                resetCampos();
                
                return;
            }

            if (modoEdicao) {
                String rs = veiculos.update(objVeiculo());

                if (!rs.equals("ok")) {
                    JOptionPane.showMessageDialog(null, rs);
                    return;
                }

                // Carrega items
                loadVeiculos("", "");

                JOptionPane.showMessageDialog(null, "Veiculo atualizado com sucesso!");
                
                // Limpa
                resetCampos();
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        opt4 = new javax.swing.JRadioButton();
        opt2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();
        txtPrecoDia = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAlugar = new javax.swing.JButton();
        txtModelo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        txtModeloPesq = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cbMarcaPesq = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbClasse = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnCadastrar1 = new javax.swing.JMenuItem();
        mnCadastrar = new javax.swing.JMenuItem();
        mnRemover = new javax.swing.JMenuItem();
        mnVoltar = new javax.swing.JMenuItem();
        mnRemover1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veiculos (Somente não alugados)");
        getContentPane().setLayout(null);

        buttonGroup1.add(opt4);
        opt4.setText("4");
        getContentPane().add(opt4);
        opt4.setBounds(600, 50, 40, 30);

        buttonGroup1.add(opt2);
        opt2.setSelected(true);
        opt2.setText("2");
        getContentPane().add(opt2);
        opt2.setBounds(550, 50, 50, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel8.setText("Modelo:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 10, 210, 30);

        tbVeiculo.setAutoCreateRowSorter(true);
        tbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbVeiculoMouseReleased(evt);
            }
        });
        tbVeiculo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbVeiculoCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane3.setViewportView(tbVeiculo);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 300, 750, 140);

        txtPrecoDia.setText("0");
        txtPrecoDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecoDiaKeyReleased(evt);
            }
        });
        getContentPane().add(txtPrecoDia);
        txtPrecoDia.setBounds(650, 140, 120, 30);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.setEnabled(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAlugar.setText("Alugar");
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 249, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 460, 750, 50);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(20, 50, 260, 30);

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel13.setText("R$");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(620, 140, 30, 30);

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel12.setText("Preço dia:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(620, 100, 150, 30);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(20, 210, 750, 10);

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel16.setText("Portas:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(550, 10, 100, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel9.setText("Categoria:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 100, 150, 30);

        getContentPane().add(cbMarca);
        cbMarca.setBounds(320, 50, 190, 30);

        txtModeloPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloPesqActionPerformed(evt);
            }
        });
        txtModeloPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloPesqKeyReleased(evt);
            }
        });
        getContentPane().add(txtModeloPesq);
        txtModeloPesq.setBounds(490, 240, 280, 30);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Modelo:");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(400, 240, 90, 30);

        cbMarcaPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMarcaPesqActionPerformed(evt);
            }
        });
        getContentPane().add(cbMarcaPesq);
        cbMarcaPesq.setBounds(100, 240, 250, 30);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Marca:");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(20, 240, 80, 30);
        getContentPane().add(txtCor);
        txtCor.setBounds(670, 50, 100, 30);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel10.setText("Cor:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(670, 10, 90, 30);

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hatch", "Sedan" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategoria);
        cbCategoria.setBounds(20, 140, 120, 30);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel11.setText("Marca:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(320, 10, 150, 30);

        txtAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoKeyTyped(evt);
            }
        });
        getContentPane().add(txtAno);
        txtAno.setBounds(190, 140, 90, 30);

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel14.setText("Ano");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(190, 100, 110, 30);

        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(320, 140, 90, 30);

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel15.setText("Placa");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(320, 100, 110, 30);

        cbClasse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C" }));
        cbClasse.setToolTipText("");
        getContentPane().add(cbClasse);
        cbClasse.setBounds(470, 140, 100, 30);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel18.setText("Classe:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(470, 100, 150, 30);

        jMenu2.setText("Opções");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        mnCadastrar1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnCadastrar1.setText("Alugar");
        mnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrar1ActionPerformed(evt);
            }
        });
        jMenu2.add(mnCadastrar1);

        mnCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnCadastrar.setText("Cadastrar");
        mnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrarActionPerformed(evt);
            }
        });
        jMenu2.add(mnCadastrar);

        mnRemover.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnRemover.setText("Excluir");
        mnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemoverActionPerformed(evt);
            }
        });
        jMenu2.add(mnRemover);

        mnVoltar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnVoltar.setText("Voltar");
        mnVoltar.setEnabled(false);
        mnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVoltarActionPerformed(evt);
            }
        });
        jMenu2.add(mnVoltar);

        mnRemover1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        mnRemover1.setText("Sair");
        mnRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemover1ActionPerformed(evt);
            }
        });
        jMenu2.add(mnRemover1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(815, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbVeiculoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculoMouseReleased
        if (tbVeiculo.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum veiculo selecionado!");
        } else {
            int index = tbVeiculo.getSelectionModel().getMinSelectionIndex();
        
            gVeiculo.setPlaca(veiculoRequest.get(index).getPlaca());
            gVeiculo.setMarcaStr(veiculoRequest.get(index).getMarcaStr());
            gVeiculo.setModelo(veiculoRequest.get(index).getModelo());
            gVeiculo.setCor(veiculoRequest.get(index).getCor());
            gVeiculo.setPortas(veiculoRequest.get(index).getPortas());
            gVeiculo.setAno(veiculoRequest.get(index).getAno());
            gVeiculo.setClasse(veiculoRequest.get(index).getClasse());
            gVeiculo.setCategoria(veiculoRequest.get(index).getCategoria());
            gVeiculo.setPrecoDia(veiculoRequest.get(index).getPrecoDia());
            
            modoEdicao(true);
        }
    }//GEN-LAST:event_tbVeiculoMouseReleased

    private void tbVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculoMouseClicked

    }//GEN-LAST:event_tbVeiculoMouseClicked

    private void tbVeiculoCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbVeiculoCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbVeiculoCaretPositionChanged

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        modoEdicao(false);
        resetCampos();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void mnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_mnCadastrarActionPerformed

    private void mnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemoverActionPerformed
        remover();
    }//GEN-LAST:event_mnRemoverActionPerformed

    private void mnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVoltarActionPerformed
        modoEdicao(false);
        resetCampos();
    }//GEN-LAST:event_mnVoltarActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        modoEdicao(false);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        if (tbVeiculo.getSelectionModel().isSelectionEmpty()) {
           JOptionPane.showMessageDialog(null, "Nenhum veiculo selecionado!");
           return;
        }
        
        frmClientes cliente = new frmClientes();
        cliente.enviaAlugado(objVeiculo());
        cliente.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void txtPrecoDiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoDiaKeyReleased
        
    }//GEN-LAST:event_txtPrecoDiaKeyReleased

    private void txtModeloPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloPesqActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoKeyTyped
        if (txtAno.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAnoKeyTyped

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        if (txtPlaca.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPlacaKeyTyped

    private void txtModeloPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloPesqKeyReleased
        cbMarcaPesq.setSelectedIndex(0);
        loadVeiculos("", txtModeloPesq.getText());
    }//GEN-LAST:event_txtModeloPesqKeyReleased

    private void cbMarcaPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMarcaPesqActionPerformed
        if(cbMarcaPesq.getSelectedIndex() != 0) {        
            txtModeloPesq.setText("");
            loadVeiculos(cbMarcaPesq.getSelectedItem().toString(), "");
            return;
        }
        
        loadVeiculos("", "");
    }//GEN-LAST:event_cbMarcaPesqActionPerformed

    private void mnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrar1ActionPerformed
        if (tbVeiculo.getSelectionModel().isSelectionEmpty()) {
           JOptionPane.showMessageDialog(null, "Nenhum veiculo selecionado!");
           return;
        }
        
        frmClientes cliente = new frmClientes();
        cliente.enviaAlugado(objVeiculo());
        cliente.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_mnCadastrar1ActionPerformed

    private void mnRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemover1ActionPerformed
        dispose();
    }//GEN-LAST:event_mnRemover1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbClasse;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbMarcaPesq;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem mnCadastrar;
    private javax.swing.JMenuItem mnCadastrar1;
    private javax.swing.JMenuItem mnRemover;
    private javax.swing.JMenuItem mnRemover1;
    private javax.swing.JMenuItem mnVoltar;
    private javax.swing.JRadioButton opt2;
    private javax.swing.JRadioButton opt4;
    private javax.swing.JTable tbVeiculo;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtModeloPesq;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPrecoDia;
    // End of variables declaration//GEN-END:variables
}
