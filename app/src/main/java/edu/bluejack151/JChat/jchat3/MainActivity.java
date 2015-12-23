package edu.bluejack151.JChat.jchat3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.shiperus.ark.jchat3.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    CallbackManager callbackManager;
    Intent pageLoginFacebook;
    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }


    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public void register(View v)
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);

    }



    public void login(View v)
    {
        //Intent intent=new Intent(this,HomeActivity.class);
        //startActivity(intent);
    }

    AccessToken accessToken;
//    ProfileTracker profileTracker;
    LoginButton fbButton;
    public static String preferencesName="LoginPref";
    SharedPreferences.Editor edit;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         editor = getSharedPreferences(preferencesName, MODE_PRIVATE).edit();


        super.onCreate(savedInstanceState);
        pageLoginFacebook =new Intent(this,HomeActivity.class);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();


        //Toast.makeText(getApplicationContext(),"Asu DEFFFF",Toast.LENGTH_LONG).show();
       fbButton=(LoginButton)findViewById(R.id.login_button);
        fbButton.setReadPermissions(Arrays.asList("email", "user_photos", "public_profile"));


        fbButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    String idUs;
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                                //Log.i("LoginActivity", graphResponse.toString());
                                try {
                                    //buat tampilin data facebook sesuai kolom nya
                                    //Toast.makeText(getApplicationContext(), jsonObject.getString("id"), Toast.LENGTH_LONG).show();
                                    editor.putString("userID", jsonObject.getString("id").toString());
                                    editor.commit();
                                   // Toast.makeText(getApplicationContext(), idUs, Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                startActivity(pageLoginFacebook);

                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id, first_name, last_name, email,gender, birthday, location"); // Parámetros que pedimos a facebook
                        request.setParameters(parameters);
                        request.executeAsync();

                        LoginManager.getInstance().logOut();

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Asu Cancel", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(getApplicationContext(), "Asu Error", Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
