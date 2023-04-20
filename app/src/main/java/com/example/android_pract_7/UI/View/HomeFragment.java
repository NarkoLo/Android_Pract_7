package com.example.android_pract_7.UI.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment{
    final public static String TAG = HomeFragment.class.getSimpleName();
    private TextView email;
    private TextView username;
    private Button exit;
    public static HomeFragment newInstance(Bundle data) {
        HomeFragment loginFragment = new HomeFragment();
        if(data != null){
            loginFragment.setArguments(data);
            return loginFragment;
        }
        return newInstance();
    }
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = (TextView) view.findViewById(R.id.email);
        username = (TextView) view.findViewById(R.id.username);
        exit = (Button) view.findViewById(R.id.exit);

        email.setText(getArguments() != null ? getArguments().getString("email") : "Error");
        exit.setOnClickListener(vie -> Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment));
        Log.i(TAG, "onViewCreated");
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }

}
