package softuni.winelovers.data.models.user;

import org.hibernate.annotations.GenericGenerator;
import softuni.winelovers.data.models.base.BaseEntity;
import softuni.winelovers.data.models.wine.Wine;
import softuni.winelovers.data.models.wine.WineNote;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "usernames", nullable = false, unique = true)
    private String username;

    @Column(name = "passwords", nullable = false)
    private String password;

    @Column(name = "emails", unique = true, nullable = false)
    private String email;

    @Column(name = "roles")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @Column(name = "is_mail_confirmed")
    private boolean isMailConfirmed;

    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "mail_confirmation_code", nullable = false, unique = true, updatable = false)
    private String mailConfirmationCode;

    @Column(name = "date_registered", nullable = false)
    private Date dateRegistered;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_wines",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "wine_id") }
    )
    private List<Wine> wines;


    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isMailConfirmed() {
        return isMailConfirmed;
    }

    public void setMailConfirmed(boolean mailConfirmed) {
        isMailConfirmed = mailConfirmed;
    }

    public String getMailConfirmationCode() {
        return mailConfirmationCode;
    }

    public void setMailConfirmationCode(String mailConfirmationCode) {
        this.mailConfirmationCode = mailConfirmationCode;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public List<Wine> getWines() {
        return wines;
    }

    public void setWines(List<Wine> wines) {
        this.wines = wines;
    }

    public void addWine(Wine wine){
        this.wines.add(wine);
    }

}
