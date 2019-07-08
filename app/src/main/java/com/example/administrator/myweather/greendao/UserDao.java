package com.example.administrator.myweather.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.administrator.myweather.common.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserId = new Property(1, String.class, "userId", false, "USER_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property StudentNum = new Property(3, String.class, "studentNum", false, "STUDENT_NUM");
        public final static Property Mobile = new Property(4, String.class, "mobile", false, "MOBILE");
        public final static Property Age = new Property(5, String.class, "age", false, "AGE");
        public final static Property Sex = new Property(6, String.class, "sex", false, "SEX");
        public final static Property Major = new Property(7, String.class, "major", false, "MAJOR");
        public final static Property HeadUrl = new Property(8, String.class, "headUrl", false, "HEAD_URL");
        public final static Property Pwd = new Property(9, String.class, "pwd", false, "PWD");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USER_ID\" TEXT," + // 1: userId
                "\"NAME\" TEXT," + // 2: name
                "\"STUDENT_NUM\" TEXT," + // 3: studentNum
                "\"MOBILE\" TEXT," + // 4: mobile
                "\"AGE\" TEXT," + // 5: age
                "\"SEX\" TEXT," + // 6: sex
                "\"MAJOR\" TEXT," + // 7: major
                "\"HEAD_URL\" TEXT," + // 8: headUrl
                "\"PWD\" TEXT);"); // 9: pwd
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(2, userId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String studentNum = entity.getStudentNum();
        if (studentNum != null) {
            stmt.bindString(4, studentNum);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(5, mobile);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(6, age);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(7, sex);
        }
 
        String major = entity.getMajor();
        if (major != null) {
            stmt.bindString(8, major);
        }
 
        String headUrl = entity.getHeadUrl();
        if (headUrl != null) {
            stmt.bindString(9, headUrl);
        }
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(10, pwd);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(2, userId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String studentNum = entity.getStudentNum();
        if (studentNum != null) {
            stmt.bindString(4, studentNum);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(5, mobile);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(6, age);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(7, sex);
        }
 
        String major = entity.getMajor();
        if (major != null) {
            stmt.bindString(8, major);
        }
 
        String headUrl = entity.getHeadUrl();
        if (headUrl != null) {
            stmt.bindString(9, headUrl);
        }
 
        String pwd = entity.getPwd();
        if (pwd != null) {
            stmt.bindString(10, pwd);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // studentNum
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mobile
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // age
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // sex
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // major
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // headUrl
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // pwd
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStudentNum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMobile(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAge(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSex(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMajor(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setHeadUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPwd(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}