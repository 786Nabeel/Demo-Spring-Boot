
package com.example.demo.repositories;

import com.example.demo.entities.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    
    
}
