package com.example.mbarr.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by mbarr on 1/8/2018.
 */

public class DialogNewNote extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_new_note, null);

        final EditText editTitle = view.findViewById(R.id.editTitle);
        final EditText editDescription = view.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = view.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = view.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = view.findViewById(R.id.checkBoxImportant);
        Button btnCancel = view.findViewById(R.id.btnCancel);
        Button btnOK = view.findViewById(R.id.btnOK);

        builder.setView(view).setMessage("Add a new note");

        // Handle the cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        // Handle the OK button
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a new note
                Note newNote = new Note();

                // Set its variable to match the user entries on the form
                newNote.setmTitle(editTitle.getText().toString());
                newNote.setmDescription(editDescription.getText().toString());
                newNote.setmIdea(checkBoxIdea.isChecked());
                newNote.setmTodo(checkBoxTodo.isChecked());
                newNote.setmImportant(checkBoxImportant.isChecked());

                // Get a reference to MainActivity
                MainActivity callingActivity = (MainActivity) getActivity();

                // Pass newNote back to MainActivity
                callingActivity.createNewNote(newNote);

                // Quit the dialog
                dismiss();
            }
        });

        return builder.create();
    }
}
