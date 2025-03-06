package dev.orisha.user_service.service;

import dev.orisha.user_service.service.dto.UploaderDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link dev.orisha.user_service.domain.Uploader}.
 */
public interface UploaderService {
  /**
   * Save a uploader.
   *
   * @param uploaderDTO the entity to save.
   * @return the persisted entity.
   */
  UploaderDTO save(UploaderDTO uploaderDTO);

  /**
   * Updates a uploader.
   *
   * @param uploaderDTO the entity to update.
   * @return the persisted entity.
   */
  UploaderDTO update(UploaderDTO uploaderDTO);

  /**
   * Partially updates a uploader.
   *
   * @param uploaderDTO the entity to update partially.
   * @return the persisted entity.
   */
  Optional<UploaderDTO> partialUpdate(UploaderDTO uploaderDTO);

  /**
   * Get the "id" uploader.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<UploaderDTO> findOne(Long id);

  /**
   * Delete the "id" uploader.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);
}
