package com.example.android_pract_7.UI.Views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.android_pract_7.R;

public class RegisterFragment extends Fragment {
    final public static String TAG = RegisterFragment.class.getSimpleName();

    public RegisterFragment() {

    }

    public static RegisterFragment newInstance(Bundle data) {
        RegisterFragment registerFragment = new RegisterFragment();
        if(data != null){
            registerFragment.setArguments(data);
            return registerFragment;
        }
        return newInstance();
    }
    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    private EditText nickname;
    private EditText name;
    private EditText surname;
    private EditText password;
    private EditText email;
    private Button rgn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nickname = view.findViewById(R.id.nickname);
        name = view.findViewById(R.id.name);
        surname = view.findViewById(R.id.surname);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.reg_password);
        rgn = view.findViewById(R.id.btnreg);


        rgn.setOnClickListener(view1 ->{
            Bundle userData = new Bundle();
            userData.putString("email", email.getText().toString());
            userData.putString("password", password.getText().toString());
            Navigation.findNavController(view).navigate(R.id.registerFragment_to_loginFragment, userData);
        });

    }
}
