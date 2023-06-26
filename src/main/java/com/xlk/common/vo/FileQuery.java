package com.xlk.common.vo;

import lombok.Data;

@Data
public class FileQuery extends Page {
    private String filename;
    private String filetype;
}
