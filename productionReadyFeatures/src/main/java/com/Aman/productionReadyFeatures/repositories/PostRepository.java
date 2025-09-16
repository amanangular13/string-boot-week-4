package com.Aman.productionReadyFeatures.repositories;

import com.Aman.productionReadyFeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
