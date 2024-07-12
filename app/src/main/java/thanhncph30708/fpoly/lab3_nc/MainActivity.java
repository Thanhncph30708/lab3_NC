package thanhncph30708.fpoly.lab3_nc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;
    private final Context context = this;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons
        btn1 = findViewById(R.id.demo31Btn1);
        btn2 = findViewById(R.id.demo31Btn2);
        btn3 = findViewById(R.id.demo31Btn3);
        btn4 = findViewById(R.id.demo31Btn4);

        setupAlertDialog();
        setupSingleChoiceDialog();
        setupMultiChoiceDialog();
        setupLoginDialog();
    }

    private void setupAlertDialog() {
        btn1.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Thông báo")
                    .setMessage("Nội dung cần thông báo")
                    .setPositiveButton("OK", (dialog, which) ->
                            Toast.makeText(getApplicationContext(), "Bạn đồng ý", Toast.LENGTH_LONG).show())
                    .setNegativeButton("Cancel", (dialog, which) ->
                            Toast.makeText(getApplicationContext(), "Bạn đã cancel", Toast.LENGTH_LONG).show());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

    private void setupSingleChoiceDialog() {
        btn2.setOnClickListener(v -> {
            String[] options = {"Xanh", "Đỏ", "Tím", "Vàng"};

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tiêu đề")
                    .setSingleChoiceItems(options, 0, (dialog, which) ->
                            Toast.makeText(getApplicationContext(), "Bạn chọn: " + options[which], Toast.LENGTH_LONG).show());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

    private void setupMultiChoiceDialog() {
        btn3.setOnClickListener(v -> {
            String[] options = {"Xanh", "Đỏ", "Tím", "Vàng"};

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Tiêu đề")
                    .setMultiChoiceItems(options, null, (dialog, which, isChecked) ->
                            Toast.makeText(getApplicationContext(), "Bạn chọn: " + options[which], Toast.LENGTH_SHORT).show());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

    private void setupLoginDialog() {
        btn4.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.login_form, null);
            builder.setView(view);

            final EditText txtUser = view.findViewById(R.id.demo31_login_form_txtU);
            final EditText txtPass = view.findViewById(R.id.demo31_login_form_txtP);

            builder.setTitle("Login Form")
                    .setPositiveButton("Login", (dialog, which) ->
                            Toast.makeText(getApplicationContext(), "Xin chào " + txtUser.getText().toString(), Toast.LENGTH_LONG).show())
                    .setNegativeButton("Cancel", (dialog, which) ->
                            Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_LONG).show());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}
