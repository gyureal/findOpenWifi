package com.example.findopenwifi.domain.service.bookmark;

import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;

import java.util.List;

public interface BookmarkGroupService {

    List<BookmarkGroup> getAllBookmarkGroup();

    BookmarkGroup getOne(int id);

    int addBookmarkGroup(BookmarkGroup bookmarkGroup);

    int updateBookmarkGroup(int id, BookmarkGroup bookmarkGroup);

    int deleteBookmarkGroup(int id);
}
