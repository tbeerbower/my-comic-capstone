package com.techelevator.repository;

import com.techelevator.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
@RepositoryRestResource(collectionResourceRel = "characters", path = "characters")
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
