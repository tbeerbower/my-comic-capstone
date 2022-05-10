package com.techelevator.repository;

import com.techelevator.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "collections", path = "collections")
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
