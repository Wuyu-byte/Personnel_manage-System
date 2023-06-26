package com.xlk.mapper;

import com.xlk.common.vo.NoticeQuery;
import com.xlk.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author zhaochangxin
 * @Title: NoticeMapper
 * @Package com.xlk.mapper
 * @Description: NoticeMapper
 * @date 2022/4/6 15:30
 */
@Mapper
@Repository
public interface NoticeMapper {
    List<Notice> getNoticeList(NoticeQuery param);

    Long countNoticeList(NoticeQuery param);

    void addNotice(Notice notice);

    void deleteNoticeById(String ids);
}
