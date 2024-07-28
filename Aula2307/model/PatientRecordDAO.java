package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRecordDAO {
    private Connection connect() {
        String url = "jdbc:sqlite:patientrecords.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public List<PatientRecord> getAllRecords() {
        List<PatientRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM patient_records";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                records.add(new PatientRecord(
                    rs.getInt("id"),
                    rs.getString("matricula"),
                    rs.getString("nome_completo"),
                    rs.getString("tipo_sanguineo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public void addRecord(PatientRecord record) {
        String sql = "INSERT INTO patient_records(matricula, nome_completo, tipo_sanguineo) VALUES(?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, record.getMatricula());
            pstmt.setString(2, record.getNomeCompleto());
            pstmt.setString(3, record.getTipoSanguineo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
