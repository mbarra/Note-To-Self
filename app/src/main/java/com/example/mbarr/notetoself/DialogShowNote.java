package com.example.mbarr.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mbarr on 1/8/2018.
 */

public class DialogShowNote extends DialogFragment {

    private Note mNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        TextView txtDescription = view.findViewById(R.id.txtDescription);

        ImageView ivImportant = view.findViewById(R.id.imageViewImportant);
        ImageView ivTodo = view.findViewById(R.id.imageViewTodo);
        ImageView ivIdea = view.findViewById(R.id.imageViewIdea);

        if (!mNote.ismImportant())
            ivImportant.setVisibility(View.GONE);
        if (!mNote.ismTodo())
            ivTodo.setVisibility(View.GONE);
        if (!mNote.ismIdea())
            ivIdea.setVisibility(View.GONE);

        Button btnOK = view.findViewById(R.id.btnOK);

        builder.setView(view).setMessage("Your note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }

    // Receive a note from the MainActivity
    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }
}
