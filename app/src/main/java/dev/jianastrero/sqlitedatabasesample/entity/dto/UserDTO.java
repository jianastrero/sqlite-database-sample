package dev.jianastrero.sqlitedatabasesample.entity.dto;

import android.database.Cursor;

import dev.jianastrero.sqlitedatabasesample.sqlite.contract.UserContract;

public class UserDTO {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private long createdAt;
    private long updatedAt;

    public UserDTO(int id,
                   String firstName,
                   String lastName,
                   int age,
                   String email,
                   String password,
                   long createdAt,
                   long updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static UserDTO fromCursor(Cursor cursor) {
        int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(UserContract.UserEntry._ID));
        String firstName = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_LAST_NAME));
        int age = cursor.getInt(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_AGE));
        String email = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_EMAIL));
        String password = cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_PASSWORD));
        long createdAt = cursor.getLong(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_CREATED_AT));
        long updatedAt = cursor.getLong(cursor.getColumnIndexOrThrow(UserContract.UserEntry.COLUMN_UPDATED_AT));

        return new UserDTO(itemId, firstName, lastName, age, email, password, createdAt, updatedAt);
    }
}
