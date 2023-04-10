package com.example.findopenwifi.domain.service.bookmark;

import com.example.findopenwifi.domain.model.bookmark.Bookmark;
import com.example.findopenwifi.domain.repository.bookmark.BookmarkRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.bookmark.BookmarkDAO;

import java.util.List;

public enum BookmarkServiceImpl implements BookmarkService {

    INSTANCE;

    private final BookmarkRepository bookmarkRepository;

    BookmarkServiceImpl() {
        this.bookmarkRepository = new BookmarkDAO();
    }

    @Override
    public List<Bookmark> getAllBookmark() {
        return bookmarkRepository.findAll();
    }

    @Override
    public int addBookmark(Bookmark bookmark) {
        return bookmarkRepository.insert(bookmark);
    }

    @Override
    public int delete(int id) {
        return bookmarkRepository.delete(id);
    }


}
