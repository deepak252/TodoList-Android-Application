package com.example.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogNewNote  extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.dialog_new_note,null); //We now have a View object called dialogView, which contains all the UI elements from our dialog_new_note.xml layout file.

        final EditText editTitle=(EditText)dialogView.findViewById(R.id.editTitle);
        final EditText editDescription=(EditText)dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea=(CheckBox) dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo=(CheckBox) dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant=(CheckBox) dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel=(Button)dialogView.findViewById(R.id.btnCancel);
        Button btnOk=(Button)dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView).setMessage("Add a New Note");

        // Handle the cancel button
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // Handle the ok button
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Note newNote=new Note();
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());

                // Get a reference to MainActivity
                MainActivity callingActivity=(MainActivity)getActivity();

                // Pass newNote back to MainActivity
                callingActivity.createNewNote(newNote);
                // Quit the dialog
                dismiss();
            }
        });
        return builder.create();
    }
}
