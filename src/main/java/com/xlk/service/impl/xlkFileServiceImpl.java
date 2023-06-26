package com.xlk.service.impl;

import com.xlk.common.vo.FileQuery;
import com.xlk.mapper.xlkFileMapper;
import com.xlk.pojo.xlkFile;
import com.xlk.service.xlkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class xlkFileServiceImpl  implements xlkFileService {
    @Autowired
    xlkFileMapper xlkFileMapper;
    @Override
    public void addXlkFile(xlkFile file) {
        xlkFileMapper.addXlkFile(file);
    }

    @Override
    public List<xlkFile> getFileList(FileQuery param) {
        return xlkFileMapper.getFileList(param);
    }

    @Override
    public Long countFileList(FileQuery param) {
        return xlkFileMapper.countFileList(param);
    }

    @Override
    public void deleteFileById(String ids) {
        xlkFileMapper.deleteFileById(ids);
    }

    @Override
    public List<xlkFile> queryFileByIds(String ids) {
        return xlkFileMapper.queryFileByIds(ids);
    }

    @Override
    public xlkFile queryFileById(String id) {
        return xlkFileMapper.queryFileById(id);
    }
}
