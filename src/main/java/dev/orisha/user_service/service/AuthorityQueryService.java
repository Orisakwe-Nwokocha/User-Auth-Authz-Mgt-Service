package dev.orisha.user_service.service;

import dev.orisha.user_service.domain.*; // for static metamodels
import dev.orisha.user_service.domain.Authority;
import dev.orisha.user_service.repository.AuthorityRepository;
import dev.orisha.user_service.service.criteria.AuthorityCriteria;
import dev.orisha.user_service.service.dto.AuthorityDTO;
import dev.orisha.user_service.service.mapper.AuthorityMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import java.util.List;

/**
 * Service for executing complex queries for {@link Authority} entities in the database.
 * The main input is a {@link AuthorityCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link AuthorityDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AuthorityQueryService extends QueryService<Authority> {

  private static final Logger log = LoggerFactory.getLogger(AuthorityQueryService.class);

  private final AuthorityRepository authorityRepository;

  private final AuthorityMapper authorityMapper;

  public AuthorityQueryService(AuthorityRepository authorityRepository, AuthorityMapper authorityMapper) {
    this.authorityRepository = authorityRepository;
    this.authorityMapper = authorityMapper;
  }

  /**
   * Return a {@link List} of {@link AuthorityDTO} which matches the criteria from the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the matching entities.
   */
  @Transactional(readOnly = true)
  public List<AuthorityDTO> findByCriteria(AuthorityCriteria criteria) {
    log.debug("find by criteria : {}", criteria);
    final Specification<Authority> specification = createSpecification(criteria);
    return authorityMapper.toDto(authorityRepository.findAll(specification));
  }

  /**
   * Return a {@link Page} of {@link AuthorityDTO} which matches the criteria from the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @param page The page, which should be returned.
   * @return the matching entities.
   */
  @Transactional(readOnly = true)
  public Page<AuthorityDTO> findByCriteria(AuthorityCriteria criteria, Pageable page) {
    log.debug("find by criteria : {}, page: {}", criteria, page);
    final Specification<Authority> specification = createSpecification(criteria);
    return authorityRepository.findAll(specification, page).map(authorityMapper::toDto);
  }

  /**
   * Return the number of matching entities in the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the number of matching entities.
   */
  @Transactional(readOnly = true)
  public long countByCriteria(AuthorityCriteria criteria) {
    log.debug("count by criteria : {}", criteria);
    final Specification<Authority> specification = createSpecification(criteria);
    return authorityRepository.count(specification);
  }

  /**
   * Function to convert {@link AuthorityCriteria} to a {@link Specification}
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the matching {@link Specification} of the entity.
   */
  protected Specification<Authority> createSpecification(
    AuthorityCriteria criteria
  ) {
    Specification<Authority> specification = Specification.where(null);
    if (criteria != null) {
      // This has to be called first, because the distinct method returns null
      if (criteria.getDistinct() != null) {
        specification = specification.and(distinct(criteria.getDistinct()));
      }
      if (criteria.getId() != null) {
        specification = specification.and(
          buildRangeSpecification(criteria.getId(), Authority_.id)
        );
      }
      if (criteria.getRole() != null) {
        specification = specification.and(
          buildSpecification(criteria.getRole(), Authority_.role)
        );
      }
      if (criteria.getUploaderId() != null) {
        specification = specification.and(
          buildSpecification(
            criteria.getUploaderId(),
            root ->
              root.join(Authority_.uploader, JoinType.LEFT).get(Uploader_.id)
          )
        );
      }
    }
    return specification;
  }
}
