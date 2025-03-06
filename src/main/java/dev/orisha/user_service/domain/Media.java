package dev.orisha.user_service.domain;

import dev.orisha.user_service.domain.enumeration.Category;
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
 * A Media.
 */
@Setter
@Getter
@Entity
@Table(name = "media")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Media implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "url", nullable = false)
  private String url;

  @Column(name = "description")
  private String description;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "category", nullable = false)
  private Category category;

  @Column(name = "time_created")
  private Instant timeCreated;

  @Column(name = "time_updated")
  private Instant timeUpdated;

  @ManyToOne(fetch = FetchType.LAZY)
  private Uploader uploader;

  // jhipster-needle-entity-add-field - JHipster will add fields here

    public Media id(Long id) {
    this.setId(id);
    return this;
  }

    public Media url(String url) {
    this.setUrl(url);
    return this;
  }

    public Media description(String description) {
    this.setDescription(description);
    return this;
  }

    public Media category(Category category) {
    this.setCategory(category);
    return this;
  }

    public Media timeCreated(Instant timeCreated) {
    this.setTimeCreated(timeCreated);
    return this;
  }

    public Media timeUpdated(Instant timeUpdated) {
    this.setTimeUpdated(timeUpdated);
    return this;
  }

    public Media uploader(Uploader uploader) {
    this.setUploader(uploader);
    return this;
  }

  // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Media)) {
      return false;
    }
    return getId() != null && getId().equals(((Media) o).getId());
  }

  @Override
  public int hashCode() {
    // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    return getClass().hashCode();
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "Media{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", timeCreated='" + getTimeCreated() + "'" +
            ", timeUpdated='" + getTimeUpdated() + "'" +
            "}";
    }
}
