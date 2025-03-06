package dev.orisha.user_service.service.criteria;

import dev.orisha.user_service.domain.enumeration.Role;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link dev.orisha.user_service.domain.Authority} entity. This class is used
 *  to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /authorities?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AuthorityCriteria implements Serializable, Criteria {

  /**
   * Class for filtering Role
   */
  public static class RoleFilter extends Filter<Role> {

    public RoleFilter() {}

    public RoleFilter(RoleFilter filter) {
      super(filter);
    }

    @Override
    public RoleFilter copy() {
      return new RoleFilter(this);
    }
  }

  @Serial
  private static final long serialVersionUID = 1L;

  private LongFilter id;

  private RoleFilter role;

  private LongFilter uploaderId;

  private Boolean distinct;

  public AuthorityCriteria() {}

  public AuthorityCriteria(AuthorityCriteria other) {
    this.id = other.optionalId().map(LongFilter::copy).orElse(null);
    this.role = other.optionalRole().map(RoleFilter::copy).orElse(null);
    this.uploaderId = other
      .optionalUploaderId()
      .map(LongFilter::copy)
      .orElse(null);
    this.distinct = other.distinct;
  }

  @Override
  public AuthorityCriteria copy() {
    return new AuthorityCriteria(this);
  }

    public Optional<LongFilter> optionalId() {
    return Optional.ofNullable(id);
  }

  public LongFilter id() {
    if (id == null) {
      setId(new LongFilter());
    }
    return id;
  }

    public Optional<RoleFilter> optionalRole() {
    return Optional.ofNullable(role);
  }

  public RoleFilter role() {
    if (role == null) {
      setRole(new RoleFilter());
    }
    return role;
  }

    public Optional<LongFilter> optionalUploaderId() {
    return Optional.ofNullable(uploaderId);
  }

  public LongFilter uploaderId() {
    if (uploaderId == null) {
      setUploaderId(new LongFilter());
    }
    return uploaderId;
  }

    public Optional<Boolean> optionalDistinct() {
    return Optional.ofNullable(distinct);
  }

  public Boolean distinct() {
    if (distinct == null) {
      setDistinct(true);
    }
    return distinct;
  }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final AuthorityCriteria that = (AuthorityCriteria) o;
    return (
      Objects.equals(id, that.id) &&
      Objects.equals(role, that.role) &&
      Objects.equals(uploaderId, that.uploaderId) &&
      Objects.equals(distinct, that.distinct)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, role, uploaderId, distinct);
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "AuthorityCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalRole().map(f -> "role=" + f + ", ").orElse("") +
            optionalUploaderId().map(f -> "uploaderId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
