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

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 15.11.16.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup;
    private Button btnReset;
    FirebaseUser user;
    int emailVerification = 0;

    pushDateListener listener;

    String emailArgs;
    View root;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reg_login_fragment,container,false);
        initViews();
        return root;
    }

    private void initViews() {
        listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Вход");
        inputEmail = (EditText)root.findViewById(R.id.email);
        inputPassword = (EditText)root.findViewById(R.id.password);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        btnSignup = (Button) root.findViewById(R.id.btn_registrate);
        Button btnLogin = (Button) root.findViewById(R.id.btn_login);
        btnReset = (Button) root.findViewById(R.id.btn_reset_password);
        btnLogin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        user = null;
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    if (!user.isEmailVerified() & emailVerification == 0) {
                        emailVerification = 1;
                    }
                    if (user.isEmailVerified())
                        emailVerification = 2;
                }
            }
        };
        auth.addAuthStateListener(authListener);
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
                final String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
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
                                    dialogLogin();
                                    btnSignup.setEnabled(false);
                                }

                            }
                        });
                break;
            case R.id.btn_reset_password:
                listener.onStartResetPassword();
                break;
        }
    }



    private void userUpdateDatabase(Task<AuthResult> task, final String email){
//        final FirebaseUser user1 = task.getResult().getUser();
//        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                .setDisplayName(email)
//                .build();
//        user1.updateProfile(profileUpdates);     Нужная фигня

    }

    private void dialogLogin() {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
        builder.setTitle("Данные пользователя")
                .setMessage("Вы вошли, Данные профиля: Здесь будут данные про статус, имя, и дату рождения пользователя")
                .setIcon(R.drawable.icon_eye_512)
                .setCancelable(false)
                .setNegativeButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                listener.mainFragmentCreate();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

