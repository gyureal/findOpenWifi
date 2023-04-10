package com.example.findopenwifi.domain.model.bookmark;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Bookmark {
    private int id;
    private int bookmarkGroupId;
    private String bookmarkGroupName;
    private String mgrNo;
    private String mgrName;
    private String dataRegDate;
    private String dataDelYn;
}
