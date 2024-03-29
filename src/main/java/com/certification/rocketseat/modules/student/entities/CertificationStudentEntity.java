package com.certification.rocketseat.modules.student.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
@Builder
public class CertificationStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100)
    private String technology;
    @Column(length = 10)
    private int grade;
    @Column(name = "student_id")
    private UUID studentID;
    @Column(name = "student_name")
    private String StudentName;
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @JsonIgnore
    private StudentEntity studentEntity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    @JsonIgnore
    List<AnswersCertificationsEntity> answersCertificationsEntity;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Question_result_id")
    private List<QuestionResultEntity> questionResults;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
