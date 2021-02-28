package com.example.notetoself;

import android.app.AlertDialog;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.zip.Inflater;

public class DialogShowNote extends DialogFragment {
    private Note mNote;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View dialogView= inflater.inflate(R.layout.dialog_show_note,null);

        final TextView txtTitle=(TextView)dialogView.findViewById(R.id.txtTitle);
        final TextView txtDescription= (TextView)dialogView.findViewById(R.id.txtDescription);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        ImageView ivImportant=(ImageView)dialogView.findViewById(R.id.imageViewImportant);
        ImageView ivTodo=(ImageView)dialogView.findViewById(R.id.imageViewTodo);
        ImageView ivIdea=(ImageView)dialogView.findViewById(R.id.imageViewIdea);

        if(!mNote.isImportant()){
            ivImportant.setVisibility(View.GONE);
        }
        if(!mNote.isTodo()){
            ivTodo.setVisibility(View.GONE);
        }
        if(!mNote.isIdea()){
            ivIdea.setVisibility(View.GONE);
        }

        Button btnOk=(Button)dialogView.findViewById(R.id.btnOk);
        builder.setView(dialogView).setMessage("YOUR NOTE");
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }

    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }
}
