package com.example.android_pract_7.UI.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.android_pract_7.R;
import com.example.android_pract_7.databinding.FragmentHomePageBinding;

public class HomePageFragment extends Fragment{
    FragmentHomePageBinding binding;
    final public static String TAG = HomePageFragment.class.getSimpleName();

    public static HomePageFragment newInstance(Bundle data) {
        HomePageFragment loginFragment = newInstance();
        if(data != null){
            loginFragment.setArguments(data);
            return loginFragment;
        }
        return loginFragment;
    }
    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_SHORT).show();
        binding = FragmentHomePageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.email.setText(getArguments() != null ? getArguments().getString("email") : "Error");
        binding.exit.setOnClickListener(vie -> Navigation.findNavController(view).navigate(R.id.homeFragment_to_loginFragment));
        Log.i(TAG, "onViewCreated");
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
