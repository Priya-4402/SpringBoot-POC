package com.techymeet.jparespository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techymeet.vo.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Long >  {

	Optional<ImageEntity> findByName(String imageName);

}
