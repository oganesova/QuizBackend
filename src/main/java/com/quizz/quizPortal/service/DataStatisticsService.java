package com.quizz.quizPortal.service;
import com.quizz.quizPortal.entity.DataStatistics;
import com.quizz.quizPortal.helper.CSVHelper;
import com.quizz.quizPortal.repository.DataStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.io.IOException;

@Service
public class DataStatisticsService {

    @Autowired
    private DataStatisticsRepository dataRepository;

    public void save(MultipartFile file) {
        try {
            List<DataStatistics> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            dataRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<DataStatistics> getAllTutorials() {
        return dataRepository.findAll();
    }
}


