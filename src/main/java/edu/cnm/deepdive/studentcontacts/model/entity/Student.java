package edu.cnm.deepdive.studentcontacts.model.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    indexes = {
        @Index(columnList = "enrolled"),
        @Index(columnList = "disenrolled")
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "last_name", "middle_name", "first_name"
        })
    }
)
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long studentId;

  @NonNull
  @Column(nullable = false, updatable = false, unique = true)
  private String studentNumber;

  @NonNull
  @Column(nullable = false)
  private String lastName;

  @NonNull
  @Column(nullable = false)
  private String firstName;

  private String middleName;

  @NonNull
  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private LocalDate enrolled;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDate disenrolled;

  @NonNull
  @OneToMany(mappedBy = "student_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @OrderBy("relationshipType ASC")
  private final List<StudentContact> studentContacts = new LinkedList<>();

  public Long getStudentId() {
    return studentId;
  }

  @NonNull
  public String getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(@NonNull String studentNumber) {
    this.studentNumber = studentNumber;
  }

  @NonNull
  public String getLastName() {
    return lastName;
  }

  public void setLastName(@NonNull String lastName) {
    this.lastName = lastName;
  }

  @NonNull
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(@NonNull String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  @NonNull
  public LocalDate getEnrolled() {
    return enrolled;
  }

  @NonNull
  public LocalDate getDisenrolled() {
    return disenrolled;
  }

  public void setDisenrolled(LocalDate disenrolled) {
    this.disenrolled = disenrolled;
  }

  @NonNull
  public List<StudentContact> getStudentContacts() {
    return studentContacts;
  }
}
