package com.opsc7311.introfirestore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;


import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText enterTitle;
    private EditText enterThought;

    //Keys
    public static final String KEY_TITLE = "title";
    public static final String KEY_THOUGHT = "thought";

    //Connection to Firestore
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterTitle = findViewById(R.id.edit_text_title);
        enterThought = findViewById(R.id.edit_text_thoughts);

        Button saveButton = findViewById(R.id.save_button);

//        saveButton.setOnClickListener(view -> {
//            String title =  enterTitle.getText().toString().trim();
//            String thought = enterThought.getText().toString().trim();
//
//            Map<String, Object> data = new HashMap<>();
//            data.put(KEY_TITLE, title);
//            data.put(KEY_THOUGHT,thought);
//
//            db.collection("Journal")
//                    .document("First Thoughts")
//                    .set(data)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//                            Toast.makeText(MainActivity.this,
//                                    "Success", Toast.LENGTH_LONG).show();
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.d(TAG, "onFailure: " + e);
//                        }
//                    });
//
//        });
        /**
         * Set a document
         * url: https://firebase.google.com/docs/firestore/manage-data/add-data
         */
//        Map<String, Object> city = new HashMap<>();
//        city.put("name", "Los Angeles");
//        city.put("state", "CA");
//        city.put("country", "USA");
//        city.put("capital", true);
//
//        db.collection("cities").document("LA")
//                .set(city, SetOptions.merge())
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Log.d(TAG, "DocumentSnapshot successfully written!");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error writing document", e);
//                    }
//                });
        // Update one field, creating the document if it does not already exist.
//        Map<String, Object> data = new HashMap<>();
//        data.put("capital", true);
//
//        db.collection("cities").document("BJ")
//                .set(data, SetOptions.merge());

        //Data types
//        Map<String, Object> docData = new HashMap<>();
//        docData.put("stringExample", "Hello world!");
//        docData.put("booleanExample", true);
//        docData.put("numberExample", 3.14159265);
//        docData.put("dateExample", new Timestamp(new Date()));
//        docData.put("listExample", Arrays.asList(1, 2, 3));
//        docData.put("nullExample", null);
//
//        Map<String, Object> nestedData = new HashMap<>();
//        nestedData.put("a", 5);
//        nestedData.put("b", true);
//
//        docData.put("objectExample", nestedData);
//
//        db.collection("data").document("one")
//                .set(docData)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Log.d(TAG, "DocumentSnapshot successfully written!");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error writing document", e);
//                    }
//                });
//        City city = new City("Los Angeles", "CA", "USA",
//                false, 5000000L, Arrays.asList("west_coast", "sorcal"));
//        db.collection("cities").document("LA").set(city);
        // Add a new document with a generated id.
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Tokyo");
        data.put("country", "Japan");
        data.put("timestamp", FieldValue.serverTimestamp());


        db.collection("cities")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}