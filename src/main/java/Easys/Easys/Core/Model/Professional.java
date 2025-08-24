package Easys.Easys.Core.Model;

import java.time.LocalDateTime;

public class Professional extends User {
    private String cpf;
    private String professionalType;
    private String professionalDescription;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {    
        this.cpf = cpf;
    }

    public String getProfessionalType() {
        return professionalType;
    }

    public void setProfessionalType(String professionalType) {
        this.professionalType = professionalType;
    }

    public String getProfessionalDescription() {
        return professionalDescription;
    }

    public void setProfessionalDescription(String professionalDescription) {
        this.professionalDescription = professionalDescription;
    }

    public Professional() {
        super();
    }
    public Professional(String name, String email, String phone, String passwordHash, LocalDateTime createdAt,
            LocalDateTime updatedAt, String cpf, String professionalType, String professionalDescription) {
        super();
        this.cpf = cpf;
        this.professionalType = professionalType;
        this.professionalDescription = professionalDescription;
    }

}
