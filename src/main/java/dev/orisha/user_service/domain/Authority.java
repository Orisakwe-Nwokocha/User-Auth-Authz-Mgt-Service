package dev.orisha.user_service.domain;

import dev.orisha.user_service.domain.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Authority.
 */
@Setter
@Getter
@Entity
@Table(name = "authority")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Authority implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;

  @ManyToOne(fetch = FetchType.LAZY)
  private Uploader uploader;

  // jhipster-needle-entity-add-field - JHipster will add fields here

    public Authority id(Long id) {
    this.setId(id);
    return this;
  }

    public Authority role(Role role) {
    this.setRole(role);
    return this;
  }

    public Authority uploader(Uploader uploader) {
    this.setUploader(uploader);
    return this;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Authority)) {
      return false;
    }
    return getId() != null && getId().equals(((Authority) o).getId());
  }

  @Override
  public int hashCode() {
    // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    return getClass().hashCode();
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "Authority{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            "}";
    }
}
