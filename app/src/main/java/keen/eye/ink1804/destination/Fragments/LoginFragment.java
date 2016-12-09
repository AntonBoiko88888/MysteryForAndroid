package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;
import keen.eye.ink1804.destination.Utills.UsersModel;

/**
 * Created by anton on 15.11.16.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup;
    private Button btnReset;
    private Context context;
    FirebaseUser user;
    private String email,password;
    pushDateListener listener;

    String emailArgs;
    View root;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reg_login_fragment,container,false);
        context = getActivity();
        initViews();
        return root;
    }

    private void initViews() {
        listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Вход");
        inputEmail = (EditText)root.findViewById(R.id.email);
        inputEmail.setText(MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL,""));
        inputPassword = (EditText)root.findViewById(R.id.password);
        inputPassword.setText(MainActivity.mSettings.getString(Constants.APP_PREF_PASSWORD,""));
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        btnSignup = (Button) root.findViewById(R.id.btn_registrate);
        Button btnLogin = (Button) root.findViewById(R.id.btn_login);
        btnReset = (Button) root.findViewById(R.id.btn_reset_password);
        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        Bundle args = getArguments();
        if (args != null) {
            emailArgs = args.getString("email");
            String password = args.getString("password");
            if (emailArgs != null) {
                inputEmail.setText(emailArgs);
                inputPassword.setText(password);
            }
        }
    }

    @Override
    public void onClick(View view) {
        final pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()) {
            case R.id.btn_registrate:
                listener.onStartRegistration();
                break;
            case R.id.btn_login:
                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "Введите email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Введите пароль!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btnReset.setVisibility(View.INVISIBLE);
                btnSignup.setVisibility(View.INVISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.INVISIBLE);
                                btnReset.setVisibility(View.VISIBLE);
                                btnSignup.setVisibility(View.VISIBLE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(getContext(), getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                }
                                else {
                                    user = auth.getCurrentUser();
                                    if(user != null) {
                                        if (user.isEmailVerified()) {
                                            btnSignup.setEnabled(false);
                                            btnReset.setEnabled(false);
                                            progressBar.setVisibility(View.VISIBLE);
                                            btnReset.setVisibility(View.INVISIBLE);
                                            btnSignup.setVisibility(View.INVISIBLE);
                                            FbUtills firebaseUtills = new FbUtills();
                                            firebaseUtills.onLogin(context,email,password);
                                            Toast.makeText(getContext(), "Вход выполнен успешно!", Toast.LENGTH_LONG).show();
                                        }
                                        else
                                            Toast.makeText(getContext(), "Ваша почта не подтверждена!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                        });
                break;
            case R.id.btn_reset_password:
                listener.onStartResetPassword();
                break;
        }
    }
}

