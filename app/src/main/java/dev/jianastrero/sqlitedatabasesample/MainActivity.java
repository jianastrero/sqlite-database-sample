package dev.jianastrero.sqlitedatabasesample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dev.jianastrero.sqlitedatabasesample.entity.dto.UserDTO;
import dev.jianastrero.sqlitedatabasesample.sqlite.dao.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        updateTexts();
    }

    private void updateTexts() {
        updateUserCountText();
        updateFirstUserText();
    }

    private void updateUserCountText() {
        TextView tvUserCount = findViewById(R.id.tvUserCount);
        int userCount = UserDao.getUsers().size();
        tvUserCount.setText("User Count: " + userCount);
    }

    private void updateFirstUserText() {
        TextView tvFirstUser = findViewById(R.id.tvFirstUser);
        int firstUserId = UserDao.getFirstUserId();

        if (firstUserId == -1) {
            tvFirstUser.setText("First User: No user found");
            return;
        }

        UserDTO userDTO = UserDao.getUser(firstUserId);
        tvFirstUser.setText("First User: " + userDTO.getFullName());
    }

    public void onCreateNewUserClick(View view) {
        UserDao.insertUser(
                "John",
                "Doe",
                20,
                "johndoe@email.com",
                "password"
        );
        updateTexts();
    }

    public void onDeleteNewUser(View view) {
        int firstUserId = UserDao.getFirstUserId();
        if (firstUserId == -1) {
            Toast.makeText(this, "No Users", Toast.LENGTH_SHORT).show();
            return;
        }
        UserDao.deleteUser(firstUserId);
        updateTexts();
    }

    public void onUpdateFirstUser(View view) {
        int firstUserId = UserDao.getFirstUserId();
        if (firstUserId == -1) {
            Toast.makeText(this, "No Users", Toast.LENGTH_SHORT).show();
            return;
        }
        UserDao.updateUser(
                firstUserId,
                "Jane",
                "Doe",
                21,
                "janedoe@email.com",
                "password"
        );
        updateTexts();
    }
}
