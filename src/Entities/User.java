package src.Entities;

public class User {

  private String username;
  private String password;
  private String accountType;

  public User(String username, String password, String accountType) {
    this.username = username;
    this.password = password;
    this.accountType = accountType;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setSalary(String accountType) {
    this.accountType = accountType;
  }

  @Override
  public String toString() {
    return String.format(
      "\nUser [username=%s, password=%s, account type=%s]",
      username,
      password,
      accountType
    );
  }
}
