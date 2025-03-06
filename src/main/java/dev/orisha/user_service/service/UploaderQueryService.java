package dev.orisha.user_service.service;

import dev.orisha.user_service.domain.*; // for static metamodels
import dev.orisha.user_service.domain.Uploader;
import dev.orisha.user_service.repository.UploaderRepository;
import dev.orisha.user_service.service.criteria.UploaderCriteria;
import dev.orisha.user_service.service.dto.UploaderDTO;
import dev.orisha.user_service.service.mapper.UploaderMapper;
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
 * Service for executing complex queries for {@link Uploader} entities in the database.
 * The main input is a {@link UploaderCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link UploaderDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UploaderQueryService extends QueryService<Uploader> {

  private static final Logger log = LoggerFactory.getLogger(
    UploaderQueryService.class
  );

  private final UploaderRepository uploaderRepository;

  private final UploaderMapper uploaderMapper;

  public UploaderQueryService(
    UploaderRepository uploaderRepository,
    UploaderMapper uploaderMapper
  ) {
    this.uploaderRepository = uploaderRepository;
    this.uploaderMapper = uploaderMapper;
  }

  /**
   * Return a {@link List} of {@link UploaderDTO} which matches the criteria from the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the matching entities.
   */
  @Transactional(readOnly = true)
  public List<UploaderDTO> findByCriteria(UploaderCriteria criteria) {
    log.debug("find by criteria : {}", criteria);
    final Specification<Uploader> specification = createSpecification(criteria);
    return uploaderMapper.toDto(uploaderRepository.findAll(specification));
  }

  /**
   * Return a {@link Page} of {@link UploaderDTO} which matches the criteria from the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @param page The page, which should be returned.
   * @return the matching entities.
   */
  @Transactional(readOnly = true)
  public Page<UploaderDTO> findByCriteria(UploaderCriteria criteria, Pageable page) {
    log.debug("find by criteria : {}, page: {}", criteria, page);
    final Specification<Uploader> specification = createSpecification(criteria);
    return uploaderRepository.findAll(specification, page).map(uploaderMapper::toDto);
  }

  /**
   * Return the number of matching entities in the database.
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the number of matching entities.
   */
  @Transactional(readOnly = true)
  public long countByCriteria(UploaderCriteria criteria) {
    log.debug("count by criteria : {}", criteria);
    final Specification<Uploader> specification = createSpecification(criteria);
    return uploaderRepository.count(specification);
  }

  /**
   * Function to convert {@link UploaderCriteria} to a {@link Specification}
   * @param criteria The object which holds all the filters, which the entities should match.
   * @return the matching {@link Specification} of the entity.
   */
  protected Specification<Uploader> createSpecification(
    UploaderCriteria criteria
  ) {
    Specification<Uploader> specification = Specification.where(null);
    if (criteria != null) {
      // This has to be called first, because the distinct method returns null
      if (criteria.getDistinct() != null) {
        specification = specification.and(distinct(criteria.getDistinct()));
      }
      if (criteria.getId() != null) {
        specification = specification.and(
          buildRangeSpecification(criteria.getId(), Uploader_.id)
        );
      }
      if (criteria.getFirstName() != null) {
        specification = specification.and(
          buildStringSpecification(criteria.getFirstName(), Uploader_.firstName)
        );
      }
      if (criteria.getLastName() != null) {
        specification = specification.and(
          buildStringSpecification(criteria.getLastName(), Uploader_.lastName)
        );
      }
      if (criteria.getEmail() != null) {
        specification = specification.and(
          buildStringSpecification(criteria.getEmail(), Uploader_.email)
        );
      }
      if (criteria.getPassword() != null) {
        specification = specification.and(
          buildStringSpecification(criteria.getPassword(), Uploader_.password)
        );
      }
      if (criteria.getDateRegistered() != null) {
        specification = specification.and(
          buildRangeSpecification(
            criteria.getDateRegistered(),
            Uploader_.dateRegistered
          )
        );
      }
      if (criteria.getDateUpdated() != null) {
        specification = specification.and(
          buildRangeSpecification(
            criteria.getDateUpdated(),
            Uploader_.dateUpdated
          )
        );
      }
    }
    return specification;
  }
}
