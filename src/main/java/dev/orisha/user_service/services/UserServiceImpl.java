package dev.orisha.user_service.services;

import dev.orisha.user_service.data.models.User;
import dev.orisha.user_service.dto.PageData;
import dev.orisha.user_service.factory.RequestFactory;
import dev.orisha.user_service.mappers.UserMapper;
import dev.orisha.user_service.data.repositories.UserRepository;
import dev.orisha.user_service.dto.UserDTO;
import dev.orisha.user_service.dto.requests.UserUpdateRequest;
import dev.orisha.user_service.exceptions.UserNotFoundException;
import dev.orisha.user_service.services.criteria.UserCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.jhipster.service.filter.StringFilter;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserQueryService userQueryService;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository, final UserMapper userMapper,
                           final UserQueryService userQueryService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userQueryService = userQueryService;
    }

    @Override
    public UserDTO getUser(final String email) {
        log.info("Trying to find user by email: {}", email);
        UserCriteria userCriteria = new UserCriteria();
        StringFilter emailFilter = new StringFilter();
        emailFilter.setEquals(email);
        userCriteria.setEmail(emailFilter);

        return userQueryService.findOneByCriteria(userCriteria)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: '%s'".formatted(email)));
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest request) {
        UserDTO userDTO = getUser(request.getEmail());
        User user = userMapper.toEntity(userDTO);
        userMapper.partialUpdate(user, request);
        user.getAuthorities().add(request.getAuthority());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Trying to fetch all users");
        return userQueryService.findByCriteria(null);

//        Page<User> usesrs = userRepository.findAll((root, query, cb) -> cb.equal(root.get("email"), "username"), PageRequest.of(1, 2));
//        List<User> userss = userRepository.findAll((root, query, cb) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            predicates.add(cb.equal(root.get("email"), "username"));
//            return cb.and(predicates.toArray(new Predicate[0]));
//        });

    }

    @Override
    public PageData<UserDTO> getAllUsers(Pageable pageable) {
        log.info("Fetching all users with pageable: {}", pageable);
        Page<UserDTO> userDTOsPage = userQueryService.findByCriteria(null, pageable);
        PageData<UserDTO> pageData = RequestFactory.buildPageData(userDTOsPage);
        log.info("Found users {}", pageData);
        return pageData;
    }

}
