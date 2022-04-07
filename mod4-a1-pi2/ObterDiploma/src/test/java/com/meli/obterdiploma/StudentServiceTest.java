package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.IStudentRepository;
import com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testCreate() {
        StudentDTO newStudent = new StudentDTO();
        Mockito.doNothing().when(studentDAO).save(newStudent);

        studentService.create(newStudent);
        Mockito.verify(studentDAO, times(1)).save(newStudent);
    }

    @Test
    public void testRead() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testGetAll() {
        StudentDTO s1 = new StudentDTO();
        StudentDTO s2 = new StudentDTO();
        StudentDTO s3 = new StudentDTO();

        Set<StudentDTO> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);

        Mockito.when(studentRepository.findAll()).thenReturn(studentSet);

        Set<StudentDTO> returnValue = studentService.getAll();

        assertEquals(returnValue.size(), 3);
    }
    @Test
    public void testGetAllWhenSetIsEmpty() {
        Set<StudentDTO> studentSet = new HashSet<>();

        Mockito.when(studentRepository.findAll()).thenReturn(studentSet);

        Set<StudentDTO> returnValue = studentService.getAll();

        assertEquals(returnValue.size(), 0);
    }
}
