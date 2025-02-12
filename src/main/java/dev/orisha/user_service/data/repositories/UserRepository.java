package dev.orisha.user_service.data.repositories;

import dev.orisha.user_service.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    boolean existsByEmail(final String email);

//    @Query("SELECT u FROM User u WHERE u.email=:email")
//    @EntityGraph(attributePaths = {"authorities"})
//    Optional<User> findByEmailWithEagerRelationships(final String email);

}
