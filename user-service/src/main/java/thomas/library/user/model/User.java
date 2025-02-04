package thomas.library.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import thomas.library.user.tools.MembershipTypeEnum;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private MembershipTypeEnum membershipType; // Regular, Premium
    private boolean isLocked;
    private Integer nombreMaxEmprunt;

    public User() {
    }

    public User(String name, String email, MembershipTypeEnum membershipType, boolean isLocked, Integer nombreMaxEmprunt) {
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.isLocked = isLocked;
        this.nombreMaxEmprunt = nombreMaxEmprunt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public MembershipTypeEnum getMembershipType() {
        return membershipType;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Integer getNombreMaxEmprunt() {
        return nombreMaxEmprunt;
    }

    public void setNombreMaxEmprunt(Integer nombreMaxEmprunt) {
        this.nombreMaxEmprunt = nombreMaxEmprunt;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setMembershipType(MembershipTypeEnum membershipType) {
        this.membershipType = membershipType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
