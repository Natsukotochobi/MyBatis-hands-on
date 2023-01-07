package com.raisetech.mybatishandson.mapper;

import com.raisetech.mybatishandson.entity.Songs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper // MyBatisのMapperである目印として@Mapperアノテーションを付与する
public interface SongsMapper {
 @Select("SELECT * FROM songs")
 List<Songs> findAll();

 @Select("SELECT * FROM songs WHERE year = #{year}")
 Optional<Songs> findById();

}
