package com.credibleninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.credibleninjas.entities.FacebookEntity;

public interface FacebookRepository extends CrudRepository<FacebookEntity, String> {

}
