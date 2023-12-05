package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDilog extends Dialog {
    private final String massage;
    private final MainActivity mainActivity;
    public WinDilog(@NonNull Context context ,String massage , MainActivity mainActivity) {
        super(context);
        this.massage=massage;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_layout);

        final TextView massagetxt=findViewById(R.id.massagetxt);
        final Button startagian = findViewById(R.id.startagin);

        massagetxt.setText(massage);

        startagian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainActivity.restartMatch();
                dismiss();

            }
        });
    }
}
