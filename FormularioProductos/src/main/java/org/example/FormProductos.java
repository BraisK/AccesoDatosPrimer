package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.Vector;

public class FormProductos {
    private JTable table1;
    private JPanel panel1;
    private JScrollPane FormProductos;
    private JButton mostrarTablaButton;
    private JButton cargarDatosButton;
    private JButton exportarDatosButton;
    private Connection conn;

    public FormProductos(Connection conn) {
        this.conn = conn;

        JFrame frame = new JFrame("Gestión de Productos");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Acción para mostrar la tabla
        mostrarTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTabla();
            }
        });

        // Acción para cargar datos desde un fichero
        cargarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosDesdeFichero();
            }
        });

        // Acción para exportar datos a un fichero
        exportarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarDatosAFichero();
            }
        });
    }

    private void mostrarTabla() {
        try {
            String query = "SELECT * FROM products"; // Cambia "productos" al nombre de tu tabla
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Crear un modelo para la tabla
            DefaultTableModel model = new DefaultTableModel();
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Añadir nombres de las columnas
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }

            // Añadir filas
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                model.addRow(row);
            }

            table1.setModel(model);

            statement.close();
            resultSet.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel1, "Error al mostrar los datos: " + ex.getMessage());
        }
    }

    private void cargarDatosDesdeFichero() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos TXT", "txt"));
        int result = fileChooser.showOpenDialog(panel1);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int registrosInsertados = 0;

                while ((line = reader.readLine()) != null) {
                    String[] valores = line.split(",");
                    if (valores.length != 3) { // Cambia este valor según las columnas de tu tabla
                        JOptionPane.showMessageDialog(panel1, "Formato de fichero incorrecto.");
                        return;
                    }

                    String query = "INSERT INTO productos (columna1, columna2, columna3) VALUES (?, ?, ?)";
                    try (PreparedStatement statement = conn.prepareStatement(query)) {
                        statement.setString(1, valores[0]); // Ajusta las columnas según tu tabla
                        statement.setString(2, valores[1]);
                        statement.setString(3, valores[2]);
                        registrosInsertados += statement.executeUpdate();
                    }
                }

                JOptionPane.showMessageDialog(panel1, "SE HAN IMPORTADO " + registrosInsertados + " REGISTROS.");
                mostrarTabla();

            } catch (IOException | SQLException ex) {
                JOptionPane.showMessageDialog(panel1, "Error al cargar datos: " + ex.getMessage());
            }
        }
    }

    private void exportarDatosAFichero() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(panel1);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                String query = "SELECT * FROM products"; // Cambia "productos" por el nombre de tu tabla
                try (PreparedStatement statement = conn.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {

                    int columnCount = resultSet.getMetaData().getColumnCount();
                    int registrosExportados = 0;

                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            writer.write(resultSet.getString(i));
                            if (i < columnCount) {
                                writer.write(",");
                            }
                        }
                        writer.newLine();
                        registrosExportados++;
                    }

                    JOptionPane.showMessageDialog(panel1, "SE HAN EXPORTADO " + registrosExportados + " REGISTROS.");
                }

            } catch (IOException | SQLException ex) {
                JOptionPane.showMessageDialog(panel1, "Error al exportar datos: " + ex.getMessage());
            }
        }
    }
}
