package com.example.gitsocial.data.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "uid")
    public int id;
    @ColumnInfo(name = "user_name")
    public String login;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "avatar_url")
    public String avatar;
}
