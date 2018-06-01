package com.example.jessica.fertiapp.ui.saveUser;

import android.view.View;

import com.example.jessica.fertiapp.api.model.Usuario;
import com.j256.ormlite.dao.Dao;

/**
 * Created by Jessica on 31/5/2018.
 */

public class SaveUser {
    public interface Presenter{
        public void saveUser(Usuario usuario, Dao dao);
    }

    public interface Repo{
        public void saveUser(Usuario usuario, Dao dao);
        public void findUserByCedula();
    }

    public interface UserView{
        public void onSaveUser(View view);
        public void showMessage(String message);
        public void goToMenuActivity();

    }

}
