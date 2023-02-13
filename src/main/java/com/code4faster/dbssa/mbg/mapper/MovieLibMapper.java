package com.code4faster.dbssa.mbg.mapper;

import com.code4faster.dbssa.mbg.model.MovieLib;
import java.util.List;

public interface MovieLibMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieLib record);

    MovieLib selectByPrimaryKey(Integer id);

    List<MovieLib> selectAll();

    int updateByPrimaryKey(MovieLib record);
}