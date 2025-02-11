package dev.orisha.user_service.services.criteria;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

import lombok.Getter;
import lombok.Setter;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

@Setter
@Getter
public class UserCriteria implements Serializable, Criteria {

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

    public UserCriteria() {}

    public UserCriteria(UserCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.firstName = other.optionalFirstName().map(StringFilter::copy).orElse(null);
        this.lastName = other.optionalLastName().map(StringFilter::copy).orElse(null);
        this.email = other.optionalEmail().map(StringFilter::copy).orElse(null);
        this.password = other.optionalPassword().map(StringFilter::copy).orElse(null);
        this.dateRegistered = other.optionalDateRegistered().map(InstantFilter::copy).orElse(null);
        this.dateUpdated = other.optionalDateUpdated().map(InstantFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public UserCriteria copy() {
        return new UserCriteria(this);
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
        UserCriteria that = (UserCriteria) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(dateRegistered, that.dateRegistered) &&
                Objects.equals(dateUpdated, that.dateUpdated) &&
                Objects.equals(distinct, that.distinct);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "UserCriteria{", "}");

        optionalId().ifPresent(f -> joiner.add("id=" + f));
        optionalFirstName().ifPresent(f -> joiner.add("firstName=" + f));
        optionalLastName().ifPresent(f -> joiner.add("lastName=" + f));
        optionalEmail().ifPresent(f -> joiner.add("email=" + f));
        optionalPassword().ifPresent(f -> joiner.add("password=" + f));
        optionalDateRegistered().ifPresent(f -> joiner.add("dateRegistered=" + f));
        optionalDateUpdated().ifPresent(f -> joiner.add("dateUpdated=" + f));
        optionalDistinct().ifPresent(f -> joiner.add("distinct=" + f));

        return joiner.toString();
    }

}
