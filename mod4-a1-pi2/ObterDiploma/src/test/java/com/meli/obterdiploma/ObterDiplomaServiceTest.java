package com.meli.obterdiploma;

import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ObterDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObterDiplomaService obterDiplomaService;


    @Test
    public void testWhenStudentAverageIs9() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematica");
        subjectDTO.setScore(9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Portugues");
        subjectDTO2.setScore(9.0);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Aaa");
        studentDTO.setSubjects(Arrays.asList(subjectDTO, subjectDTO2));

        Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);

        StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

        assertEquals(8, studentDTO1.getAverageScore());
        assertEquals("O aluno Aaa obteve uma média de 8. Você pode melhorar.", studentDTO1.getMessage());
    }

    @Test
    public void testWhenStudentAverageIsGreaterThan9() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matematica");
        subjectDTO.setScore(9.1);
        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Portugues");
        subjectDTO2.setScore(9.0);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Aaa");
        studentDTO.setSubjects(Arrays.asList(subjectDTO, subjectDTO2));

        Mockito.when(studentDAO.findById(any())).thenReturn(studentDTO);

        StudentDTO studentDTO1 = obterDiplomaService.analyzeScores(1L);

        assertEquals(9.05, studentDTO1.getAverageScore());
        assertEquals("O aluno Aaa obteve uma média de 9,05. Parabéns!", studentDTO1.getMessage());
    }

    @Test
    public void testWhenStudentIsNotFound() {

        Mockito.when(studentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));

        StudentNotFoundException exeption = assertThrows(StudentNotFoundException.class, () -> obterDiplomaService.analyzeScores(1L));
        assertEquals(HttpStatus.NOT_FOUND, exeption.getStatus());
        assertEquals("O aluno com id 1 não está registrado", exeption.getError().getDescription());
    }

    @Test
    public void testWhenStudentIdIsInvalid() {
        // Mockito.when(studentDAO.findById("text").thenThrow(new MethodArgumentTypeMismatchException));
    }
}
