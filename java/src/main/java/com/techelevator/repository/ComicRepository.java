package com.techelevator.repository;

import com.techelevator.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "comics", path = "comics")
public interface ComicRepository extends JpaRepository<Comic, Long> {
}
