package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class PersonalArea extends AppCompatActivity {

    private Button ChooseImage, set_btn, menu, rasp, sback;
    private ImageView imageView, imBD;
    private Object BitmapDrawable;
    private StorageReference mStorageRef;
    private Uri upLoadUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_area);

        mStorageRef = FirebaseStorage.getInstance().getReference("ImageDB");
        set_btn = (Button) findViewById(R.id.set_btn);
        set_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetting();
            }
        });

        sback = (Button) findViewById(R.id.sback);
        sback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalArea.this, MainActivity.class);
                startActivity(i);
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);
        imBD = (ImageView) findViewById(R.id.imBD);
        ChooseImage = (Button) findViewById(R.id.ChooseImage);
        ChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
getImage();
            }
        });

       menu = (Button) findViewById(R.id.button9);
       menu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               openMenu();
           }
       });

      /* rasp =(Button) findViewById(R.id.button7);
       rasp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(PersonalArea.this, Spisok.class);
               startActivity(i);
           }
       }); */

      // Write a message to the database
      FirebaseDatabase database = FirebaseDatabase.getInstance();
      DatabaseReference myRef = database.getReference("message");

      myRef.setValue("Hello, World!");

      // Read from the database
      myRef.addValueEventListener(new ValueEventListener() {
        private Object Tag;

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
          // This method is called once with the initial value and again
          // whenever data at this location is updated.
          String value = dataSnapshot.getValue(String.class);
          Log.d((String) Tag, "Value is: " + value);
        }

        @Override
        public void onCancelled(DatabaseError error) {
          // Failed to read value
          Log.w((String) Tag, "Failed to read value.", error.toException());
        }
      });

    }

    private void openMenu() {
        Intent switcher = new Intent(PersonalArea.this, MainActivity3.class);
        startActivity(switcher);
        finish();
    }

    private void openSetting() {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }


    private void getImage(){
        Intent intentchooser = new Intent();
        intentchooser.setType("image/*");
        intentchooser.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentchooser, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data != null && data.getData() != null){
            if (resultCode == RESULT_OK){
                Log.d("MyLog", "Image URI : " + data.getData());
                imageView.setImageURI(data.getData());
                uploadImage();
            }
        }
    }

    private void uploadImage(){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable() ).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        final StorageReference mRef = mStorageRef.child(System.currentTimeMillis() + "my_image");
        UploadTask up = mRef.putBytes(byteArray);
        Task<Uri> task = up.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                return mRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                upLoadUri = task.getResult();
            }
        });
    }

}
