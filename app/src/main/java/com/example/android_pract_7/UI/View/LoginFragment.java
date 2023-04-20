package com.example.android_pract_7.UI.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    final public static String TAG = LoginFragment.class.getSimpleName();

    public LoginFragment(){

    }

    public static LoginFragment newInstance(Bundle data) {
        LoginFragment loginFragment = new LoginFragment();
        if(data != null){
            loginFragment.setArguments(data);
            return loginFragment;
        }
        return newInstance();
    }
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }


    private EditText email;
    private EditText password;
    private Button login;
    private TextView register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = (EditText) view.findViewById(R.id.editText_email);
        password = (EditText) view.findViewById(R.id.editText_password);
        login = (Button) view.findViewById(R.id.button_login);
        register = (TextView) view.findViewById(R.id.textView_register);


        if (getArguments() != null) {
            email.setText(getArguments().getString("email"));
            password.setText(getArguments().getString("password"));
        }

        login.setOnClickListener(vie -> {
            Bundle userData = new Bundle();
            userData.putString("email", email.getText().toString());
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment,userData);

        });
        register.setOnClickListener(vie ->{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
        });
    }

}
