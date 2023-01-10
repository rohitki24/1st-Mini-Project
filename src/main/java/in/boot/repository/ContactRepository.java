package in.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.boot.binding.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
