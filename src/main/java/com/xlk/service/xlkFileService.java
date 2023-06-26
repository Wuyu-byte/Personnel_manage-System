package com.xlk.service;

import com.xlk.common.vo.FileQuery;
import com.xlk.pojo.Employee;
import com.xlk.pojo.xlkFile;

import java.util.List;

public interface xlkFileService {
    void addXlkFile(xlkFile file);

    List<xlkFile> getFileList(FileQuery param);

    Long countFileList(FileQuery param);

    void deleteFileById(String ids);

    List<xlkFile> queryFileByIds(String ids);

    xlkFile queryFileById(String id);
}
