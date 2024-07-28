package model;

public class PatientRecord {
    private int id;
    private String matricula;
    private String nomeCompleto;
    private String tipoSanguineo;

    public PatientRecord(int id, String matricula, String nomeCompleto, String tipoSanguineo) {
        this.id = id;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.tipoSanguineo = tipoSanguineo;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
}
