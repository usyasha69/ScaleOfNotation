package com.example.pk.scaleofnotation;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;


public class PutInformationFragment extends Fragment {
    @BindView(R.id.pif_put_convert_to_binary)
    EditText putConvertToBinary;
    @BindView(R.id.pif_put_convert_to_octal)
    EditText putConvertToOctal;
    @BindView(R.id.pif_put_convert_to_hexadecimal)
    EditText putConvertToHexadecimal;

    private Handler handler;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler();
    }

    @OnTextChanged(value = R.id.pif_put_convert_to_binary
            , callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onTextChangedBinary(Editable editable) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String text = putConvertToBinary.getText().toString();

                if (!text.isEmpty()) {
                    scaleOfNotationListener.convertToBinary(Integer.parseInt(text));
                } else {
                    Toast.makeText(getContext()
                            , "Please, put a number!", Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    @OnTextChanged(value = R.id.pif_put_convert_to_octal
            , callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onTextChangedOctal(Editable editable) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String text = putConvertToOctal.getText().toString();

                if (!text.isEmpty()) {
                    scaleOfNotationListener.convertToOctal(Integer.parseInt(text));
                } else {
                    Toast.makeText(getContext(), "Please, put a number!"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    @OnTextChanged(value = R.id.pif_put_convert_to_hexadecimal
            , callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onTextChangedHexadecimal(Editable editable) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String text = putConvertToHexadecimal.getText().toString();

                if (!text.isEmpty()) {
                    scaleOfNotationListener.convertToHexadecimal(Integer.parseInt(text));
                } else {
                    Toast.makeText(getContext(), "Please, put a number!"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_put_information, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
