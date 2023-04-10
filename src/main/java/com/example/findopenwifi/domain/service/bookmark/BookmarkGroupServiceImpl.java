package com.example.findopenwifi.domain.service.bookmark;

import com.example.findopenwifi.domain.model.bookmark.BookmarkGroup;
import com.example.findopenwifi.domain.repository.bookmark.BookmarkGroupRepository;
import com.example.findopenwifi.domain.repository.bookmark.BookmarkRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.bookmark.BookmarkGroupDAO;

import java.util.List;

public enum BookmarkGroupServiceImpl implements BookmarkGroupService{

    INSTANCE;

    private final BookmarkGroupRepository bookmarkGroupRepository;

    BookmarkGroupServiceImpl() {
        this.bookmarkGroupRepository = new BookmarkGroupDAO();
    }

    @Override
    public List<BookmarkGroup> getAllBookmarkGroup() {
        return bookmarkGroupRepository.findAll();
    }

    @Override
    public BookmarkGroup getOne(int id) {
        return bookmarkGroupRepository.findOne(id);
    }


    @Override
    public int addBookmarkGroup(BookmarkGroup bookmarkGroup) {
        return bookmarkGroupRepository.save(bookmarkGroup);
    }

    @Override
    public int updateBookmarkGroup(int id, BookmarkGroup bookmarkGroup) {
        return bookmarkGroupRepository.update(id, bookmarkGroup);
    }

    @Override
    public int deleteBookmarkGroup(int id) {
        return bookmarkGroupRepository.delete(id);
    }
}
