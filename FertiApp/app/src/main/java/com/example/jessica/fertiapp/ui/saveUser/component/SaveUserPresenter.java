package com.example.jessica.fertiapp.ui.saveUser.component;

import android.content.Intent;
import android.widget.Toast;

import com.example.jessica.fertiapp.MainActivity;
import com.example.jessica.fertiapp.api.DatabaseHelper;
import com.example.jessica.fertiapp.api.model.Usuario;
import com.example.jessica.fertiapp.ui.saveUser.SaveUser;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

/**
 * Created by Jessica on 31/5/2018.
 */

public class SaveUserPresenter implements SaveUser.Presenter{
    public SaveUser.Repo repo;
    public SaveUser.UserView view;

    public SaveUserPresenter(SaveUser.Repo repo, SaveUser.UserView view) {
        this.repo = repo;
        this.view = view;
    }

    @Override
    public void saveUser(Usuario user, Dao usuDao) {
        repo.saveUser(user, usuDao);

    }
}
