package com.example.findopenwifi.domain.service.bookmark;


import com.example.findopenwifi.domain.model.bookmark.Bookmark;

import java.util.List;

public interface BookmarkService {

    List<Bookmark> getAllBookmark();

    int addBookmark(Bookmark bookmark);

    int delete(int id);
}
