/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import conexionBD.Conexion;
import cruds.CrudAdministrador;
import cruds.CrudEmpleado;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Administrador;
import modelo.Empleado;

/**
 *
 * @author cesar
 */
public class VentanaAdministradores extends javax.swing.JFrame {
    Conexion c = Conexion.getC();
    String controlador = c.getControlador();
    String url = c.getUrl();
    Connection con = c.getCon();
    CrudAdministrador ca = new CrudAdministrador();
    int commit = 0;
    
    public void atuaclizaTabla(JTable tabla) {
		try {
			
			String Consulta = "SELECT * FROM dept_manager";		
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
    public void atuaclizaTablaOtra(String sql,JTable t) {
		try {
			
			
			ResulSetTableModel modeloDatos = null;
			try {
				modeloDatos = new ResulSetTableModel(controlador, url, sql);
			}catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(getContentPane(), ex);
			}
			t.setModel(modeloDatos);
		}//Try
		catch (Exception sqle) {
			JOptionPane.showMessageDialog(getContentPane(), sqle);
		}
	}    
        public void atuaclizaTablaSQL(String sql) {
		try {
		
			ResulSetTableModel modeloDatos = null;
			try {
				modeloDatos = new ResulSetTableModel(controlador, url, sql);
			}catch (ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(getContentPane(), ex);
			}
			tabla1.setModel(modeloDatos);
		}//Try
		catch (Exception sqle) {
			JOptionPane.showMessageDialog(getContentPane(), sqle);
		}
	}
            public boolean buscar(){
       int cem = Integer.parseInt(tnoEmpleado.getText());
       String cdp = tnoDepartamento.getText();
       String sqlem = "SELECT * FROM employees " +  ("WHERE emp_no ='"+cem+"'");
       String sqldp = "SELECT * FROM departments " + ("WHERE dept_no ='"+cdp+"'");
         atuaclizaTablaOtra(sqlem,tablaem);
         atuaclizaTablaOtra(sqldp,tabladp);
         int countem = tablaem.getRowCount();
         int countdp = tabladp.getRowCount();
         if(countem==0){
             JOptionPane.showMessageDialog(null, "ese empleado no existe");
             return false;
         }else{
         if(countdp==0){
                 JOptionPane.showMessageDialog(null, "Ese departamento no existe");
                 return false;
             }else{
             return true;
         }
             
         }
       
     }
    public void limpiarCajas(){
        tnoEmpleado.setText("");
        tnoDepartamento.setText("");
    }
     public String laFecha(JComboBox dia,JComboBox mes,JComboBox año){
        String d = (String) dia.getSelectedItem();
        String m = (String) mes.getSelectedItem();
        String a = (String) año.getSelectedItem();
        return a+"/"+m+"/"+d;
    }
     public String laFechaG(JComboBox dia,JComboBox mes,JComboBox año){
        String d = (String) dia.getSelectedItem();
        String m = (String) mes.getSelectedItem();
        String a = (String) año.getSelectedItem();
        return a+"-"+m+"-"+d;
    }
      public void buscarPorCampo(){
        if(tnoDepartamento.getText().isEmpty() && !tnoEmpleado.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM dept_manager WHERE emp_no::TEXT LIKE'"+tnoEmpleado.getText()+"%'");
        }else if(!tnoDepartamento.getText().isEmpty() && tnoEmpleado.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM dept_manager WHERE dept_no LIKE'"+tnoDepartamento.getText()+"%'");
        }else if(tnoDepartamento.getText().isEmpty() && tnoEmpleado.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM dept_manager");
        }else if(!tnoDepartamento.getText().isEmpty() && !tnoEmpleado.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM dept_manager WHERE emp_no::TEXT LIKE'"+tnoEmpleado.getText()+"%' AND dept_no LIKE'"+tnoDepartamento.getText()+"%'");
            }
        }
      public void contadorR(){
        if(tabla1.getRowCount()==0){
               JOptionPane.showMessageDialog(null,"No se encontraron registros");
               atuaclizaTablaSQL("SELECT * FROM dept_manager");
           }
    }
     public void obtenerRegistro() {
		try {   
                        int i = (int)tabla1.getValueAt(tabla1.getSelectedRow(), 0);
                        tnoEmpleado.setText(i+"");
                        tnoDepartamento.setText((String)tabla1.getValueAt(tabla1.getSelectedRow(),1));
			Date ff =  (Date) tabla1.getValueAt(tabla1.getSelectedRow(), 2);
                        String sff = ff+"";
			String[] na = sff.split("-");
                        cbDiaF.setSelectedItem(na[2]);
                        cbMesF.setSelectedItem(na[1]);
                        cbAñoF.setSelectedItem(na[0]);
                        Date ft = (Date) tabla1.getValueAt(tabla1.getSelectedRow(), 3);
			String sft = ft+"";
                        String[] co = sft.split("-");
                        cbDiaT.setSelectedItem(co[2]);
                        cbMesT.setSelectedItem(co[1]);
                        cbAñoT.setSelectedItem(co[0]);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Producto no existe");
			tnoEmpleado.setText("");
                        tnoDepartamento.setText("");	
		}
	}
    public VentanaAdministradores() {
        ca.beggin();
        initComponents();
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        tnoEmpleado.addKeyListener(new KeyAdapter(){
			   public void keyTyped(KeyEvent e){
				      char caracter = e.getKeyChar();
				      if(((caracter < 48) || (caracter > 57)) &&(caracter != '\b')){
				         e.consume(); 
				      }
				   }
				});
        atuaclizaTabla(tabla1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGrupo = new javax.swing.ButtonGroup();
        cbDiaT = new javax.swing.JComboBox<>();
        cbMesT = new javax.swing.JComboBox<>();
        cbAñoT = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        escroll = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        tnoEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladp = new javax.swing.JTable();
        tnoDepartamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaem = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbDiaF = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbMesF = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbAñoF = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        toggBConsultas = new javax.swing.JToggleButton();
        toggBAltas = new javax.swing.JToggleButton();
        toggBBajas = new javax.swing.JToggleButton();
        toggBCambios = new javax.swing.JToggleButton();
        jLfiltroConsulta = new javax.swing.JLabel();
        jComboBFiltroConsulta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        cbDiaT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbDiaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaTActionPerformed(evt);
            }
        });

