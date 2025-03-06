package dev.orisha.user_service.service.criteria;

import dev.orisha.user_service.domain.enumeration.Category;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link dev.orisha.user_service.domain.Media} entity. This class is used
 * to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /media?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@Setter
@Getter
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MediaCriteria implements Serializable, Criteria {

  /**
   * Class for filtering Category
   */
  public static class CategoryFilter extends Filter<Category> {

    public CategoryFilter() {}

    public CategoryFilter(CategoryFilter filter) {
      super(filter);
    }

    @Override
    public CategoryFilter copy() {
      return new CategoryFilter(this);
    }
  }

  @Serial
  private static final long serialVersionUID = 1L;

  private LongFilter id;

  private StringFilter url;

  private StringFilter description;

  private CategoryFilter category;

  private InstantFilter timeCreated;

  private InstantFilter timeUpdated;

  private LongFilter uploaderId;

  private Boolean distinct;

  public MediaCriteria() {}

  public MediaCriteria(MediaCriteria other) {
    this.id = other.optionalId().map(LongFilter::copy).orElse(null);
    this.url = other.optionalUrl().map(StringFilter::copy).orElse(null);
    this.description = other
      .optionalDescription()
      .map(StringFilter::copy)
      .orElse(null);
    this.category = other
      .optionalCategory()
      .map(CategoryFilter::copy)
      .orElse(null);
    this.timeCreated = other
      .optionalTimeCreated()
      .map(InstantFilter::copy)
      .orElse(null);
    this.timeUpdated = other
      .optionalTimeUpdated()
      .map(InstantFilter::copy)
      .orElse(null);
    this.uploaderId = other
      .optionalUploaderId()
      .map(LongFilter::copy)
      .orElse(null);
    this.distinct = other.distinct;
  }

  @Override
  public MediaCriteria copy() {
    return new MediaCriteria(this);
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

    public Optional<StringFilter> optionalUrl() {
    return Optional.ofNullable(url);
  }

  public StringFilter url() {
    if (url == null) {
      setUrl(new StringFilter());
    }
    return url;
  }

    public Optional<StringFilter> optionalDescription() {
    return Optional.ofNullable(description);
  }

  public StringFilter description() {
    if (description == null) {
      setDescription(new StringFilter());
    }
    return description;
  }

    public Optional<CategoryFilter> optionalCategory() {
    return Optional.ofNullable(category);
  }

  public CategoryFilter category() {
    if (category == null) {
      setCategory(new CategoryFilter());
    }
    return category;
  }

    public Optional<InstantFilter> optionalTimeCreated() {
    return Optional.ofNullable(timeCreated);
  }

  public InstantFilter timeCreated() {
    if (timeCreated == null) {
      setTimeCreated(new InstantFilter());
    }
    return timeCreated;
  }

    public Optional<InstantFilter> optionalTimeUpdated() {
    return Optional.ofNullable(timeUpdated);
  }

  public InstantFilter timeUpdated() {
    if (timeUpdated == null) {
      setTimeUpdated(new InstantFilter());
    }
    return timeUpdated;
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
    final MediaCriteria that = (MediaCriteria) o;
    return (
      Objects.equals(id, that.id) &&
      Objects.equals(url, that.url) &&
      Objects.equals(description, that.description) &&
      Objects.equals(category, that.category) &&
      Objects.equals(timeCreated, that.timeCreated) &&
      Objects.equals(timeUpdated, that.timeUpdated) &&
      Objects.equals(uploaderId, that.uploaderId) &&
      Objects.equals(distinct, that.distinct)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      id,
      url,
      description,
      category,
      timeCreated,
      timeUpdated,
      uploaderId,
      distinct
    );
  }

  // prettier-ignore
    @Override
    public String toString() {
        return "MediaCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalUrl().map(f -> "url=" + f + ", ").orElse("") +
            optionalDescription().map(f -> "description=" + f + ", ").orElse("") +
            optionalCategory().map(f -> "category=" + f + ", ").orElse("") +
            optionalTimeCreated().map(f -> "timeCreated=" + f + ", ").orElse("") +
            optionalTimeUpdated().map(f -> "timeUpdated=" + f + ", ").orElse("") +
            optionalUploaderId().map(f -> "uploaderId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
