package br.com.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
