package com.web.hello;

public class User {
   private String name;
   private int age;
   private String sex;
   private String[] hobbies;
   private String education;
   private String email;
   
   public User() {
    
   }

public User(String name, int age, String sex, String[] hobbies, String education, String email) {
 super();
 this.name = name;
 this.age = age;
 this.sex = sex;
 this.hobbies = hobbies;
 this.education = education;
 this.email = email;
}

public String getName() {
 return name;
}

public void setName(String name) {
 this.name = name;
}

public int getAge() {
 return age;
}

public void setAge(int age) {
 this.age = age;
}

public String getSex() {
 return sex;
}

public void setSex(String sex) {
 this.sex = sex;
}

public String[] getHobbies() {
 return hobbies;
}

public void setHobbies(String[] hobbies) {
 this.hobbies = hobbies;
}

public String getEducation() {
 return education;
}

public void setEducation(String education) {
 this.education = education;
}

public String getEmail() {
 return email;
}

public void setEmail(String email) {
 this.email = email;
}
   
   
}