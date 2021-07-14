package com.example.gitsocial.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gitsocial.data.room.entities.User;

@Database(entities = {User.class, /*add other entities here*/}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao users();
}
