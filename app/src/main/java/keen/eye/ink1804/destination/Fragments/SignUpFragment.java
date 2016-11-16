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

public class SignUpFragment extends Fragment implements View.OnClickListener{
    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    private FirebaseAuth.AuthStateListener authListener;
    FirebaseUser user;
    long count=0;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    final private DatabaseReference messageRef = mDatabase.getRef();


    View root;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_signup,container,false);
        initViews();
        return root;
    }

    private void initViews() {
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Регистрация");
        btnSignIn = (Button) root.findViewById(R.id.sign_in_button);
        btnSignUp = (Button) root.findViewById(R.id.sign_up_button);
        inputEmail = (EditText) root.findViewById(R.id.email);
        inputPassword = (EditText) root.findViewById(R.id.password);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        btnResetPassword = (Button) root.findViewById(R.id.btn_reset_password);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        final pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()) {
            case R.id.sign_in_button:
                listener.onStartSignUpFragment();
                break;
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

                user = null;

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getContext(), "Аунтефикация не удалась, попробуйте ввести другой почтовый адресс.",
                                            Toast.LENGTH_SHORT).show();
                                } else if(task.isSuccessful()) {
                                    messageRef.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            count = dataSnapshot.getChildrenCount();
                                        }
                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                        }
                                    });
                                    authListener = new FirebaseAuth.AuthStateListener() {
                                        @Override
                                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                            user = firebaseAuth.getCurrentUser();
                                            if (user != null) {
                                                if (!user.isEmailVerified()) {
                                                    dialogVerification(task, email);
                                                }
                                                if (user.isEmailVerified())
                                                    Toast.makeText(getActivity(), "Ваша почта подтверждена, теперь вы можете войти!", Toast.LENGTH_LONG).show();
                                                listener.onStartLoginFragment(email, password);
                                            }
                                            else
                                                Toast.makeText(getActivity(), "Дерьмо собачье", Toast.LENGTH_LONG).show();
                                        }
                                    };
                                    auth.addAuthStateListener(authListener);
                                }
                            }
                        });
        }
    }
    private void dialogVerification(final Task<AuthResult> task, final String email){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Верификация")
                .setMessage("Ваша почта еще не подтверждена. Отправьте себе письмо с подтверждением, нажав на кнопку 'Послать'. Если вы подтвердили свою почту через письмо, нажмите 'Ок' и войдите, в противном случае вы не войдете.")
                .setIcon(R.drawable.icon_eye)
                .setCancelable(false)
                .setNegativeButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                if(!user.isEmailVerified())
                                    dialogVerification(task, email);
                                else
                                {
                                    UsersModel usersModel = new UsersModel(user.getEmail(), user.getUid());
                                    usersModel.toMap();
                                    messageRef.child(count+"").setValue(usersModel);
                                    messageRef.child(count+"").setValue(usersModel);
                                    FirebaseDatabase.getInstance().getReference("users").child(count + "").child("Email").setValue(user.getEmail());
                                    Toast.makeText(getActivity(), "Регистрация прошла успешно, теперь вы можете войти", Toast.LENGTH_LONG).show();
                                    dialog.cancel();
                                }
                            }
                        })
                .setPositiveButton("Послать", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        user.sendEmailVerification();
                        dialogVerification(task, email);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

