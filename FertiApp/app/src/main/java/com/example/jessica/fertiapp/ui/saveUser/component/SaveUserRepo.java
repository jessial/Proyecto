package com.example.jessica.fertiapp.ui.saveUser.component;

import android.content.Intent;
import android.widget.Toast;

import com.example.jessica.fertiapp.MainActivity;
import com.example.jessica.fertiapp.api.model.Usuario;
import com.example.jessica.fertiapp.ui.saveUser.SaveUser;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

/**
 * Created by Jessica on 31/5/2018.
 */

public class SaveUserRepo implements SaveUser.Repo {

    @Override
    public void saveUser(Usuario usuario, Dao usuDao) {
        try {
            usuDao.create(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findUserByCedula() {

    }
}
