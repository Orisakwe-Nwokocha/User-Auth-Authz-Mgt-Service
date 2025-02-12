package dev.orisha.user_service.services;

// for static metamodels

import dev.orisha.user_service.data.models.User;
import dev.orisha.user_service.data.models.User_;
import dev.orisha.user_service.data.repositories.UserRepository;
import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.mappers.UserMapper;
import dev.orisha.user_service.services.criteria.UserCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import java.util.List;
import java.util.Optional;

/**
 * Service for executing complex queries for {@link User} entities in the database.
 * The main input is a {@link dev.orisha.user_service.services.criteria.UserCriteria UserCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link dev.orisha.user_service.dto.UserDTO UserDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UserQueryService extends QueryService<User> {

    private static final Logger LOG = LoggerFactory.getLogger(UserQueryService.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserQueryService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> findOneByCriteria(UserCriteria criteria) {
        LOG.debug("find one by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        UserDTO dto = userMapper.toDto(userRepository.findOne(specification)
                                                     .orElse(null));
        return Optional.ofNullable(dto);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> findByCriteria(UserCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return userMapper.toDto(userRepository.findAll(specification));
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> findByCriteria(UserCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<User> specification = createSpecification(criteria);
        return userRepository.findAll(specification, page).map(userMapper::toDto);
    }

    @Transactional(readOnly = true)
    public long countByCriteria(UserCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<User> specification = createSpecification(criteria);
        return userRepository.count(specification);
    }

    protected Specification<User> createSpecification(UserCriteria criteria) {
        Specification<User> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), User_.id));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), User_.firstName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastName(), User_.lastName));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), User_.email));
            }
            if (criteria.getPassword() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPassword(), User_.password));
            }
            if (criteria.getDateRegistered() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateRegistered(), User_.dateRegistered));
            }
            if (criteria.getDateUpdated() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateUpdated(), User_.dateUpdated));
            }
        }
        return specification;
    }
}