        cbMesT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbAñoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055" }));
        cbAñoT.setSelectedIndex(100);

        jLabel10.setText("Dia");

        jLabel11.setText("Mes");

        jLabel15.setText("Año");

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
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        escroll.setViewportView(tabla1);

        tnoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoEmpleadoActionPerformed(evt);
            }
        });
        tnoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnoEmpleadoKeyReleased(evt);
            }
        });

        jLabel1.setText("Numero de Empleado");

        tabladp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabladp);

        tnoDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoDepartamentoActionPerformed(evt);
            }
        });
        tnoDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnoDepartamentoKeyReleased(evt);
            }
        });

        jLabel2.setText("Numero de Departamento");

        tablaem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaem);

        jLabel8.setText("Desde");

        cbDiaF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbAñoF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055" }));
        cbAñoF.setSelectedIndex(80);

        jLabel5.setText("Dia");

        jLabel6.setText("Mes");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("ADMINISTRADORES");

        jLabel14.setText("Año");

        jLabel9.setText("Hasta");

        bGrupo.add(toggBConsultas);
        toggBConsultas.setText("Consultas");
        toggBConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBConsultasActionPerformed(evt);
            }
        });

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

        jLfiltroConsulta.setText("Filtro de Consulta: ");

        jComboBFiltroConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. Empleado", "No. Departamento", "Fecha Desde", "Fecha Hasta", "Campos de texto" }));
        jComboBFiltroConsulta.setToolTipText("");
        jComboBFiltroConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBFiltroConsultaActionPerformed(evt);
            }
        });

        jButton1.setText("Vista-Relacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(tnoDepartamento))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(tnoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(cbDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cbMesF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cbAñoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(10, 10, 10)
                                                            .addComponent(jLabel5)
                                                            .addGap(27, 27, 27)
                                                            .addComponent(jLabel6)
                                                            .addGap(27, 27, 27)
                                                            .addComponent(jLabel14))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(cbDiaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cbMesT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cbAñoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(10, 10, 10)
                                                            .addComponent(jLabel10)
                                                            .addGap(27, 27, 27)
                                                            .addComponent(jLabel11)
                                                            .addGap(27, 27, 27)
                                                            .addComponent(jLabel15)))))
                                            .addGap(9, 9, 9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(toggBAltas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(toggBBajas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(toggBCambios)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(toggBConsultas)))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLfiltroConsulta)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(toggBAltas)
                            .addComponent(toggBBajas)
                            .addComponent(toggBCambios)
                            .addComponent(toggBConsultas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLfiltroConsulta)
                            .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tnoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tnoDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel14))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbDiaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMesF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAñoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbDiaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMesT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAñoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDiaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiaTActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
     if(toggBAltas.isSelected()){
     String noEm = tnoEmpleado.getText();
     String noDp = tnoDepartamento.getText();
     String fFrom = laFecha(cbDiaF, cbMesF, cbAñoF);
     String fTo = laFecha(cbDiaT, cbMesT, cbAñoT);
     if(noEm.equals("")||noDp.equals("")){
         JOptionPane.showMessageDialog(null, "Algun campo quedo sin ser llenado");
     }else{
          if(noDp.length()>4){
             JOptionPane.showMessageDialog(null, "El numero de departamento debe ser de maximo 4 digitos ");
          }else{
              boolean x = buscar();
              if(x==true){
            int neI = Integer.parseInt(noEm);
            Administrador ad = new Administrador(neI, noDp,fFrom,fTo);
            
            if(ca.insert(ad)){
                commit = 1;
            }else{
                    JOptionPane.showMessageDialog(null, "Registro existente, si desea modificarlo vaya a MODIFICAR");    
                        }
                
              }
                
          }
            
     }
       atuaclizaTabla(tabla1);
        }else if(toggBBajas.isSelected()){
            String i = (tnoEmpleado.getText());
            
            if(ca.delete(i)){
            commit = 1;
        }else{
            JOptionPane.showMessageDialog(null,"El registro no existe y no puede ser eliminado");
        }
            atuaclizaTablaSQL("SELECT * FROM dept_manager");
        tnoEmpleado.setText("");
        tnoDepartamento.setText("");
        }else if(toggBCambios.isSelected()){//CAMBIO
            String noEm = tnoEmpleado.getText();
        String noDp = tnoDepartamento.getText();
        String fFrom = laFecha(cbDiaF, cbMesF, cbAñoF);
        String fTo = laFecha(cbDiaT, cbMesT, cbAñoT);
        if(noEm.equals("")||noDp.equals("")){
            JOptionPane.showMessageDialog(null, "Algun campo quedo sin ser llenado");
        }else{
            if(noDp.length()>4){
                JOptionPane.showMessageDialog(null, "El numero de departamento debe ser de maximo 4 digitos ");
            }else{
                if(buscar()){
                    int neI = Integer.parseInt(noEm);
                    Administrador ad = new Administrador(neI, noDp,fFrom,fTo);
                    
                    if(ca.modificar(ad)){
                        commit = 1;
                    }else{
                        JOptionPane.showMessageDialog(null, "Registro existente, si desea modificarlo vaya a MODIFICAR");
                    }

                }

            }

        }
        atuaclizaTabla(tabla1);
        }else if(toggBConsultas.isSelected()){
            String sql = "SELECT * FROM dept_manager ";
            if(jComboBFiltroConsulta.getSelectedIndex()==0){
                if(tnoEmpleado.getText().equals("")){
               JOptionPane.showMessageDialog(null,"Inmgresa un numero de empleado a buscar");
           }else{
               sql = sql + "WHERE emp_no ::TEXT LIKE'"+tnoEmpleado.getText()+"%'";
               atuaclizaTablaSQL(sql);
               
           }
           contadorR();
            }else if(jComboBFiltroConsulta.getSelectedIndex()==1){
                if(tnoDepartamento.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Inmgresa un numero de departamento a buscar");
            }else{
                sql = sql + "WHERE dept_no LIKE'"+tnoDepartamento.getText()+"%'";
                atuaclizaTablaSQL(sql);
            }
            contadorR();
            }else if(jComboBFiltroConsulta.getSelectedIndex()==2){
                sql = sql + "WHERE from_date::TEXT LIKE'"+laFechaG(cbDiaF, cbMesF, cbAñoF)+"%'";
                atuaclizaTablaSQL(sql);
                contadorR();
            }else if (jComboBFiltroConsulta.getSelectedIndex()==3){
                sql = sql + "WHERE to_date::TEXT LIKE'"+laFechaG(cbDiaT, cbMesT, cbAñoT)+"%'";
                atuaclizaTablaSQL(sql);
                contadorR();
            }else if(jComboBFiltroConsulta.getSelectedIndex()==4){
                sql = sql + "WHERE emp_no::TEXT LIKE '"+tnoEmpleado.getText()+"%' AND dept_no LIKE '"+tnoDepartamento.getText()+"%'";
            }
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Ninguna opcion seleccionada");
        }
    }//GEN-LAST:event_btnAccionActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCajas();
        atuaclizaTablaSQL("SELECT * FROM dept_manager");

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
          if(commit == 1){
              int resp = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los cambios?");
             if(resp==0){
                 ca.commit();
                 try {
                      c.cerrarConexion();
                  } catch (SQLException ex) {
                      Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                  }
            setVisible(false);
        }else if(resp==1){
                 ca.rollback();
                 try {
                      c.cerrarConexion();
                  } catch (SQLException ex) {
                      Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                  }
            setVisible(false);
        }else if(resp==2){
        } 
         }else{
              try {
                      c.cerrarConexion();
                  } catch (SQLException ex) {
                      Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                  }
                 setVisible(false);
             }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tnoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnoEmpleadoActionPerformed

    private void tnoDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoDepartamentoActionPerformed
        
    }//GEN-LAST:event_tnoDepartamentoActionPerformed

    private void toggBConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBConsultasActionPerformed
        btnAccion.setText("Buscar");
        btnAccion.setBackground(Color.BLUE);
        tnoEmpleado.setEnabled(true);
        tnoDepartamento.setEnabled(false);
        cbDiaF.setEnabled(false);
        cbMesF.setEnabled(false);
        cbAñoF.setEnabled(false);
        cbDiaT.setEnabled(false);
        cbMesT.setEnabled(false);
        cbAñoT.setEnabled(false);
        jComboBFiltroConsulta.setSelectedIndex(0);
        jLfiltroConsulta.setVisible(true);
        jComboBFiltroConsulta.setVisible(true);
        limpiarCajas();
    }//GEN-LAST:event_toggBConsultasActionPerformed

    private void toggBAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBAltasActionPerformed
        btnAccion.setText("Añadir");
        btnAccion.setBackground(Color.green);
        tnoEmpleado.setEnabled(true);
        tnoDepartamento.setEnabled(true);
        cbDiaF.setEnabled(true);
        cbMesF.setEnabled(true);
        cbAñoF.setEnabled(true);
        cbDiaT.setEnabled(true);
        cbMesT.setEnabled(true);
        cbAñoT.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();

    }//GEN-LAST:event_toggBAltasActionPerformed

    private void toggBBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBBajasActionPerformed
        btnAccion.setText("Eliminar");
        btnAccion.setBackground(Color.red);
        tnoEmpleado.setEnabled(true);
        tnoDepartamento.setEnabled(false);
        cbDiaF.setEnabled(false);
        cbMesF.setEnabled(false);
        cbAñoF.setEnabled(false);
        cbDiaT.setEnabled(false);
        cbMesT.setEnabled(false);
        cbAñoT.setEnabled(false);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBBajasActionPerformed

    private void toggBCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBCambiosActionPerformed
        btnAccion.setText("Guardar");
        btnAccion.setBackground(Color.MAGENTA);
        tnoEmpleado.setEnabled(true);
        tnoDepartamento.setEnabled(true);
        cbDiaF.setEnabled(true);
        cbMesF.setEnabled(true);
        cbAñoF.setEnabled(true);
        cbDiaT.setEnabled(true);
        cbMesT.setEnabled(true);
        cbAñoT.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBCambiosActionPerformed

    private void jComboBFiltroConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBFiltroConsultaActionPerformed
        limpiarCajas();
        atuaclizaTablaSQL("SELECT * FROM dept_manager");
        if(jComboBFiltroConsulta.getSelectedIndex()==0){
            tnoEmpleado.setEnabled(true);
            tnoDepartamento.setEnabled(false);
            cbDiaT.setEnabled(false);
            cbMesT.setEnabled(false);
            cbAñoT.setEnabled(false);
            cbDiaF.setEnabled(false);
            cbMesF.setEnabled(false);
            cbAñoF.setEnabled(false);
            
        }else if(jComboBFiltroConsulta.getSelectedIndex()==1){
            tnoEmpleado.setEnabled(false);
            tnoDepartamento.setEnabled(true);
            cbDiaF.setEnabled(false);
            cbMesF.setEnabled(false);
            cbAñoF.setEnabled(false);
            cbDiaT.setEnabled(false);
            cbMesT.setEnabled(false);
            cbAñoT.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==2){
            tnoEmpleado.setEnabled(false);
            tnoDepartamento.setEnabled(false);
            cbDiaF.setEnabled(true);
            cbMesF.setEnabled(true);
            cbAñoF.setEnabled(true);
            cbDiaT.setEnabled(false);
            cbMesT.setEnabled(false);
            cbAñoT.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==3){
            tnoEmpleado.setEnabled(false);
            tnoDepartamento.setEnabled(false);
            cbDiaF.setEnabled(false);
            cbMesF.setEnabled(false);
            cbAñoF.setEnabled(false);
            cbDiaT.setEnabled(true);
            cbMesT.setEnabled(true);
            cbAñoT.setEnabled(true);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==4){
            tnoEmpleado.setEnabled(true);
            tnoDepartamento.setEnabled(true);
            cbDiaF.setEnabled(false);
            cbMesF.setEnabled(false);
            cbAñoF.setEnabled(false);
            cbDiaT.setEnabled(false);
            cbMesT.setEnabled(false);
            cbAñoT.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBFiltroConsultaActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        if(toggBBajas.isSelected()||toggBCambios.isSelected()){
            obtenerRegistro();
        }
    }//GEN-LAST:event_tabla1MouseClicked

  

    private void tnoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnoEmpleadoKeyReleased
       if(toggBBajas.isSelected()||toggBCambios.isSelected()){
            buscarPorCampo();
        }
    }//GEN-LAST:event_tnoEmpleadoKeyReleased

    private void tnoDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnoDepartamentoKeyReleased
       if(toggBBajas.isSelected()){
            buscarPorCampo();
        }
    }//GEN-LAST:event_tnoDepartamentoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Vista().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGrupo;
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbAñoF;
    private javax.swing.JComboBox<String> cbAñoT;
    private javax.swing.JComboBox<String> cbDiaF;
    private javax.swing.JComboBox<String> cbDiaT;
    private javax.swing.JComboBox<String> cbMesF;
    private javax.swing.JComboBox<String> cbMesT;
    private javax.swing.JScrollPane escroll;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBFiltroConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLfiltroConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabladp;
    private javax.swing.JTable tablaem;
    private javax.swing.JTextField tnoDepartamento;
    private javax.swing.JTextField tnoEmpleado;
    private javax.swing.JToggleButton toggBAltas;
    private javax.swing.JToggleButton toggBBajas;
    private javax.swing.JToggleButton toggBCambios;
    private javax.swing.JToggleButton toggBConsultas;
    // End of variables declaration//GEN-END:variables
}
