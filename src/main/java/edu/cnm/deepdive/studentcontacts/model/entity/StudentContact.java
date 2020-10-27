package edu.cnm.deepdive.studentcontacts.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    indexes = {
        @Index(columnList = "relationship_type")
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "student_id", "contact_id"
        })
    }
)
public class StudentContact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private long studentContactId;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "student_id", nullable = false, updatable = false)
  private Student studentId;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contact_id", nullable = false, updatable = false)
  private Contact contactId;

  private boolean primary;

  @NonNull
  @Column(nullable = false, updatable = false)
  @Enumerated(value = EnumType.STRING)
  private Relationship relationshipType;

  public long getStudentContactId() {
    return studentContactId;
  }

  @NonNull
  public Student getStudentId() {
    return studentId;
  }

  @NonNull
  public Contact getContactId() {
    return contactId;
  }

  public boolean isPrimary() {
    return primary;
  }

  public void setPrimary(boolean primary) {
    this.primary = primary;
  }

  @NonNull
  public Relationship getRelationshipType() {
    return relationshipType;
  }

  public void setRelationshipType(
      @NonNull Relationship relationshipType) {
    this.relationshipType = relationshipType;
  }

  public enum Relationship {

    PARENT, GUARDIAN, SIBLING, OTHER

  }
}
