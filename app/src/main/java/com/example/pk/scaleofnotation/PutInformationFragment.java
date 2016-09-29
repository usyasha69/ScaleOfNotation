package com.example.pk.scaleofnotation;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PutInformationFragment extends Fragment {
    @BindView(R.id.pif_put_convert_to_binary)
    EditText putConvertToBinary;
    @BindView(R.id.pif_put_convert_to_octal)
    EditText putConvertToOctal;
    @BindView(R.id.pif_put_convert_to_hexadecimal)
    EditText putConvertToHexadecimal;

    public void setScaleOfNotationListener(ScaleOfNotationListener listener) {
        this.scaleOfNotationListener = listener;
    }

    private ScaleOfNotationListener scaleOfNotationListener;


    public static PutInformationFragment newInstance() {

        Bundle args = new Bundle();

        PutInformationFragment fragment = new PutInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_put_information, container, false);
        ButterKnife.bind(this, view);

        putConvertToBinary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String text = putConvertToBinary.getText().toString();

                        if (!text.isEmpty()) {
                            scaleOfNotationListener.convertToBinary(Integer.parseInt(text));
                        } else {
                            Toast.makeText(getContext(), "Please, put a number!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });

        putConvertToOctal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String text = putConvertToOctal.getText().toString();

                        if (!text.isEmpty()) {
                            scaleOfNotationListener.convertToOctal(Integer.parseInt(text));
                        } else {
                            Toast.makeText(getContext(), "Please, put a number!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });

        putConvertToHexadecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String text = putConvertToHexadecimal.getText().toString();

                        if (!text.isEmpty()) {
                            scaleOfNotationListener.convertToHexadecimal(Integer.parseInt(text));
                        } else {
                            Toast.makeText(getContext(), "Please, put a number!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });

        return view;
    }
}
