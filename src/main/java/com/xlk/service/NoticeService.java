package com.xlk.service;

import com.xlk.common.vo.NoticeQuery;
import com.xlk.pojo.Notice;

import java.util.List;

/**
 * @author zhaochangxin
 * @Title: NoticeService
 * @Package com.xlk.service
 * @Description: NoticeService
 * @date 2022/4/6 15:33
 */
public interface NoticeService {
    List<Notice> getNoticeList(NoticeQuery param);

    Long countNoticeList(NoticeQuery param);

    void addNotice(Notice notice);

    void deleteNoticeById(String ids);
}
