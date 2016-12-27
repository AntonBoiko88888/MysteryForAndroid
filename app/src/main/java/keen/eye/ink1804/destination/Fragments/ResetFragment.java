package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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
import com.google.firebase.auth.FirebaseAuth;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 15.11.16.
 */

public class ResetFragment extends Fragment {
    private EditText inputEmail;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    View root;

    public ResetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.reg_reset_fragment, container, false);
        initViews();
        return root;
    }

    private void initViews() {
        ((pushDateListener) getActivity()).toolbarSetTitle("Новый пароль");
        inputEmail = (EditText) root.findViewById(R.id.email);
        final Button btnReset = (Button) root.findViewById(R.id.btn_reset_password);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity().getApplication(), "Введите свой Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getContext(), "Мы отправили письмо на вашу почту для восстановления пароля", Toast.LENGTH_SHORT).show();
                                    } else {
                                    Toast.makeText(getContext(), "Ошибка, проверьте правильность почты", Toast.LENGTH_SHORT).show();
                                }

                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        });
            }
        });
    }
}

