package com.cooksys.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.entity.Hashtag;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
	HashtagDto entityToDto(Hashtag hashtag);

	List<HashtagDto> entitiesToDtos(List<Hashtag> hashtags);

	Hashtag dtoToEntity(HashtagDto hashtagDto);

}
