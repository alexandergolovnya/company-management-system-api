package com.aleksgolovnya.deansoffice.service.subjects;

import com.aleksgolovnya.deansoffice.entity.Score;
import com.aleksgolovnya.deansoffice.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score addScore(Score score) {
        Score savedScore = scoreRepository.saveAndFlush(score);
        return savedScore;
    }

    @Override
    public void deleteScore(Long id) {
        Score deleteScore = scoreRepository.getOne(id);
        scoreRepository.delete(deleteScore);
    }

    @Override
    public Score editScore(Score score) {
        return scoreRepository.saveAndFlush(score);
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getById(Long id) {
        Score score = scoreRepository.getOne(id);
        return score;
    }
}
