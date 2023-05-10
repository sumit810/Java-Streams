package beans;

public class Employee {

  final Integer id;
  final String firstName;
  final String lastName;
  final String email;
  final String gender;
  final Integer age;

  final String department;

  int yearOfJoining;

  double salary;

  public Employee(Integer id, String firstName, String lastName, String email, String gender,
                  Integer age, String department, int yearOfJoining, double salary) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.age = age;
    this.department = department;
    this.yearOfJoining = yearOfJoining;
    this.salary = salary;

  }

  public Integer getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getGender() {
    return gender;
  }

  public Integer getAge() {
    return age;
  }

  public String getDepartment() {
    return department;
  }

  public int getYearOfJoining() {
    return yearOfJoining;
  }

  public double getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", gender='" + gender + '\'' +
            ", age=" + age +
            ", department='" + department + '\'' +
            ", yearOfJoining=" + yearOfJoining +
            ", salary=" + salary +
            '}';
  }
}