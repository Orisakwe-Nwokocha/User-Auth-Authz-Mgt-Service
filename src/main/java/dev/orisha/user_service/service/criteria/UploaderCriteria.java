package dev.orisha.user_service.service.criteria;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link dev.orisha.user_service.domain.Uploader} entity. This class is used
 * to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /uploaders?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UploaderCriteria implements Serializable, Criteria {

  @Serial
  private static final long serialVersionUID = 1L;

  private LongFilter id;

  private StringFilter firstName;

  private StringFilter lastName;

  private StringFilter email;

  private StringFilter password;

  private InstantFilter dateRegistered;

  private InstantFilter dateUpdated;

  private Boolean distinct;

  public UploaderCriteria() {}

  public UploaderCriteria(UploaderCriteria other) {
    this.id = other.optionalId().map(LongFilter::copy).orElse(null);
    this.firstName = other
      .optionalFirstName()
      .map(StringFilter::copy)
      .orElse(null);
    this.lastName = other
      .optionalLastName()
      .map(StringFilter::copy)
      .orElse(null);
    this.email = other.optionalEmail().map(StringFilter::copy).orElse(null);
    this.password = other
      .optionalPassword()
      .map(StringFilter::copy)
      .orElse(null);
    this.dateRegistered = other
      .optionalDateRegistered()
      .map(InstantFilter::copy)
      .orElse(null);
    this.dateUpdated = other
      .optionalDateUpdated()
      .map(InstantFilter::copy)
      .orElse(null);
    this.distinct = other.distinct;
  }

  @Override
  public UploaderCriteria copy() {
    return new UploaderCriteria(this);
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

    public Optional<StringFilter> optionalFirstName() {
    return Optional.ofNullable(firstName);
  }

  public StringFilter firstName() {
    if (firstName == null) {
      setFirstName(new StringFilter());
    }
    return firstName;
  }

    public Optional<StringFilter> optionalLastName() {
    return Optional.ofNullable(lastName);
  }

  public StringFilter lastName() {
    if (lastName == null) {
      setLastName(new StringFilter());
    }
    return lastName;
  }

    public Optional<StringFilter> optionalEmail() {
    return Optional.ofNullable(email);
  }

  public StringFilter email() {
    if (email == null) {
      setEmail(new StringFilter());
    }
    return email;
  }

    public Optional<StringFilter> optionalPassword() {
    return Optional.ofNullable(password);
  }

  public StringFilter password() {
    if (password == null) {
      setPassword(new StringFilter());
    }
    return password;
  }

    public Optional<InstantFilter> optionalDateRegistered() {
    return Optional.ofNullable(dateRegistered);
  }

  public InstantFilter dateRegistered() {
    if (dateRegistered == null) {
      setDateRegistered(new InstantFilter());
    }
    return dateRegistered;
  }

    public Optional<InstantFilter> optionalDateUpdated() {
    return Optional.ofNullable(dateUpdated);
  }

  public InstantFilter dateUpdated() {
    if (dateUpdated == null) {
      setDateUpdated(new InstantFilter());
    }
    return dateUpdated;
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
    final UploaderCriteria that = (UploaderCriteria) o;
    return (
      Objects.equals(id, that.id) &&
      Objects.equals(firstName, that.firstName) &&
      Objects.equals(lastName, that.lastName) &&
      Objects.equals(email, that.email) &&
      Objects.equals(password, that.password) &&
      Objects.equals(dateRegistered, that.dateRegistered) &&
      Objects.equals(dateUpdated, that.dateUpdated) &&
      Objects.equals(distinct, that.distinct)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      id,
      firstName,
      lastName,
      email,
      password,
      dateRegistered,
      dateUpdated,
      distinct
    );
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "UploaderCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalFirstName().map(f -> "firstName=" + f + ", ").orElse("") +
            optionalLastName().map(f -> "lastName=" + f + ", ").orElse("") +
            optionalEmail().map(f -> "email=" + f + ", ").orElse("") +
            optionalPassword().map(f -> "password=" + f + ", ").orElse("") +
            optionalDateRegistered().map(f -> "dateRegistered=" + f + ", ").orElse("") +
            optionalDateUpdated().map(f -> "dateUpdated=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
