package me.ezeezegg.togglme.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.ezeezegg.togglme.Interfaces.AsyncVolleyResponse;
import me.ezeezegg.togglme.R;
import me.ezeezegg.togglme.applications.VolleyApplication;
import me.ezeezegg.togglme.constants.Urls;
import me.ezeezegg.togglme.helpers.VolleyHelper;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AsyncVolleyResponse {


    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button buttonLogin;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        buttonLogin = (Button) findViewById(R.id.email_sign_in_button);
        buttonLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void login() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        VolleyHelper volleyHelper = new VolleyHelper(this,Urls.urlLoginToggl, this);
        volleyHelper.makeVolleyRequest(email, password);
//        makeVolleyRequest(email, password);
    }

    @Override
    public void AsyncVolleyFinish(String response) {
        JSONObject parse = null;
        try {
            parse = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Toast.makeText(this, "response: " + parse.getString("since"), Toast.LENGTH_SHORT ).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AsyncVolleyError(String error) {
        Toast.makeText(context, "ERROR: " + error, Toast.LENGTH_SHORT ).show();
    }
}

