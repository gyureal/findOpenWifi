package com.example.findopenwifi.domain.model.bookmark;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class BookmarkGroup {
    private int id;
    private String groupName;
    private int order;
    private String dataRegDate;
    private String dataUpdDate;
    private String dataDelYn;
}
