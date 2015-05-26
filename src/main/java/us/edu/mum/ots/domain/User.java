package us.edu.mum.ots.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author bipin
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_name", length = 50, nullable = false, unique = true, updatable = false)
    private String userName;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "middle_name", length = 50, nullable = true)
    private String middleName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "address", length = 255, nullable = false)
    private String address;
    @Column(name = "mobile", length = 15, nullable = false)
    private String mobile;

    public User() {
    }

    public User(String userName, String password, String firstName, String middleName, String lastName, String address, String mobile) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Email
    @NotNull(message = "Username cannot be empty.")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull(message = "Password cannot be empty.")
    @Pattern(regexp = "[A-Z0-9a-z]{6,50}", message = "Password must be alpha numeric with minimum 6 characters.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "First name cannot be empty.")
    @Pattern(regexp = "[A-Z0-9a-z\\s]{3,50}", message = "First name must be alpha numeric with minimum 3 characters.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @NotNull(message = "Last name cannot be empty.")
    @Pattern(regexp = "[A-Z0-9a-z\\s]{3,50}", message = "Last name must be alpha numeric with minimum 3 characters.")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "Address cannot be empty.")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull(message = "Mobile cannot be empty.")
    @Pattern(regexp = "[0-9\\s]{9,15}", message = "Mobile must be numeric with minimum 9 characters.")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

}
