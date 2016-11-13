//package keen.eye.ink1804.destination.Utills;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//
//import java.util.concurrent.Executor;
//
//import keen.eye.ink1804.destination.R;
//
//import static android.content.ContentValues.TAG;
//
///**
// * Created by Ink1804 on 04.10.16.
// */
//
//public class FirebaseUtill {
//
//
//    public void createAccount(String email, String password, final Context context, FirebaseAuth mAuth) {
//        Log.d(TAG, "createAccount:" + email);
//        if (!validateForm()) {
//            return;
//        }
//
////        showProgressDialog();
//
//        // [START create_user_with_email]
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
//
//                        // If sign in fails, display a message to the user. If sign in succeeds
//                        // the auth state listener will be notified and logic to handle the
//                        // signed in user can be handled in the listener.
//                        if (!task.isSuccessful()) {
//                            Toast.makeText(context, R.string.common_signin_button_text,
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // [START_EXCLUDE]
////                        hideProgressDialog();
//                        // [END_EXCLUDE]
//                    }
//                });
//        // [END create_user_with_email]
//    }
//    private void signIn(String email, String password, final Context context, FirebaseAuth mAuth) {
//        Log.d(TAG, "signIn:" + email);
//        if (!validateForm()) {
//            return;
//        }
//
////        showProgressDialog();
//
//        // [START sign_in_with_email]
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
//
//                        // If sign in fails, display a message to the user. If sign in succeeds
//                        // the auth state listener will be notified and logic to handle the
//                        // signed in user can be handled in the listener.
//                        if (!task.isSuccessful()) {
//                            Log.w(TAG, "signInWithEmail:failed", task.getException());
//                            Toast.makeText(context, R.string.gcm_defaultSenderId,
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // [START_EXCLUDE]
//                        if (!task.isSuccessful()) {
//                            //mStatusTextView.setText(R.string.auth_failed);
//                        }
////                        hideProgressDialog();
//                        // [END_EXCLUDE]
//                    }
//                });
//        // [END sign_in_with_email]
//    }
//
//    private void signOut(FirebaseAuth mAuth) {
//        mAuth.signOut();
//        updateUI(null);
//    }
//
////    private boolean validateForm( final Context context, FirebaseAuth mAuth) {
////        boolean valid = true;
////
////        String email = mEmailField.getText().toString();
////        if (TextUtils.isEmpty(email)) {
////            mEmailField.setError("Required.");
////            valid = false;
////        } else {
////            mEmailField.setError(null);
////        }
////
////        String password = mPasswordField.getText().toString();
////        if (TextUtils.isEmpty(password)) {
////            mPasswordField.setError("Required.");
////            valid = false;
////        } else {
////            mPasswordField.setError(null);
////        }
////
////        return valid;
////    }
//
////    private void updateUI(FirebaseUser user) {
//////        hideProgressDialog();
////        if (user != null) {
////            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt, user.getEmail()));
////            //          mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));
////
////            findViewById(R.id.email_create_account_button).setVisibility(View.GONE);
////            findViewById(R.id.sign_out_button).setVisibility(View.VISIBLE);
////            findViewById(R.id.email_sign_in_button).setEnabled(false);
////        } else {
////            mStatusTextView.setText(R.string.signed_out);
////            mDetailTextView.setText(null);
////
////            findViewById(R.id.email_sign_in_button).setEnabled(true);
////            findViewById(R.id.email_create_account_button).setVisibility(View.VISIBLE);
////            findViewById(R.id.sign_out_button).setVisibility(View.GONE);
////        }
////    }
//
//
//}
