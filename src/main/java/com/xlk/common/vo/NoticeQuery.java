package com.xlk.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhaochangxin
 * @Title: NoticeQuery
 * @Package com.xlk.common.vo
 * @Description: NoticeQuery
 * @date 2022/4/6 15:32
 */
@Data
public class NoticeQuery extends Page {
    private String message;
    private String start_date;
}
