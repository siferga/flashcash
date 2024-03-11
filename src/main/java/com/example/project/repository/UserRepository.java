package com.example.project.repository;


import com.example.project.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    //attention HQL on pointe sur les objets du code et pas sur la base en direct
    // au besoin si on veux faire du vrai sql rajouter, nativeQuery = true
    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.socialLinkList WHERE u.email=:email ")
    public Optional<User> findUserByMail(String email);

}
