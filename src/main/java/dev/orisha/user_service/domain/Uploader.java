package dev.orisha.user_service.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Uploader.
 */
@Setter
@Getter
@Entity
@Table(name = "uploader")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Uploader implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @NotNull
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @NotNull
  @Column(name = "password", nullable = false)
  private String password;

  @NotNull
  @Column(name = "date_registered", nullable = false)
  private Instant dateRegistered;

  @Column(name = "date_updated")
  private Instant dateUpdated;

  // jhipster-needle-entity-add-field - JHipster will add fields here

    public Uploader id(Long id) {
      this.setId(id);
      return this;
  }

    public Uploader firstName(String firstName) {
      this.setFirstName(firstName);
      return this;
  }

    public Uploader lastName(String lastName) {
      this.setLastName(lastName);
      return this;
  }

    public Uploader email(String email) {
      this.setEmail(email);
      return this;
  }

    public Uploader password(String password) {
      this.setPassword(password);
      return this;
  }

    public Uploader dateRegistered(Instant dateRegistered) {
      this.setDateRegistered(dateRegistered);
      return this;
  }

    public Uploader dateUpdated(Instant dateUpdated) {
      this.setDateUpdated(dateUpdated);
      return this;
  }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Uploader)) {
      return false;
    }
    return getId() != null && getId().equals(((Uploader) o).getId());
  }

  @Override
  public int hashCode() {
    // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    return getClass().hashCode();
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "Uploader{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", dateRegistered='" + getDateRegistered() + "'" +
            ", dateUpdated='" + getDateUpdated() + "'" +
            "}";
    }
}
