package dev.orisha.user_service.service.dto;

import dev.orisha.user_service.domain.enumeration.Category;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link dev.orisha.user_service.domain.Media} entity.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MediaDTO implements Serializable {

  private Long id;

  @NotNull
  private String url;

  private String description;

  @NotNull
  private Category category;

  private Instant timeCreated;

  private Instant timeUpdated;

  private UploaderDTO uploader;

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MediaDTO mediaDTO)) {
      return false;
    }

        if (this.id == null) {
      return false;
    }
    return Objects.equals(this.id, mediaDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "MediaDTO{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", timeCreated='" + getTimeCreated() + "'" +
            ", timeUpdated='" + getTimeUpdated() + "'" +
            ", uploader=" + getUploader() +
            "}";
    }
}
