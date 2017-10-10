package net.kang.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.kang.dto.Music;

@Mapper
public interface MusicMapper {
	Music findOne(int id);
	Music findByTitle(String title);
	List<Music> findByGenreId(int genreId);
	List<Music> findAll();
	void insert(Music music);
	void update(Music music);
	void delete(int id);
}
