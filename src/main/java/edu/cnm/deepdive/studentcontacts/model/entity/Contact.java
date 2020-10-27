package edu.cnm.deepdive.studentcontacts.model.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.lang.NonNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "last_name", "middle_name", "first_name"
        })
    }
)
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private Long contactId;

  @NonNull
  @Column(nullable = false)
  private String lastName;

  @NonNull
  @Column(nullable = false)
  private String firstName;

  private String middleName;

  @NonNull
  @Column(nullable = false)
  private String phoneNumber;

  private String smsNumber;

  private String email;

  @NonNull
  @OneToMany(mappedBy = "contact_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @OrderBy("studentId ASC")
  private final List<StudentContact> studentContacts = new LinkedList<>();

  public Long getContactId() {
    return contactId;
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
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(@NonNull String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSmsNumber() {
    return smsNumber;
  }

  public void setSmsNumber(String smsNumber) {
    this.smsNumber = smsNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NonNull
  public List<StudentContact> getStudentContacts() {
    return studentContacts;
  }
}
