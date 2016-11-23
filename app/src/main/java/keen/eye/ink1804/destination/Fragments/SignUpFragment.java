package keen.eye.ink1804.destination.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.UsersModel;

/**
 * Created by anton on 15.11.16.
 */

public class SignUpFragment extends Fragment implements View.OnClickListener {
    private EditText inputEmail, inputPassword;
    protected Button btnSignUp;
    protected Button btnIsEmailVerification;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    FirebaseUser user;
    private String emailBundle, passwordBundle;

    boolean flag = true;
    long count = 0;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    final private DatabaseReference messageRef = mDatabase.getRef();


    View root;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reg_signup_fragment, container, false);
        initViews();
        return root;
    }

    private void initViews() {
        pushDateListener listener = (pushDateListener) getActivity();
        listener.toolbarSetTitle("Регистрация");
        btnSignUp = (Button) root.findViewById(R.id.sign_up_button);
        inputEmail = (EditText) root.findViewById(R.id.email);
        inputPassword = (EditText) root.findViewById(R.id.password);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        btnIsEmailVerification = (Button) root.findViewById(R.id.btn_isEmailVerification);
        btnSignUp.setOnClickListener(this);
        btnIsEmailVerification.setOnClickListener(this);
        btnIsEmailVerification.setEnabled(false);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        final pushDateListener listener = (pushDateListener) getActivity();
        switch (view.getId()) {
            case R.id.sign_up_button:
                final String email = inputEmail.getText().toString().trim();
                final String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getContext(), "Введите email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Введите пароль!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getContext(), "Пароль короткий, минимум 6 символов!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                progressBar.setVisibility(View.INVISIBLE);
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getContext(), "Аунтефикация не удалась, попробуйте ввести другой почтовый адресс.",
                                            Toast.LENGTH_SHORT).show();
                                } else if (task.isSuccessful()) {
                                    messageRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            count = dataSnapshot.getChildrenCount();
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                        }
                                    });

                                    auth.signInWithEmailAndPassword(email, password)
                                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (!task.isSuccessful()) {
                                                        if (password.length() < 6) {
                                                            inputPassword.setError(getString(R.string.minimum_password));
                                                        } else {
                                                            Toast.makeText(getContext(), "Аунтефикация не удалась", Toast.LENGTH_LONG).show();
                                                        }
                                                    }
                                                    else {
                                                        emailBundle = email;
                                                        passwordBundle = password;
                                                        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                                                            @Override
                                                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                                                user = firebaseAuth.getCurrentUser();
                                                                if (user != null)
                                                                    if (!user.isEmailVerified())
                                                                        if (flag) {
                                                                            user.sendEmailVerification();
                                                                            flag = false;
                                                                        }
                                                            }
                                                        };
                                                        auth.addAuthStateListener(authListener);
                                                        dialogVerification();
                                                        btnSignUp.setEnabled(false);
                                                        auth.signOut();
                                                    }
                                                }
                                            });
                                }
                            }
                        });
                break;
            case R.id.btn_isEmailVerification:
                auth.signInWithEmailAndPassword(emailBundle, passwordBundle)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {
                                        Toast.makeText(getContext(), "Аунтефикация не удалась", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
                                        @Override
                                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                            user = firebaseAuth.getCurrentUser();
                                            if (user != null) {
                                                if (user.isEmailVerified()) {
                                                    UsersModel usersModel = new UsersModel(user.getEmail(), user.getUid());
                                                    usersModel.toMap();
                                                    messageRef.child(count + "").setValue(usersModel);
                                                    listener.onLoginClick(emailBundle, passwordBundle);
                                                    auth.signOut();
                                                } else
                                                    Toast.makeText(getContext(), "Вы еще не подтвердили свою почту!",
                                                            Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    };
                                    auth.addAuthStateListener(authListener);
                                }
                            }
                        });
                break;
        }
    }
    private void dialogVerification() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Верификация")
                .setMessage("Ваша почта еще не подтверждена. Мы отправили вам письмо с подтверждением на указанный Email при регистрации.")
                .setIcon(R.drawable.icon_eye_512)
                .setCancelable(false)
                .setNegativeButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                btnIsEmailVerification.setEnabled(true);
                                }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}

