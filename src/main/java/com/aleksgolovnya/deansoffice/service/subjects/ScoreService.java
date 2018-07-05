package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.entity.Score;
import com.aleksgolovnya.deansoffice.entity.Subject;

import java.util.List;

public interface ScoreService {
    Score addScore(Score score);
    void deleteScore(Long id);
    Score editScore(Score score);
    List<Score> getAll();
    Score getById(Long id);
}
