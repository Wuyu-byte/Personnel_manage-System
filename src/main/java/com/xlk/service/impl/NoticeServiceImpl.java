package com.xlk.service.impl;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.xlk.common.vo.NoticeQuery;
import com.xlk.mapper.NoticeMapper;
import com.xlk.pojo.Notice;
import com.xlk.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaochangxin
 * @Title: NoticeServiceImpl
 * @Package com.xlk.service.impl
 * @Description: NoticeServiceImpl
 * @date 2022/4/6 15:34
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNoticeList(NoticeQuery param) {
        return noticeMapper.getNoticeList(param);
    }

    @Override
    public Long countNoticeList(NoticeQuery param) {
        return noticeMapper.countNoticeList(param);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    @Override
    public void deleteNoticeById(String ids) {
        noticeMapper.deleteNoticeById(ids);
    }
}
