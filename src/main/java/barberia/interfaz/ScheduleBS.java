package barberia.interfaz;

// Paquetes utilizados
import barberia.control.Control;
import barberia.control.DataVerification;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// ScheduleBS: Clase que se encarga de la ventana para el funcionamiento del menú de horario.
public class ScheduleBS extends javax.swing.JFrame {
    // Variables utilizadas
    private Control control;
    private ArrayList<String> horarioInfo;
    
    // Constructor
    public ScheduleBS() {
        control = Control.getInstance();
        horarioInfo = control.verHorario();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        daysComboBox = new javax.swing.JComboBox<>();
        setScheduleButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        openingSpinner = new javax.swing.JSpinner();
        closingSpinner = new javax.swing.JSpinner();
        setAllScheduleButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horario");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(142, 131, 108));

        daysComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        daysComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysComboBoxActionPerformed(evt);
            }
        });

        setScheduleButton.setBackground(new java.awt.Color(102, 102, 102));
        setScheduleButton.setForeground(new java.awt.Color(255, 255, 255));
        setScheduleButton.setText("Aceptar");
        setScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setScheduleButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Día de la semana");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Hora de Apertura");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Hora de Clausura");

        openingSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"00:00 am", "01:00 am", "02:00 am", "03:00 am", "04:00 am", "05:00 am", "06:00 am", "07:00 am", "08:00 am", "09:00 am", "10:00 am", "11:00 am", "12:00 pm", "13:00 pm", "14:00 pm", "15:00 pm", "16:00 pm", "17:00 pm", "18:00 pm", "19:00 pm", "20:00 pm", "21:00 pm", "22:00 pm", "23:00 pm"}));

        closingSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"00:00 am", "01:00 am", "02:00 am", "03:00 am", "04:00 am", "05:00 am", "06:00 am", "07:00 am", "08:00 am", "09:00 am", "10:00 am", "11:00 am", "12:00 pm", "13:00 pm", "14:00 pm", "15:00 pm", "16:00 pm", "17:00 pm", "18:00 pm", "19:00 pm", "20:00 pm", "21:00 pm", "22:00 pm", "23:00 pm"}));

        setAllScheduleButton.setBackground(new java.awt.Color(102, 102, 102));
        setAllScheduleButton.setForeground(new java.awt.Color(255, 255, 255));
        setAllScheduleButton.setText("Aceptar para todos los días");
        setAllScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAllScheduleButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(32, 31, 31));
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Regresar al menú");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(7);
        String horarioTexto = "";
        for (String diaInfo: horarioInfo){
            horarioTexto += diaInfo + "\n";
        }
        jTextArea1.setText(horarioTexto);
        jTextArea1.setEditable(false);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(closingSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(openingSpinner)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(daysComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(setScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(setAllScheduleButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(returnButton)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(daysComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(openingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(closingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setAllScheduleButton)
                            .addComponent(setScheduleButton))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Método para establecer un horario a una fecha en específico.
    private void setScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setScheduleButtonActionPerformed
        // Se obtiene la hora de inicio y el día.
        String hora = openingSpinner.getValue().toString();
        String dia = daysComboBox.getSelectedItem().toString();
        // Se guarda como entero la hora de inicio.
        int horaInicio = Integer.parseInt(hora.substring(0, 2));
        // Se obtiene la hora de clausura.
        hora = closingSpinner.getValue().toString();
        // Se guarda como entero la hora de clausura.
        int horaFin = Integer.parseInt(hora.substring(0, 2));
        // Si la hora de apertura es igual a la hora de clausura, se le avisará al usuario que esto hace que
        // el día se interprete como libre.
        if (horaInicio == horaFin){
            int result = JOptionPane.showConfirmDialog(this, "Usted esta dando este día como libre ¿Desea continuar?",
               "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // Si la opción es no, entonces sale y no hace ningún cambio.
            if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION){
                return;
            }
        }
        // En caso de que las horas difieran o en el caso anterior se haya recibido un sí como respuesta, se ejecuta el
        // siguiente bloque de código.
        try{
            // Se establece el horario con las horas solicitadas para el día solicitado.
            control.establecerHorario(DataVerification.stringDayToInt(dia), horaInicio, horaFin);
            Control.guardarDatos(control);
            JOptionPane.showMessageDialog(this, "Horario establecido para el día "+ dia +" exitosamente.",
                    "Notificación", JOptionPane.INFORMATION_MESSAGE);
            // Se cierra la ventana y se abre una nueva con los datos actualizados.
            dispose();
            ScheduleBS horarioMenu = new ScheduleBS();
            horarioMenu.setVisible(true);
        }catch (Exception e){
            // Si ocurre algún error imprevisto, se le notificará al usuario.
            JOptionPane.showMessageDialog(this, "Se ha previsto un error en el programa, intente de nuevo más tarde.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_setScheduleButtonActionPerformed

    private void daysComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysComboBoxActionPerformed
    }//GEN-LAST:event_daysComboBoxActionPerformed
    
    // Método para establecer el mismo horario a todos los días.
    private void setAllScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAllScheduleButtonActionPerformed
        // Se obtiene la hora de inicio.
        String hora = openingSpinner.getValue().toString();
        // Se guarda como entero la hora de inicio.
        int horaInicio = Integer.parseInt(hora.substring(0, 2));
        // Se obtiene la hora de clausura.
        hora = closingSpinner.getValue().toString();
        // Se guarda como entero la hora de clausura.
        int horaFin = Integer.parseInt(hora.substring(0, 2));
        // Si la hora de Inicio es igual que la hora de finalización, no se puede guardar el horario para ese día.
        if (horaInicio == horaFin){
            int result = JOptionPane.showConfirmDialog(this, "Usted está asignando todos los días como libres ¿Desea continuar?",
               "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            // Si la opción es no, entonces sale y no hace ningún cambio.
            if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION){
                return;
            }
        }
        // En caso de que las horas difieran o en el caso anterior se haya recibido un sí como respuesta, se ejecuta el
        // siguiente bloque de código.
        try{
            // Se establece el horario con las horas solicitadas para todos los días.
            control.establecerHorarioTodos(horaInicio, horaFin);
            Control.guardarDatos(control);
            JOptionPane.showMessageDialog(this, "Horario establecido para todos los días exitosamente.",
                    "Notificación", JOptionPane.INFORMATION_MESSAGE);
            // Se cierra la ventana y se abre una nueva con los datos actualizados.
            dispose();
            ScheduleBS horarioMenu = new ScheduleBS();
            horarioMenu.setVisible(true);
        }catch (Exception e){
            // Si ocurre algún error imprevisto, se le notificará al usuario.
            JOptionPane.showMessageDialog(this, "Se ha previsto un error en el programa, intente de nuevo más tarde.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_setAllScheduleButtonActionPerformed
    
     // Método para regresar al menú principal mediante un botón.
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
       // Se pregunta al usuario si desea volver al menú principal
        int result = JOptionPane.showConfirmDialog(this, "¿Desea volver al menú principal?",
               "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       // Si la respuesta es afirmativa entonces se cierra la ventana actual y se abre la ventana de menú principal.
        if (result == JOptionPane.YES_OPTION){
           dispose();
           Barberia barberia = new Barberia();
           barberia.setVisible(true);
       }       
    }//GEN-LAST:event_returnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ScheduleBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScheduleBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScheduleBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScheduleBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScheduleBS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner closingSpinner;
    private javax.swing.JComboBox<String> daysComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner openingSpinner;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton setAllScheduleButton;
    private javax.swing.JButton setScheduleButton;
    // End of variables declaration//GEN-END:variables
}