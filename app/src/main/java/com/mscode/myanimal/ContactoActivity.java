package com.mscode.myanimal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity  {

    private Toolbar toolbar;

    Session session;

    Button enviar;

    EditText mensaje;
    EditText email;

    String correo;
    String contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = findViewById(R.id.toolbar);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        mensaje = findViewById(R.id.txtDescription);
        email = findViewById(R.id.txtEmail);
        enviar = findViewById(R.id.Btnnext);

        correo = "*****@gmail.com";
        contrasena= "******";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

              try{
                    session = Session.getDefaultInstance(properties, new Authenticator(){
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contrasena);

                        }
                    });

                    if(session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject(mensaje.toString());
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email.toString()));
                        message.setContent(mensaje.getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,ContactoActivity.class );
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Intent intent2 = new Intent(this,AboutActivity.class );
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}