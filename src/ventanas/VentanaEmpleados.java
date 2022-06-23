/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import cruds.CrudEmpleado;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Empleado;

/**
 *
 * @author cesar
 */
public class VentanaEmpleados extends javax.swing.JFrame {
    String controlador = new conexionBD.Conexion().getControlador();
    String url = new conexionBD.Conexion().getUrl();
    
    public void atuaclizaTabla(JTable tabla) {
		
        try {
			
			String Consulta = "SELECT * FROM employees";		
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
    public void obtenerRegistro() {
            try {   
                        int i = (int)tabla.getValueAt(tabla.getSelectedRow(), 0);
                        tnoEmpleado.setText(i+"");
			Date fn =  (Date) tabla.getValueAt(tabla.getSelectedRow(), 1);
                        String sfn = fn+"";
			String[] na = sfn.split("-");
                        cbDiaN.setSelectedItem(na[2]);
                        cbMesN.setSelectedItem(na[1]);
                        cbAñoN.setSelectedItem(na[0]);
                        
                        tNombre.setText((String) tabla.getValueAt(tabla.getSelectedRow(), 2));
                        tApellido.setText((String)tabla.getValueAt(tabla.getSelectedRow(), 3));
                        String genero = (String) tabla.getValueAt(tabla.getSelectedRow(),4);
                        if(genero.equals("M")){
                            cbGenero.setSelectedIndex(0);
                        }else{
                            cbGenero.setSelectedIndex(1);
                        }
                        Date fc = (Date) tabla.getValueAt(tabla.getSelectedRow(), 5);
			String sfc = fc+"";
                        String[] co = sfc.split("-");
                        cbDiaC.setSelectedItem(co[2]);
                        cbMesC.setSelectedItem(co[1]);
                        cbAñoC.setSelectedItem(co[0]);
		}catch (Exception e) {
			
			
		}
		
	}
    public void limpiarCajas(){
        tnoEmpleado.setText("");
        tNombre.setText("");
        tApellido.setText("");
    }
    
    
    public void atuaclizaTablaSQL(String sql) {
		try {
			
			
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
     public void buscarPorCampos(){
        if(tnoEmpleado.getText().isEmpty()&&!tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM employees WHERE first_name LIKE'"+tNombre.getText()+"%'");
        }else if(!tnoEmpleado.getText().isEmpty()&&tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM employees WHERE emp_no::TEXT LIKE '"+tnoEmpleado.getText()+"%'");
        }else if(tnoEmpleado.getText().isEmpty()&&tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM employees");
        }else if(!tnoEmpleado.getText().isEmpty()&&!tNombre.getText().isEmpty()){
            atuaclizaTablaSQL("SELECT * FROM employees WHERE emp_no::TEXT LIKE'"+tnoEmpleado.getText()+"%' AND first_name LIKE'"+tNombre.getText()+"%'");
        }
    }  
     public void contadorR(){
        if(tabla.getRowCount()==0){
               JOptionPane.showMessageDialog(null,"No se encontraron registros");
               atuaclizaTablaSQL("SELECT * FROM employees");
           }
        
    }
    
    public VentanaEmpleados() {
        initComponents();
        
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        
        tnoEmpleado.addKeyListener(new KeyAdapter(){
			   public void keyTyped(KeyEvent e){
				      char caracter = e.getKeyChar();
				      if(((caracter < 48) || (caracter > 57)) &&(caracter != '\b')){
				         e.consume(); 
				      }
				   }
				});
        
               atuaclizaTabla(tabla);
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoB = new javax.swing.ButtonGroup();
        toggBAltas = new javax.swing.JToggleButton();
        toggBBajas = new javax.swing.JToggleButton();
        toggBCambios = new javax.swing.JToggleButton();
        toggBConsultas = new javax.swing.JToggleButton();
        tApellido = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnAccion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        escroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cbDiaC = new javax.swing.JComboBox<>();
        cbMesC = new javax.swing.JComboBox<>();
        cbAñoC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbDiaN = new javax.swing.JComboBox<>();
        cbMesN = new javax.swing.JComboBox<>();
        tnoEmpleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbAñoN = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLfiltroConsulta = new javax.swing.JLabel();
        jComboBFiltroConsulta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        grupoB.add(toggBAltas);
        toggBAltas.setText("Altas");
        toggBAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBAltasActionPerformed(evt);
            }
        });

        grupoB.add(toggBBajas);
        toggBBajas.setText("Bajas");
        toggBBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBBajasActionPerformed(evt);
            }
        });

        grupoB.add(toggBCambios);
        toggBCambios.setText("Cambios");
        toggBCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBCambiosActionPerformed(evt);
            }
        });

        grupoB.add(toggBConsultas);
        toggBConsultas.setText("Consultas");
        toggBConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggBConsultasActionPerformed(evt);
            }
        });

        jLabel10.setText("Apellido");

        jButton1.setText("Contar Generos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Genero");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel13.setText("Fecha de contratacion");

        btnAccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        escroll.setViewportView(tabla);

        cbDiaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbAñoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054" }));
        cbAñoC.setSelectedIndex(100);

        jLabel2.setText("Dia");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        jLabel1.setText("Numero de Empleado");

        cbDiaN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMesN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        tnoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnoEmpleadoKeyReleased(evt);
            }
        });

        jLabel8.setText("Fecha de Nacimiento");

        cbAñoN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055" }));
        cbAñoN.setSelectedIndex(80);

        jLabel5.setText("Dia");

        tNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNombreKeyReleased(evt);
            }
        });

        jLabel6.setText("Mes");

        jLabel9.setText("Nombre");

        jLabel14.setText("Año");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("EMPLEADOS");

        jLfiltroConsulta.setText("Filtro de Consulta: ");

        jComboBFiltroConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. Empleado", "Fecha de Nacimiento", "Nombre ", "Apellido", "Genero", "Fecha de Contratacion", "Campos de Texto" }));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(toggBAltas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBBajas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBCambios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggBConsultas)
                        .addGap(32, 32, 32)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLfiltroConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbDiaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbMesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbAñoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(253, 253, 253)
                                    .addComponent(jLabel15)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(tnoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(tNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbDiaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbMesN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbAñoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel5)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel6)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel14))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(33, 33, 33)
                                        .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(tApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(125, 125, 125)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(jLabel2)
                            .addGap(27, 27, 27)
                            .addComponent(jLabel3)
                            .addGap(27, 27, 27)
                            .addComponent(jLabel4)))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toggBAltas)
                        .addComponent(toggBBajas)
                        .addComponent(toggBCambios)
                        .addComponent(toggBConsultas))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLfiltroConsulta)
                    .addComponent(jComboBFiltroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tnoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel14))
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbDiaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbMesN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbAñoN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(11, 11, 11)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(tApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGap(1, 1, 1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cbDiaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAñoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(escroll, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggBBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBBajasActionPerformed
        btnAccion.setText("Eliminar");
        btnAccion.setBackground(Color.red);
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(true);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBBajasActionPerformed

    private void toggBAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBAltasActionPerformed
        btnAccion.setText("Añadir");
        btnAccion.setBackground(Color.green);
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(true);
        cbDiaC.setEnabled(true);
        cbMesC.setEnabled(true);
        cbAñoC.setEnabled(true);
        cbDiaN.setEnabled(true);
        cbMesN.setEnabled(true);
        cbAñoN.setEnabled(true);
        cbGenero.setEnabled(true);
        tApellido.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
         
    }//GEN-LAST:event_toggBAltasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiarCajas();
       atuaclizaTablaSQL("SELECT * FROM employees");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void toggBCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBCambiosActionPerformed
        btnAccion.setText("Guardar");
        btnAccion.setBackground(Color.MAGENTA);
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(true);
        cbDiaC.setEnabled(true);
        cbMesC.setEnabled(true);
        cbAñoC.setEnabled(true);
        cbDiaN.setEnabled(true);
        cbMesN.setEnabled(true);
        cbAñoN.setEnabled(true);
        cbGenero.setEnabled(true);
        tApellido.setEnabled(true);
        jLfiltroConsulta.setVisible(false);
        jComboBFiltroConsulta.setVisible(false);
        limpiarCajas();
    }//GEN-LAST:event_toggBCambiosActionPerformed

    private void toggBConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggBConsultasActionPerformed
       btnAccion.setText("Buscar");
        btnAccion.setBackground(Color.BLUE);
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        jComboBFiltroConsulta.setSelectedIndex(0);
         jLfiltroConsulta.setVisible(true);
        jComboBFiltroConsulta.setVisible(true);
          limpiarCajas();
    }//GEN-LAST:event_toggBConsultasActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        if(toggBAltas.isSelected()){
        String noEm = tnoEmpleado.getText() ;
        String fNaci = laFecha(cbDiaN, cbMesN, cbAñoN);
        String nombre = tNombre.getText();
        String apellido = tApellido.getText();
        String genero = (String)cbGenero.getSelectedItem() ;
        if(genero.equals("Masculino")){
            genero = "M";
        }else{
            genero = "F";
        }
        String fContrato = laFecha(cbDiaC, cbMesC, cbAñoC);
        
        if(noEm.equals("")||fNaci.equals("")||nombre.equals("")||apellido.equals("")||fContrato.equals("")){
            JOptionPane.showMessageDialog(null, "Algun campo quedo sin ser llenado");
        }else{
            int neI = Integer.parseInt(noEm);
            Empleado emp = new Empleado(neI, fNaci,nombre,apellido,genero,fContrato);
            CrudEmpleado ce = new CrudEmpleado();
            if(ce.insert(emp)){
                
            }else{
                    JOptionPane.showMessageDialog(null, "Registro existente, si desea modificarlo vaya a MODIFICAR");    
                        }
             atuaclizaTabla(tabla);
               
               
            }
        }else if(toggBBajas.isSelected()){
        String i = (tnoEmpleado.getText());
        CrudEmpleado ce = new CrudEmpleado();
        if(ce.delete(i)){
            
        }else{
            JOptionPane.showMessageDialog(null,"El registro no existe y no puede ser eliminado");
        }
        atuaclizaTablaSQL("SELECT * FROM employees");
        tnoEmpleado.setText("");
        tNombre.setText("");
        tApellido.setText("");
        }else if(toggBCambios.isSelected()){
        String noEm = tnoEmpleado.getText() ;
        String fNaci = laFecha(cbDiaN, cbMesN, cbAñoN);
        String nombre = tNombre.getText();
        String apellido = tApellido.getText();
        String genero = (String)cbGenero.getSelectedItem() ;
        if(genero.equals("Masculino")){
            genero = "M";
        }else{
            genero = "F";
        }
        String fContrato = laFecha(cbDiaC, cbMesC, cbAñoC);
        
        if(noEm.equals("")||fNaci.equals("")||nombre.equals("")||apellido.equals("")||fContrato.equals("")){
            JOptionPane.showMessageDialog(null, "Algun campo quedo sin ser llenado");
        }else{
            int neI = Integer.parseInt(noEm);
            Empleado emp = new Empleado(neI, fNaci,nombre,apellido,genero,fContrato);
            CrudEmpleado ce = new CrudEmpleado();
            if(ce.modificar(emp)){
                
            }else{
                    JOptionPane.showMessageDialog(null, "Registro existente, si desea modificarlo vaya a MODIFICAR");    
                        }
             atuaclizaTabla(tabla);
               
               
            }
        }else if(toggBConsultas.isSelected()){
            
            String sql = "SELECT * FROM employees ";
            if(jComboBFiltroConsulta.getSelectedIndex()==0){
            if(tnoEmpleado.getText().equals("")){
               JOptionPane.showMessageDialog(null,"Inmgresa un numero de empleado a buscar");
           }else{
               sql = sql + "WHERE emp_no ::TEXT LIKE'"+tnoEmpleado.getText()+"%'";
               atuaclizaTablaSQL(sql);
               
           }
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==1){
           sql = sql + "WHERE birth_date::TEXT LIKE'"+laFechaG(cbDiaN, cbMesN, cbAñoN)+"%'";
           atuaclizaTablaSQL(sql);
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==2){
           
           if(tNombre.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Ingresa un Nombre a buscar");
           }else{
               sql = sql + "WHERE first_name LIKE'"+tNombre.getText()+"%'";
               atuaclizaTablaSQL(sql);
           }
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==3){
          
           if(tApellido.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Inmgresa un Apellido a buscar");
            }else{
               sql = sql + "WHERE last_name LIKE'"+tApellido.getText()+"%'";
               atuaclizaTablaSQL(sql);
           }
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==4){
           
           String x = "";
           if(cbGenero.getSelectedIndex()==0){
               x="M";
           }else{
               x="F";
           }
           sql = sql + "WHERE gender::TEXT LIKE'"+x+"%'";
           atuaclizaTablaSQL(sql);
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==5){
           sql = sql + "WHERE hire_date::TEXT LIKE'"+laFechaG(cbDiaC, cbMesC, cbAñoC)+"%'";
           atuaclizaTablaSQL(sql);
           contadorR();
       }else if(jComboBFiltroConsulta.getSelectedIndex()==6){
           sql = sql + "WHERE emp_no ::TEXT LIKE'"+tnoEmpleado.getText()+"%' AND first_name LIKE'"+tNombre.getText()+"%' AND last_name LIKE'"+tApellido.getText()+"%'";
           atuaclizaTablaSQL(sql);
           contadorR();
       }
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Ninguna opcion seleccionada");
        }
    }//GEN-LAST:event_btnAccionActionPerformed

    private void tnoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnoEmpleadoKeyReleased
        if(toggBBajas.isSelected()||toggBCambios.isSelected()){
            buscarPorCampos();
        }
    }//GEN-LAST:event_tnoEmpleadoKeyReleased

    private void tNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNombreKeyReleased
         if(toggBBajas.isSelected()){
            buscarPorCampos();
        }
    }//GEN-LAST:event_tNombreKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
         if(toggBBajas.isSelected()||toggBCambios.isSelected()){
            obtenerRegistro();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void jComboBFiltroConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBFiltroConsultaActionPerformed
        limpiarCajas();
        atuaclizaTablaSQL("SELECT * FROM employees");
        if(jComboBFiltroConsulta.getSelectedIndex()==0){
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==1){
        tnoEmpleado.setEnabled(false);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(true);
        cbMesN.setEnabled(true);
        cbAñoN.setEnabled(true);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==2){
        tnoEmpleado.setEnabled(false);
        tNombre.setEnabled(true);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==3){
        tnoEmpleado.setEnabled(false);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(true);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==4){
        tnoEmpleado.setEnabled(false);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(true);
        tApellido.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==5){
        tnoEmpleado.setEnabled(false);
        tNombre.setEnabled(false);
        cbDiaC.setEnabled(true);
        cbMesC.setEnabled(true);
        cbAñoC.setEnabled(true);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(false);
        }else if(jComboBFiltroConsulta.getSelectedIndex()==6){
        tnoEmpleado.setEnabled(true);
        tNombre.setEnabled(true);
        cbDiaC.setEnabled(false);
        cbMesC.setEnabled(false);
        cbAñoC.setEnabled(false);
        cbDiaN.setEnabled(false);
        cbMesN.setEnabled(false);
        cbAñoN.setEnabled(false);
        cbGenero.setEnabled(false);
        tApellido.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBFiltroConsultaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new VerGeneros().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbAñoC;
    private javax.swing.JComboBox<String> cbAñoN;
    private javax.swing.JComboBox<String> cbDiaC;
    private javax.swing.JComboBox<String> cbDiaN;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbMesC;
    private javax.swing.JComboBox<String> cbMesN;
    private javax.swing.JScrollPane escroll;
    private javax.swing.ButtonGroup grupoB;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBFiltroConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField tApellido;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField tnoEmpleado;
    private javax.swing.JToggleButton toggBAltas;
    private javax.swing.JToggleButton toggBBajas;
    private javax.swing.JToggleButton toggBCambios;
    private javax.swing.JToggleButton toggBConsultas;
    // End of variables declaration//GEN-END:variables
}
