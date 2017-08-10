package com.database;

import com.common.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao {

	List<Image> getImage(Image image);

}
