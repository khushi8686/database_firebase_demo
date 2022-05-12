package com.example.database_firebase_demo;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class donar extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button submit_btn;
        EditText name,city,contact,blood;
        name=findViewById(R.id.name);
        city=findViewById(R.id.city);
        contact=findViewById(R.id.Contect);
        blood=findViewById(R.id.bloodgroup);
        submit_btn=findViewById(R.id.submit);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Donor");
                DatabaseReference usersRef = ref.child("users");
                Map<String, Object> user = new HashMap<>();
                user. put ("Name" , name.getText ().toString());
                user.put ("City" ,city.getText ().toString());
                user.put ("Contact" ,contact.getText ().toString());
                user.put ("blood group",blood.getText ().toString());
                usersRef.child("User").push().setValue(user);
//                Map<String, Object> user = new HashMap<>();
//                user. put ("Name" , name.getText ().toString());
//                user.put ("City" ,city.getText ().toString());
//                user.put ("Contact" ,contact.getText ().toString());
//                user.put ("blood group",blood.getText ().toString());
//                FirebaseDatabase.getInstance().getReference().child("User").push().setValue(user);
//                // Add a new document with a generated ID
//                db.collection("users")
//                        .add(user)
//                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                            @Override
//                            public void onSuccess(DocumentReference documentReference) {
//                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w(TAG, "Error adding document", e);
//                            }
//                        });
            }
        });
    }
}

