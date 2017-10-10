package net.kang.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.kang.dto.Genre;
@Mapper
public interface GenreMapper {
	List<Genre> findAll();
	List<Genre> findAllWithMusics(int id);
	Genre findOne(int id);
	void insert(Genre genre);
	void update(Genre genre);
}
