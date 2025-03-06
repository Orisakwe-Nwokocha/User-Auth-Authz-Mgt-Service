package dev.orisha.user_service.service;

import dev.orisha.user_service.service.dto.AuthorityDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link dev.orisha.user_service.domain.Authority}.
 */
public interface AuthorityService {
  /**
   * Save a authority.
   *
   * @param authorityDTO the entity to save.
   * @return the persisted entity.
   */
  AuthorityDTO save(AuthorityDTO authorityDTO);

  /**
   * Updates a authority.
   *
   * @param authorityDTO the entity to update.
   * @return the persisted entity.
   */
  AuthorityDTO update(AuthorityDTO authorityDTO);

  /**
   * Partially updates a authority.
   *
   * @param authorityDTO the entity to update partially.
   * @return the persisted entity.
   */
  Optional<AuthorityDTO> partialUpdate(AuthorityDTO authorityDTO);

  /**
   * Get the "id" authority.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<AuthorityDTO> findOne(Long id);

  /**
   * Delete the "id" authority.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);
}
