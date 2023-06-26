package com.xlk.mapper;

import com.xlk.common.vo.FileQuery;
import com.xlk.pojo.xlkFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface xlkFileMapper {
    void addXlkFile(xlkFile file);

    List<xlkFile> getFileList(FileQuery param);

    Long countFileList(FileQuery param);

    void deleteFileById(String ids);

    List<xlkFile> queryFileByIds(String ids);

    xlkFile queryFileById(String id);

}
