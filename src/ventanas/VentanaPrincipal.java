/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import conexionBD.Conexion;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author cesar
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    VentanaEmpleados ve ;
    VentanaAdministradores va;
    VentanaDepartamentos vd ;

    public VentanaPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuEmpleados = new javax.swing.JMenu();
        jMenuDepartamentos = new javax.swing.JMenu();
        jMenuAdministradores = new javax.swing.JMenu();
        jMenuReporte = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Sistema de Gestio de Empleados");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/empresa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel2)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jMenuEmpleados.setText("Empleados");
        jMenuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuEmpleadosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuEmpleados);

        jMenuDepartamentos.setText("Departamentos");
        jMenuDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuDepartamentosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuDepartamentos);

        jMenuAdministradores.setText("Administradores");
        jMenuAdministradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAdministradoresMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuAdministradores);

        jMenuReporte.setText("Reporte");
        jMenuReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuReporteMouseClicked(evt);
            }
        });
        jMenuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReporteActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuReporte);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuEmpleadosMouseClicked
           ve = new VentanaEmpleados();
        if(ve.isVisible()==true){
              
          }else{
            ve.setVisible(true);
            
          }  
        
    }//GEN-LAST:event_jMenuEmpleadosMouseClicked

    private void jMenuDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuDepartamentosMouseClicked
        vd = new VentanaDepartamentos(); 
        if(vd.isVisible()==true){
              
          }else{
            vd.setVisible(true);  
          } 
    }//GEN-LAST:event_jMenuDepartamentosMouseClicked

    private void jMenuAdministradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAdministradoresMouseClicked
        va = new VentanaAdministradores();
        if(va.isVisible()==true){
              
          }else{
            va.setVisible(true);  
          } 
    }//GEN-LAST:event_jMenuAdministradoresMouseClicked

    private void jMenuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReporteActionPerformed
        
    }//GEN-LAST:event_jMenuReporteActionPerformed

    private void jMenuReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuReporteMouseClicked
        Conexion con = Conexion.getC();
        try {
            String ruta=System.getProperty("user.dir")+"/src/r/report1.jasper";
            JasperReport jaspe=(JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint print=JasperFillManager.fillReport(jaspe,null,con.getCon());
            JasperViewer view= new JasperViewer(print,false);
            view.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al generar el reporte---->"+e.getMessage());
        }
    }//GEN-LAST:event_jMenuReporteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenuAdministradores;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDepartamentos;
    private javax.swing.JMenu jMenuEmpleados;
    private javax.swing.JMenu jMenuReporte;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
