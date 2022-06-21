/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import cruds.CrudDepartamentos;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Departamento;


public class VentanaDepartamentos extends javax.swing.JFrame {
    public void buscarPorCampo(){
        if(tnoDepartamento.getText().isEmpty() && !tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM departments WHERE dept_name LIKE'"+tNombre.getText()+"%'");
        }else if(!tnoDepartamento.getText().isEmpty() && tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM departments WHERE dept_no LIKE'"+tnoDepartamento.getText()+"%'");
        }else if(tnoDepartamento.getText().isEmpty() && tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM departments");
        }else if(!tnoDepartamento.getText().isEmpty() && !tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM departments WHERE dept_name LIKE'"+tNombre.getText()+"%' AND dept_no LIKE'"+tnoDepartamento.getText()+"%'");
            }
        } 
    public void atuaclizaTabla(JTable tabla) {
		try {
			String controlador = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/employees";
			String Consulta = "SELECT * FROM departments";		
			ResulSetTableModel modeloDatos = null;
			try {
				modeloDatos = new ResulSetTableModel(controlador, url, Consulta);
			}catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(getContentPane(), ex);
			}
			tabla.setModel(modeloDatos);
		}//Try
		catch (Exception sqle) {
			JOptionPane.showMessageDialog(getContentPane(), sqle);
		}
	}
    public void atuaclizaTablaSQL(String sql) {
		try {
			String controlador = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/employees";
			ResulSetTableModel modeloDatos = null;
			try {
				modeloDatos = new ResulSetTableModel(controlador, url, sql);
			}catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(getContentPane(), ex);
			}
			tabla.setModel(modeloDatos);
		}//Try
		catch (Exception sqle) {
			JOptionPane.showMessageDialog(getContentPane(), sqle);
		}
	}
    public void limpiarCajas(){
        tnoDepartamento.setText("");
        tNombre.setText("");
        
    }
    public VentanaDepartamentos() {
        initComponents();
        atuaclizaTabla(tabla);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGrupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tnoDepartamento = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        escroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        toggBAltas = new javax.swing.JToggleButton();
        toggBBajas = new javax.swing.JToggleButton();
        toggBCambios = new javax.swing.JToggleButton();
        toggBConsultas = new javax.swing.JToggleButton();
        jLfiltroConsulta = new javax.swing.JLabel();
        jComboBFiltroConsulta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero de Departamento");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("DEPARTAMENTOS");

        tnoDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoDepartamentoActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre");

        btnAccion.setText("-");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(102, 204, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        escroll.setViewportView(tabla);

        bGrupo.add(toggBAltas);
        toggBAltas.setText("Altas");
        toggBAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBAltasActionPerformed(evt);
            }
        });

        bGrupo.add(toggBBajas);
        toggBBajas.setText("Bajas");
        toggBBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBBajasActionPerformed(evt);
            }
        });

        bGrupo.add(toggBCambios);
        toggBCambios.setText("Cambios");
        toggBCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBCambiosActionPerformed(evt);
            }
        });

        bGrupo.add(toggBConsultas);
        toggBConsultas.setText("Consultas");
        toggBConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBConsultasActionPerformed(evt);
            }
        });

        jLfiltroConsulta.setText("Filtro de Consulta: ");

        jComboBFiltroConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. Departamento", "Nombre", "Todos" }));
        jComboBFiltroConsulta.setToolTipText("");
        jComboBFiltroConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBFiltroConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(tnoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLfiltroConsulta)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toggBAltas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBBajas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBConsultas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(314, 314, 314))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toggBAltas)
                    .addComponent(toggBBajas)
                    .addComponent(toggBCambios)
                    .addComponent(toggBConsultas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLfiltroConsulta)
                            .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tnoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnoDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoDepartamentoActionPerformed
        
    }//GEN-LAST:event_tnoDepartamentoActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        if(toggBAltas.isSelected()){
             String noDp = tnoDepartamento.getText() ;
        String nombre = tNombre.getText();
        
        if(noDp.equals("")||nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Algun campo quedo sin ser llenado");
        }else{
             if(noDp.length()>4){
             JOptionPane.showMessageDialog(null, "El numero de departamento debe ser de maximo 4 digitos ");
            }else{   
                 
            Departamento depa = new Departamento(noDp,nombre);
            CrudDepartamentos cd = new CrudDepartamentos();
            if(cd.insert(depa)){
            }else{
                JOptionPane.showMessageDialog(null, "Registro existente, si desea modificarlo vaya a MODIFICAR");
            }}
            atuaclizaTabla(tabla);

        }
        }else if(toggBBajas.isSelected()){
            
        }else if(toggBCambios.isSelected()){
            
        }else if(toggBConsultas.isSelected()){
            
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Ninguna opcion Seleccionada");
        }
    }//GEN-LAST:event_btnAccionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        tnoDepartamento.setText("");
        tNombre.setText("");

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        setVisible(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void toggBAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBAltasActionPerformed
        btnAccion.setText("Añadir");
        btnAccion.setBackground(Color.green);
        tnoDepartamento.setEnabled(true);
        tNombre.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();

    }//GEN-LAST:event_toggBAltasActionPerformed

    private void toggBBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBBajasActionPerformed
        btnAccion.setText("Eliminar");
        btnAccion.setBackground(Color.red);
        tnoDepartamento.setEnabled(true);
        tNombre.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBBajasActionPerformed

    private void toggBCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBCambiosActionPerformed
        btnAccion.setText("Guardar");
        btnAccion.setBackground(Color.MAGENTA);
        tnoDepartamento.setEnabled(true);
        tNombre.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBCambiosActionPerformed

    private void toggBConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBConsultasActionPerformed
        btnAccion.setText("Buscar");
        btnAccion.setBackground(Color.BLUE);
        tnoDepartamento.setEnabled(true);
        tNombre.setEnabled(false);
        jLfiltroConsulta.setVisible(true);
        jComboBFiltroConsulta.setVisible(true);
        jComboBFiltroConsulta.setSelectedIndex(0);
        limpiarCajas();
    }//GEN-LAST:event_toggBConsultasActionPerformed

    private void jComboBFiltroConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBFiltroConsultaActionPerformed
        limpiarCajas();
        if(jComboBFiltroConsulta.getSelectedIndex()==0){
            tnoDepartamento.setEnabled(true);
            tNombre.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==1){
            tnoDepartamento.setEnabled(false);
            tNombre.setEnabled(true);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==2){
            tnoDepartamento.setEnabled(true);
            tNombre.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBFiltroConsultaActionPerformed

    
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
            java.util.logging.Logger.getLogger(VentanaDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDepartamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDepartamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGrupo;
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JScrollPane escroll;
    private javax.swing.JComboBox<String> jComboBFiltroConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLfiltroConsulta;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tnoDepartamento;
    private javax.swing.JToggleButton toggBAltas;
    private javax.swing.JToggleButton toggBBajas;
    private javax.swing.JToggleButton toggBCambios;
    private javax.swing.JToggleButton toggBConsultas;
    // End of variables declaration//GEN-END:variables
}
