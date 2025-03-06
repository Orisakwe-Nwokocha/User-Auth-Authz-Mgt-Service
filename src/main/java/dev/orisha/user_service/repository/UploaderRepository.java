package dev.orisha.user_service.repository;

import dev.orisha.user_service.domain.Uploader;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Uploader entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UploaderRepository
  extends JpaRepository<Uploader, Long>, JpaSpecificationExecutor<Uploader> {}
