package com.example.findopenwifi.domain.repository.bookmark;

import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;

import java.util.List;

public interface BookmarkGroupRepository {

    int save(BookmarkGroup bookmarkGroup);

    List<BookmarkGroup> findAll();

    BookmarkGroup findOne(int id);
    int update(int id, BookmarkGroup bookmarkGroup);
    int delete(int id);
}
