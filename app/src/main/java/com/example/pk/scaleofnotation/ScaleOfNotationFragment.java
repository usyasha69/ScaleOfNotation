package com.example.pk.scaleofnotation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ScaleOfNotationFragment extends Fragment implements ScaleOfNotationListener {
    @BindView(R.id.sonf_binary_result)
    TextView binaryResult;
    @BindView(R.id.sonf_octal_result)
    TextView octalResult;
    @BindView(R.id.sonf_hexadecimal_result)
    TextView hexadecimalResult;

    public static ScaleOfNotationFragment newInstance() {

        Bundle args = new Bundle();

        ScaleOfNotationFragment fragment = new ScaleOfNotationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scale_of_notation, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void convertToBinary(int number) {
        binaryResult.setText(Integer.toBinaryString(number));
    }

    @Override
    public void convertToOctal(int number) {
        octalResult.setText(Integer.toOctalString(number));
    }

    @Override
    public void convertToHexadecimal(int number) {
        hexadecimalResult.setText(Integer.toHexString(number));
    }
}
