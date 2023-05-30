package br.ifpe.triunfopixel.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUnitUtil {
    private static final String URL = "jdbc:derby://localhost:1527/pdsc";
    private static final String USER = "app";
    private static final String PASSWORD = "app";
    private static final String XML_FILE = "./dbunit/init.sql";

    public static void inserirDados() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
                Statement statement = conn.createStatement()) {
            ClassLoader classLoader = DbUnitUtil.class.getClassLoader(); 
            URL resource = classLoader.getResource(XML_FILE);
            
            try (BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(!(line.isBlank() || line.isEmpty())) {
                        statement.execute(line.trim());
                    }
                }
                reader.close();
            }
            conn.close();
            statement.close();
        } catch (IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } 
    }
}
