package com.example.findopenwifi.domain.repository.bookmark;

import com.example.findopenwifi.domain.model.bookmark.Bookmark;

import java.util.List;

public interface BookmarkRepository {
    List<Bookmark> findAll();
    int insert(Bookmark bookmark);

    int delete(int id);
}
