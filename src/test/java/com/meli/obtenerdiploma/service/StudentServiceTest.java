package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    @Test
    void create() {
        StudentDTO expectedStudentDTO=loadStudent();
        studentService.create(expectedStudentDTO);
        verify(studentDAO, atLeast(1)).save(expectedStudentDTO);
    }
    private StudentDTO loadStudent(){
        return new StudentDTO(
                3L,
                "jorge",
                "El alumno jorge ha obtenido un promedio de 9.5. Felicitaciones!",
                9.5,
                List.of(
                        new SubjectDTO(
                                "subject11",
                                9.5
                        )
                )
        );
    }
    @Test
    void read() {
        StudentDTO expectedStudent = loadStudent();
        long id = 3L;
        when(studentDAO.findById(3L)).thenReturn(loadStudent());
        StudentDTO actual = studentService.read(3L);
        assertEquals(expectedStudent, actual);
    }

    @Test
    void update() {
        studentService.create(loadStudent());
        System.out.println(studentDAO.findById(Long.valueOf(1)));

    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}