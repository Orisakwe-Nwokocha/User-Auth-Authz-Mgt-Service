package dev.orisha.user_service.service.dto;

import dev.orisha.user_service.domain.enumeration.Role;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link dev.orisha.user_service.domain.Authority} entity.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AuthorityDTO implements Serializable {

  private Long id;

  @NotNull
  private Role role;

  private UploaderDTO uploader;

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AuthorityDTO authorityDTO)) {
      return false;
    }

        if (this.id == null) {
      return false;
    }
    return Objects.equals(this.id, authorityDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "AuthorityDTO{" +
            "id=" + getId() +
            ", role='" + getRole() + "'" +
            ", uploader=" + getUploader() +
            "}";
    }
}
