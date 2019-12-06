package com.example.solution;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private ToggleButton LLight;
    private ToggleButton LFan;
    private ToggleButton BLight;
    private ToggleButton BFan;
    private Handler handler = new Handler();
    private DatabaseReference ref;

    private RelativeLayout relativeLayout;
    private Runnable runnable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LLight = findViewById(R.id.toggleButton1);
        LFan =findViewById(R.id.toggleButton2);
        BLight = findViewById(R.id.toggleButton3);
        BFan = findViewById(R.id.toggleButton4);
        relativeLayout=findViewById(R.id.mainlay);
        ref = FirebaseDatabase.getInstance().getReference();

        flRunnable();

        LLight.setOnClickListener(v -> {


            Toast.makeText(getApplicationContext(), "light is-  " + LLight.getText().toString() ,Toast.LENGTH_SHORT).show();
            if(LLight.isChecked())
            {
                //ref.child("Living Room").child("Light").setValue("1").addOnSuccessListener(aVoid -> {
                //          //  Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                //        //});
                LLight.setBackgroundColor(getColor(R.color.green));

                ref.child("Living Room/Light").setValue("1").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });

            }else
            {
                LLight.setBackgroundColor(getColor(R.color.Red));
                ref.child("Living Room").child("Light").setValue("0").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }

        });

        LFan.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Fan is-  " + LFan.getText().toString() ,Toast.LENGTH_SHORT).show();
            if(LFan.isChecked())
            {
                LFan.setBackgroundColor(getColor(R.color.green));
                ref.child("Living Room/Fan").setValue("1").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });

            }else
            {
                LFan.setBackgroundColor(getColor(R.color.Red));
                ref.child("Living Room/Fan").setValue("0").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }
        });
        BLight.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Light is-  " + BLight.getText().toString() ,Toast.LENGTH_SHORT).show();
            if(BLight.isChecked())
            {
                BLight.setBackgroundColor(getColor(R.color.green));
                ref.child("Bed Room/Light").setValue("1").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }else
            {
                BLight.setBackgroundColor(getColor(R.color.Red));
                ref.child("Bed Room/Light").setValue("0").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }
        });
        BFan.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Fan is-  " + BFan.getText().toString() ,Toast.LENGTH_SHORT).show();
            if(BFan.isChecked())
            {
                BFan.setBackgroundColor(getColor(R.color.green));
                ref.child("Bed Room/Fan").setValue("1").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }else
            {
                BFan.setBackgroundColor(getColor(R.color.Red));
                ref.child("Bed Room/Fan").setValue("0").addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Error 123 : " + e.getMessage());
                    }
                }).addOnCanceledListener(new OnCanceledListener() {
                    @Override
                    public void onCanceled() {
                        System.out.println("Error 456");
                    }
                });
            }
        });



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                String LivingL=dataSnapshot.child("Living Room/Light").getValue().toString();
                String LivingF=dataSnapshot.child("Living Room/Fan").getValue().toString();
                String BedL=dataSnapshot.child("Bed Room/Light").getValue().toString();
                String BedF=dataSnapshot.child("Bed Room/Fan").getValue().toString();

                if(LivingL.equals("1"))
                {
                    LLight.setBackgroundColor(getColor(R.color.green));
                }
                else{
                    LLight.setBackgroundColor(getColor(R.color.Red));
                }

                if(LivingF.equals("1"))
                {
                    LFan.setBackgroundColor(getColor(R.color.green));
                }
                else{
                    LFan.setBackgroundColor(getColor(R.color.Red));
                }

                if(BedL.equals("1"))
                {
                    BLight.setBackgroundColor(getColor(R.color.green));
                }
                else{
                    BLight.setBackgroundColor(getColor(R.color.Red));
                }

                if(BedF.equals("1"))
                {
                    BFan.setBackgroundColor(getColor(R.color.green));
                }
                else{
                    BFan.setBackgroundColor(getColor(R.color.Red));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    void kill(){
        LLight.setClickable(false);
        LFan.setClickable(false);
        BLight.setClickable(false);
        BFan.setClickable(false);
    }

    void unkill(){
        LLight.setClickable(true);
        LFan.setClickable(true);
        BLight.setClickable(true);
        BFan.setClickable(true);
    }

    private void flRunnable(){
        Snackbar snackbar;
       snackbar=Snackbar.make(relativeLayout,"Server Down", BaseTransientBottomBar.LENGTH_INDEFINITE);
       handler.postDelayed(runnable = new Runnable() {
           @Override
           public void run() {
               ref.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       long currentTime=55000;
                       long dbtime=Long.parseLong(dataSnapshot.child("TimeStamp").getValue().toString());
                       String Service=(dataSnapshot.child("Service").getValue().toString());

                        snackbar.setBackgroundTint(getColor(R.color.colorPrimary));

                        if((currentTime-dbtime)>15000 && Service.equals("0")){
                            kill();
                            snackbar.show();
                       }
                        else if((currentTime-dbtime)>15000 && Service.equals("2")){
                            kill();
                            snackbar.show();
                        }
                        else if ((currentTime-dbtime)<15000 && Service.equals("2")){
                            kill();
                            snackbar.setBackgroundTint(getColor(R.color.Red));
                            snackbar.setText("Kill Switch is pressed :");
                            snackbar.show();
                       }
                        else{
                            unkill();
                            snackbar.dismiss();
                        }


                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {
                       Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                   }
               });
            handler.postDelayed(runnable,1000);

           }

       },100);


    }


}
