package dev.orisha.user_service.service.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link dev.orisha.user_service.domain.Uploader} entity.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UploaderDTO implements Serializable {

  private Long id;

  private String firstName;

  private String lastName;

  @NotNull
  private String email;

  @NotNull
  private String password;

  @NotNull
  private Instant dateRegistered;

  private Instant dateUpdated;

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UploaderDTO uploaderDTO)) {
      return false;
    }

        if (this.id == null) {
      return false;
    }
    return Objects.equals(this.id, uploaderDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "UploaderDTO{" +
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
