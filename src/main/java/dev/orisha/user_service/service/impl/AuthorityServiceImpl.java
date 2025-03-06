package dev.orisha.user_service.service.impl;

import dev.orisha.user_service.domain.Authority;
import dev.orisha.user_service.repository.AuthorityRepository;
import dev.orisha.user_service.service.AuthorityService;
import dev.orisha.user_service.service.dto.AuthorityDTO;
import dev.orisha.user_service.service.mapper.AuthorityMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link dev.orisha.user_service.domain.Authority}.
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

  private static final Logger log = LoggerFactory.getLogger(
    AuthorityServiceImpl.class
  );

  private final AuthorityRepository authorityRepository;

  private final AuthorityMapper authorityMapper;

  public AuthorityServiceImpl(
    AuthorityRepository authorityRepository,
    AuthorityMapper authorityMapper
  ) {
    this.authorityRepository = authorityRepository;
    this.authorityMapper = authorityMapper;
  }

  @Override
  public AuthorityDTO save(AuthorityDTO authorityDTO) {
    log.debug("Request to save Authority : {}", authorityDTO);
    Authority authority = authorityMapper.toEntity(authorityDTO);
    authority = authorityRepository.save(authority);
    return authorityMapper.toDto(authority);
  }

  @Override
  public AuthorityDTO update(AuthorityDTO authorityDTO) {
    log.debug("Request to update Authority : {}", authorityDTO);
    Authority authority = authorityMapper.toEntity(authorityDTO);
    authority = authorityRepository.save(authority);
    return authorityMapper.toDto(authority);
  }

  @Override
  public Optional<AuthorityDTO> partialUpdate(AuthorityDTO authorityDTO) {
    log.debug("Request to partially update Authority : {}", authorityDTO);

    return authorityRepository
      .findById(authorityDTO.getId())
      .map(existingAuthority -> {
        authorityMapper.partialUpdate(existingAuthority, authorityDTO);

        return existingAuthority;
      })
      .map(authorityRepository::save)
      .map(authorityMapper::toDto);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<AuthorityDTO> findOne(Long id) {
    log.debug("Request to get Authority : {}", id);
    return authorityRepository.findById(id).map(authorityMapper::toDto);
  }

  @Override
  public void delete(Long id) {
    log.debug("Request to delete Authority : {}", id);
    authorityRepository.deleteById(id);
  }
}
