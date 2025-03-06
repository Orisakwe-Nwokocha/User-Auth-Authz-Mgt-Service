package dev.orisha.user_service.repository;

import dev.orisha.user_service.domain.Authority;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorityRepository
  extends JpaRepository<Authority, Long>, JpaSpecificationExecutor<Authority> {}
