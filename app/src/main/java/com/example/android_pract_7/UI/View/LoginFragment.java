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

import com.example.android_pract_7.R;
import com.example.android_pract_7.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    final public static String TAG = LoginFragment.class.getSimpleName();
    FragmentLoginBinding binding;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            binding.editTextEmail.setText(getArguments().getString("email"));
            binding.editTextPassword.setText(getArguments().getString("password"));
        }

        binding.buttonLogin.setOnClickListener(vie -> {
            Bundle userData = new Bundle();
            userData.putString("email", binding.editTextEmail.getText().toString());
            Navigation.findNavController(view).navigate(R.id.loginFragment_to_homeFragment,userData);

        });
        binding.textViewRegister.setOnClickListener(vie ->{
            Navigation.findNavController(view).navigate(R.id.loginFragment_to_registerFragment);
        });
    }

}
