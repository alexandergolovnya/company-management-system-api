package com.universityspa.service.studying;

import com.universityspa.dto.SubjectDto;
import com.universityspa.entity.Subject;
import com.universityspa.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
//    @Autowired
//    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Subject addSubject(SubjectDto subjectDto) {
        Subject subjectToCreate = new Subject();

        subjectToCreate.setName(subjectDto.getName());
        subjectToCreate.setDescription(subjectDto.getDescription());
//        List<Teacher> teachers = teacherRepository.findAllById(subjectDto.getTeacherId());
//        subjectToCreate.setTeachers(teachers);

        Subject savedSubject = subjectRepository.saveAndFlush(subjectToCreate);
        return savedSubject;
    }

    @Override
    public void deleteSubject(Long id) {
        Subject deleteSubject = subjectRepository.getOne(id);
        subjectRepository.delete(deleteSubject);
    }

    @Override
    public Subject editSubject(SubjectDto subjectDto) {
        Subject subject = convertToEntity(subjectDto);
        Subject savedSubject = subjectRepository.saveAndFlush(subject);
        return savedSubject;
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Long id) {
        Subject subject = subjectRepository.getOne(id);
        return subject;
    }

    @Override
    public Subject convertToEntity(SubjectDto subjectDto) {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        subject.setName(subjectDto.getName());
        subject.setDescription(subjectDto.getDescription());
//        List<Teacher> teachers = teacherRepository.findAllById(subjectDto.getTeacherId());
//        subject.setTeachers(teachers);
        return subject;
    }

    /**
     * Method receives all teachers of this subject
     *
     * @param id of the subject
     * @return [Teacher]
     */
//    @Override
//    public List<Teacher> getSubjectTeachers(Long id) {
//        List<Teacher> teachers = subjectRepository.getSubjectTeachers(id);
//        return teachers;
//    }
}
