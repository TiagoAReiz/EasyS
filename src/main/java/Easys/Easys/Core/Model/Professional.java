package Easys.Easys.Core.Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Professional extends User {
    private Long professionalId;
    private String cpf;
    private String professionalType;
    private String professionalDescription;

    public Long getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
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
    public Professional(UUID id, String name, String email, String phone, String passwordHash, LocalDateTime createdAt,
            LocalDateTime updatedAt, Long professionalId, String cpf) {
        super();
        this.professionalId = professionalId;
        this.cpf = cpf;
    }

}
